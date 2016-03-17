<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.*" %>
<%@ page import="mx.edu.ulsaoaxaca.sistema.bean.*" %>
<%@ page import="mx.edu.ulsaoaxaca.sistema.bean.DAO.*" %>
<%@ page import="java.sql.SQLException" %>
<%
	// Verifica que los parámetros existan
	if(request.getParameter("usuario") != null &&  request.getParameter("pass") != null) {
	 	String user = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		CuentaDAO dao = new CuentaDAOImpl();
		// Se validan los datos llamando al DAO el cual retorna un objeto Cuenta en caso de que
		//los datos estén bien, de otro medo retorna null
	 	Cuenta c = null;
		try {
			c = dao.validarCuenta(user, pass);
			// Verifica si el DAO NO retornó null
			if (c != null) {
				// Si el resultado no es nulo, entonces los datos de la cuenta se guardan en objetos JSON
				response.setContentType("application/json");
				JSONObject padre = new JSONObject();
				JSONObject cuenta = new JSONObject();
				JSONObject persona = new JSONObject();
				JSONObject perfil = new JSONObject();
				
				cuenta.put("usuario", c.getUsuario());
				cuenta.put("contrasena", c.getContrasena());
				cuenta.put("status", c.getActivo());
				
				persona.put("nombre", c.getPersona().getNombre());
				persona.put("sexo", c.getPersona().getSexo());
				persona.put("fechaNacimiento", c.getPersona().getFechaNacimiento());
				
				perfil.put("nombre", c.getPerfil().getNombre());
				perfil.put("descripcion", c.getPerfil().getDescripcion());
				
				padre.put("cuenta", cuenta);
				padre.put("persona", persona);
				padre.put("perfil", perfil);
				
				out.print(padre.toString());
			
			} else {
				// De otro modo se envía un error al cliente
				System.out.println("No existe la cuenta");
				response.sendError(450);
			}
		} catch(SQLException e) {
			System.out.println("error");
			response.sendError(551);
		} catch(Exception e) {
			response.sendError(551);
		}
		
	} else {
		System.out.println("no existen los parametros");
		response.sendError(500);
	}




//agregar propiedades de la cuenta

			/*out.println("[");
	         	out.println("{" + "\"cuenta\": {");
		            out.print("\"id\": \"" + c.getId() + "\", ");
		            out.print("\"usuario\": \"" + c.getUsuario() + "\", ");
		            out.print("\"contrasena\": \"" + c.getContrasena() + "\", ");
		            out.print("\"status\": \"" + c.getActivo() + "\"");
	          		out.println("}");
	          	out.println("},");
	          	out.println("{" + "\"persona\": {");
		            out.print("\"nombre\": \"" + c.getPersona().getNombre() + "\", ");
		            out.print("\"sexo\": \"" + c.getPersona().getSexo() + "\", ");
		            out.print("\"fechaNacimiento\": \"" + c.getPersona().getFechaNacimiento() + "\"");
		            out.println("}");
	          	out.println("},");
	         	 out.println("{" + "\"perfil\": {");
		            out.print("\"nombre\": \"" + c.getPersona().getNombre() + "\", ");
		            out.print("\"descripcion\": \"" + c.getPersona().getSexo() + "\"");
		            out.println("}");
	          	out.println("}");
			out.print("]");
			*/
%>



