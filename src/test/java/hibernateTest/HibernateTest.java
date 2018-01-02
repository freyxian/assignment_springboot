package hibernateTest;

import java.sql.SQLException;
import javax.transaction.Transactional;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.uxpsystems.assignment.dao.UserTblRepository;
import com.uxpsystems.assignment.entity.UserTbl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.uxpsystems.assignment.Application.class)
//@DataJpaTest
@Transactional
public class HibernateTest {
	@Autowired 
	private UserTblRepository factory;
	
	@Test
	public void testDataSource() throws SQLException {
		    
		// UserTbl(long id, String username, String password,
		// String status, String role)
	UserTbl user = new UserTbl((new Long(2)), "xjb", "123456", "Activated","USER");
	factory.save(user);
	}

}
