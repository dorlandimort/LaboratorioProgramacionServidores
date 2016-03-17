<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>El factorial de 7 es:</h1> 
	<h2><%= factorial(7)%></h2>
	<%!
		double factorial(double n) {
			if (n == 1 || n == 0)
				return 1;
			else {
				return n * factorial(n-1);
			}
		}
	%>
</body>
</html>