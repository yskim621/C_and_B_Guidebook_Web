package gmail.yskim62100.c_and_b_guidebook.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.yskim62100.c_and_b_guidebook.domain.Membertbl;

@Repository
public class MembertblDao {
	@Autowired
	// 하이버네이트 사용 객체
	private SessionFactory sessionFactory;
	
	
	public List<Membertbl> list(){
		return sessionFactory.getCurrentSession().createCriteria(Membertbl.class).list();
	}
	
	public Membertbl detail(String memberemail) {
		
		Membertbl membertbl = sessionFactory.getCurrentSession().get(Membertbl.class, memberemail);
		return membertbl;
	}
	
	
	// email 중복 검사를 위한 메소드
	public List<String> emailcheck(){
		List<String> list = sessionFactory.getCurrentSession().createNativeQuery("select memberemail from membertbl").getResultList();
		return list;
	}
	
	
	// nickname 중복 검사를 위한 메소드
	public List<String> nicknamecheck(String membernickname){
		List<String> list = sessionFactory.getCurrentSession().createNativeQuery("select membernickname from membertbl"
							+ " where membernickname = \'" + membernickname + "\'").getResultList();
		return list;
	}
	
	
	// 회원가입을 위한 메소드
	public void register(Membertbl membertbl) {
		
		sessionFactory.getCurrentSession().save(membertbl);
	}
	
	// 로그인을 위한 메소드
	// membernickname과 memberpassword를 가지고 로그인
	// membernickname를 가지고 모든 정보를 전부 찾아가면 
	public List<Membertbl> login(String membernickname){
		List<Membertbl> list = sessionFactory.getCurrentSession().createNativeQuery(
					  "select memberemail, memberpassword, membernickname, membername,  memberphone, membergender, memberleave "
					+ "from membertbl "
					+ "where membernickname = \'" + membernickname + "\'", Membertbl.class).getResultList();
		return list;
	}
}
