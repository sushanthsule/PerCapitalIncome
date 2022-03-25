package com.sapient.percapitaincome.exception;

public class RateExchangeException extends RuntimeException{

	private String msg;
	
	public RateExchangeException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
