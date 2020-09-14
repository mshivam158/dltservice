package com.dlt.model;

import javax.persistence.Id;

//@Entity
public class EORamdAppConfigSetup extends EOObject {
	private static final long serialVersionUID = 1L;
	@Id
	private Long primaryKey;
	private Integer maxClientAccount = 100;//Total no. of accounts in the active database. When exceeded, the oldest in the inactive state state shall be archived
	private Integer maxProject = 10;
	private Integer maxAssetMaster = 10;
	private Integer maxAsset = 1000;
	private Integer maxStation = 100;
	private Integer maxSystem = 10;
	private Integer maxSystemAsset = 1000;
	private Integer maxRbd = 10;
	private Integer maxRbdElement = 1000;
	private Integer maxRamBaseline = 1;
	private Integer maxHazardBaseline = 1;
	private Integer maxFailureReport = 1000;
	private Integer maxEquipmentFailureRecord = 1000;
	private Integer maxRamRecord = 1000;
	private Integer maxHazardRecord = 1000;

}
