package gmail.yskim62100.c_and_b_guidebook.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import gmail.yskim62100.c_and_b_guidebook.service.MembertblService;

@RestController
public class MembertblRestController {
	@Autowired
	private MembertblService membertblService;
	
	@RequestMapping(value="member/register", method = RequestMethod.POST)
	public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response) {
		membertblService.register(request);
		Map<String, Object> map = (Map<String, Object>) request.getAttribute("result");
		System.out.println("REST controller: " + map);
		return map;
	}
	
	
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public Map<String, Object> login(HttpSession session, HttpServletRequest request){
		membertblService.login(request, session);
		Map<String, Object> map = (Map<String, Object>) session.getAttribute("result");
		//Map<String, Object> map = (Map<String, Object>) request.getAttribute("result");
		return map;
	}

}
