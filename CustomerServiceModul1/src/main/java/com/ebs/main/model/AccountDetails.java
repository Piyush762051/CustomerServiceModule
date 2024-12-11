package com.ebs.main.model;

import java.util.List;
import java.util.Set;

import com.ebs.main.enm.AccountStatus;
import com.ebs.main.enm.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AccountDetails 
{
	@Id
	private long accountNumber;	    //primary key(Long)
	private static String bankName="Easy bank System";	      
	private static String branchIFSC_Code="EBS1234K";	
	private static	String bankAddress="Karvenagar Pune"; 

	@Enumerated(EnumType.STRING)
	private AccountType accountType;	 // SAVING, CURRENT, SALARY
	private double currentBalance;	
	
	@Enumerated(EnumType.STRING)
	private	AccountStatus accountStatus;	// ACTIVE, INACTIVE,CLOSED
	
	@OneToOne(cascade = CascadeType.ALL)
	private	AccountHolderDetails accountHolderDetails;	
	
	@OneToMany(cascade = CascadeType.MERGE.REMOVE.REFRESH.DETACH)
	private Set<TransactionDetails> accountTransactionHistory;	
	
	@OneToOne(cascade = CascadeType.MERGE.REMOVE.REFRESH.DETACH)
	private	ATMDetails atmDetails;	
	
	@OneToMany(cascade = CascadeType.MERGE.REMOVE.REFRESH.DETACH)
	private List<ChequeBookDetails> chequeBooks;

}
