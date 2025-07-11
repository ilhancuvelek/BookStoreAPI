package com.ilhancuvelek.bookstore.bookstore.core.utilities.results;

public class Result {
	
	private boolean isSuccess;
	private String message;
	
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Result(boolean isSuccess, String message) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
	}
	public Result(boolean isSuccess) {
		super();
		this.isSuccess = isSuccess;
	}

}
