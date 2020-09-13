package com.dlt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.model.EOUser;
import com.dlt.repos.UserRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
	private UserRepo userRepo;

	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public EOUser addUser(@RequestBody EOUser eoUser) {
		return this.userRepo.save(eoUser);
	}

	@RequestMapping(path = "/getUsers", method = RequestMethod.GET)
	public List<EOUser> getUsers() {
		return this.userRepo.findAll();
	}

	@RequestMapping(path = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") long id) {
		this.userRepo.deleteById(id);
	}

}
