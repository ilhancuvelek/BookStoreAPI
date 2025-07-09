package com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);

}
