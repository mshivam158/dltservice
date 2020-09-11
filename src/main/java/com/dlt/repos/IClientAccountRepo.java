package com.dlt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlt.model.ClientAccount;

public interface IClientAccountRepo extends JpaRepository<ClientAccount, Long> {

}
