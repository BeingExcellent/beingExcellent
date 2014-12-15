package com.beingExcellent.authentication.dao;

import com.beingExcellent.model.entity.Users;



public interface LoginDao {
	Users findByUserName(String username);
}
