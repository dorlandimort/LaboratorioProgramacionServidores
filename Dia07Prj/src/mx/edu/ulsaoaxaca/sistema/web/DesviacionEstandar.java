package mx.edu.ulsaoaxaca.sistema.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesviacionEstandar extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		File archivo = new File("datos");
		List<String> datos = new LinkedList<>();
		int contador = 0;
		double suma = 0.0;
		if (archivo.exists()) {
			Scanner sc = new Scanner(archivo);
			while(sc.hasNext()) {
				String dato = sc.nextLine();
				datos.add(dato);
				suma += Double.parseDouble(dato);
				contador++;
			}
			sc.close();
			
			double media = suma / contador;
			double sumatoria = 0.0;
			for(String d : datos) {
				sumatoria += Math.pow((Double.parseDouble(d) - media), 2);
			}
			double cuadrado = sumatoria / (contador - 1);
			double desviacionEstandar = Math.sqrt(cuadrado);
			
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("Orlando Giovanni, Desviación Estándar: " + desviacionEstandar);
			writer.println("</body>");
			writer.println("</html>");
			writer.flush();
			
		} else
			System.out.println("no archivo");
		
		
	}

}
