package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IProjectRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectSvcs {
	//@Autowired
	private IProjectRepo projectRepos;
}
