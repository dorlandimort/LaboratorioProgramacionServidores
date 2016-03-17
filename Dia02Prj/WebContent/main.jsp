<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="mx.edu.ulsaoaxaca.sistema.bean.*" %>
<%@ page import="mx.edu.ulsaoaxaca.sistema.bean.DAO.*" %>
<%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	
	
	
	
	
	<%
	
		String usuario= request.getParameter("usuario");
		String contra = request.getParameter("contrasena");
		
		CuentaDAO dao = new CuentaDAOImpl();
		
		
		
		List<Cuenta> lista = dao.getAll(usuario,contra);
		
		if(lista.size()>0){
			for(Cuenta c : lista) {
				out.println("Cuenta: usuario:" + c.getUsuario() + " contrasena: " + c.getContrasena() + 
						" Status: " + c.getActivo() + "<br>" + 
						"Persona:  nombre: " + c.getPersona().getNombre() + " Sexo: " + c.getPersona().getSexo() +
						" Fecha Nacimiento: " + c.getPersona().getFechaNacimiento() + "<br>" +
						"Perfil: nombre:" + c.getPerfil().getNombre() + " descripcion: " + c.getPerfil().getDescripcion());
			}
			
			
		}else{
			
			
			response.sendRedirect("Test.jsp");
			
		}
		
		
	%>
</body>
</html>