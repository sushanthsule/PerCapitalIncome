package com.sapient.percapitaincome.exception;

public class DataSourceException extends RuntimeException {

	
	private String msg;
	
	public DataSourceException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
