package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RoleEntity;
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByName(String name);

}
