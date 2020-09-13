package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.ProjectInfo;

@Repository
public interface IProjectInfoRepo extends JpaRepository<ProjectInfo, Long> {

}
