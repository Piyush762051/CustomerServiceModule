package com.ebs.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.main.model.AccountHolderDetails;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolderDetails, Long>
{

	public Optional<AccountHolderDetails> findById(long id);

}
