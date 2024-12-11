package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.main.model.AccountDetails;
import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.serviceI.AccDetailsServiceI;

@RequestMapping("/accountDetail")
@RestController
public class AccDetailsController 
{

	private static final Logger LOG=LoggerFactory.getLogger(AccDetailsController.class);

	@Autowired AccDetailsServiceI serviceI;
	
	
	@PostMapping("/createAccountCustomer")
	public ResponseEntity<AccountDetails> oncreatedAccountCustomer(@RequestPart ("aData") String textData,
            @RequestPart ("aAdharCard") MultipartFile fileAdharcard,
            @RequestPart("aPanCard") MultipartFile filePancard,
            @RequestPart ("aPhoto") MultipartFile filePhoto,
            @RequestPart ("aJoinLetter") MultipartFile fileJoinLetter,
            @RequestPart ("aSalarySlip") MultipartFile fileSalarySlip)
	{
		
		AccountDetails accountDetailRef=serviceI.saveAccount(textData,fileAdharcard,filePancard,filePhoto,fileJoinLetter,fileSalarySlip);
		return new ResponseEntity<AccountDetails>(accountDetailRef, HttpStatus.CREATED);
	}
	
	@GetMapping("/allAccountCustomer")
	public ResponseEntity<Iterable<AccountDetails>> onDisplayAllAccount()
	{
			Iterable<AccountDetails> accRef=serviceI.displayAccount();
			return new ResponseEntity<Iterable<AccountDetails>>(accRef, HttpStatus.OK);
	}
	
	
}
