package com.uxpsystems.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Tbl")
public class UserTbl implements java.io.Serializable {
	@Id
	@Column(name = "id")
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String status;
	@Column
	private String role;

	public UserTbl() {
	}

	public UserTbl(Long id, String username, String password, String status, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
