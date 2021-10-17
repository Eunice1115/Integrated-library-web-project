/*
 * 책 등록, 반납 ,대출 등의 책과 관련된 기능을 담은 컨트롤러
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.Bestbook;
import model.Board;
import model.Book;
import model.Bookreserve;
import model.Join;
import model.Member;
import model.Rental;
import service.BoardMybatisDao;
import service.BookMybatisDao;
import util.MybatisConnection;


@Controller
@RequestMapping("/book/")
public class BookController {
	
	HttpServletRequest request;
	Model m;
	HttpSession session;
	

	@Autowired
	BookMybatisDao dao;
	
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		
		this.request = request;
		this.m = m;
		this.session = request.getSession();
		
	}
	
	//책 리스트 보여주기
	@RequestMapping("booklist")
	public String booklist(String req1, String req2, String req3) {
		
		//pageNum(현재 페이지 넘버)가져와서 세션에 저장
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		
		//검색폼에 검색된 req1(도서관 이름), req2(제목),req(저자)가져와서 세션에 저장
		session.setAttribute("req1", req1);
		session.setAttribute("req2", req2);
		session.setAttribute("req3", req3);
		
		//pageNum(현재 페이지 넘버)를 숫자(pageInt)로 바꾼다.
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) 	{pageNum = "1";}
		int pageInt = Integer.parseInt(pageNum);
		
		int limit = 10; //한 페이지에 출력될 책 개수
		int bookcount = 0; //조건에 맞는 책 개수
		List<Book> list = new ArrayList(); //조건에 맞는 이벤트 리스트
		
		if(req1==null && req2==null && req3==null) {req1=""; req2=""; req3="";}//검색단어가 없을 경우
		
		if(req1!=null && req2=="" && req3=="") {//도서관만 검색되었을 경우
			bookcount = dao.bookCount1(req1);
			System.out.println(bookcount);
			list = dao.bookList1(req1,pageInt, limit, bookcount); 
			System.out.println(list);
		}
		else if(req1=="" && req2!=null && req3=="") {//제목만 검색되었을 경우
			bookcount = dao.bookCount2(req2);
			System.out.println(bookcount);
			list = dao.bookList2(req2,pageInt, limit, bookcount); 
			System.out.println(list);
		}
		else if(req1=="" && req2=="" && req3!=null) {//저자만 검색되었을 경우
			bookcount = dao.bookCount3(req3);
			System.out.println(bookcount);
			list = dao.bookList3(req3,pageInt, limit, bookcount); 
			System.out.println(list);
		}
		else if(req1!=null && req2!=null && req3=="") {//도서관과 제목만 검색되었을 경우
			bookcount = dao.bookCount4(req1,req2);
			System.out.println(bookcount);
			list = dao.bookList4(req1,req2,pageInt, limit, bookcount);
			System.out.println(list);
		}
		else if(req1!=null && req2=="" && req3!=null) {//도서관과 저자만 검색되었을 경우
			bookcount = dao.bookCount5(req1,req3);
			System.out.println(bookcount);
			list = dao.bookList5(req1,req3,pageInt, limit, bookcount);
		}
		
		//페이징 작업
		int maxpage = (int) (bookcount / limit) + (bookcount % limit == 0 ? 0 : 1);
		int bottomLine = 3; // page 1,2,3 : 1, 4,5,6: 2
		int startpage = 1 + (pageInt - 1) / bottomLine * bottomLine;
		int endpage = startpage + bottomLine - 1;
		if (endpage > maxpage) 	endpage = maxpage;
		int boardnum = bookcount - (pageInt - 1) * limit;  
		
		
		m.addAttribute("bookcount", bookcount);  // 등록된 전체 게시물의 건수
		m.addAttribute("list", list);  //프린트한 게시물
		m.addAttribute("boardnum", boardnum); //게시물 시작번호
		m.addAttribute("pageNum", pageNum);  //현재 페이지 번호
		
		//하단 페이징
		m.addAttribute("startpage", startpage); // 하단 시작 페이지
		m.addAttribute("endpage", endpage);  //하단 end 페이지
		m.addAttribute("bottomLine", bottomLine);  //하단 화면당 페이지 보기
		m.addAttribute("maxpage", maxpage);  //총 페이지수
		
		m.addAttribute("req1",req1);
		m.addAttribute("req2",req2);
		m.addAttribute("req3",req3);
			
		return "book/bookList";
	}
	
	//도서 입력하는 폼 
	@RequestMapping("bookInfoForm")
	public String bookInfoForm() {
		return "book/bookInfoForm";
	}
	
	//입력한 도서 내용 처리
	@RequestMapping("bookInfoPro")
	public String bookInfoPro(Book book) {
		String path = request.getServletContext().getRealPath("/") + "photo"; //도서 사진 주소
		System.out.println(path);
		MultipartFile multipartFile = book.getF();
		
		//도서 사진 처리하기
		if(!multipartFile.isEmpty()) {
			File file = new File(path, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				book.setBookpicture(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			book.setBookpicture("");
		}
		
		//도서 등록(등록에 성공하면 num이 1)
		int num = dao.BookInsert(book);
		
		System.out.println(num + "개 저장됨.");
	
		m.addAttribute("book", book);
		if(num != 1) {
			m.addAttribute("url", "/book/bookInfoForm");
			m.addAttribute("msg", "등록 실패");
		}else {
			m.addAttribute("url", "/book/booklist");
			m.addAttribute("msg", "등록 성공");
		}
		return "alert";
	}
	
	//입력한 도서 내용을 보여줌
	@RequestMapping("bookInfo")
	public String bookInfo(int booknum) {
		//해당 booknum(책번호)이 있는 데이터를 Book테이블에서 찾아서 book으로 저장
		Book book = dao.selectOne(booknum);
		//해당 booknum(책번호)이 있는 데이터를 Rental테이블에서 찾아서 rental로 저장
		Rental rental = dao.rentalSelect(booknum);
		//해당 booknum(책번호)를 예약한 인원
		int num = dao.reserveCount(booknum);
		m.addAttribute("book", book);
		m.addAttribute("rental", rental);
		m.addAttribute("num", num);
		return "book/bookInfo";
	}
	
	//도서내용 수정 하는 화면 
	@RequestMapping("bookUpdateForm") 
	public String bookUpdateForm(int booknum) {
		Book book = dao.selectOne(booknum);
		m.addAttribute("book", book);
		return "book/bookUpdate";
	}
	
	//도서내용 수정 처리
	@RequestMapping("bookUpdatePro")
	public String bookUpdatePro(Book book) {
		
		String path = request.getServletContext().getRealPath("/") + "photo"; //도서 사진 주소
		System.out.println(path);
		MultipartFile multipartFile = book.getF();

		//도서 사진 처리
		if(!multipartFile.isEmpty()) {
			File file = new File(path, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				book.setBookpicture(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		m.addAttribute("book", book);
		//도서가 성공적으로 수정되었는지 확인
		if(dao.bookUpdate(book)) {
			m.addAttribute("url", "/book/bookInfo?booknum="+book.getBooknum());
			m.addAttribute("msg", "수정성공");
			
		}else {
			m.addAttribute("url", "/book/bookUpdateForm?booknum="+book.getBooknum());
			m.addAttribute("msg", "수정실패");
		}
		return "alert";
	}
	
	//도서 삭제
	@RequestMapping("bookDelete") 
	public String bookDelete(int booknum) {
		//도서가 삭제되었는지 확인(num이 1이면 성공적으로 삭제됨)
		int num = 0;
		num = dao.bookDelete(booknum);
		System.out.println(num);
		
		String msg = "삭제하는데 실패하였습니다!";
		String url = "book/bookInfo?booknum=" + booknum;
		
		if (num==1) {			
			msg = "성공적으로 삭제하였습니다.";
			url = "book/booklist";		
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//신착도서 리스트 확인하기
	@RequestMapping("newbooklist")
	public String newbooklist(String req1, String req2) {
		
		//현재 페이지 넘버 세션에 저장
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) 	pageNum = "1";
		int pageInt = Integer.parseInt(pageNum);
		
		//검색폼에서 입력받은 req1(연도),req2(월)을 가져와서 세션에 저장
		session.setAttribute("req1", req1);
		session.setAttribute("req2", req2);
		
		String req = req1+"-"+req2; //현재 데이터 형태에 맞게 조합(연도-월)
		int limit = 10; //한 페이지에 출력될 도서 개수
		int bookcount = dao.newbookcount(req); //조건에 맞는 도서 개수
		List<Book> list = dao.newbooklist(req, pageInt, limit, bookcount); //조건에 맞는 도서리스트
		
		//페이징 작업
		int maxpage = (int) (bookcount / limit) + (bookcount % limit == 0 ? 0 : 1);
		int bottomLine = 3; // page 1,2,3 : 1, 4,5,6: 2
		int startpage = 1 + (pageInt - 1) / bottomLine * bottomLine;
		int endpage = startpage + bottomLine - 1;
		if (endpage > maxpage) 	endpage = maxpage;
		int boardnum = bookcount - (pageInt - 1) * limit;  
		
		
		m.addAttribute("bookcount", bookcount);  // 등록된 전체 게시물의 건수
		m.addAttribute("list", list);  //프린트한 게시물
		m.addAttribute("boardnum", boardnum); //게시물 시작번호
		m.addAttribute("pageNum", pageNum);  //현재 페이지 번호
		
		//하단 페이징
		m.addAttribute("startpage", startpage); // 하단 시작 페이지
		m.addAttribute("endpage", endpage);  //하단 end 페이지
		m.addAttribute("bottomLine", bottomLine);  //하단 화면당 페이지 보기
		m.addAttribute("maxpage", maxpage);  //총 페이지수
		
		m.addAttribute("req1",req1);
		m.addAttribute("req2",req2);
			
		return "book/newbookList";
	}
	
	//도서 예약 처리
	@RequestMapping("bookReservePro")
	public String bookReservePro(Bookreserve brsv){
		
		//해당 booknum(책번호)와 memberid(회원 아이디)로 예약이 되어있는지 확인(1이면 이미 예약된 상태)
		int num1 = dao.prebookReserve(brsv.getBooknum(),brsv.getMemberid());
		//해당 booknum(책번호)가 대출중인 상태인지 확인(a가1이면 대출중이어서 예약 가능)
		int a = dao.preRental(brsv.getBooknum());
		
		if(a!=0){
			if(num1==0) {
				//해당 도서 정보로 예약(num2가 1이면 예약됨)
				int num2 = dao.bookReserveInsert(brsv);
				if(num2 != 1) {
					m.addAttribute("url",  "book/bookInfo?booknum=" + brsv.getBooknum());
					m.addAttribute("msg", "예약에 실패하였습니다");
					
				}else {
					m.addAttribute("url", "book/bookInfo?booknum=" + brsv.getBooknum());
					m.addAttribute("msg", "예약에 성공하였습니다");
				}
			}
			else {
			m.addAttribute("url",  "book/bookInfo?booknum=" + brsv.getBooknum());
			m.addAttribute("msg","이미 예약하셨습니다.");
			}
		}else {
			m.addAttribute("url","book/bookInfo?booknum=" + brsv.getBooknum());
			m.addAttribute("msg","대출중인 도서만 예약 가능합니다.");
		}
		return "alert";	
	}
	
	//도서 예약내역 확인
	@RequestMapping("bookReserveConfirm")
	public String bookReserveConfirm(String memberid) {
		//Reservation테이블에 해당 아이디가 포함된 데이터가 있으면 리스트로 저장
		List<Bookreserve> list = dao.bookreserveList(memberid);
		m.addAttribute("list", list);
		return "book/bookReserveConfirm";
	}
	
	//도서 예약 취소
	@RequestMapping("bookReserveDelete")
	public String bookReserveDelete(int booknum, String memberid) {
		
		String id = (String) session.getAttribute("login");
		String msg = "삭제 할 수 없습니다";
		String url = "book/bookReserveConfirm?memberid="+memberid;
			
		//해당 booknum(책 번호)과 memberid(회원아이디)가 포함된 데이터 Reservation테이블에서 삭제(1이면 삭제됨)
		int num = 0;
		num = dao.bookReserveDelete(booknum,memberid);
			
		if (num!=0) {			
			msg="삭제 하였습니다";			
		}
			
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//도서대출정보 입력하는 화면 
	@RequestMapping("rentalForm")
	public ModelAndView rentalForm() {
		return new ModelAndView("rentalForm");
	}
	
	//도서대출 처리
	@RequestMapping("rentalPro")
	public String rentalPro(Rental rental) {
		//해당 booknum(책번호)가 대출중인 상태인지 확인(a가1이면 대출중이어서 대출 불가)    
		int num1 = dao.preRental(rental.getBooknum());
		if(num1==0) {
			//해당 도서 대출 정보가 담긴 내역을 Rental테이블에 삽입(num2가 1이면 삽입 성공)
			int num2 = dao.bookRentalInsert(rental);
			if(num2==1) {
				//도서 대출이 완료된 후 해당 대출 번호가 있는 데이터를 rental에 저장
				rental = dao.rentalselectOne(rental.getRentalnum());
				String changestate = "대출중";
				//Rental테이블에 있는 책은 대출중인 상태로 변경
				dao.bookStateUpdate(rental.getBooknum(),changestate);
				//Rental테이블에 있는 책은 Reservation테이블에서 자동 삭제
				dao.bookReserveDelete(rental.getBooknum(),rental.getMemberid());
				m.addAttribute("msg","대출 성공") ;
				m.addAttribute("url","book/rentalChk?rentalnum="+rental.getRentalnum()+"&booknum="+rental.getBooknum());
			}else {
				m.addAttribute("msg","대출 실패") ;
				m.addAttribute("url","book/rentalForm");
			}
		}else {
			m.addAttribute("msg","이미 대출중인 도서입니다.") ;
			m.addAttribute("url","book/rentalForm");
		}
		return "alert";
	}
	
	
	//대출후 관리자가 대출내역 확인
	@RequestMapping("rentalChk")
	public ModelAndView rentalChk(int rentalnum,int booknum) {
		Book book = dao.selectOne(booknum);
		Rental rental = dao.rentalselectOne(rentalnum);
		m.addAttribute("book", book);
		m.addAttribute("rental", rental);
		return new ModelAndView("rentalChk");
	}
	
	//대출후 사용자가 대출내역 확인
	@RequestMapping("bookRentalConfirm")
	public String bookRentalConfirm(String memberid) {
		//Rental테이블과 Reservation테이블에서 조인한 내용을 리스트로 저장
		List<Join> list = dao.selectRentalList(memberid);
		m.addAttribute("list", list);
		return "book/bookRentalConfirm";
	}
	
	//도서 반납
	@RequestMapping("bookReturn")
	public String bookReturn(String memberid, int booknum) {
        int num = 0;
		//해당 memberid,booknum(책번호)가 있는 데이터를 Rental테이블에서 삭제(num이 1이면 삭제됨)
		num = dao.bookReturn(memberid,booknum);
		
		String msg = "반납하는데 실패하였습니다!";
		String url = "book/bookRentalConfirm?memberid=" + memberid;
		
		if (num==1) {			
			String changestate = "대출가능";
			//반납된 도서는 대출가능 상태로 변경
			dao.bookReturnUpdate(booknum,changestate);
			msg = "성공적으로 반납하였습니다.";
			url = "book/bookRentalConfirm?memberid="+memberid;		
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//대출횟수가 가장 많은 책 10권 리스트로 보기
	@RequestMapping("bestBookList")
	public String bestBookList() {
		List<Bestbook> list = dao.bestBookList();
		m.addAttribute("list", list);
		return "book/bestbookList";
	}

	//대출한 도서 연장
	@RequestMapping("bookReturnRenew")
	public String bookReturnRenew(String memberid, int booknum) {
		//대출날짜와 반납예정 날짜의 차를 구하기
		int num = dao.period(memberid, booknum);
		
		if(num>=28) {
			m.addAttribute("msg", "연장횟수 2회를 초과했습니다.");
			m.addAttribute("url", "book/bookRentalConfirm?memberid=" + memberid);
		}else {
			//해당 memberid와 booknum(책번호)를 가진 데이터 반납기한 연장
			dao.returnRenew(memberid,booknum);
			m.addAttribute("msg", "연장되었습니다.");
			m.addAttribute("url", "book/bookRentalConfirm?memberid=" + memberid);
		}
		return "alert";
	}
	
}//end
	

