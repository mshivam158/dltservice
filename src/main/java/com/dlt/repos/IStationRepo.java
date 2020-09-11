package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlt.model.Station;

public interface IStationRepo extends JpaRepository<Station, Long> {

}
