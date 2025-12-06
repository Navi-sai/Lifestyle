package com.lifestyle.lifestyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifestyle.lifestyle.entity.DressEntity;
import com.lifestyle.lifestyle.service.DressService;

@RestController
@RequestMapping("/api/lifestyle")
public class LifestyleController {
	
	@Autowired
	public DressService dressService;
	
	@PostMapping("/createDress")
	public DressEntity createDress(@RequestBody DressEntity dress) {
		return dressService.createDress(dress);
		
	}

}
