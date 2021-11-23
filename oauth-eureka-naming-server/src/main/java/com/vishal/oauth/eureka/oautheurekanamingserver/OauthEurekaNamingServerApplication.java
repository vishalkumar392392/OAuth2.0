package com.vishal.oauth.eureka.oautheurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OauthEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthEurekaNamingServerApplication.class, args);
	}

}
