package com.uxpsystems.assignment.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.entity.UserTbl;

public interface UserTblRepository extends CrudRepository<UserTbl, Long> {
	public UserTbl getByUsername(String userName);

	@Modifying
	@Query("UPDATE UserTbl SET username = :username, password = :password, status = :status, role = :role where id = :id")
	public void updateUser(@Param("username") String username, @Param("password") String password,
			@Param("status") String status, @Param("role") String role, @Param("id") Long id);
}