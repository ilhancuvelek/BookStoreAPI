package com.ilhancuvelek.bookstore.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.UserService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessResult;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.UserDao;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.User;


@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(userDao.findByEmail(email));
	}

	@Override
	public Result update(User user) {
		userDao.save(user);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(User user) {
		userDao.save(user);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<User> getById(int userId) {
		return new SuccessDataResult<User>(userDao.getById(userId));
	}
	
	

}
