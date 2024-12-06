package com.ebs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.main.model.AccountHolderDetails;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolderDetails, Integer>
{

}
