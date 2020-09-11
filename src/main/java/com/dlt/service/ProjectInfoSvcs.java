package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IProjectInfoRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectInfoSvcs {
	//@Autowired
	private IProjectInfoRepo projectInfoRepos;
}
