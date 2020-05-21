<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORMULARIO COMPLETO</title>
</head>
<body>
	<h1>Formulario Completo</h1>

	<c:if test="${not empty validationes}">
		<div style="padding: 20px; background-color: #DDD; color: #000;">
			<ol>
				<c:forEach items="${validationes}" var="validacion">
					<li>${validacion}</li>
				</c:forEach>
			</ol>
		</div>
	</c:if>




	<div class="form container">

		<form action="formulario-completo" method="POST">

			<label for="name" class="obligatoria">Name:</label> <input
				type="text" name="name" id="name" value="${nombre}" autofocus
				required placeholder="Minimo 3, maximo 15" pattern="[A-Za-z]{3,15}"><br>

			<br> <label for="surname" class="obligatoria">First
				name:</label> <input type="text" name="surname" id="surname"
				value="${apellido}" required><br> <br> <label
				for="age">Age:</label> <input type="number" value="${edad}"
				placeholder="16" min="16" step="1" name="age" id="age" size="3"
				maxlength="3" value="16"><br> <br> <label
				for="studies">Studies:</label> <select name="studies" id="studies"
				value="${estudios}"}>
				<option value="u">University</option>
				<option value="p">Profesional</option>
				<option value="o" selected>Others</option>
			</select> <br> <br> <br>

			<fieldset>
				<legend>Choose your gender:</legend>
				<label for="gender" value="${genero}">Genre:</label><br> <input
					type="radio" id="male" name="gender" value="male"> <label
					for="male">Male</label><br> <input type="radio" id="female"
					name="gender" value="female"> <label for="female">Female</label><br>
				<input type="radio" id="other" name="gender" value="other">
				<label for="other">Other</label><br>
			</fieldset>

			<br>


			<fieldset >
				<legend>horario:</legend>

				<input type="checkbox" id="fulltime" name="hours" value="ft">
				<label for="fulltime"> Full time</label><br> <input
					type="checkbox" id="parttime" name="hours" value="pt"> <label
					for="parttime"> Part time</label><br> <input type="checkbox"
					id="all" name="hours" value="all" checked> <label for="all">
					All</label><br>
			</fieldset>




			<label for="text">Comments:</label><br>
			<textarea name="message" value="${comentario}" cols="50" rows="10"
				id="text" placeholder="Tus comentarios son de agradecer..."></textarea>

			<br> <label for="photo">Add your photo</label><br> <input
				type="file" name="photo" id="photo" enctype="multipart/form-data"><br>

			<br> <input type="submit" value="Send">

		</form>
</body>
</html>