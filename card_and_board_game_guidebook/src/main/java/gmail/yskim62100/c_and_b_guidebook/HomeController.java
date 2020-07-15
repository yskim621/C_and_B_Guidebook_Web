package gmail.yskim62100.c_and_b_guidebook;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
		
	// 시작 요청이 오면 return에 있는 파일명.jsp으로 포워딩: servlet-context.xml 파일의 ViewResolver와 결합해서 실제 출력할 view를 결정
	@RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	
	// form 요청을 GET으로 전송했을 때 처리할 메소드 (value의 값은 main.jsp의 링크의 URL과 일치해야함)
	@RequestMapping(value="game/trumpcard", method = RequestMethod.GET)
	public String trumpcard() {
		// 단순 페이지 이동은 jsp 파일의 이름만 리턴하면 됨(views/gametbl 디렉토리 내 'trumpcard'.jsp 파일의 jsp를 제외한 이름과 동일해야함)
		return "gametbl/trumpcard";
	}
	
	@RequestMapping(value="game/hwatu", method = RequestMethod.GET)
	public String hwatu() {
		
		return "gametbl/hwatu";
	}
	
	@RequestMapping(value="game/boardgame", method = RequestMethod.GET)
	public String boardgame() {
		
		return "gametbl/boardgame";
	}
	
	
	@RequestMapping(value="member/register", method = RequestMethod.GET)
	public String register() {
		
		return "membertbl/register/register";
	}
	
	@RequestMapping(value="member/login", method = RequestMethod.GET)
	public String login() {
		
		return "membertbl/login/login";
	}
	

	
	/*
	// 예외가 발생하면 처리하는 메소드
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("result", e.getMessage());
		return "exceptionhandling/error404";
	}
	*/
}
