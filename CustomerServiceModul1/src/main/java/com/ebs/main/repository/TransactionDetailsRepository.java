package com.ebs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebs.main.model.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long>
{

}
