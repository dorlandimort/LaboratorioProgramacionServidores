package mx.edu.ulsaoaxaca.sistema.bean.DAO;

import java.util.List;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;

public interface CuentaDAO {
	
	public List<Cuenta> getAll(String usu, String contra);
	
	
}
