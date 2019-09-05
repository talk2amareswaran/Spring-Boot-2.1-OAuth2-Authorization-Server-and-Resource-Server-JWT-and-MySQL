package com.talk2amareswaran.projects.authserver.model;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private String id;
	private String name;

	public CustomUser(UserEntity userEntity) {
		super(userEntity.getEmailId(), userEntity.getPassword(), userEntity.getGrantedAuthoritiesList());
		this.id = userEntity.getId();
		this.name = userEntity.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
