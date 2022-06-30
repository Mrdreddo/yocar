package com.yocar.base.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.yocar.base.dao.AdminDao;
import com.yocar.base.dao.CarDetailsDao;
import com.yocar.base.dto.Admin;
import com.yocar.base.dto.CarDetails;
import com.yocar.base.service.AdminServiceImpl;
import com.yocar.base.service.CarServiceImpl;
import com.yocar.base.util.JwtUtil;
@ExtendWith(MockitoExtension.class)
public class CarDetailsServiceTest {

	@Mock
	private AdminDao adminDao;
	
	@Mock
	private CarDetailsDao carDao;

	@Mock
	private JwtUtil jwtUtil;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@InjectMocks
	private CarServiceImpl carServiceImpl;
	


	@Test
	void testLoadUserByUsername() {
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setAdminName("admin");
		admin.setPassword("1234");
		admin.setAdminRole("ROLE_ADMIN");

		when(adminDao.findByAdminName("admin")).thenReturn(admin);
		UserDetails loadUserByUsername = adminServiceImpl.loadUserByUsername("admin");

		assertEquals("admin", loadUserByUsername.getUsername());

	}
	
	@Test
	void testgetAllCarDetails() {

		List<CarDetails> carList = new ArrayList<>();
		CarDetails carDetails = new CarDetails();
		carDetails.setCarId(201);
		carDetails.setCompany("Mahindra");
		carDetails.setCarBreakSystem("ABS");
		carList.add(carDetails);

		when(carDao.findAll()).thenReturn(carList);
		List<CarDetails> carList2 = carServiceImpl.getAllCar();
		assertTrue(!carList2.isEmpty());
	}
	
//	@Test
//	void testGetCarByCompany() {
//
//		List<CarDetails> carList = new ArrayList<CarDetails>();
//		CarDetails details = new CarDetails();
//		details.setCarId(102);
//		details.setCompany("mahindra");
//		details.setCarEngineCapacity(229);
//		details.setCarMileage(12.2);
//		carList.add(details);
//		when(carDao.finByCompany("mahindra")).thenReturn(carList);
//		List<CarDetails> details2 = carServiceImpl.findByCarCompany("mahindra");
//		assertEquals("mahindra", carList.get(0).getCompany());
//
//	}
	
}
