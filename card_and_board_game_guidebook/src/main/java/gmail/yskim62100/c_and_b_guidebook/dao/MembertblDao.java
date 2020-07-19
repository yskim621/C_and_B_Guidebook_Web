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
		return sessionFactory.getCurrentSession().get(Membertbl.class, memberemail);
	}
	
	public Membertbl register(Membertbl membertbl) {
		
		sessionFactory.getCurrentSession().save(membertbl);
		return membertbl;
	}
}
