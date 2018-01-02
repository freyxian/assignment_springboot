package com.uxpsystems.assignment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.uxpsystems.assignment.entity.UserTbl;
import com.uxpsystems.assignment.service.UserManager;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class UserController {

	private static final Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserManager home;
	
	@RequestMapping(value="/user", method=GET)
	@ResponseBody	
	public UserTbl userGet(@RequestParam("data")  int id ) {
		logger.debug("User GET json:"+id);
		UserTbl user1 = home.getUserById(id);
	return user1;
	}
	
	@RequestMapping(value="/user", method=POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  UserTbl userPost(@RequestBody UserTbl s_user ) {
		logger.debug("User POST json:"+s_user.toString());
		home.insertUser(s_user);
	return s_user;
	}
	
	@RequestMapping(value="/user", method=PUT,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  UserTbl userPut(@RequestBody UserTbl s_user ) {
		logger.debug("User PUT json:"+s_user.toString());
		home.updateUser(s_user);
	return s_user;
	}
	
	@RequestMapping(value="/user", method=DELETE,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  UserTbl userDelete(@RequestBody UserTbl s_user ) {
		logger.debug("User DELETE json:"+s_user.toString());
		home.deleteUser(s_user.getId());
	return s_user;
	}
	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public UserTbl handleException(HttpServletRequest req, Exception e) {
    	logger.error("Exception Request url ="+req.getRequestURL());
    	logger.error("Exception message ="+e.getMessage());
    	UserTbl uerror = new UserTbl();
    	uerror.setId(0l);
    	uerror.setUsername("Excetpion happened!");
    	return uerror;
    }
}
