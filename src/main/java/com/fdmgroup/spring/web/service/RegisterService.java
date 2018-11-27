package com.fdmgroup.spring.web.service;

public class RegisterService {
	
	public static String generateFailMsg(String password) {
		
		int wrongTime = 0;		
		String failMsg = "Your password should contain ";
		
		if(password.equals(password.toLowerCase())) {
			
			if (wrongTime != 0) {
					
				failMsg += ", ";
			}
			failMsg += "at least ONE uppercase letter";
			wrongTime++;
		}
			
		if(password.equals(password.toUpperCase())) {
				
			if (wrongTime != 0) {
					
				failMsg += ", ";
			}
				
			failMsg += "at least ONE lowercase letter";
			wrongTime++;
		}
			
		if(!password.matches(".*\\d.*")) {

			if (wrongTime != 0) {
					
				failMsg += ", ";
			}
				
			failMsg += "at least ONE number";
			wrongTime++;
		}
			
		if(password.matches("[a-zA-Z0-9 ]*")) {
				
			if (wrongTime != 0) {
					
				failMsg += ", ";
			}
				
			failMsg += "at least ONE special symbol";
			wrongTime++;
		}
			
		if(password.length() < 8) {

			if (wrongTime != 0) {
					
				failMsg += ", ";
			}
				
			failMsg += "at least EIGHT characters";
		}
		
		return failMsg;
	}
}
