package com.missionariodapaz.MissionarioDaPaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MissionarioDaPazApplication {

	public static void main(String[] args) {

		SpringApplication.run(MissionarioDaPazApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
