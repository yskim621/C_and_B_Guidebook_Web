package gmail.yskim62100.c_and_b_guidebook;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardtblTest {
	// 데이터 베이스 접속 정보 주입
	@Autowired
	private DataSource dataSource;
	
	//데이터베이스 연결을 테스트
		@Test
		public void connectTest() {
			try {
				System.out.println(dataSource.getConnection());
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
}
