package gmail.yskim62100.c_and_b_guidebook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.JSONPObject;

import gmail.yskim62100.c_and_b_guidebook.dao.MembertblDao;
import gmail.yskim62100.c_and_b_guidebook.domain.Membertbl;

@Service
public class MembertblServiceImpl implements MembertblService {
	@Autowired
	private MembertblDao membertblDao;

	@Override
	@Transactional
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<Membertbl> list = membertblDao.list();
		
		request.setAttribute("list", list);
	}

	@Override
	@Transactional
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String memberemail = ar[ar.length-1];
		
		System.out.println("memberemail: " + memberemail);
		
		Membertbl membertbl = membertblDao.detail(memberemail);
		
		request.setAttribute("membertbl", membertbl);
		
	}

	@Override
	@Transactional
	public void register(HttpServletRequest request, HttpServletResponse response) {
		Membertbl membertbl = new Membertbl();
		try {
			
			String memberemail = request.getParameter("memberemail");
			String memberpassword = request.getParameter("memberpassword");
			String membername = request.getParameter("membername");
			String membernickname = request.getParameter("membernickname");
			String memberphone = request.getParameter("memberphone");
			String membergender = request.getParameter("membergender");
			
			membertbl.setMemberemail(memberemail);
			membertbl.setMembergender(membergender);
			membertbl.setMembername(membername);
			membertbl.setMembernickname(membernickname);
			membertbl.setMemberpassword(memberpassword);
			membertbl.setMemberphone(memberphone);
			
			membertbl = membertblDao.register(membertbl);
			
			
			request.setAttribute("membertbl", membertbl);

		} catch(Exception e) {
			System.out.println("Servcie: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
}
