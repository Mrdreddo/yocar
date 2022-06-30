package com.yocar.base.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yocar.base.dto.CarDetails;


public interface CarDetailsDao extends CrudRepository<CarDetails, Integer> {
	
	
	public CarDetails findByCarId(int id);
//	public List<CarDetails> finByCompany(String companyName);
}
