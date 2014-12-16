package com.beingExcellent.repositories.rdbms;

import com.beingExcellent.model.entity.User;

public interface UserRepository {
	User findByUserName(String userName);
}
