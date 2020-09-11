package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IStationRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StationSvcs {
	//@Autowired
	private IStationRepo stationRepos;
}
