package com.ilhancuvelek.bookstore.bookstore.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.UserService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.ErrorDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.User;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService service;
	
	@Autowired
	public UsersController(UserService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return service.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(service.add(user));
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody User user) {
		return service.update(user);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody User user) {
		return service.delete(user);
	}

	@GetMapping("/findByEmail")	
	public DataResult<User> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}
	@GetMapping("/getById")	
	public DataResult<User> getById(@RequestParam int userId) {
		return service.getById(userId);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		
		return errors;
	}

}
