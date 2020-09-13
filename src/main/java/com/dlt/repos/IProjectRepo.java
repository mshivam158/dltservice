package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.Project;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Long> {

}
