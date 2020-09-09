package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashPasswordMain {

	public static void main(String[] args) {
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		String encoded=b.encode("pass");
		System.out.println(encoded);
	}

}
