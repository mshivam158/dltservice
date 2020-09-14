package com.dlt.enumconstant;

public enum ApiErrorCode {
	AMC01("AMC01", "User Not Authorized for this operation");

	private ApiErrorCode(String id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	private String id;
	private String msg;

	public String getMsg() {
		return this.msg;
	}

	public String getId() {
		return this.id;
	}
}
