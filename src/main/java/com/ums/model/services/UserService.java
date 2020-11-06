package com.ums.model.services;

import com.ums.model.entity.User;

public interface UserService {

	public User findByUsername(String username);
}
