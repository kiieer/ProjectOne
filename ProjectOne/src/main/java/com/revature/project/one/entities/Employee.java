package com.revature.project.one.entities;

public class Employee {
	private int id;
	private String username;
	private String pass;
	private String type;
	
	public Employee() {
		super();
	}

	public Employee(int id, String username, String type) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
	}

	public Employee(int id, String username, String pass, String type) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[USER] (id=" + id + ", username=" + username + ", pass=" + pass + ", type=" + type + "]";
	}
}
