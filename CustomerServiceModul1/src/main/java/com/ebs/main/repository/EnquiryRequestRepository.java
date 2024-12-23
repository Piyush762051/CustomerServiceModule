package com.ebs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebs.main.model.EnquiryRequest;

@Repository
public interface EnquiryRequestRepository extends JpaRepository<EnquiryRequest, Integer>
{

}
