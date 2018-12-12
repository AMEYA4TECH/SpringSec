<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
hello ${userName} !!!

 <p>Don't forget: ${userName}</p>
<%-- <c:url value="/j_spring_security_logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a> --%>

<spring:url value="/logout" var="url" htmlEscape="true"/>
 <a href="${url}">Log out</a> 
 
</body>
</html>
