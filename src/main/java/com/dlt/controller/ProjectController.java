package com.dlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlt.model.EOProject;
import com.dlt.model.EOProjectInfo;
import com.dlt.repos.IProjectInfoRepo;
import com.dlt.repos.IProjectRepo;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/project")
@Api(value = "Project API", tags = "Project API")
public class ProjectController {
	@Autowired
	private IProjectRepo projectRepo;
	@Autowired
	private IProjectInfoRepo projectInfoRepo;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<EOProject> getProject() {
		return this.projectRepo.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public EOProject addProject(@RequestBody EOProject eoProject) {
		return this.projectRepo.save(eoProject);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteProject(@PathVariable("id") long id) {
		this.projectRepo.deleteById(id);
		return "Successfully Deleted";
	}

	@RequestMapping(path = "/getProjectInfo", method = RequestMethod.GET)
	public List<EOProjectInfo> getProjectInfo() {
		return this.projectInfoRepo.findAll();
	}

	@RequestMapping(path = "/addProjectInfo", method = RequestMethod.POST)
	public EOProjectInfo addProjectInfo(@RequestBody EOProjectInfo eoProjectInfo) {
		return this.projectInfoRepo.save(eoProjectInfo);
	}

	@RequestMapping(path = "/deleteProjectInfo/{id}", method = RequestMethod.DELETE)
	public String deleteProjectInfo(@PathVariable("id") long id) {
		this.projectInfoRepo.deleteById(id);
		return "Successfully Deleted";
	}
}
