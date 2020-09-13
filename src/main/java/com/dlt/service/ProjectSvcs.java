package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IProjectRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSvcs {
	//@Autowired
	private IProjectRepo projectRepos;
}
