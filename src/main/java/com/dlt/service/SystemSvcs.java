package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.ISystemRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SystemSvcs {
	//@Autowired
	private ISystemRepo systemRepos;
}
