package com.ebs.main.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.ebs.main.model.AccountHolderDetails;

public interface AccHolDetailsServiceI
{

public AccountHolderDetails saveAccount(String textData, MultipartFile fileAdharcard, MultipartFile filePancard,
		MultipartFile filePhoto, MultipartFile fileJoinLetter, MultipartFile fileSalarySlip);

public Iterable<AccountHolderDetails> getCustomerAccount();

public AccountHolderDetails onsingleAccount(int id);

public AccountHolderDetails onUpdateCustomerAccount(int accId, String textData, MultipartFile fileAdharcard,
		MultipartFile filePancard, MultipartFile filePhoto, MultipartFile fileJoinLetter, MultipartFile fileSalarySlip);


}
