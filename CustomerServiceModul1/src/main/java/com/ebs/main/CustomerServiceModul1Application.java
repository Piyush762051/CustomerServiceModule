package com.ebs.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerServiceModul1Application
{
private static final Logger LOG=LoggerFactory.getLogger(CustomerServiceModul1Application.class);

	public static void main(String[] args)
	{
		LOG.info("Open Customer-Modul1");
		SpringApplication.run(CustomerServiceModul1Application.class, args);
	}

}
