package gmail.yskim62100.c_and_b_guidebook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardtblService {
	// 전체 보기를 위한 메소드
	public void select(HttpServletRequest request);
	
	// 상세 보기를 위한 메소드
	public void detail(HttpServletRequest request);
	
	// 데이터 삽입을 위한 메소드
	public void insert(HttpServletRequest request, HttpServletResponse response);
	
	// 데이터 수정을 위한 메소드
	public void update(HttpServletRequest request, HttpServletResponse response);
}
