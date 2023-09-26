package com.realitart.contentandstreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsContentAndStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsContentAndStreamingApplication.class, args);
	}

}
