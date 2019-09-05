package com.talk2amareswaran.projects.authserver.dao;

import com.talk2amareswaran.projects.authserver.model.UserEntity;

public interface OAuthDAOService {

	public UserEntity getUserDetails(String emailId);
}
