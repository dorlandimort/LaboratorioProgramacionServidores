import java.sql.SQLException;

import mx.edu.ulsaoaxaca.sistema.web.DAO.CuentaDAO;
import mx.edu.ulsaoaxaca.sistema.web.DAO.CuentaDAOImpl;
import mx.edu.ulsaoaxaca.sistema.web.bean.Cuenta;


public class Test {
	public static void main(String ... args) {
		
		CuentaDAO dao = new CuentaDAOImpl();
		try {
			Cuenta cuenta = dao.validarCuenta("potts", "12345");
			System.out.println(cuenta.getUsuario());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
