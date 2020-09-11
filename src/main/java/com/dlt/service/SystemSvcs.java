package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.ISystemRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SystemSvcs {
	//@Autowired
	private ISystemRepo systemRepos;
}
