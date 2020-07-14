package gmail.yskim62100.c_and_b_guidebook.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MembertblService {
	public void list(HttpServletRequest request, HttpServletResponse response);
	
	public void detail(HttpServletRequest request, HttpServletResponse response);
}
