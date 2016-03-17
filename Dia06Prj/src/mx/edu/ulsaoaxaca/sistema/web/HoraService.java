package mx.edu.ulsaoaxaca.sistema.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoraService extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		Date fechaHora = new Date();
		fechaHora.toString();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("Orlando Giovanni " + fechaHora.toString());
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
	}

}
