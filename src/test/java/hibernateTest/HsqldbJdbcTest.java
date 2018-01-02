package hibernateTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.uxpsystems.assignment.Application.class)
public class HsqldbJdbcTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void HsqlDBTest() throws SQLException {
		
		Connection c = dataSource.getConnection();
		
		Statement stmt = c.createStatement();
		int result = stmt.executeUpdate("INSERT INTO user_tbl VALUES (100,'xja','password','USER','Activated' )");
		c.commit();
	}
}
