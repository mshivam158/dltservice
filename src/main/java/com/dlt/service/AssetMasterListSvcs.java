package com.dlt.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dlt.enumconstant.ApiErrorCode;
import com.dlt.exception.RestException;
import com.dlt.exception.RestValidationException;
import com.dlt.model.EOAssetMasterList;
import com.dlt.model.EORamdAppConfigSetup;
import com.dlt.repos.IAssetMasterListRepo;
import com.dlt.repos.IProjectRepo;
import com.dlt.repos.IRamdAppConfigSetupRepo;

@Service
public class AssetMasterListSvcs {

	@Autowired
	private IAssetMasterListRepo assetMasterListRepo;
	@Autowired
	private IProjectRepo projectRepo;
	@Autowired
	private IRamdAppConfigSetupRepo eoRamdAppConfigSetupRepo;

	public HashMap<String, Object> getLooksUpData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("ASSET_MASTER_LIST", this.assetMasterListRepo.findAll());
		returnMap.put("PROJECTS", this.projectRepo.findAll());
		return returnMap;
	}

	public List<EOAssetMasterList> getAllMasterList() {
		return this.assetMasterListRepo.findAll();
	}

	public EOAssetMasterList createAssetMasterList(EOAssetMasterList eoAssetMasterListObj) {
		EOAssetMasterList eoAssetMasterList;
		EORamdAppConfigSetup eoRamdAppConfigSetup = this.eoRamdAppConfigSetupRepo.findAll().get(0);
		if (eoAssetMasterListObj.getProjectID() == null || eoAssetMasterListObj.getProjectID().getProjectId() == null) {
			throw new RestValidationException(ApiErrorCode.AMC_04);
		}
		if (this.assetMasterListRepo.findByProjectPkCount(eoAssetMasterListObj.getProjectID().getProjectId()) == eoRamdAppConfigSetup.getMaxAssetMaster()) {
			throw new RestValidationException(ApiErrorCode.AMC02);
		}
		eoAssetMasterListObj.setAssetMasterNameAndVersion(eoAssetMasterListObj.getAssetMasterName() + "-" + eoAssetMasterListObj.getAssetMasterVersion());
		if (eoAssetMasterListObj.getAssetMasterListId() == null) {
			eoAssetMasterListObj.setDateOfCreation(LocalDateTime.now());
		}
		try {
			eoAssetMasterList = this.assetMasterListRepo.save(eoAssetMasterListObj);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return eoAssetMasterList;
	}

	public void deleteAssetMasterList(List<EOAssetMasterList> eoAssetMasterLists) {
		try {
			this.assetMasterListRepo.deleteInBatch(eoAssetMasterLists);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
