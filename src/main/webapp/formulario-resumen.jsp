<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Resumen</title>
</head>
<body>

	<h1>Mostrar Resumen CV</h1>
	
	<p style="color: red;">${mensaje}</p>
 
	
	//DATOS
	<h2> DATOS CV</h2>
	<p>atributos recibidos del controlador</p>
	<br>
	<h3>Name:</h3>${nombre}
 
    <h3>Surname:</h3>${apellido}
 
    <h3>Age:</h3>${edad}
 
    <h3>Studies:</h3>${estudios}
 
    <h3>hours:</h3>
    
    <%
        ArrayList<String> hours = (ArrayList<String>) request.getAttribute("hoursSelected");    
        for (String hour : hours) {
    %> 
  		  <p> <%=hours%> </p>
 
    <%
    } // FOR
    %>
 
    <h3>Gender:</h3>${genero}
 
    <h3>Comments:</h3>${comentario}
 
    
 
	
	
	

</body>
</html>