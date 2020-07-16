package gmail.yskim62100.c_and_b_guidebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;
import gmail.yskim62100.c_and_b_guidebook.service.BoardtblService;

@RestController
public class BoardtblRestController {
	@Autowired
	private BoardtblService boardtblService;

	@RequestMapping(value="board/write", method = RequestMethod.POST)
	public Boardtbl insert(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("요청도달");
		
		boardtblService.insert(request, response);
		
		Boardtbl boardtbl = (Boardtbl)request.getAttribute("boardtbl");
		System.out.println("RestController: " + boardtbl);
		
		return boardtbl;
	}
	
	
}
