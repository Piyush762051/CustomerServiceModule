package com.ebs.main.serviceI;

import com.ebs.main.model.AccountHolderDetails;

public interface AccHolDetailsServiceI {

public	AccountHolderDetails oncreatedAccountDetails(AccountHolderDetails accdetails);

public AccountHolderDetails onUpdateCustomerAccount(AccountHolderDetails acc_Details, int accId);


}
