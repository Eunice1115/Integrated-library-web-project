/*
 * 열람실 관련 기능을 처리하는 컨트롤러
 */

package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Seat;
import service.SeatMybatisDao;

@Controller
@RequestMapping("/seat/")
public class SeatController {

	HttpServletRequest request;
	Model m;
	HttpSession session;

	@Autowired
	SeatMybatisDao dao;

	@ModelAttribute
	void init(HttpServletRequest request, Model m) {

		this.request = request;
		this.m = m;
		this.session = request.getSession();
	}

	//시설예약 홈페이지 띄우기
	@RequestMapping("seatInfo")
	public String seatInfo(){
		return "seat/seatInfo";
	}
	
	//입실 처리 페이지 띄우기
	@RequestMapping("seatInput")
	public ModelAndView seatInput(String memberid) {
		m.addAttribute("memberid",memberid);
		return new ModelAndView("seatInput");
	}
	
    //입실처리
	@RequestMapping("seatInputPro")
	public String seatInputPro(Seat seat) {
		
		int num = 0;
		
		//입실 처리 페이지 입력 정보 Seat테이블에 삽입(성공하면 num이 1)
		num = dao.seatInsert(seat);
		m.addAttribute("seat", seat);
		
		String url = "seat/seatInput";
		if (num == 1) {
			m.addAttribute("msg", "입실이 완료 되었습니다");
			
		} else {
			m.addAttribute("msg", "사용중인 좌석입니다");
		}
		m.addAttribute("url", url);
		return "alert";
	}

	//연장 화면 띄우기
	@RequestMapping("seatUpdate")
	public ModelAndView seatUpdate(String memberid) {
		m.addAttribute("memberid",memberid);
		return new ModelAndView("seatUpdate");
	}
	
	//연장 처리
	@RequestMapping("seatUpdatePro")
	public String seatUpdatePro(String memberid, String pass) {
		
		String msg = "비밀번호를 확인해 주세요";
		String url = "seat/seatUpdate?userid=" + memberid;
		int num = 0;
		Seat seat=dao.selectOne(memberid);
		
		//입실했을 때의 비밀번호와 같으면 update(num이 1이면 update됨)
		if(pass.equals(seat.getPass())) {
		num = dao.seatUpdate(memberid, pass);
		}
		
		if(num == 1) {
		msg = "연장 되었습니다";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//퇴실 창 띄우기
	@RequestMapping("seatDelete")
	public ModelAndView seatDelete(String memberid) {
		m.addAttribute("memberid",memberid);
		return new ModelAndView("seatDelete");
	}
	
	//퇴실 처리하기
	@RequestMapping("seatDeletePro")
	public String seatDeletePro(String memberid, String pass) {
		String msg = "회원정보를 확인해주세요";
		String url = "seat/seatDelete?memberid=" + memberid;
		Seat seat=dao.selectOne(memberid);
		int num = 0;
		
		//입실했을 때의 아이디와 비밀번호가 같으면 퇴실처리됨(num이 1이면 delete)
		if(pass.equals(seat.getPass()) && memberid.equals(seat.getMemberid())) {
			num = dao.seatDelete(memberid, pass);
		}
		
		if(num ==1) {
		msg = "퇴실되었습니다";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);
		return "alert";
	}
	
	//해당 회원의 시설예약 내역 보여주기
	@RequestMapping("seatList")
	public String seatList(String memberid) {
		List<Seat> list = dao.Selectlist(memberid);
		System.out.println(list);
		m.addAttribute("list", list);
		return "seat/seatList";
	}
	
}//end