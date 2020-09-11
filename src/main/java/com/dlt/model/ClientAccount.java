package com.dlt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * • Above data is entered by the system administrator through system admin
 * interface.<br>
 * • When the license expiry date is reached, DLT automatically changes the
 * client status to inactive.<br>
 * • On login, the client’s active status and user credential are validated.
 * Access is granted only to the licensed application(s). This feature shall be
 * implemented with <b>keycloak</b> of the framework.
 *
 * @author Shivam
 *
 */

@Entity
public class ClientAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientId;

	private String clientName;
	private String[] application;
	private Date licenseStart;
	private Date licenseExpiry;
	private String userId;//email id
	private String password;
	private String clientStatus;//Active,Inactive

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String[] getApplication() {
		return this.application;
	}

	public void setApplication(String[] application) {
		this.application = application;
	}

	public Date getLicenseStart() {
		return this.licenseStart;
	}

	public void setLicenseStart(Date licenseStart) {
		this.licenseStart = licenseStart;
	}

	public Date getLicenseExpiry() {
		return this.licenseExpiry;
	}

	public void setLicenseExpiry(Date licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientStatus() {
		return this.clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

}
