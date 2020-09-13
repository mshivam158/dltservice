package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.Station;

@Repository
public interface IStationRepo extends JpaRepository<Station, Long> {

}
