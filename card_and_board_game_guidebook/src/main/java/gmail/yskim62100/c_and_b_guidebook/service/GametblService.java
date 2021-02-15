package gmail.yskim62100.c_and_b_guidebook.service;

import javax.servlet.http.HttpServletRequest;

public interface GametblService {
	
	// 상세보기를 위한 메소드
	public void gameinfo_blackjack(HttpServletRequest request);

	public void gameinfo_bacara(HttpServletRequest request);
	
	public void gameinfo_hoola(HttpServletRequest request);
}
