package com.dlt.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dlt.enumconstant.AssetsStatus;
import com.dlt.enumconstant.CriticalItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EOSystemAsset extends EOObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long assetId;
	private String traceability;
	private float opsLife;
	private float opshour;
	private float residualLife;
	private float mtbfBaseline;
	private float mtbfcurrent;
	private float mttrBaseline;
	private float mttrCurrent;

	@Enumerated(EnumType.STRING)
	private CriticalItem criticalItem;
	@Enumerated(EnumType.STRING)
	private AssetsStatus assetStatus;

	public Long getAssetId() {
		return this.assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getTraceability() {
		return this.traceability;
	}

	public void setTraceability(String traceability) {
		this.traceability = traceability;
	}

	public float getOpsLife() {
		return this.opsLife;
	}

	public void setOpsLife(float opsLife) {
		this.opsLife = opsLife;
	}

	public float getOpshour() {
		return this.opshour;
	}

	public void setOpshour(float opshour) {
		this.opshour = opshour;
	}

	public float getResidualLife() {
		return this.residualLife;
	}

	public void setResidualLife(float residualLife) {
		this.residualLife = residualLife;
	}

	public float getMtbfBaseline() {
		return this.mtbfBaseline;
	}

	public void setMtbfBaseline(float mtbfBaseline) {
		this.mtbfBaseline = mtbfBaseline;
	}

	public float getMtbfcurrent() {
		return this.mtbfcurrent;
	}

	public void setMtbfcurrent(float mtbfcurrent) {
		this.mtbfcurrent = mtbfcurrent;
	}

	public float getMttrBaseline() {
		return this.mttrBaseline;
	}

	public void setMttrBaseline(float mttrBaseline) {
		this.mttrBaseline = mttrBaseline;
	}

	public float getMttrCurrent() {
		return this.mttrCurrent;
	}

	public void setMttrCurrent(float mttrCurrent) {
		this.mttrCurrent = mttrCurrent;
	}

	public CriticalItem getCriticalItem() {
		return this.criticalItem;
	}

	public void setCriticalItem(CriticalItem criticalItem) {
		this.criticalItem = criticalItem;
	}

	public AssetsStatus getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(AssetsStatus assetStatus) {
		this.assetStatus = assetStatus;
	}

	/*
	 * @Column(name="SystemID") private System systemID;
	 */

}
