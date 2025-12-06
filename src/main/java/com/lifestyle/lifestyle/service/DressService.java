package com.lifestyle.lifestyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifestyle.lifestyle.entity.DressEntity;
import com.lifestyle.lifestyle.repository.DressRepo;

@Service
public class DressService {
	
	@Autowired
	public DressRepo dressRepo;
	
	
	public DressEntity createDress(DressEntity dress) {
		return dressRepo.save(dress);
	}

}
