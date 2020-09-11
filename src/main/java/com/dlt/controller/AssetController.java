package com.dlt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.model.EOAsset;
import com.dlt.model.EOAssetMaster;
import com.dlt.repos.AssetMasterRepo;
import com.dlt.repos.AssetRepo;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AssetController {
	//@Autowired
	private AssetMasterRepo assetMasterRepo;
	//@Autowired
	private AssetRepo assetRepo;

	@RequestMapping(path = "/getAssetsMaster", method = RequestMethod.GET)
	public List<EOAssetMaster> getAssetMaster() {
		return this.assetMasterRepo.findAll();
	}

	@RequestMapping(path = "/addAssetMaster", method = RequestMethod.POST)
	public EOAssetMaster addAssetMaster(@RequestBody EOAssetMaster eoAssetMaster) {
		return this.assetMasterRepo.save(eoAssetMaster);
	}

	@RequestMapping(path = "/deleteAssetMaster/{id}", method = RequestMethod.DELETE)
	public void addAssetMaster(@PathVariable("id") long id) {
		this.assetMasterRepo.deleteById(id);
	}

	@RequestMapping(path = "/getAssets", method = RequestMethod.GET)
	public List<EOAsset> getAsset() {
		return this.assetRepo.findAll();
	}

	@RequestMapping(path = "/addAsset", method = RequestMethod.POST)
	public EOAsset addAsset(@RequestBody EOAsset eoAsset) {
		return this.assetRepo.save(eoAsset);
	}

	@RequestMapping(path = "/deleteAsset/{id}", method = RequestMethod.DELETE)
	public void addAsset(@PathVariable("id") long id) {
		this.assetRepo.deleteById(id);
	}
}
