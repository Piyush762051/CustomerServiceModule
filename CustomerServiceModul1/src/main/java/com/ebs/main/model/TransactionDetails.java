package com.ebs.main.model;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.ebs.main.enm.TransactionMedium;
import com.ebs.main.enm.TransactionStatus;
import com.ebs.main.enm.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionDetails
{
	@Id
    private	long	tranctioncId;  //accountNo+random  PrimaryKey (long )
    private	float	transactionAmmount;// must not be 0
   
    @Enumerated(EnumType.STRING)
    private	TransactionType transactionType;  // DEPOSIT, WITHDRAWAL
    
    @Enumerated(EnumType.STRING)
    private	TransactionMedium transactionMedium;   // ATM, ONLINE, BRANCH
   
    @Enumerated(EnumType.STRING)
    private	TransactionStatus	transactionStatus;      //SUCCESS,FAILURE,PENDING,CANCELLED
    private	String	transactionRemark;   //constant
    @CreationTimestamp
    private Date transactionDate;
}
