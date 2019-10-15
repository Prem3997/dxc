<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dxc.pms.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pro" class="com.dxc.pms.model.Product" scope="session"></jsp:useBean>
<jsp:setProperty property="productId" name="pro" param="productId"/>
<jsp:setProperty property="productName" name="pro" param="productName"/>
<jsp:setProperty property="quantityOnHand" name="pro" param="quantityOnHand"/>
<jsp:setProperty property="productPrice" name="pro" param="productPrice"/>
<a href="displayProduct.jsp">DisplayProduct</a>
</body>
</html>