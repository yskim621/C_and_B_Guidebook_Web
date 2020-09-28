package gmail.yskim62100.c_and_b_guidebook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gmail.yskim62100.c_and_b_guidebook.dao.MembertblDao;
import gmail.yskim62100.c_and_b_guidebook.domain.Membertbl;
import gmail.yskim62100.c_and_b_guidebook.util.CryptoUtil;

@Service
public class MembertblServiceImpl implements MembertblService {
	@Autowired
	private MembertblDao membertblDao;
	CryptoUtil cryptoUtil = new CryptoUtil();
	
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
	public void register(HttpServletRequest request) {
		try {
			
			String memberemail = request.getParameter("memberemail");
			String memberpassword = request.getParameter("memberpassword");
			String membername = request.getParameter("membername");
			String membernickname = request.getParameter("membernickname");
			String memberphone = request.getParameter("memberphone");
			String membergender = request.getParameter("membergender");
			
			// 결과를 저장할 Map을 생성
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", false);
			map.put("emailcheck", true);
			map.put("nicknamecheck", true);
			
			String key = "yskim621";
			
			// email 중복 검사
			// 복호화가 가능한 암호화로 되어 있음
			List<String> emaillist = membertblDao.emailcheck();
			for (String temp : emaillist) {
				try {
					// 복호화 해서 비교
					if (cryptoUtil.decrypt(temp).equals(memberemail)) {
						map.put("emailcheck", false);
						request.setAttribute("result", map);
						return;
					}
				} catch (Exception e) {
					System.out.println("이메일 체크 예외" + e.getMessage());
				}
			}

			// nickname 중복검사
			List<String> nicknamelist = membertblDao.nicknamecheck(membernickname);
			if (nicknamelist != null && nicknamelist.size() > 0) {
				map.put("nicknamecheck", false);
				request.setAttribute("result", map);
				return;
			}
			
			// Dao의 파라미터 만들기
			Membertbl membertbl = new Membertbl();
			try {
				membertbl.setMemberemail(cryptoUtil.encrypt(memberemail));
			} catch (Exception e) {
			}
			membertbl.setMembergender(membergender);
			membertbl.setMembername(membername);
			membertbl.setMembernickname(membernickname);
			membertbl.setMemberpassword(BCrypt.hashpw(memberpassword, BCrypt.gensalt()));
			membertbl.setMemberphone(memberphone);
			
			// 회원가입 메소드 호출
			membertblDao.register(membertbl);
			map.put("result", true);
			System.out.println("Service check: " + map);
			request.setAttribute("result", map);
			// map에서 result가 회원가입 성공여부
			// emailcheck는 이메일 중복 검사 통과 여부
			// nicknamecheck는 닉네임 중복 검사 통과 여부
			
		} catch(Exception e) {
			System.out.println("Servcie: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	@Transactional
	public void login(HttpServletRequest request) {
		
		// 파라미터 읽기
		String membernickname = request.getParameter("membernickname");
		String memberpassword = request.getParameter("memberpassword");
		
		// System.out.println("membernickname: " + membernickname);
		// System.out.println("memberpassword: " + memberpassword);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		// nickname을 가지고 데이터를 찾아오기
		List<Membertbl> list = membertblDao.login(membernickname);
		System.out.println("list: " + list);
		
		// nickname에 해당하는 데이터가 없다면 더이상 진행할 필요가 없음
		if(list == null || list.size() < 1) {
			request.setAttribute("result", map);
			return;
		}
		
		// 찾아온 데이터와 비밀번호를 비교
		for(Membertbl member : list) {
			if(BCrypt.checkpw(memberpassword, member.getMemberpassword())) {
				map.put("membernickname", membernickname);
				try {
					map.put("memberemail", cryptoUtil.decrypt(member.getMemberemail()));
				} catch(Exception e) {}
				map.put("result", true);
				request.setAttribute("result", map);
				return;
			}
		}
		
	}
	
}
