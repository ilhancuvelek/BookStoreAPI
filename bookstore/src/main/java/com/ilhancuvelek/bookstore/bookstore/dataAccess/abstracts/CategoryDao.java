package com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category	, Integer>{

}
