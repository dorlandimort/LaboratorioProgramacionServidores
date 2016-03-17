package mx.edu.ulsaoaxaca.sistema.bean.DAO;

import java.sql.SQLException;
import java.util.List;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;

public interface CuentaDAO {
	
	public List<Cuenta> obtenerCuentas() throws SQLException;
	public Cuenta validarCuenta(String user, String pass) throws SQLException;
	
}
