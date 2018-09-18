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
  
  <tr>
    <td>id:  ${emp.id}</td>
    <td>name: ${emp.name}</td> 
    <td>sal: ${emp.sal}</td> 
    <td>phone: ${emp.phone.phoneNumber}</td> 
    <td>first name: ${emp.phone.firstName}</td> 
   </tr>
    </br>
   <%-- <c:forEach items="${emp.listAddr}" var="addr">
     <tr>
    <td>${addr.street }  </td>
    <td>${addr.city }  </td>
    <td>${addr.pincode }  </td>
    <td>${addr.state }  </td>
    </tr>
	 </c:forEach>  --%>
  

</body>
</html>