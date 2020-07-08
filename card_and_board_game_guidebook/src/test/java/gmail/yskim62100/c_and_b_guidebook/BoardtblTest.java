package gmail.yskim62100.c_and_b_guidebook;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardtblTest {
	// 데이터 베이스 접속 정보 주입
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Hibernate 설정 확인
	@Test
	public void settingTest(){
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		sessionFactory = context.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
	}

		
	// 데이터베이스 연결을 테스트
	@Test
	public void connectTest() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	
	@Test
	public void HibernateTest() {
		System.out.println(sessionFactory);
	}
	*/

}
