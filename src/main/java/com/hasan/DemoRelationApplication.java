package com.hasan;

import com.hasan.controller.UserController;
import com.hasan.entity.Address;
import com.hasan.service.AddressService;
import com.hasan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoRelationApplication {

	@Autowired
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(DemoRelationApplication.class, args);
	}



//	@PostConstruct 												// If you want to run code-first,you should add this annotation.
//	public void init(){
//
//		if(addressService.getTopByCity("kocaeli") == null) {
//			Address address = new Address();
//			address.setCity("kocaeli");
//			addressService.save(address);
//		}
//
//	}

}
