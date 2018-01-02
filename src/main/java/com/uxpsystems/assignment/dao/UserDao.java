package com.uxpsystems.assignment.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.uxpsystems.assignment.entity.UserTbl;

@Component
@Transactional
public class UserDao {
	private static final Log logger = LogFactory.getLog(UserDao.class);

	@Autowired
	private UserTblRepository respository;

	public void insertUser(UserTbl user) {
		logger.debug("In UserDao, respository=" + respository.toString());

		respository.save(user);
	}

	public UserTbl getUserById(long userId) {
		logger.debug("UserDao.getUserById" + userId);

		UserTbl user = (UserTbl) respository.findOne(userId);
		return user;
	}

	public UserTbl getUserByName(String username) {
		logger.debug("In UserDao, respository=" + respository.toString());
		UserTbl user = (UserTbl) respository.getByUsername(username);
		return user;
	}

	public void updateUser(UserTbl user) {
		logger.debug("In UserDao, respository=" + respository.toString());
		respository.updateUser(user.getUsername(), user.getPassword(), user.getStatus(), user.getRole(), user.getId());
	}

	public void deleteUser(Long id) {
		logger.debug("In UserDao, respository=" + respository.toString());
		respository.delete(id);
	}
}
