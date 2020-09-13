package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOSystemAsset;

@Repository
public interface ISystemAssetRepo extends JpaRepository<EOSystemAsset, Long> {

}
