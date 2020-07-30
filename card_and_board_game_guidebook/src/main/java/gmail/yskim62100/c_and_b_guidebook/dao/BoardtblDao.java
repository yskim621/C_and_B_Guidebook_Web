package gmail.yskim62100.c_and_b_guidebook.dao;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<Boardtbl> select(Map<String, Object> map) {
		// 결과를 저장할 list
		List<Boardtbl> list = new ArrayList<Boardtbl>();

		// 검색항목 - searchtype, 검색어 - value
		// 시작번호 - start 페이지 당 데이터 개수 - size

		// 파라미터 읽기 - ServiceImpl에서 만들어서 넘겨주어야 합니다.
		String searchtype = (String) map.get("searchtype");
		String value = (String) map.get("value");
		int start = (Integer) map.get("start");
		int size = (Integer) map.get("size");

		// like 검색을 하기 위해서 % 사용
		// 대소문자 구분하지 않고 검색하기 위해서 toLowerCase 사용
		if(value != null) {
			value = "%" + value.toLowerCase() + "%";
		}	

		if (searchtype == null) {
			list = sessionFactory.getCurrentSession()
					.createNativeQuery("select * from boardtbl limit " + start + "," + size).getResultList();
		} else if (searchtype.equals("membernickname")) {
			list = sessionFactory
					.getCurrentSession().createNativeQuery("select * from boardtbl where "
							+ "lower(membernickname) like \'" + value + "\' limit " + start + "," + size)
					.getResultList();
		} else if (searchtype.equals("boardtitle")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select * from boardtbl where "
					+ "lower(boardtitle) like \'" + value + "\' limit " + start + "," + size).getResultList();
		} else if (searchtype.equals("both")) {
			list = sessionFactory.getCurrentSession()
					.createNativeQuery("select * from boardtbl where " + "lower(boardtitle) like \'" + value + "\'"
							+ " or lower(membernickname) like \'" + value + "\' limit " + start + ", " + size)
					.getResultList();
		}
		return list;
	}
	
	// 검색 결과의 데이터 개수를 리턴하는 메소드
	// 하이버네이트에서는 정수를 리턴할 때는 BigInteger로 리턴됩니다.
	public BigInteger count(Map<String, Object> map) {
		// 파라미터 읽기 - ServiceImpl에서 만들어서 넘겨주어야 합니다.
		String searchtype = (String) map.get("searchtype");
		String value = (String) map.get("value");

		List<BigInteger> list = null;
		if(value != null) {
			value = "%" + value.toLowerCase() + "%";
		}
		
		if (searchtype == null) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select count(*) from boardtbl").getResultList();
		} else if (searchtype.equals("membernickname")) {
			list = sessionFactory.getCurrentSession()
					.createNativeQuery("select count(*) from boardtbl " + "where lower(membernickname) like \'" + value + "\'")
					.getResultList();
		} else if (searchtype.equals("boardtitle")) {
			list = sessionFactory.getCurrentSession()
					.createNativeQuery("select count(*) from boardtbl " + "where lower(boardtitle) like \'" + value + "\'")
					.getResultList();
		} else if (searchtype.equals("both")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select count(*) from boardtbl "
					+ "where lower(boardtitle) like \'" + value + "\'" + " or lower(membernickname) like \'" + value + "\'")
					.getResultList();
		}
		return list.get(0);
	}
	
	// 상세보기
	public Boardtbl detail(Integer boardnum) {
		Boardtbl boardtbl = sessionFactory.getCurrentSession().get(Boardtbl.class, boardnum);
		return boardtbl;
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
	public Boardtbl update(Boardtbl boardtbl) {
		
		sessionFactory.getCurrentSession().update(boardtbl);
		return boardtbl;
	}
	 
	
	
	
}
