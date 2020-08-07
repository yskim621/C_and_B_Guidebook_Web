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
	
	// 가장 큰 ItemId를 찾아오는 메소드
	public int maxid() {
		List<Integer> list = sessionFactory.getCurrentSession().createNativeQuery("select max(boardnum) from boardtbl")
				.getResultList();
		return list.get(0);
	}
	
	// 데이터 삽입
	public void insert(Boardtbl boardtbl) {
		//System.out.println("DAO 요청 도달");
		
		sessionFactory.getCurrentSession().save(boardtbl);
	}
	
	// 데이터 수정
	public void update(Boardtbl boardtbl) {
		System.out.println("DAO 요청 도달");
		
		sessionFactory.getCurrentSession().saveOrUpdate(boardtbl);
	}
	 
	// 데이터 삭제 -> Hibernate는 Delete시 DTO를 매개변수로 받음
	public void delete(Boardtbl boardtbl) {
		//이전에 수행 중인 내용을 모두 삭제하고 작업을 수행
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().delete(boardtbl);
	}
	
	
}
