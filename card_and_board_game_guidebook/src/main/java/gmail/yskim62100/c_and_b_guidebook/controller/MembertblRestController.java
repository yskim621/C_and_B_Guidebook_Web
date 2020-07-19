package gmail.yskim62100.c_and_b_guidebook.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;
import gmail.yskim62100.c_and_b_guidebook.domain.Membertbl;
import gmail.yskim62100.c_and_b_guidebook.service.MembertblService;

@RestController
public class MembertblRestController {
	@Autowired
	private MembertblService membertblService;
	
	@RequestMapping(value="member/register", method = RequestMethod.POST)
	public Membertbl register(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("요청도달");
		
		membertblService.register(request, response);
		
		
		Membertbl membertbl = (Membertbl)request.getAttribute("membertbl");
		System.out.println("RestController: " + membertbl);
		
		return membertbl;
	}

}
