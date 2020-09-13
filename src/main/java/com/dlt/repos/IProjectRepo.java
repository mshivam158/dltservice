package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.EOProject;
@Repository
public interface IProjectRepo extends JpaRepository<EOProject, Long> {

}
