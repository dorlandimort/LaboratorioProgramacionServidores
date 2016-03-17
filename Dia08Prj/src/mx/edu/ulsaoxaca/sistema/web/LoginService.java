package mx.edu.ulsaoxaca.sistema.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.ulsaoaxaca.sistema.web.DAO.CuentaDAO;
import mx.edu.ulsaoaxaca.sistema.web.DAO.CuentaDAOImpl;
import mx.edu.ulsaoaxaca.sistema.web.bean.Cuenta;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contra = request.getParameter("contrasena");
		if (usuario != null && contra != null) {
			CuentaDAO dao = new CuentaDAOImpl();
			Cuenta cuenta;
			
			try {
				cuenta = dao.validarCuenta(usuario, contra);
				if (cuenta != null) {
					request.setAttribute("cuenta", cuenta);
				    request.getRequestDispatcher("/main.jsp").forward(request, response);
				} else {
					response.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		
	}

}
