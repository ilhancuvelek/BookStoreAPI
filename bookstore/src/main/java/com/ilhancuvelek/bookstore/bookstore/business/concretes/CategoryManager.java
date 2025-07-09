package com.ilhancuvelek.bookstore.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.CategoryService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessResult;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.CategoryDao;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	
	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		
		return new SuccessDataResult<List<Category>>(categoryDao.findAll(),"Kategoriler Listelendi.");
	}

	@Override
	public Result add(Category category) {
		categoryDao.save(category);
		return new SuccessResult("Kategori Eklendi.");
	}

	@Override
	public Result update(Category category) {
		categoryDao.save(category);
		return new SuccessResult("Güncellendi.");
	}

	@Override
	public Result delete(Category category) {
		categoryDao.delete(category);
		return new SuccessResult("Silindi.");
	}

	@Override
	public DataResult<Category> getById(int categoryId) {
		return new SuccessDataResult<Category>(categoryDao.getById(categoryId));
	}

}
