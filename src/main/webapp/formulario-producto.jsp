<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>
    
<h2>registro de productos</h2>
        <div class="form container">
        
        
<a href="index.jsp">Volver</a>

	<h1>Formulario Para Crear/Modificar Producto</h1>
	
	<div class="row">
		<div class="col">
		
			<form action="productos" method="post" class="form-producto">
	
		
				<div class="form-group">
                    <label for="id">id</label>
                    <input type="text" 
                           class="form-control" 
                          value="${producto.id}" 
                          readonly>                
                </div>
                
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" 
                           class="form-control" 
                           value="${producto.nombre}"
                           required
                           autofocus
                           placeholder="Nombre del producto"
                           name="nombre"
                           id="nombre">                
                </div>

                <div class="form-group">
                    <label for="precio">Precio:</label>
                    <input type="text" 
                           class="form-control" 
                           value="${producto.precio}"
                           required
                           placeholder="0.0 € "
                           name="precio"
                           id="precio">                
                </div>

                <div class="form-group">
                    <label for="imagen">Imagen:</label>
                    <input type="text" 
                           class="form-control" 
                           value="${producto.imagen}"
                           placeholder="URL de la imagen"
                           name="imagen"
                           id="imagen">                
                </div>
                
                <!-- campos oculto que se envia pero no se ve -->
               <input type="hidden" name="id" value="0">        

                <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
            </form>
		
		</div>
		<div class="col">
		<img src=" ${producto.imagen}" class="img-thumbnail" alt=" imagen del producto">
		
		</div>
	
	
	</div>
	
            
<%@include file="includes/pie.jsp" %>