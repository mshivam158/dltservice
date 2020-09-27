package com.dlt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.model.EOAssetMaster;
import com.dlt.model.EOAssetMasterList;
import com.dlt.repos.IAssetMasterListRepo;
import com.dlt.repos.IAssetMasterRepo;
import com.dlt.ui.AssetsMaster;

@Service
public class AssetsMasterTreeSvcs {
	@Autowired
	private IAssetMasterListRepo assetsMasterListRepo;
	@Autowired
	private IAssetMasterRepo assetsMasterRepo;

	public ArrayList<AssetsMaster> getTreeStructure() {
		ArrayList<AssetsMaster> treeView = new ArrayList<AssetsMaster>();
		ArrayList<EOAssetMasterList> masterList = (ArrayList<EOAssetMasterList>) this.assetsMasterListRepo.findAll();
		if (!masterList.isEmpty()) {
			masterList.forEach(master -> {
				AssetsMaster parent = this.getParentTree(master);
				ArrayList<EOAssetMaster> assetsMaster = (ArrayList<EOAssetMaster>) this.assetsMasterRepo.getAssetsMasterForMasterList(master.getAssetMasterListId());
				this.buildTreeForParent(parent, assetsMaster);
				treeView.add(parent);
			});
		}
		return treeView;
	}

	private AssetsMaster getParentTree(EOAssetMasterList masterList) {
		AssetsMaster parent = new AssetsMaster();
		parent.setId(masterList.getAssetMasterListId());
		parent.setName(masterList.getAssetMasterNameAndVersion());
		parent.setAssetsMasterList(true);
		return parent;
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

	private void buildTreeForParent(AssetsMaster parent, ArrayList<EOAssetMaster> assetsMaster) {
		if (!assetsMaster.isEmpty()) {
			for (EOAssetMaster master : assetsMaster) {
				AssetsMaster childMaster = this.getAssetsMater(master);
				parent.addChildAssetsMaster(childMaster);
			}
		}
	}
}
