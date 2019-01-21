package com.centrica.service.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("v1")
public interface AddressSerachServiceProxy {
	
	@RequestMapping("addresses?postcode=NG97ES")
	public String serachAddress();
	
}
