package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOAssetMaster;

@Repository
public interface IAssetMasterRepo extends JpaRepository<EOAssetMaster, Long>{

}