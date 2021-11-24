package com.vishal.oauth.api.oauthapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OauthapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthapigatewayApplication.class, args);
	}

}
