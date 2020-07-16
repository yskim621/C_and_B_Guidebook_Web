package gmail.yskim62100.c_and_b_guidebook.dao;


import java.util.ArrayList;
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
		List<Boardtbl> list = sessionFactory.getCurrentSession().createCriteria(Boardtbl.class).list();
		return list;	
	}
	
	// 상세보기
	public Boardtbl detail(Integer boardnum) {
		return sessionFactory.getCurrentSession().get(Boardtbl.class, boardnum);
	}
	
	
	// 데이터 삽입
	public Boardtbl insert(Boardtbl boardtbl) {
		//System.out.println("DAO 요청 도달");
		List<Boardtbl> list = sessionFactory.getCurrentSession().createSQLQuery("select * from boardtbl where boardnum = (select max(boardnum) from boardtbl)").addEntity(Boardtbl.class).list();
		System.out.println("DAO: " + list);
		System.out.println("DAO: " + list.get(0));
		
		boardtbl.setBoardnum(list.get(0).getBoardnum() + 1);
		boardtbl.setMembernickname("광고문의");
		
		sessionFactory.getCurrentSession().save(boardtbl);
		return boardtbl;
	}
	
	// 데이터 수정
	 
	
	
	
}
