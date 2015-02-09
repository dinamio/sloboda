package com.sloboda.site.entity;

public class User {
	
	private Long id;
	
	private String login;
	
	private String password;

	private String email;
	
	private String name;
	
	private String surname;
	
	private Photo avatar;
	
	private Boolean isAdministrator;
	
	public String getLogin() {
		return login;
	}
		
	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Photo getAvatar() {
		return avatar;
	}

	public void setAvatar(Photo avatar) {
		this.avatar = avatar;
	}

	public Boolean getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(Boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
}
