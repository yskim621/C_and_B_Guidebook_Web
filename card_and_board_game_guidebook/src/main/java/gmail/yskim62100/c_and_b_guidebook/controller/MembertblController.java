package gmail.yskim62100.c_and_b_guidebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gmail.yskim62100.c_and_b_guidebook.service.MembertblService;

@Controller
public class MembertblController {
	@Autowired
	private MembertblService membertblService;
	
	@RequestMapping(value="member/management", method = RequestMethod.GET)
	public String memberinfo(HttpServletRequest request, HttpServletResponse response) {
		
		membertblService.list(request, response);
		
		return "membertbl/management";
	}
	
	@RequestMapping(value="member/detail/{memberemail}", method = RequestMethod.GET)
	public String memberinfodetail(HttpServletRequest request, HttpServletResponse response) {
		
		membertblService.detail(request, response);
		
		return "membertbl/detail";
	}
}
