package gmail.yskim62100.c_and_b_guidebook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;
import gmail.yskim62100.c_and_b_guidebook.service.BoardtblService;

@RestController
public class BoardtblRestController {
	@Autowired
	private BoardtblService boardtblService;
	//ModelAndView mav = null;
	
	
	// 검색해서 데이터를 전송하는 요청을 생성
	@RequestMapping(value = "board/select")
	public Map<String, Object> select(HttpServletRequest request) {
		// 서비스 메소드를 호출해서 결과를 가져옵니다.
		boardtblService.select(request);
		List<Boardtbl> list = (List<Boardtbl>) request.getAttribute("list");
		int count = (Integer) request.getAttribute("count");
		String pageno = (String) request.getAttribute("pageno");
		//int startpage = (Integer) request.getAttribute("startpage");
		int endpage = (Integer) request.getAttribute("endpage");
		//boolean prev = (Boolean) request.getAttribute("prev");
		boolean next = (Boolean) request.getAttribute("next");
		 
		
		// 가져온 데이터를 출력할 Map에 저장하고 Map을 출력
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("list", list);
		map.put("pageno", pageno);
		//map.put("startpage", startpage);
		map.put("endpage", endpage);
		//map.put("prev", prev);
		map.put("next", next);
		
		return map;
	}
	
	
	@RequestMapping(value = "board/detail/{boardnum}")
	public Map<String, Object> detail(HttpServletRequest request) {

		boardtblService.detail(request);
		Boardtbl boardtbl = (Boardtbl) request.getAttribute("boardtbl");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardtbl", boardtbl);
		
		//mav.setViewName("boardtbl/datail");
		
		return map;
	}
	

	@RequestMapping(value="board/write", method = RequestMethod.POST)
	public Map<String, Object> insert(MultipartHttpServletRequest request) {
		
		// System.out.println("요청도달");
		
		boardtblService.insert(request);
		Boolean result = (Boolean) request.getAttribute("insert");
		Map<String, Object> map = new HashMap<String, Object>();
		// 삽입에 성공하면 result는 true 그렇지 않으면 false
		if (result != null)
			map.put("result", result);
		else
			map.put("result", false);
		return map;	
	}
	
	
	@RequestMapping(value="board/update/{boardnum}", method = RequestMethod.POST)
	public Map<String, Object> update(MultipartHttpServletRequest request) {
		
		System.out.println("RestController 요청도달");
		
		boardtblService.update(request);
		
		Boolean result = (Boolean) request.getAttribute("update");
		Map<String, Object> map = new HashMap<String, Object>();
		// 삽입에 성공하면 result는 true 그렇지 않으면 false
		if (result != null)
			map.put("result", result);
		else
			map.put("result", false);
		
		System.out.println("RestController: " + result);
		return map;
		
	}
	
	
	@RequestMapping(value="board/delete", method=RequestMethod.POST)
	public Map<String, Object> delete(HttpServletRequest request){
		
		boardtblService.delete(request);
		
		Map<String, Object> map = (Map<String, Object>) request.getAttribute("result");
		
		System.out.println("RestController: " + map);
		return map;
	}
	
	
}
