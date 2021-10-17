/*
 * 회원가입 등 관련된 기능을 담은 컨트롤러
 */

package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Member;
import oracle.sql.DATE;

import service.MemberMybatisDao;

@Controller
@RequestMapping("/member/")
public class MemberController  {
	
	HttpServletRequest request;
	Model m;
	HttpSession session;
	
	@Autowired
	MemberMybatisDao dao;
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		this.request = request;
		this.m = m;
		this.session = request.getSession();
	}
	
	//홈화면 띄우기
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	// 회원가입 페이지로 가기
	@RequestMapping("memberInput")
	public String memberInput() {
		return "member/memberInput";
	}
	
	
	//회원가입 처리
	@RequestMapping("memberInputPro")
	public String memberInputPro(Member member) {
		//회원정보 Member테이블에 삽입(num이 1이면 삽입 성공)
		int num = dao.memberInsert(member);
		m.addAttribute("member", member);
		if(num != 1) {
			m.addAttribute("url", "/member/memberInput");
			m.addAttribute("msg", "회원가입에 실패하였습니다");
			
		}else {
			m.addAttribute("url", "/member/loginForm");
			m.addAttribute("msg", "회원가입에 성공하였습니다");
		}
		return "alert";	
	}
	
	//로그인 페이지 띄우기
	@RequestMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//로그인 처리
	@RequestMapping("loginPro")
	public String loginPro(String memberid, String pass)  {
		//해당 memberid(회원아이디가 있는 데이터 조회해서 member로 저장)
		Member member = dao.selectOne(memberid);
		
		String msg = "아이디를 확인하세요";
		String url = "member/loginForm";
		
		if(member != null) {
			if(pass.equals(member.getPass())) {
				request.getSession().setAttribute("login", memberid);
				msg=member.getName() + "님이 로그인 하셨습니다.";
				url = "member/main";
		}else {
				msg="비밀번호를 확인하세요.";
				url = "member/loginForm";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//로그아웃처리
	@RequestMapping("logOut")
	public String logOut(){
		request.getSession().invalidate();
		return "main";
	}
	
	
	//관리자(admin)이 보는 멤버리스트 
	@RequestMapping("memberList")
	public String memberList(String req) {
		//검색폼에서 회원 아이디(req) 입력 받아 세션에 저장
		session.setAttribute("req", req);
		
		String id = (String) session.getAttribute("login");
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		
		if (id != null && id.equals("admin")) {
			
			if (request.getParameter("pageNum") != null) {
				session.setAttribute("pageNum", request.getParameter("pageNum"));
			}
			
			if(req == null) {req ="";}
			
			String pageNum = (String) session.getAttribute("pageNum");
			if (pageNum == null) 	{pageNum = "1";}
			int pageInt = Integer.parseInt(pageNum);
			
			int limit = 10; //한 페이지에 출력될 회원 수
			int membercount = dao.memberCount(req); //조건을 만족한 회원수
			List<Member> mlist = dao.memberList(req, pageInt, limit, membercount); //조건을 만족한 회원리스트
			
			int maxpage = (int) (membercount / limit) + (membercount % limit == 0 ? 0 : 1);
			int bottomLine = 3; // page 1,2,3 : 1, 4,5,6: 2
			int startpage = 1 + (pageInt - 1) / bottomLine * bottomLine;
			int endpage = startpage + bottomLine - 1;
			if (endpage > maxpage) 	endpage = maxpage;
			int boardnum = membercount - (pageInt - 1) * limit; 
			
			
			m.addAttribute("mlist", mlist);
			m.addAttribute("pageNum", pageNum);
			
			m.addAttribute("startpage", startpage); 
			m.addAttribute("endpage", endpage);  
			m.addAttribute("bottomLine", bottomLine); 
			m.addAttribute("maxpage", maxpage);
			
			m.addAttribute("req",req);
			
			return "member/memberList";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";

	}
	
	
	
	//회원 정보 확인
	@RequestMapping("memberInfo")
	public String memberInfo(String userid) {
		
		String id = (String) session.getAttribute("login");
		
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		
		if (id != null) {
			if (id.equals("admin")) {
				Member member = dao.selectOne(userid);
				m.addAttribute("member", member);
				return "member/memberInfo";
			} else {
				Member member = dao.selectOne(id);
				m.addAttribute("member", member);
				return "member/memberInfo";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//회원 정보 수정화면 띄우기
	@RequestMapping("memberUpdate")
	public String memberUpdate(String userid){
		
		String id = (String) session.getAttribute("login");
	
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		if (id != null) { // login 되어있음
			if (id.equals("admin")) { // login id가 admin
				Member member = dao.selectOne(userid);
				m.addAttribute("member", member);
				return "member/memberUpdate";
			} else { // admin 이 아닌 유저
				Member member = dao.selectOne(id);
				m.addAttribute("member", member);
				return "member/memberUpdate";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//회원 정보 수정 처리
	@RequestMapping("memberUpdatePro")
	public String memberUpdatePro(String userid, Member member) {
		
		String id = (String) session.getAttribute("login");
		
		String msg = "수정 할 수 없습니다";
		String url = "member/main";
		int num = 0;
		
		if (id != null) {
			if (id.equals("admin")) {
				member.setMemberid(userid);
				url = "member/memberList";
			} else {
				member.setMemberid(id);
				url = "member/memberInfo";
			}
			num = dao.memberUpdate(member); //수정된 회원정보 Member테이블에 update(num이 1이면 성공)
		}
		
		if (num==1) {
			msg="수정되었습니다 ";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//삭제 화면 띄우기
	@RequestMapping("memberDelete")
	public String memberDelete(String userid)  {
		
		String id = (String) session.getAttribute("login");
		
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/loginForm";
		
		if (id != null) { // login 되어있음
			if (id.equals("admin")) { // login id가 admin
				Member member = dao.selectOne(userid);
				m.addAttribute("member", member);
				return "member/deleteForm";
			} else { // admin 이 아닌 유저
				Member member = dao.selectOne(id);
				m.addAttribute("member", member);
				return "member/deleteForm";
			}
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	
	//삭제 처리하기
	@RequestMapping("memberDeletePro")
	public String memberDeletePro(String userid, String pass) {
		
		String id = (String) session.getAttribute("login");
		
		String msg = "탈퇴 할 수 없습니다";
		String url = "member/main";
		
		int num = 0;
		
		if (id != null) {
			if (id.equals("admin")) {
				num = dao.memberDelete(userid, pass); //해당 id와 비밀번호가 있는 데이터 삭제(1이면 삭제됨)
				url = "member/memberList";
			} else {
				num = dao.memberDelete(id, pass);
				request.getSession().invalidate();
				url = "member/main";			
			}	
		}
		
		if (num==1) {			
			msg="탈퇴 하였습니다";			
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	
	//사이트맵 화면 띄우기
	@RequestMapping("siteMap")
	public String siteMap()  {
		return "member/siteMap";
	
	}
	
	
	//아이디 중복체크 화면 띄우기
	@RequestMapping("idChkForm")
	public ModelAndView idChkForm() {
		return new ModelAndView("idChkForm");
	}
	
	//아이디 중복체크 처리
	@RequestMapping("idChkPro")
	public String idChkPro(String memberid) {
		int num = dao.idChk(memberid);//Member테이블에서 해당 memberid개수 확인
		System.out.println(num);
		System.out.println(memberid);
		String msg = "회원정보를 확인 할 수 없습니다";
		String url = "member/idChkForm";
		if(num !=0 ) {
			msg = "중복된 아이디 입니다.";
		}else {
			msg="사용 가능한 아이디 입니다.";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
}//end
	
