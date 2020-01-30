package com.genting.currency.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genting.currency.service.ExchangeCurrencyService;

/**
 * Servlet implementation class ExchangeCurrency
 */
@WebServlet("/CurrencyRate")
public class ExchangeCurrency extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sourceCurrency = request.getParameter("sourceCurrency");
		String targetCurrency = request.getParameter("targetCurrency");
		String sourceAmount = request.getParameter("sourceAmount");
		request.setAttribute("message", "");
		ExchangeCurrencyService service = new ExchangeCurrencyService();
		
		try {
		BigDecimal rate = service.getExchangeRate(sourceCurrency, targetCurrency);
		if (rate != null) {
			BigDecimal targetAmount = service.getExchangedAmount(new BigDecimal(sourceAmount), rate);
			request.setAttribute("targetAmount", targetAmount);	
		} else {
			request.setAttribute("message", "The Given Currency Type is not available");
		}
			
		} catch (Exception e) {
			if (e instanceof java.lang.NumberFormatException) {
				request.setAttribute("message", "Please enter numbers only in Source Amount field");
			}
		}
		
		request.setAttribute("sourceCurrency", sourceCurrency);
		request.setAttribute("targetCurrency", targetCurrency);
		request.setAttribute("sourceAmount", sourceAmount);
		
		RequestDispatcher reqdis = request.getRequestDispatcher("index.jsp");
		reqdis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
