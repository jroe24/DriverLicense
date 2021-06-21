<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Profile Page</title>
</head>
<body>
	 <h1>
	     <c:out value="${ license.person.firstName} ${license.person.lastName}" />
	 </h1>
	 <p>License Number:
	     <c:out value="${license.number}" />
	 </p>
	 <p>State:
	     <c:out value="${ license.state }" />
	 </p>
	 <p>Expiration Date:
	     <fmt:formatDate pattern="MM-dd-yyyy" value="${license.expirationDate}" />
	 </p>
</body>
</html>