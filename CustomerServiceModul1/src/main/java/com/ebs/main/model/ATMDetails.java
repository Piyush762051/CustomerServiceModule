package com.ebs.main.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
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
public class ATMDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
	private long atmNumber;	//random  primary Key Long
	private String	atmHolderName;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date atmValidUpto;	
	private int	atmcveCode;	//utility class Randam

}
