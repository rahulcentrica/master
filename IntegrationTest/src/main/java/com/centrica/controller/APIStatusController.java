package com.centrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centrica.service.proxy.AddressSerachServiceProxy;

@RestController
public class APIStatusController {
	
	@Autowired AddressSerachServiceProxy addressSearch;

	@GetMapping
	public String validateServicesAreUp() {
		addressSearch.serachAddress();
		return "I have started your test !!!";
	}
}
