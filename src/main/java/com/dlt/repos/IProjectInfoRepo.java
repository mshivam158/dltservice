package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlt.model.ProjectInfo;

public interface IProjectInfoRepo extends JpaRepository<ProjectInfo, Long> {

}
