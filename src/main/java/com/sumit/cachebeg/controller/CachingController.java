package com.sumit.cachebeg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caches")
public class CachingController {

	@Autowired
    private CacheManager cacheManager;
	
	@DeleteMapping("clear")
	public ResponseEntity<Void> clearAllCaches() {
		//First time, this request will take avg. 4s, then it will take avg. 6ms to serve the request as it is taking it from cache.
		//We can clear the cache and this request will again take avg. 4s to serve the request. 
		cacheManager.getCacheNames().stream().forEach(catche->{
			System.out.println(catche);
			cacheManager.getCache(catche).clear();
		});
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
