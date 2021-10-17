/*
 * 지역행사, 이벤트와 관련된 기능을 담은 컨트롤러
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.Board;
import model.Boardev;
import model.Book;
import model.Eventrsv;
import service.BoardMybatisDao;
import service.BoardevMybatisDao;



@Controller
@RequestMapping("/boardev/")
public class BoardevController {
	
	HttpServletRequest request;
	Model m;
	HttpSession session;
	
	@Autowired
	BoardevMybatisDao dao;
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		this.request = request;
		this.m = m;
		this.session = request.getSession();
	}
	
	//boardid_ev 숫자에 따라 행사 종류 출력
	public String getBoardevName(String boardid_ev) {
		String boardName_ev = "";
		switch (boardid_ev) {
		case "1": {   boardName_ev="지역행사"; break;	}
		case "2": {   boardName_ev="강연"; break;	}
		case "3": {   boardName_ev="체험프로그램"; break;	}
		case "4": {   boardName_ev="이벤트"; break;	}
		default :
		boardName_ev="지역행사";
		}
		return boardName_ev;
	}	
	
	//행사 리스트를 출력
	@RequestMapping("evlist")
	public String evlist(String req1,String req2) {
		
		//pageNum(현재 페이지 넘버), boardid_ev(현재 boardid_ev 숫자)가져와서 세션에 저장
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		if (request.getParameter("boardid_ev") != null) {
			session.setAttribute("boardid_ev", request.getParameter("boardid_ev"));
			session.setAttribute("pageNum", "1");
		}
		
		//검색폼에 검색된 req1(도서관 이름), req2(대상 ex.유아)가져와서 세션에 저장
		session.setAttribute("req1", req1);
		session.setAttribute("req2", req2);
		
		//boardid_ev숫자를 문자로 바꾸고, pageNum(현재 페이지 넘버)를 숫자(pageInt)로 바꾼다.
		String boardid_ev = (String) session.getAttribute("boardid_ev");
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) 	pageNum = "1";
		int pageInt = Integer.parseInt(pageNum);
		
		
		int limit = 10;  //한 페이지에 출력될 개시물 개수
		int evcount=0; //조건에 맞는 이벤트 개수
		List<Boardev> list = new ArrayList(); //조건에 맞는 이벤트 리스트
		
		if(req1==null && req2==null) {req1=""; req2="";}//검색단어가 없을 경우
		
		if(req1!=null && req2=="") {//도서관만 검색되었을 경우
			evcount = dao.evCount1(req1,boardid_ev);
			list = dao.evList1(req1,pageInt, limit, evcount,boardid_ev); 
		}
		else if(req1=="" && req2!=null) {//대상만 검색되었을 경우
			evcount = dao.evCount2(req2,boardid_ev);
			list = dao.evList2(req2,pageInt, limit, evcount,boardid_ev); 
		}
		else if(req1!=null && req2!=null) {//도서관과 대상이 같이 검색되었을 경우
			evcount = dao.evCount3(req1,req2,boardid_ev);
			list = dao.evList3(req1,req2,pageInt, limit, evcount,boardid_ev); 
		}
		
		//페이징 작업
		int maxpage = (int) (evcount / limit) + (evcount % limit == 0 ? 0 : 1);
		int bottomLine = 3; // page 1,2,3 : 1, 4,5,6: 2
		int startpage = 1 + (pageInt - 1) / bottomLine * bottomLine;
		int endpage = startpage + bottomLine - 1;
		if (endpage > maxpage) 	endpage = maxpage;
		int boardnum = evcount - (pageInt - 1) * limit;  
		
		
		m.addAttribute("evcount", evcount);  
		m.addAttribute("list", list);  
		m.addAttribute("boardnum", boardnum);
		m.addAttribute("pageNum", pageNum);  
		
		//하단 페이징 작업
		m.addAttribute("startpage", startpage); // 하단 시작 페이지
		m.addAttribute("endpage", endpage);  //하단 end 페이지
		m.addAttribute("bottomLine", bottomLine);  //하단 화면당 페이지 보기
		m.addAttribute("maxpage", maxpage);  //총 페이지수
		
		m.addAttribute("boardName", getBoardevName(boardid_ev));
		m.addAttribute("req1",req1);
		m.addAttribute("req2",req2);
			
		return "boardev/boardevList";
	}
	
	//이벤트를 등록 하는 페이지
	@RequestMapping("evWriteForm") 
	public String evWriteForm() {
		String boardid_ev = (String) session.getAttribute("boardid_ev");
		if (boardid_ev == null)  	boardid_ev = "1";
		m.addAttribute("boardName", getBoardevName(boardid_ev));
		return "boardev/boardevForm";
	}
	
	//이벤트 등록한 내용을 처리
	@RequestMapping("evWritePro") 
	public String evWritePro(Boardev boardev) {
		String path = request.getServletContext().getRealPath("/") + "photo"; //포스터 사진저장 경로
		System.out.println(path);
		MultipartFile multipartFile = boardev.getF();
		
		//포스터 사진 등록처리
		if(!multipartFile.isEmpty()) {
			File file = new File(path, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				boardev.setContent_ev(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}else {
			boardev.setContent_ev("");
		}
		
		String boardid_ev = (String) session.getAttribute("boardid_ev");
		boardev.setBoardid_ev(boardid_ev);
		int num = dao.boardevInsert(boardev); //이벤트 등록한 내용을 Board_event테이블에 삽입
		
        System.out.println(num + "개 저장됨.");
		
		if(num != 1) {
			m.addAttribute("url", "/boardev/evWriteForm?boardid_ev"+boardid_ev);
			m.addAttribute("msg", "등록 실패");
			
		}else {
			m.addAttribute("url", "/boardev/evlist?boardid_ev"+boardid_ev);
			m.addAttribute("msg", "등록 성공");
		}
		return "alert";
	}
	
	//이벤트 등록된 내용과, 관리자에게는 이벤트를 등록한 사람을 리스트로 보여줌 
	@RequestMapping("evChk")
	public String evChk(int eventnum) {
		String boardid_ev = (String) session.getAttribute("boardid_ev");
		
		if (boardid_ev == null)  	{boardid_ev = "1";}
		m.addAttribute("boardName", getBoardevName(boardid_ev));

		//해당 eventnum(이벤트 넘버)와 boardid_ev가 포함된 자료를 테이블에서 찾아서 boardev에 저장
		Boardev boardev = dao.selectBoardev(eventnum,boardid_ev);
		
		/*해당 eventnum(이벤트 넘버)가 있는 자료를 테이블에서 찾아서 리스트로 저장
		 (해당 이벤트를 등록한 사람을 찾기 위함)*/
		List<Eventrsv> list = dao.chkList(eventnum);
		m.addAttribute("boardev", boardev);
		m.addAttribute("list",list);
		return "boardev/boardevChk";
	}
	
	//이벤트를 수정하는 페이지
	@RequestMapping("evUpdateForm")
	public String evUpdateForm(int eventnum) {
		String boardid_ev = (String) session.getAttribute("boardid_ev");

		if (boardid_ev == null)  	boardid_ev = "1";
		m.addAttribute("boardName", getBoardevName(boardid_ev));
		
		//해당 eventnum(이벤트 넘버)와 boardid_ev가 포함된 자료를 테이블에서 찾아서 boardev에 저장
		Boardev boardev = dao.selectBoardev(eventnum,boardid_ev);
		m.addAttribute("boardev", boardev);
		return "boardev/boardevUpdate";
	}
	
	//이벤트 수정된 내용을 처리
	@RequestMapping("evUpdatePro")
	public String evUpdatePro(Boardev boardev) {

		//포스터 사진 등록처리
		String uploadpath = request.getServletContext().getRealPath("/") + "photo";
	    MultipartFile multipartFile = boardev.getF();
		
		if(!multipartFile.isEmpty()) {
			File file = new File(uploadpath, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				boardev.setContent_ev(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//해당 eventnum(이벤트 넘버)가 있는 자료를 테이블에서 찾아서 boardev2에 저장
		Boardev boardev2 = dao.selectOne(boardev.getEventnum());
		String msg = "비밀번호가 틀렸습니다.";
		String url = "boardev/evUpdateForm?eventnum="+boardev.getEventnum();
		
		if(boardev.getPass().equals(boardev2.getPass())) {
			if(dao.update(boardev)) {
				msg = "게시물 수정 완료";
				url = "boardev/evChk?eventnum="+boardev.getEventnum();
			}else {
				msg = "게시물 수정 실패";
			}
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";
	}
	
	//이벤트를 삭제하는 페이지
	@RequestMapping("evDeleteForm")
	public String evDeleteForm(int eventnum) {
		m.addAttribute("eventnum", eventnum);
		return "boardev/boardevDelete";
	}
	
	//이벤트 삭제를 처리
	@RequestMapping("evDeletePro") 
	public String evDeletePro(int eventnum, String pass) {
		
		System.out.println(pass);
		String msg = "비밀번호가 틀렸습니다!";
		String url = "boardev/evDeleteForm?eventnum=" + eventnum;
		
		Boardev boardev = dao.selectOne(eventnum);
		
		//이벤트 등록했을 때의 비밀번호와 같으면 삭제 처리됨
		if (pass.equals(boardev.getPass())) {
			if (dao.delete(eventnum)) {
				msg = "게시글을 성공적으로 삭제하였습니다.";
				url = "boardev/evlist";
			} else {
				msg = "게시글을 삭제하는데 실패하였습니다!";
				url = "boardev/evChk?eventnum=" + eventnum;
			}
		}

		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "alert";
	}
	
	//이벤트 예약 처리
	@RequestMapping("evReserve")
	public String evReserve(Eventrsv eventrsv) {
		
		/*
		 *해당 eventnum(이벤트 넘버)와 memberid(회원아이디)가 Eventrsv(이벤트 예약 테이블)에 있는지 확인
		  num1이 1이면 이미 예약 했으므로 예약 하지 못한다.
		 */
		int num1 = dao.preEvreserve(eventrsv.getEventnum(),eventrsv.getMemberid());

		Boardev boardev = dao.selectOne(eventrsv.getEventnum());
		int a = boardev.getTotal(); //해당 이벤트의 최대 신청가능 인원(정원)
		int b = boardev.getRegister(); //해당 이벤트 신청인원
		
		/*
		 *num1이 0(예약하지 않음), a>b(정원에 미달한 상황)이면 예약 가능
		 *예약 했을 때 a==b가 되면 자동으로 접수중에서 접수종료로 변경된다. 
		 */
		
		if(num1==0) {
			
			if(a>b) {
			
				int num2 = dao.insertEvreserve(eventrsv);
				
				if(num2==1) {
					//Eventrsv테이블 삽입 성공하면 해당 eventnum(이벤트 넘버)를 가진 데이터는 등록인원이 +1 된다.
					dao.rsvstateUpdate(eventrsv.getEventnum());
					
					Boardev dvboardev = dao.selectOne(eventrsv.getEventnum());
					int c = dvboardev.getTotal();
					int d = dvboardev.getRegister();
					
					if(c==d) {//등록인원이 정원과 같으면 자동으로 접수종료
						String state = "접수종료";
						dao.fullUpdate(eventrsv.getEventnum(),state);
						}
					
				    m.addAttribute("msg", "예약에 성공했습니다!");
				    m.addAttribute("url","boardev/evChk?eventnum="+eventrsv.getEventnum());
				}else {
					m.addAttribute("msg", "예약에 실패했습니다.");
					m.addAttribute("url","boardev/evChk?eventnum="+eventrsv.getEventnum());
				}
			}else {
				m.addAttribute("msg", "정원을 초과했습니다.");
				m.addAttribute("url", "boardev/evChk?eventnum="+eventrsv.getEventnum());
			}
		}else {
				m.addAttribute("msg", "이미 예약하였습니다.");
				m.addAttribute("url","boardev/evChk?eventnum="+eventrsv.getEventnum());
		}
		return "alert";
		
	}
	
	//사용자가 이벤트 등록 내역을 확인
	@RequestMapping("evReserveConfirm")
	public String evReserveConfirm(String memberid) {
		
		List<Eventrsv> list = dao.evRsvlist(memberid);
		m.addAttribute("list", list);
		return "boardev/boardevReserve";
	}
	
	//동록한 이벤트 취소
	@RequestMapping("evReserveDelete")
	public String evReserveDelete(int eventnum, String memberid) {
	   /*
		*해당 eventnum(이벤트 넘버)와 memberid(회원 아이디)를 가진 데이터를 Eventrsv테이블에서 삭제
		*삭제 되면 num은 1
		*/
		int num = dao.evReserveDelete(eventnum,memberid);
		
		if(num!=0) {
			//Eventrsv 삭제 성공하면 해당 eventnum(이벤트 넘버)를 가진 데이터는 등록인원이 -1 된다.
			dao.rsvstateUpdate2(eventnum);
			Boardev dvboardev = dao.selectOne(eventnum);
			int a = dvboardev.getTotal();
			int b = dvboardev.getRegister();
			if(a!=b) {
				String state = "접수중";
				dao.fullUpdate(eventnum, state);
			}
			m.addAttribute("msg","예약을 취소했습니다.");
			m.addAttribute("url","boardev/evReserveConfirm?memberid="+memberid);
		}
		else {
			m.addAttribute("msg", "취소에 실패했습니다.");
			m.addAttribute("url", "boardev/evReserveConfirm?memberid="+memberid);
		}
		
		return "alert";
	}
	
}//class end
