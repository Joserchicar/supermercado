<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="producto" />
  <jsp:param name="title" value="producto" /> 
</jsp:include>
<a href="index.jsp">Volver</a>

	<h1>Listado Productos</h1>
	<p>${mensaje}</p>


	<a href="producto">Ir a formulario para Crear Nuevo Producto</a>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	

	   <table class="tabla table table-striped">
                <thead>
                  <tr>
                    <th scope="col">id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Precio</th>
                    <th scope="col">imagen </th>
                    <th scope="col">operaciones</th>
                    
                  </tr>
                </thead>
                <tbody>
                  <tr>
                  <c:forEach items="${producto}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td><img src="${p.imagen}" alt="imagen..."></td>
					<td>
						<a href="producto?id=${p.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Producto"></i></a>
						<a href="producto-eliminar?id=${p.id}"><i class="fas fa-trash fa-2x" title="Eliminar Producto"></i></a>
					</td>
				</tr>
			</c:forEach>
                    
                </tbody>
              </table>
	
        
      <%@include file="includes/pie.jsp" %>
        
