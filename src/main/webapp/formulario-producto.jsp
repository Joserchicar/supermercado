<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formulario prooducto</title>
</head>
<body>

<h1>Formulario para crear un producto</h1> 

<p>${mensaje}</p>

<form action="producto-crear" method="post"> 

	<input type="text" name="nombre"placeholder="escribe el nombre del producto">
	
	<input type="submit" value="crear">	

</form>


</body>
</html>