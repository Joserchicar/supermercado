<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Inicio";  %>
<%@include file="includes/cabeceraEjemplos.jsp" %>

<h1>Pagina principal</h1>

<%
	// esto es codigo Java - Scriptlets
	// podemos usar varias lienas y cada una debe terminar con ;
	out.print("<p>Esta linea esta en Java</p>");
	out.print("<p>Tu nombre es: " + request.getParameter("nombre") + "</p>");
	

%>

<p>Ejemplo de expresion, 2 + 2 = <%= 2 + 2 %></p>
<p>Las expresiones solo pueden contener una linea y no usan <code>;</code> </p>

<p>Ejemplo de expresion con EL - Expresion Lenaguage, 2 + 2 = ${2 + 2}</p>

<a href="MiPrimerServlet?nombre=ander&apellido=uraga&email=aaa@aaaa.com">Mi Primer Servlet Ejemplo</a>
<br>
<a href="getYpost.jsp?title=GetPost">GET y POST</a>
<br>
<a href="formulario-validacion.jsp">Ejemplo Formulario Validacion</a>
<br>
<a href="formulario.jsp">Ejemplo Formulario Completo</a>
<br>
<a href="ver-tabla-alumnos">Ver alumnos en tabla</a>
<br>
<a href="productos">Ver Productos</a>
<br>
<a href="formulario-producto.jsp">Crear Producto</a>


<%@include file="includes/pie.jsp" %>
