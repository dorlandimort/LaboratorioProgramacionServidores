<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mx.edu.ulsaoaxaca.sistema.web.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datos de la cuenta</title>
</head>
<body>
	<c:choose>
		<c:when test="${cuenta != null}">
			<label>Usuario: ${cuenta.getUsuario()}</label><br>
			<label>Status: ${cuenta.getActivo() }</label><br>
			<label>Nombre: ${cuenta.getPersona().getNombre() }</label><br>
			<label>Sexo: ${cuenta.getPersona().getSexo() }</label><br>
			<label>Fecha de Nacimiento: ${cuenta.getPersona().getFechaNacimiento() }</label><br>
			<label>Nombre de perfil: ${cuenta.getPerfil().getNombre() }</label><br>
			<label>Descripción: ${cuenta.getPerfil().getDescripcion() }</label><br>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>