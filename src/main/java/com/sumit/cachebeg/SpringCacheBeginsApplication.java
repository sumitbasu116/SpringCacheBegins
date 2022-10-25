package com.sumit.cachebeg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheBeginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheBeginsApplication.class, args);
	}

}
