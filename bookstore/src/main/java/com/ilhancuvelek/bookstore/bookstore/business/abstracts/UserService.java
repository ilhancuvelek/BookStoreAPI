package com.ilhancuvelek.bookstore.bookstore.business.abstracts;

import java.util.List;

import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	DataResult<User> getById(int userId);
	
	Result add(User user);
	
	Result update(User user);
	
	Result delete(User user);

	DataResult<User> findByEmail(String email);
}
