package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IClientAccountRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientAccountSvcs {
	//@Autowired
	private IClientAccountRepo clientAccountRepos;
}
