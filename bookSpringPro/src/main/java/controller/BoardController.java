/*
 * 공지사항,건의사항(게시판) 관련된 기능을 담은 컨트롤러
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import service.BoardMybatisDao;



@Controller
@RequestMapping("/board/")
public class BoardController {
	
	
	HttpServletRequest request;
	Model m;
	HttpSession session;
	
	
	
	@Autowired
	BoardMybatisDao dao;
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		
		this.request = request;
		this.m = m;
		this.session = request.getSession();
		
	}
	
	//boardid 숫자에 따라 게시판 종류 출력
	public String getBoardName(String boardid) {
			
		String boardName = "";
		switch (boardid) {
		case "1": {   boardName="공지사항"; break;	}
		case "2": {   boardName="건의사항"; break;	}
		default:boardName="공지사항";
		}
		return boardName;
	}
		
	//공지사항 및 건의사항 리스트로 보여주기
	@RequestMapping("list")
	public String list(String req1,String req2) {
		//pageNum(현재 페이지 넘버), boardid(현재 boardid 숫자)가져와서 세션에 저장
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		
		if (request.getParameter("boardid") != null) {
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", "1");
		}

		//검색폼에 검색된 req1(도서관 이름), req2(작성자)가져와서 세션에 저장
		session.setAttribute("req1", req1);
		session.setAttribute("req2", req2);
		
		String boardid = (String) session.getAttribute("boardid");
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) 	pageNum = "1";
		int pageInt = Integer.parseInt(pageNum);
		
        int limit = 10; // 한페이지에 출력할 게시물 건수
        int boardcount=0; //조건에 맞는 게시물 개수
        List<Board> list = new ArrayList<Board>(); //조건에 맞는 게시물 리스트
        
        if(req1==null && req2==null) {req1=""; req2="";} //검색 단어가 없을 경우
        
        if(req1!=null && req2 =="") {//도서관만 검색되었을 경우
			boardcount = dao.boardCount1(req1, boardid);
			System.out.println(boardcount);
			list = dao.list1(req1,pageInt,limit,boardid); 
			System.out.println(list);
        }
        else if(req1=="" && req2!=null) {//작성자만 검색되었을 경우
        	boardcount = dao.boardCount2(req2, boardid);
        	System.out.println(boardcount);
        	list = dao.list2(req2,pageInt,limit,boardid);
        	System.out.println(list);
        }
        else if(req1!=null && req2!=null) {//도서관과 작성자모두 검색되었을 경우
        	boardcount = dao.boardCount3(req1, req2, boardid);
        	System.out.println(boardcount);
        	list = dao.list3(req1,req2,pageInt,limit,boardid);
        	System.out.println(list);
        }
        
        
		//페이징 작업
		int maxpage = (int) (boardcount / limit) + (boardcount % limit == 0 ? 0 : 1);
		int bottomLine = 3; // page 1,2,3 : 1, 4,5,6: 2
		int startpage = 1 + (pageInt - 1) / bottomLine * bottomLine;
		int endpage = startpage + bottomLine - 1;
		if (endpage > maxpage) 	endpage = maxpage;
		int boardnum = boardcount - (pageInt - 1) * limit;  
		
		m.addAttribute("boardcount", boardcount);  // 등록된 전체 게시물의 건수
		m.addAttribute("list", list);  //프린트한 게시물
		m.addAttribute("boardnum", boardnum); //게시물 시작번호
		m.addAttribute("pageNum", pageNum);  //현재 페이지 번호
		
		//하단 페이징
		m.addAttribute("startpage", startpage); // 하단 시작 페이지
		m.addAttribute("endpage", endpage);  //하단 end 페이지
		m.addAttribute("bottomLine", bottomLine);  //하단 화면당 페이지 보기
		m.addAttribute("maxpage", maxpage);  //총 페이지수
	
		//게시판 제목
		m.addAttribute("boardName", getBoardName(boardid));  //게시판 제목 (공지시항, 건의사항)
		m.addAttribute("boardid",boardid);
		m.addAttribute("req1",req1);
		m.addAttribute("req2",req2);
	
		return "board/boardList";
	}
	
	
	//게시판 작성하는 화면 보여주기
	@RequestMapping("writeForm") 
	public String writeForm() {
		String boardid = (String) session.getAttribute("boardid");
		if (boardid == null)  	boardid = "1";
		request.setAttribute("boardName", getBoardName(boardid));
		return "board/boardInfoForm";
	}
	
	//게시판 작성한 내용 처리
	@RequestMapping("writePro")
	public String writePro(Board board) {
		
		String uploadpath = request.getServletContext().getRealPath("/") + "upfile";//파일 경로
		MultipartFile multipartFile = board.getF();

		//파일 업로드처리
		if(!multipartFile.isEmpty()) {
			File file = new File(uploadpath, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				board.setFile1(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			board.setFile1("");
		}
		
		String boardid = (String) session.getAttribute("boardid");
		if (boardid == null)  	boardid = "1";
		
		board.setBoardid(boardid);
		
		String msg = "게시물 등록 실패";
		String url = "board/writeForm";
		
		if(dao.insert(board)) {
			msg = "게시물 등록 성공";
			url = "board/list";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		
		return "alert";
	
	}	

	//게시물 작성내용 확인
	@RequestMapping("info") 
	public String info(int num) {

		Board board = dao.selectOne(num); // 해당 게시물번호를 가진 게시물 조회
		dao.readcntadd(num); // 조회건수증가
		m.addAttribute("board", board);
		String boardid = (String) request.getSession().getAttribute("boardid");
		if (boardid == null)  	boardid = "1";
		request.setAttribute("boardName", getBoardName(boardid));
		
		return "board/boardInfo";
	}

	//게시물 수정화면 띄우기
	@RequestMapping("updateForm") 
	public String updateForm(int num) {
		Board board = dao.selectOne(num);
		m.addAttribute("board", board);
		return "board/boardUpdate";
	}

	//게시물 수정 처리
	@RequestMapping("update")
	public String update(Board board) {
		
		String uploadpath = request.getServletContext().getRealPath("/") + "upfile/"; //파일 경로
	    MultipartFile multipartFile = board.getF();
		
	    //파일 업로드 처리
		if(!multipartFile.isEmpty()) {
			File file = new File(uploadpath, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				board.setFile1(multipartFile.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Board dbBoard = dao.selectOne(board.getNum());
		String msg = "비밀번호가 틀렸습니다.";
		String url = "board/updateForm?num="+board.getNum();
		
		if(board.getPass().equals(dbBoard.getPass())) {
			if(dao.update(board)) {
				msg = "게시물 수정 완료";
				url = "board/list";
			}else {
				msg = "게시물 수정 실패";
			}
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		
		return "alert";
	}
	
	//게시물 삭제 화면 띄우기
	@RequestMapping("deleteForm") 
	public String deleteForm(int num) {
		m.addAttribute("num", num);
		return "board/boardDelete";
	}
	
	//게시물 삭제 처리
	@RequestMapping("delete") 
	public String delete(int num, String pass) {
		
		System.out.println(pass);
		String msg = "비밀번호가 틀렸습니다!";
		String url = "board/deleteForm?num=" + num;
		
		Board board = dao.selectOne(num);
		
		if (pass.equals(board.getPass())) {
			if (dao.delete(num)) {
				msg = "게시글을 성공적으로 삭제하였습니다.";
				url = "board/list";
			} else {
				msg = "게시글을 삭제하는데 실패하였습니다!";
				url = "board/info?num=" + num;
			}
		}

		m.addAttribute("url", url);
		m.addAttribute("msg", msg);

		return "alert";
	}

	//답글쓰는 화면 띄우기
	@RequestMapping("replyForm") 
	public String replyForm(int num) {
		
		Board board = dao.selectOne(num); // 게시물 조회
		
		m.addAttribute("board", board);
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null)  	boardid = "1";
		m.addAttribute("boardName", getBoardName(boardid));
		return "board/replyForm";
	}
	
	//답글쓰기 처리
	@RequestMapping("replyPro") 
	public String replyPro(Board board) {
		String boardid = (String) session.getAttribute("boardid");
		if (boardid == null) 	boardid = "1";
		
		board.setFile1("");
		board.setBoardid(boardid);
		dao.refstepadd(board.getRef(), board.getRefstep());
		
		String msg = "답변등록시 오류발생";
		String url = "board/replyForm?num=" + board.getNum();
		if (dao.insert(board)) {
			msg = "답변등록 완료";	url = "board/list";
		}
		m.addAttribute("url", url);
		m.addAttribute("msg", msg);
		return "alert";
	}
	
	//faq화면 띄우기
	@RequestMapping("faqForm")
	public String faqForm() {
		return "board/faqForm";
	}
	
}//end