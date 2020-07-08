package gmail.yskim62100.c_and_b_guidebook.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembertblDao {
	@Autowired
	// 하이버네이트 사용 객체
	private SessionFactory sessionFactory;
}
