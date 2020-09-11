package com.dlt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Stations are created and updated by the user. A station cannot be deleted if
 * it has any data in its system and its lower levels of the structure.
 *
 * @author Shivam
 *
 */
@Entity
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stationId;
	private String stationName;

	private Long systems;

	@ManyToOne
	@JoinColumn(name = "projectID", nullable = false)
	private Project project;

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Long getSystems() {
		return systems;
	}

	public void setSystems(Long systems) {
		this.systems = systems;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
