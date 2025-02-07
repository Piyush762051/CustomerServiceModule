package com.ebs.main.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.ebs.main.enm.AccountStatus;
import com.ebs.main.model.AccountDetails;

public interface AccDetailsServiceI
{

	public AccountDetails saveAccount(String textData, MultipartFile fileAdharcard, MultipartFile filePancard,
			MultipartFile filePhoto, MultipartFile fileJoinLetter, MultipartFile fileSalarySlip);

	public Iterable<AccountDetails> displayAccount();
	
	public AccountDetails getAccountDetails(long accountNumber);
	
	public void addTransactionHistory(AccountDetails accountDetails);
	
	public void addNewAccountHolderRequest(AccountDetails accountDetails);

	public AccountDetails ongetSingleCustomer(long accountno);

	public AccountDetails onsetAccountNumber(long accountnumber, AccountStatus accountstatus);



}
