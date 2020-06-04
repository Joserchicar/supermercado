<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="login" />
  <jsp:param name="title" value="login" /> 
</jsp:include>

	

	
	<form action="login" method="post"class="form-login" onsubmit="cifrar()">
	
	
		<input type="text" name="nombre" placeholder="Tu Nombre">
		<br>
		<input type="password" name="pass" placeholder="Tu Contraseña">
		<br>
		
		 <select name="idioma" class="custom-select">		  
		  <option value="es">Castellano</option>
		  <option value="eu">Euskera</option>
		  <option value="en">Ingles</option>
		</select>
		
		<br>
		<input type="submit" value="Iniciar Sesión"class="btn btn-primary btn-block">
	
	</form>
	
	<%@include file="includes/pie.jsp" %>
	