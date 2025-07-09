package com.ilhancuvelek.bookstore.bookstore.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.CategoryService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	@GetMapping("/getall")
	public DataResult<List<Category>> getAll(){
		return categoryService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Category category) {
		return categoryService.update(category);
		
	}

	@DeleteMapping("/delete")
	public Result delete( @RequestBody Category category) {
		return categoryService.delete(category);
		
	}
	@GetMapping("/getById")
	public DataResult<Category> getById(@RequestParam int categoryId) {
		return categoryService.getById(categoryId);
	}

}
