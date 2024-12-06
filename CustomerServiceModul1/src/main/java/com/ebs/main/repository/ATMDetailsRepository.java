package com.ebs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.main.model.ATMDetails;

@Repository
public interface ATMDetailsRepository extends JpaRepository<ATMDetails, Long>
{

}
