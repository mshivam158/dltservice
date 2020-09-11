package com.dlt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EOAssetMaster implements Serializable {
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
	private String classification;
	private String category;
	private String composition;
	private String traceability;
	private String denomination;
	private String assetLife;
	private String repairable;
	private String lineReplaceable;
	private String maintainable;
	/*
	 * @Column(name="Parent Asset") private EOAsset parentAssetId;
	 */
	/*
	 * @Column(name="Vendor") private Vendor vendorId;
	 */

}
