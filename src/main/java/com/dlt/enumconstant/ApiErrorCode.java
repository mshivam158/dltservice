package com.dlt.enumconstant;

public enum ApiErrorCode {
	AMC01("AMC01", "User Not Authorized for this operation"),
	AMC02("AMC02", "Failed the addition of New Entry if it is above the upper limit"),
	AMC03("AMC03", "Next state is not Possible at this state"),
	AMC_04(
			"AMC04",
			"Project ID is mendatory"),
	AMC404("AMC404", "Object Not Found for given Id"),
	//System Assets
	AMSA01("AMSA01", "Master Assets ID is mendatory"),
	//Ramd System Config
	AMRSC01("AMRSC01", "Can't create more than 1 Row in Ramd App config setup");

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
