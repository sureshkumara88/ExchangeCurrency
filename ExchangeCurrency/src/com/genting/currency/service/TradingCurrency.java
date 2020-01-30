package com.genting.currency.service;

import java.math.BigDecimal;

public interface TradingCurrency {

	public BigDecimal getExchangeRate(String sourceCurrency, String targetCurrency) throws Exception ;
	
	public BigDecimal getExchangedAmount(BigDecimal amount, BigDecimal rate) throws Exception ;
	
}
