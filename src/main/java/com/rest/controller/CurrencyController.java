package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.domain.ConvertCurrencyRequestDTO;
import com.rest.domain.ConvertCurrencyResponseDTO;

@RestController
public class CurrencyController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value = "/currency")
	public ConvertCurrencyResponseDTO convertCurrency(@RequestBody ConvertCurrencyRequestDTO request) {
		String conversionEndpoint = "https://www.google.com/finance/converter?a=" + request.getAmount() + 
				"&from=" + request.getFromCurrency() + "&to=" + request.getToCurrency();
		ConvertCurrencyResponseDTO response = restTemplate.getForObject(conversionEndpoint, ConvertCurrencyResponseDTO.class);
        return response;
	}

}
