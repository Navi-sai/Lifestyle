package com.lifestyle.lifestyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifestyle.lifestyle.entity.DressEntity;

@Repository
public interface DressRepo extends JpaRepository<DressEntity, Integer>{

}
