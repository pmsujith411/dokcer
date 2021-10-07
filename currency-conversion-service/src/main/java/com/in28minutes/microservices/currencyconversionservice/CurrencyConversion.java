package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private BigDecimal conversionMultiple;
	private String from;
	private String to;
	private int port;
	private int qty;
	private int tot;
	public CurrencyConversion(){
		super();
	}
	public CurrencyConversion(Long id, BigDecimal conversionMultiple, String from, String to, int port, int qty,
			int tot) {
		super();
		this.id = id;
		this.conversionMultiple = conversionMultiple;
		this.from = from;
		this.to = to;
		this.port = port;
		this.qty = qty;
		this.tot = tot;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
}
