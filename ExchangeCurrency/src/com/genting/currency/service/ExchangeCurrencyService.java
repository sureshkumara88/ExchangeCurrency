package com.genting.currency.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.genting.currency.util.Utility;

public class ExchangeCurrencyService implements TradingCurrency {

	private Utility util = new Utility();
	
	public BigDecimal getExchangeRate(String sourceCurrency, String targetCurrency) throws Exception {
		try {
			return util.getCurrency(sourceCurrency, targetCurrency);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public BigDecimal getExchangedAmount(BigDecimal amount, BigDecimal rate) throws Exception {
		try {
			return amount.multiply(rate).setScale(0, RoundingMode.DOWN);
		} catch (Exception e) {
			throw new Exception(e);
		}		
	}
}
