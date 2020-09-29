package com.dlt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.model.EOAssetMaster;
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.ui.AssetsMaster;

@Service
public class AssetsMasterTreeSvcs {

	@Autowired
	private IAssetMasterRepo assetsMasterRepo;

	public ArrayList<AssetsMaster> getTreeStructure(Long masterListId) {
		ArrayList<AssetsMaster> treeView = new ArrayList<AssetsMaster>();
		ArrayList<EOAssetMaster> assetsMaster = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.getAssetsMasterForMasterList(masterListId);
		assetsMaster.forEach(asset -> {
			AssetsMaster master = this.getAssetsMater(asset);
			treeView.add(master);
		});
		return treeView;
	}

	private AssetsMaster getAssetsMater(EOAssetMaster eoAssetsMaster) {
		AssetsMaster assetsMaster = new AssetsMaster();
		assetsMaster.setId(eoAssetsMaster.getAssetId());
		assetsMaster.setName(eoAssetsMaster.getNomenclature());
		ArrayList<EOAssetMaster> masterArray = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.findByParentAssetId(eoAssetsMaster);
		if (!masterArray.isEmpty()) {
			masterArray.forEach(eoassetsMaster -> {
				AssetsMaster child = this.getAssetsMater(eoassetsMaster);
				assetsMaster.addChildAssetsMaster(child);
			});
		}
		return assetsMaster;
	}
}
