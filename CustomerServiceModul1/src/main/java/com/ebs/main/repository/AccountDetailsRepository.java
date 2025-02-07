package com.ebs.main.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.main.model.AccountDetails;


public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long>
{
//	public AccountDetails findByAccountNumber(long accountno);
	public AccountDetails findByAccountNumber(long accountnumber);

}
