package com.dlt.controller;

import java.util.ArrayList;
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

import com.dlt.model.EOAssetMaster;
import com.dlt.model.EOAssetMasterList;
import com.dlt.model.EOSystemAsset;
import com.dlt.service.AssetMasterListSvcs;
import com.dlt.service.AssetMasterSvcs;
import com.dlt.service.AssetsMasterTreeSvcs;
import com.dlt.service.SystemAssetSvcs;
import com.dlt.ui.AssetsMaster;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/assets")
@Api(value = "Assets API", tags = "Assets API")
public class AssetController extends BaseController {

	@Autowired
	private AssetMasterListSvcs assetMasterListSvcs;
	@Autowired
	private AssetMasterSvcs assetMasterSvcs;
	@Autowired
	private SystemAssetSvcs systemAssetSvcs;
	@Autowired
	private AssetsMasterTreeSvcs assetsMasterTreeSvcs;

	/* First hit of asset master page */
	@RequestMapping(path = "/master/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getAssetsMasterData() {
		return this.assetMasterSvcs.getLookupData();
	}

	@RequestMapping(path = "/master/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addAssetMaster(@RequestBody EOAssetMaster eoAssetMaster) {
		EOAssetMaster eoAssetMasterObj = this.assetMasterSvcs.createAssetMaster(eoAssetMaster);
		return this.successResponseForObj(eoAssetMasterObj);
	}

	@RequestMapping(path = "/master/fetch/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> addAssetMaster(@PathVariable("id") Long id) {
		EOAssetMaster eoAssetMasterObj = this.assetMasterSvcs.findAssetsMasterByID(id);
		return this.successResponseForObj(eoAssetMasterObj);
	}

	@RequestMapping(path = "/master/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAssetMaster(@RequestBody List<EOAssetMaster> eoAssetMasters) {
		this.assetMasterSvcs.deleteAssetMaster(eoAssetMasters);
		return this.deleteSuccess();
	}

	/* First hit of  system asset list page */

	@RequestMapping(path = "/system/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getSystemAssetData() {
		return this.systemAssetSvcs.getLookupData();
	}

	@RequestMapping(path = "/system/all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllSystemAsset() {
		return this.successResponseForList(this.systemAssetSvcs.getAllSystemAssets());
	}

	@RequestMapping(path = "/system/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addSystemAsset(@RequestBody EOSystemAsset eoSystmAsset) {
		EOSystemAsset eoSystmAssetObj = this.systemAssetSvcs.createSystemAsset(eoSystmAsset);
		return this.successResponseForObj(eoSystmAssetObj);
	}

	@RequestMapping(path = "/system/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSystemAsset(@RequestBody List<EOSystemAsset> eoSystemAssets) {
		this.systemAssetSvcs.deleteSystemAsset(eoSystemAssets);
		return this.deleteSuccess();
	}

	/* First hit of asset master list page */

	@RequestMapping(path = "/masterList/getlookup", method = RequestMethod.GET)
	public HashMap<String, Object> getAssetMasterListData() {
		return this.assetMasterListSvcs.getLooksUpData();
	}

	@RequestMapping(path = "/masterList/all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAssetMasterList() {
		return this.successResponseForList(this.assetMasterListSvcs.getAllMasterList());
	}

	@RequestMapping(path = "/masterList/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addAssetMasterList(@RequestBody EOAssetMasterList eoAssetMasterListObj) {
		EOAssetMasterList eoAssetMasterList = this.assetMasterListSvcs.createAssetMasterList(eoAssetMasterListObj);
		return this.successResponseForObj(eoAssetMasterList);
	}

	@RequestMapping(path = "/masterList/fetch/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> addAssetMasterList(@PathVariable("id") Long id) {
		EOAssetMasterList eoAssetMasterList = this.assetMasterListSvcs.findMasterListByID(id);
		return this.successResponseForObj(eoAssetMasterList);
	}

	@RequestMapping(path = "/masterList/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAssetMasterList(@RequestBody List<EOAssetMasterList> eoAssetMasterLists) {
		this.assetMasterListSvcs.deleteAssetMasterList(eoAssetMasterLists);
		return this.deleteSuccess();
	}

	@RequestMapping(path = "/masterList/tree", method = RequestMethod.GET)
	public ResponseEntity<Object> getTreeViewOfMaster() {
		ArrayList<AssetsMaster> treeView = this.assetsMasterTreeSvcs.getTreeStructure();
		return ResponseEntity.status(HttpStatus.OK).body(treeView);
	}

}
