package com.genting.currency.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.genting.currency.model.ExchangeRates;

public class Utility {
	
	private List<ExchangeRates> loadCurrencyExchange() {
		List<ExchangeRates> exchangerates = new ArrayList<>();
		 try (FileReader reader = new FileReader("D:\\currency.csv");
	             BufferedReader br = new BufferedReader(reader)) {

	            // read line by line
	            String line;
	            while ((line = br.readLine()) != null) {
	            	ExchangeRates exchangeRate = new ExchangeRates();
	                String[] rates = line.split(",");
	                exchangeRate.setSourceCurrency(rates[0]);
	                exchangeRate.setTargetCurrency(rates[1]);
	                exchangeRate.setRate(new BigDecimal(rates[2]));
	                exchangerates.add(exchangeRate);
	            }

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
		 return exchangerates;
	}
	
	public BigDecimal getCurrency(String sourceCurrency, String targetCurrency) {
		List<ExchangeRates> exchangerates = loadCurrencyExchange();
		
		for (ExchangeRates rate : exchangerates) {
			if (rate.getSourceCurrency().equals(sourceCurrency) && rate.getTargetCurrency().equals(targetCurrency)) {
				return rate.getRate();
			}
		}
		
		return null;
	}
}
