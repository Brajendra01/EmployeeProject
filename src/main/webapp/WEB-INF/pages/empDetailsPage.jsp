<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
  Employee Details::
  </br>
  
  <c:forEach items="${empList}" var="emp"> 
  <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td> 
    <td>${emp.sal}</td> </tr>
</c:forEach>
  

</body>
</html>