package com.yocar.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.yocar.base.dao.CarDetailsDao;
import com.yocar.base.dto.Admin;
import com.yocar.base.dto.CarDetails;
import com.yocar.base.util.JwtUtil;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDetailsDao dao;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserDetailsService detailsService;

	@Override
	public List<CarDetails> getAllCar() {
		List<CarDetails> details = (List<CarDetails>) dao.findAll();
		if (details.size() <= 0) {
			return null;
		} else {
			return details;
		}
	}

	@Override
	public boolean addCar(CarDetails carDetails) {
		boolean isAdded = false;
		if(carDetails.getCarFuelType().toLowerCase().equals("electric")) {
			carDetails.setCarOnRoadPrice(carDetails.getCarShowroomPrice()*1.04);
		}else {
			if(carDetails.getCarShowroomPrice()<5) {
				carDetails.setCarOnRoadPrice(carDetails.getCarShowroomPrice()*1.13);
			}else if (carDetails.getCarShowroomPrice()>5 && carDetails.getCarShowroomPrice()<10) {
				carDetails.setCarOnRoadPrice(carDetails.getCarShowroomPrice()*1.14);
			}else if (carDetails.getCarShowroomPrice()>10 && carDetails.getCarShowroomPrice()<20) {
				carDetails.setCarOnRoadPrice(carDetails.getCarShowroomPrice()*1.17);
			}else {
				carDetails.setCarOnRoadPrice(carDetails.getCarShowroomPrice()*1.18);
			}
		}
		
		CarDetails carDetails2 = dao.save(carDetails);
		if (carDetails2 != null) {
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean deleteCar(int id) {
		boolean isDeleted = false;
		CarDetails details = dao.findByCarId(id);
		if (details != null) {
			dao.delete(details);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public boolean updateCar(CarDetails carDetails) {
		boolean isUpdated = false;
		CarDetails details = dao.findByCarId(carDetails.getCarId());
		if (details != null) {
			details.setCarId(carDetails.getCarId());
			details.setCarName(carDetails.getCarName());
			details.setCompany(carDetails.getCompany());
			details.setCarFuelType(carDetails.getCarFuelType());
			details.setCarPowerSteering(carDetails.isCarPowerSteering());
			details.setCarBreakSystem(carDetails.getCarBreakSystem());
			details.setCarShowroomPrice(carDetails.getCarShowroomPrice());
			details.setCarOnRoadPrice(carDetails.getCarOnRoadPrice());
			details.setCarImageURL(carDetails.getCarImageURL());
			details.setCarMileage(carDetails.getCarMileage());
			details.setCarSeatingCapacity(carDetails.getCarSeatingCapacity());
			details.setCarEngineCapacity(carDetails.getCarEngineCapacity());
			details.setCarGearType(carDetails.getCarGearType());

			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public CarDetails getCarById(int id) {
		return dao.findByCarId(id);
	}

//	public List<CarDetails> findByCarCompany(String companyName) {
//		List<CarDetails> details = (List<CarDetails>) dao.finByCompany(companyName);
//		if(details!=null) {
//			return details;
//		}
//		return null;
//	}

}
