package gmail.yskim62100.c_and_b_guidebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;
import gmail.yskim62100.c_and_b_guidebook.service.BoardtblService;

@Controller
public class BoardtblController {
	@Autowired
	private BoardtblService boardtblService;
	
	@RequestMapping(value="board/list", method = RequestMethod.GET)
	public String board(HttpServletRequest request) {
		
		return "boardtbl/list";
	}
	
	
	@RequestMapping(value="board/get/{boardnum}", method = RequestMethod.GET)
	public String detail(HttpServletRequest request) {
		
		boardtblService.detail(request);
		
		return "boardtbl/detail";
	}
	
	
	
		
	@RequestMapping(value="board/write", method = RequestMethod.GET)
	public String insert() {
		
		return "boardtbl/write";
	}
	
	@RequestMapping(value="board/alter/{boardnum}", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		
		// 서비스 메소드 호출
		boardtblService.detail(request);
		
		return "boardtbl/update";
	}

}
