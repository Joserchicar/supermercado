<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formulario producto</title>
</head>
<body>

<a href="index.jsp">Volver</a>

<h1>Formulario para crear un producto</h1> 

<p>${mensaje}</p>

<form action="producto-crear" method="post"> 

	<label for="id">id:</label>
	<input type="text" name="id" id="id" value="${producto.id}" >
	<br>
	<label for="nombre">nombre:</label>
	<input type="text" name="nombre" value="${producto.nombre}" placeholder="escribe el nombre del producto">
	<br>
	<input type="submit" value="guardar">	

</form>


</body>
</html>