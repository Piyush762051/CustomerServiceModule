package com.ebs.main.serviceI;

import com.ebs.main.model.ATMDetails;

public interface ATMDetailsServiceI {

public	ATMDetails saveATMDetails(ATMDetails atmDetails);

public ATMDetails getATMDetailsById(long id);

}
