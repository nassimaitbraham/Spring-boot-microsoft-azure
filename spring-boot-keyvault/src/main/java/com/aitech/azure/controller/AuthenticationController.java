package com.aitech.azure.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@Value("${login}")
	private String login;
	@Value("${password}")
	private String password;
	
	@GetMapping("/getCredential")
    public String getCredential() {
        return "Login value =" + login + ", password value: " + password;
    }

}
