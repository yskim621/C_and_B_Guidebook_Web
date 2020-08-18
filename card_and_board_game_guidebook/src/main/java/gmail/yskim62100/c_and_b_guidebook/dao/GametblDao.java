package gmail.yskim62100.c_and_b_guidebook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.yskim62100.c_and_b_guidebook.domain.Gametbl;

@Repository
public class GametblDao {
	@Autowired
	// 하이버네이트 사용 객체
	private SessionFactory sessionFactory;
	
	public Gametbl gameinfo(String gamecode) {
		
		Gametbl gametbl = sessionFactory.getCurrentSession().get(Gametbl.class, gamecode);
		return gametbl;
	}
}
