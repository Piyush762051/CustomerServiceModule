package com.ebs.main.model;

import java.util.Date;



import com.ebs.main.enm.ChequeBookStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChequeBookDetails
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chequeBookId; // Primary Key

    private Long accountNumber; 

    private int numberOfLeaves; // Number of leaves in the chequebook

    @Temporal(TemporalType.DATE)
    private Date issuedDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date expiryDate; // Optional

    @Enumerated(EnumType.STRING)
    private ChequeBookStatus status; // ACTIVE,EXPIRED,CANCELLED

    private Long startChequeNumber; // First cheque number
    private Long endChequeNumber;   // Last cheque number

    
    private Date requestDate; // When the cheque book was requested
}
