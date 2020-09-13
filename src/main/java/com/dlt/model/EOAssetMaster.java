package com.dlt.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dlt.enumconstant.AssetLife;
import com.dlt.enumconstant.Category;
import com.dlt.enumconstant.Classification;
import com.dlt.enumconstant.Composition;
import com.dlt.enumconstant.Denomination;
import com.dlt.enumconstant.Repairable;
import com.dlt.enumconstant.Traceability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EOAssetMaster extends EOObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assetId;
	private String nomenclature;
	private String drawingNo;
	private String drawingItemReference;
	private String partNumber;
	private String model;
	private String manufacturer;
	@Enumerated(EnumType.STRING)
	public Classification classification;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private Composition composition;
	@Enumerated(EnumType.STRING)
	private Traceability traceability;
	private Denomination denomination;
	@Enumerated(EnumType.STRING)
	private AssetLife assetLife;
	@Enumerated(EnumType.STRING)
	private Repairable repairable;
	private String lineReplaceable;
	private String maintainable;
	private String vendorId;

	@ManyToOne
	@JoinColumn(name = "ParentAsset")
	private EOSystemAsset parentAssetId;

	public Long getAssetId() {
		return this.assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getNomenclature() {
		return this.nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public String getDrawingNo() {
		return this.drawingNo;
	}

	public void setDrawingNo(String drawingNo) {
		this.drawingNo = drawingNo;
	}

	public String getDrawingItemReference() {
		return this.drawingItemReference;
	}

	public void setDrawingItemReference(String drawingItemReference) {
		this.drawingItemReference = drawingItemReference;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Composition getComposition() {
		return this.composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public Traceability getTraceability() {
		return this.traceability;
	}

	public void setTraceability(Traceability traceability) {
		this.traceability = traceability;
	}

	public Denomination getDenomination() {
		return this.denomination;
	}

	public void setDenomination(Denomination denomination) {
		this.denomination = denomination;
	}

	public AssetLife getAssetLife() {
		return this.assetLife;
	}

	public void setAssetLife(AssetLife assetLife) {
		this.assetLife = assetLife;
	}

	public Repairable getRepairable() {
		return this.repairable;
	}

	public void setRepairable(Repairable repairable) {
		this.repairable = repairable;
	}

	public String getLineReplaceable() {
		return this.lineReplaceable;
	}

	public void setLineReplaceable(String lineReplaceable) {
		this.lineReplaceable = lineReplaceable;
	}

	public String getMaintainable() {
		return this.maintainable;
	}

	public void setMaintainable(String maintainable) {
		this.maintainable = maintainable;
	}

	public String getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public EOSystemAsset getParentAssetId() {
		return this.parentAssetId;
	}

	public void setParentAssetId(EOSystemAsset parentAssetId) {
		this.parentAssetId = parentAssetId;
	}

}
