<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/WEB-INF/tlds/cusAddress.tld" prefix="cust" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product Login Page</h1>
<h1><a href="searchProduct.html">GetProductById</a></h1>
<h1><a href="ProductController">SearchALLProducts</a></h1>
<h1><a href="productForm.html">ProductForm</a></h1>
<cust:AddressOfDXC></cust:AddressOfDXC>
<cust:PrintName name="Prem" noOfTimes="3"></cust:PrintName>
<cust:PrintName name="Balaji"></cust:PrintName>
<jstl:forEach var="PB" begin="1" end="10" step="1"><h1>HI, This is PB <jstl:out value="${PB}"></jstl:out></h1></jstl:forEach>
</body>
</html>