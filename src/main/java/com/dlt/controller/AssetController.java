package com.dlt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.enumconstant.AssetLife;
import com.dlt.enumconstant.AssetsStatus;
import com.dlt.enumconstant.Category;
import com.dlt.enumconstant.Classification;
import com.dlt.enumconstant.Composition;
import com.dlt.enumconstant.CriticalItem;
import com.dlt.enumconstant.Denomination;
import com.dlt.enumconstant.Repairable;
import com.dlt.enumconstant.Traceability;
import com.dlt.exception.RestException;
import com.dlt.model.EOAssetMaster;
import com.dlt.model.EOObject;
import com.dlt.model.EOSystemAsset;
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.repos.ISystemAssetRepo;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/assets")
@Api(value = "Assets API", description = "Api Used For Assets Master, System Assets operation", tags = "Assets API")
public class AssetController extends BaseController {
	@Autowired
	private IAssetMasterRepo assetMasterRepo;
	@Autowired
	private ISystemAssetRepo systemAssetRepo;

	@RequestMapping(path = "/master/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getAssetsMasterData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("Classification", Classification.values());
		returnMap.put("Category", Category.values());
		returnMap.put("Composition", Composition.values());
		returnMap.put("Traceability", Traceability.values());
		returnMap.put("Denomination", Denomination.values());
		returnMap.put("AssetLife", AssetLife.values());
		returnMap.put("Repairable", Repairable.values());
		returnMap.put("SystemAssets", this.systemAssetRepo.findAll());
		return returnMap;
	}

	@RequestMapping(path = "/master/all", method = RequestMethod.GET)
	public List<EOAssetMaster> getAssetMaster() {
		return this.assetMasterRepo.findAll();
	}

	@RequestMapping(path = "/master/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addAssetMaster(@RequestBody EOAssetMaster eoAssetMaster) {
		EOObject assetsMaster = null;
		try {
			assetsMaster = this.assetMasterRepo.save(eoAssetMaster);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.successResponseForObj(assetsMaster);
	}

	@RequestMapping(path = "/master/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAssetMaster(@PathVariable("id") long id) {
		this.handlePKValidation(id);
		try {
			this.assetMasterRepo.deleteById(id);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.deleteSuccess();
	}

	@RequestMapping(path = "/system/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getSystemAssetData() {
		HashMap<String, Object> returnMap = new HashMap<>();
		returnMap.put("AssetsStatus", AssetsStatus.values());
		returnMap.put("CriticalItem", CriticalItem.values());
		return returnMap;
	}

	@RequestMapping(path = "/system/all", method = RequestMethod.GET)
	public List<EOSystemAsset> getSystemAssets() {
		return this.systemAssetRepo.findAll();
	}

	@RequestMapping(path = "/system/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addSystemAsset(@RequestBody EOSystemAsset eoSystmAsset) {
		EOSystemAsset dbSystemAssets = null;
		//if((eoSystmAsset.getAssetStatus() != AssetsStatus.Expired) || (eoSystmAsset.getAssetStatus() != AssetsStatus.Uninstalled))
		eoSystmAsset.setResidualLife(eoSystmAsset.getOpsLife() - eoSystmAsset.getOpshour());
		try {
			dbSystemAssets = this.systemAssetRepo.save(eoSystmAsset);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.successResponseForObj(dbSystemAssets);
	}

	@RequestMapping(path = "/system/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSystemAsset(@PathVariable("id") long id) {
		this.handlePKValidation(id);
		try {
			this.systemAssetRepo.deleteById(id);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.deleteSuccess();
	}
}
