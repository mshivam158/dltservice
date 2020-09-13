package com.dlt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * • Project is created by the system admin through the system admin interface.
 * • Project data can be updated by the user. A project cannot be deleted by the
 * user.
 *
 * @author Shivam
 *
 */

@Data
@Entity
public class EOProject extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;

	private String projectName;

	@ManyToOne
	@JoinColumn(name = "ClientID", nullable = false)
	private EOClientAccount clientAccount;

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public EOClientAccount getClientAccount() {
		return this.clientAccount;
	}

	public void setClientAccount(EOClientAccount clientAccount) {
		this.clientAccount = clientAccount;
	}

}
