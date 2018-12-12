<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U session is expired</title>
</head>
<body>
<p>U session is expired</p>
 <%-- <c:url value="/login" var="loginUrl"/> --%>
<spring:url value="/login" var="url" htmlEscape="true"/>
 <a href="${url}">login again</a> 
<%--  <a href="<c:url value='/login'/>"></a> --%>
</body>
</html>