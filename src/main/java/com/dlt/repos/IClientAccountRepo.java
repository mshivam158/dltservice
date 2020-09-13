package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlt.model.ClientAccount;

@Repository
public interface IClientAccountRepo extends JpaRepository<ClientAccount, Long> {

}
