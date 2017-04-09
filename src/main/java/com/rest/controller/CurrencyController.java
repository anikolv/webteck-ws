package com.rest.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.ConvertCurrencyRequestDTO;

@RestController
public class CurrencyController {
	
	@PostMapping(value = "/currency", consumes = MediaType.APPLICATION_XML_VALUE)
	public String convertCurrency(@RequestBody ConvertCurrencyRequestDTO request) throws IOException {
		String conversionEndpoint = "https://www.google.com/finance/converter?a=" + request.getAmount() + 
				"&from=" + request.getFromCurrency() + "&to=" + request.getToCurrency();
		Document doc = Jsoup.connect(conversionEndpoint).get();
		Elements result = doc.select("span.bld");
		return result.text().replaceAll("[^\\d.]", "");
	}

}
