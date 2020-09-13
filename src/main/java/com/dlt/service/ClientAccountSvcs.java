package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IClientAccountRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientAccountSvcs {
	//@Autowired
	private IClientAccountRepo clientAccountRepos;
}
