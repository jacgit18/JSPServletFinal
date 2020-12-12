<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tlds/csajsp-taglib.tld" prefix="ex"%>

<html>
<head>
<title>MVC With DB</title>
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
<body>


	<table class="title">
		<tr>
			<th>MVC With DB</th>
		</tr>
	</table>
	<br />

	<fieldset>
		<legend>SSN # Finder</legend>
		<form action="searchmysocial" Method="Post">
			Enter SSN #: <input type="text" name="SSN" value="${studentJspRef.SSN}"><br>
			<!-- 
						Enter SSN #: <input type="text" name="SSN" value="${ssnInfo.SSN}"><br>  -->

			<input type="submit" value="Find Student">
		</form>
		<ex:HelloTag message="Hello Worlds">
			Test
		</ex:HelloTag>
		<UL>
			<LI>Current time: <%=new java.util.Date()%>
			<LI>Server: <%=application.getServerInfo()%>
			<LI>Session ID: <%=session.getId()%>
			
		</UL>
	</fieldset>

</body>
</html>

