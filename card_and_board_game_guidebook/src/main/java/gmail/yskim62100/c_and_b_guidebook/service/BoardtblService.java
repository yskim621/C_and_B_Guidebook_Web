package gmail.yskim62100.c_and_b_guidebook.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardtblService {
	// 전체 보기를 위한 메소드
	public void select(HttpServletRequest request);
	
	// 상세 보기를 위한 메소드
	public void detail(HttpServletRequest request);
	
	// 데이터 삽입을 위한 메소드
	public void insert(MultipartHttpServletRequest request);
	
	// 데이터 수정을 위한 메소드
	public void update(MultipartHttpServletRequest request);
	
	// 데이터 삭제을 위한 메소드
	public void delete(HttpServletRequest request);
	
}
