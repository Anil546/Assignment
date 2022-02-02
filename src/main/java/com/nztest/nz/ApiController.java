package com.nztest.nz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nztest.nz.pojo.Account;
import com.nztest.nz.services.BussService;

@RestController
public class ApiController {
	
	@Autowired
	private BussService service;

	@PostMapping("/getId")
	public String getUniquId(@RequestBody Account account) {
		return service.generateFunc(account);
	}
	
}
