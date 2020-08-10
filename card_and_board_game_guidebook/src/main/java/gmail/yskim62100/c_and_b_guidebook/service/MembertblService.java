package gmail.yskim62100.c_and_b_guidebook.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MembertblService {
	
	public void list(HttpServletRequest request, HttpServletResponse response);
	
	public void detail(HttpServletRequest request, HttpServletResponse response);
	
	// 회원 가입을 위한 메소드
	public void register(HttpServletRequest request);
	
	// 로그인을 위한 메소드
	public void login(HttpServletRequest request);
}
