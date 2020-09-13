package com.dlt.exception;

import java.io.Serializable;

public class ApiError implements Serializable {
	private static final long serialVersionUID = 1L;

	private int status;
	private String msg;
	private boolean isError;

	public ApiError() {
		super();
	}

	public ApiError(int status, String msg, boolean isError) {
		super();
		this.status = status;
		this.msg = msg;
		this.isError = isError;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isError() {
		return this.isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

}
