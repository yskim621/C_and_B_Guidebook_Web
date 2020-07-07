package gmail.yskim62100.c_and_b_guidebook.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;

@Repository
public class BoardtblDao {
	@Autowired
	// 하이버네이트 사용 객체
	private SessionFactory sessionFactory;
	
	
	// 전체 데이터 가져오기
	public List<Boardtbl> list() {
		return sessionFactory.getCurrentSession().createCriteria(Boardtbl.class).list();
		
	}
	
	// 상세보기
	public Boardtbl detail(Integer boardtblnum) {
		return sessionFactory.getCurrentSession().get(Boardtbl.class, boardtblnum);
	}
	
	

	
	
}
