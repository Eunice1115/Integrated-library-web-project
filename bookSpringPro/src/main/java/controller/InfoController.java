/*
 * 도서관 이용, 정보를 보여주는 기능을 담은 컨트롤러
 */

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info/")
public class InfoController {
	
	HttpServletRequest request;
	Model m;
	HttpSession session;
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		this.request = request;
		this.m = m;
		this.session = request.getSession();
	}
	
	//도서관 이용 페이지 띄우기
	@RequestMapping("libUse")
	public String libraryUse() {
		return "info/libraryUse";
	}
	
	//도서관 정보 페이지 띄우기
	@RequestMapping("libInfo")
	public String libraryInfo() {
		return "info/libraryInfo";
	}
	
	
	
}//end