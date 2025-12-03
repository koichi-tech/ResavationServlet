package com.example.strategy;

public interface AuthenticationStrategy {
	
	boolean AuthenticationCheck(String mailAddress,String password);
}
