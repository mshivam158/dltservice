package com.dlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.model.EOClientAccount;
import com.dlt.repos.IClientAccountRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/clientaccount")
public class ClientAccountController {
	@Autowired
	private IClientAccountRepo clientAccountRepos;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<EOClientAccount> getClientAccount() {
		return this.clientAccountRepos.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public EOClientAccount addClientAccount(@RequestBody EOClientAccount eoClientAccount) {
		return this.clientAccountRepos.save(eoClientAccount);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteClientAccount(@PathVariable("id") long id) {
		this.clientAccountRepos.deleteById(id);
		return "Successfully Deleted";
	}
}
