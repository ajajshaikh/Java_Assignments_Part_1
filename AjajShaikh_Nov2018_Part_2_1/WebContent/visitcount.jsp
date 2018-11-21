<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		int i=0;	//Global variable for count
	%>
	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //Cache control to prevent back button
		if(session.getAttribute("username")==null){	//session validation
			response.sendRedirect("login.jsp");
		}
	%>
	<%
		i++;
		out.println("\t\tVisit count : " + i);	
	%>	
	<form action="Logout">		
		<input type="submit" value="Logout">	
</body>
</html>