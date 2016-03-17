<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="mx.edu.ulsaoaxaca.sistema.bean.*" %>
<%@ page import="mx.edu.ulsaoaxaca.sistema.bean.DAO.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.json.JSONObject" %>
	<%
		/*if(request.getParameter("user") != null &&  request.getParameter("pass") != null) {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass"); 
			CuentaDAO dao = new CuentaDAOImpl();
			Cuenta c = dao.validate(user, pass);
			*/
			//if (c != null) {
				/*out.println("Cuenta: usuario:" + c.getUsuario() + "<br>" + " contrasena: " + c.getContrasena() + "<br>" + 
					" Status: " + c.getActivo() + "<br>" + 
					"Persona:  nombre: " + c.getPersona().getNombre() + "<br>" + " Sexo: " + c.getPersona().getSexo() + "<br>" +
					" Fecha Nacimiento: " + c.getPersona().getFechaNacimiento() + "<br>" +
					"Perfil: nombre:" + c.getPerfil().getNombre() + "<br>" + " descripcion: " + c.getPerfil().getDescripcion());*/
					
					/*JSONObject cu = new JSONObject();	
					cu = new JSONObject(request.getParameter("jsonData"));
					out.println(cu.toString());
					*/
				JSONObject obj = new JSONObject();
				obj.put("usuario", "hola");
				PrintWriter writer = response.getWriter();
			    writer.println(obj);
			    writer.flush();
				
			/*} else {
				String error = "error=Error, usuario y/o contrasena inválidos";
				response.sendRedirect("index.jsp" );
				
			}*/
		//}
	 %>