package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment envmnt;
	
	@Autowired
	private ExcganeValueRepo repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to) {
		ExchangeValue exchangeValue = repo.findByFromAndTo(from, to);
		Optional<ExchangeValue> valOpt = Optional.ofNullable(exchangeValue);
		if(valOpt.isPresent()) {
			exchangeValue = valOpt.get();
		}else{
			throw new EmployeeNotFoundException("Not found");
		}
		exchangeValue.setPort(Integer.parseInt(envmnt.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@GetMapping("/currency-exchange/all")
	public List<ExchangeValue> getall(){
		return repo.findAll();
		//new RestTemplate()
	}

}
