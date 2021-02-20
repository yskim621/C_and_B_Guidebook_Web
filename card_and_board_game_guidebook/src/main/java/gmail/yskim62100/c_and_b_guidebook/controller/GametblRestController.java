package gmail.yskim62100.c_and_b_guidebook.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmail.yskim62100.c_and_b_guidebook.service.GametblService;

@RestController
public class GametblRestController {
	@Autowired
	private GametblService gametblService;
	
	// Trumpcard
	@RequestMapping(value = "game/trumpcard/black_jack")
	public Map<String, Object> gameinfo_blackjack(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		// System.out.println("REST controller: " + result);
		
		// 리턴부분이 Json형태로 형태로 자료를 만들기 위해서는 Serializable이 필요
		return map;
	}
	
	@RequestMapping(value = "game/trumpcard/bacara")
	public Map<String, Object> gameinfo_bacara(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
				
		return map;
	}
	
	@RequestMapping(value = "game/trumpcard/hoola")
	public Map<String, Object> gameinfo_hoola(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	
	
	// Hwatu
	@RequestMapping(value = "game/hwatu/gostop")
	public Map<String, Object> gameinfo_gostop(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	@RequestMapping(value = "game/hwatu/seosda")
	public Map<String, Object> gameinfo_seosda(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	
	
	// Boardgame
	@RequestMapping(value = "game/boardgame/chess")
	public Map<String, Object> gameinfo_chess(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	@RequestMapping(value = "game/boardgame/go")
	public Map<String, Object> gameinfo_go(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	@RequestMapping(value = "game/boardgame/janggi")
	public Map<String, Object> gameinfo_janggi(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}
	
	@RequestMapping(value = "game/boardgame/omok")
	public Map<String, Object> gameinfo_omok(HttpServletRequest request) {

		gametblService.gameinfo(request);
		
		List<String> result = (List<String>) request.getAttribute("result");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		return map;
	}

	
}
