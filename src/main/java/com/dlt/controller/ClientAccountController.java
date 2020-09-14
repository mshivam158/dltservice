package com.dlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.exception.RestException;
import com.dlt.model.EOClientAccount;
import com.dlt.model.EOObject;
import com.dlt.repos.IClientAccountRepo;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/clientaccount")
@Api(value = "Client Account API", tags = "Client Account API")
public class ClientAccountController extends BaseController {
	@Autowired
	private IClientAccountRepo clientAccountRepos;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<EOClientAccount> getClientAccount() {
		return this.clientAccountRepos.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addClientAccount(@RequestBody EOClientAccount eoClientAccount) {
		EOObject clientAccount = null;
		try {
			clientAccount = this.clientAccountRepos.save(eoClientAccount);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.successResponseForObj(clientAccount);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteClientAccount(@PathVariable("id") long id) {
		this.handlePKValidation(id);
		try {
			this.clientAccountRepos.deleteById(id);
		} catch (Exception e) {
			throw new RestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return this.deleteSuccess();
	}
}
