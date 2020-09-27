package com.dlt.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class AssetsMasterListTree implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private ArrayList<AssetsMaster> children = new ArrayList<>();

	public ArrayList<AssetsMaster> getchildren() {
		return this.children;
	}

	public void setchildren(ArrayList<AssetsMaster> childMasterList) {
		this.children = childMasterList;
	}

	public void addChildMaster(AssetsMaster master) {
		this.children.add(master);
	}

}
