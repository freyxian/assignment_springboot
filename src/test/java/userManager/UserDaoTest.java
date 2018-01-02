package userManager;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.UserTbl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.uxpsystems.assignment.Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class UserDaoTest {
	@Autowired
	UserDao userDao;
	
	 @Test
	 public void a_insert() throws Exception {
		 
		 UserTbl user = new UserTbl(new Long(101),"aab","123","Activated","USER");
		 //UserDao userDao = (UserDao) context.getBean("com.uxpsystems.assignment.dao.UserDao");
		 userDao.insertUser(user);
	 }
	
	 @Test
	 public void b_findById() throws Exception {
		 UserTbl user = userDao.getUserById(103);
		 if(user == null)System.out.println("User not found!");
		 else System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==103);
	 }
	
	 @Test
	 public void c_findByName() throws Exception {
		 UserTbl user = userDao.getUserByName("aace");
		 System.out.println("User Name is: "+user.getUsername());
		 assertTrue(user.getId()==104);
	 }
	 
	 @Test
	 public void d_updateUser() throws Exception {
		 UserTbl user = new UserTbl(new Long(201),"aac","12345","Deactivated","USER");
		 userDao.updateUser(user);
	 }
	 
	 @Test
	 public void e_deleteUser() throws Exception {
		 
		 userDao.deleteUser((long) 201);
	 }
}
