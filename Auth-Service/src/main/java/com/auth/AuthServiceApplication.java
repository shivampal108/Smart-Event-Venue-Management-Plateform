package com.auth;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AuthServiceApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(AuthServiceApplication.class, args);
		
//		   KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
//	        keyGenerator.init(256);
//
//	        SecretKey key = keyGenerator.generateKey();
//
//	        String secret = Base64.getEncoder()
//	                .encodeToString(key.getEncoded());
//
//	        System.out.println(secret);
	}

}
