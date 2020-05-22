<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>

<a href="index.jsp">Volver</a>

	<h1>Listado Productos</h1>
	<p>${mensaje}</p>

	<a href="producto-crear">Ir a formulario para Crear Nuevo Producto</a>
	
	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
	
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Operaciones<td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${producto}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>
					<a href="producto-crear?id=${p.id}">EDITAR</a>
					<a href="producto-eliminar?id=${p.id}">ELIMINAR</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>