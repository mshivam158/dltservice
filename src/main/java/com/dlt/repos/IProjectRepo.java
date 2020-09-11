package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlt.model.Project;

public interface IProjectRepo extends JpaRepository<Project, Long> {

}
