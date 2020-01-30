<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exchange Currency</title>
</head>
<body>
<form action="CurrencyRate" method="post">
	<fieldset>
		<legend>
			<b><i><font size="7" color="navy">Exchange Currency Application</font></i></b>
		</legend>
		<div>
			<p>
				Source Currency : &nbsp;&nbsp; <input type="text" name="sourceCurrency" id="sourceCurrencyId" value="${sourceCurrency}">
			</p>			
		</div>
		<div>
			<p>
				Target Currency : &nbsp;&nbsp; <input type="text" name="targetCurrency" id="targetCurrencyId" value="${targetCurrency}">					
			</p>
		</div>
		<div>
			<p>
				Source Amount : &nbsp;&nbsp; <input type="text" name="sourceAmount" id="sourceAmountId" value="${sourceAmount}">					
			</p>
		</div>	
		<div>
			<p>
				Target Amount : &nbsp;&nbsp; ${targetAmount}			
			</p>
		</div>	
		<div style="text-indent:150px; ">
			<p>
				<input type="submit" name="submitButton" Value="Calculate">
			</p>
		</div>
		<div align="center">
			<font color="red">${message}</font>
		</div>
	</fieldset>
</form> 
</body>
</html>