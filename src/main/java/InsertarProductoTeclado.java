

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;


public class InsertarProductoTeclado {

	public static void main(String[] args) {
		
		final String URL="jdbc:mysql://localhost/supermercado";
		final String USUARIO="debian-sys-maint";
		final String PASS ="o8lAkaNtX91xMUcV";
		final String SQL="INSERT INTO producto(nombre,id_usuario) VALUES (?,1);";
		
		
		
		try
		{
			// comprobar que tengamos el . jar de mysql
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("existe el .jar para mysql");
		   // Conectarnos a una BBDD supermercado//
		   Connection conexion = DriverManager.getConnection (URL,USUARIO,PASS);
		   System.out.println("CONEXION CON EXITO");
		   
		   //Realizar una consulta 
		   PreparedStatement pst = conexion.prepareStatement(SQL);
		   //ResultSet rs= pst.executeQuery();
		   
		   
		   System.out.println("Insertar  Productos");
		   System.out.println("--------------------");
		   
		   //TODO pedir el nombre del producto a insertar por pantalla por teclado 
		   Scanner teclado=new Scanner(System.in);
		   String prod=teclado.nextLine();
		   
		  while (teclado.hasNext()&&prod!="" ) {
			String string = (String) teclado.next();
			
				pst.setString(1,prod );	
		}
			// TODO como detener el introducir productos para que ejecute 
		teclado.close();
		   
		     
		   //cambiamos el 1º ? de la  SQL por "galletitas salada
		  // pst.setString(1,"galletitas saladas");
		   
		   int affectedRows=pst.executeUpdate();
		   // realizar 1 a 1 los resultados hasta que no existan mas registros
		  //affectesRows es el numero de registros insertados
		   System.out.println("numero de registros insertados : "+affectedRows );
		   
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		} 
		
		
		
		
		
	}
	
	
}
