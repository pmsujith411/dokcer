package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/from/{frm}/to/{to}/quantity/{qty}")
	public CurrencyConversion calculate(@PathVariable String frm, @PathVariable String to,
			@PathVariable int qty) {
		//
		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("frm", frm);
		uriVars.put("to", to);
		ResponseEntity< CurrencyConversion> respEnt = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{frm}/to/{to}",
				CurrencyConversion.class,uriVars);
		CurrencyConversion currencyConversion = respEnt.getBody();
		return new CurrencyConversion(currencyConversion.getId(),currencyConversion.getConversionMultiple(),currencyConversion.getFrom(),currencyConversion.getTo(),
				8880,60*qty,qty);
	}
}
