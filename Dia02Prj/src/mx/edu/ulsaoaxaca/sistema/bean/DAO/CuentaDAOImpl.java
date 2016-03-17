package mx.edu.ulsaoaxaca.sistema.bean.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;
import mx.edu.ulsaoaxaca.sistema.bean.Perfil;
import mx.edu.ulsaoaxaca.sistema.bean.Persona;

public class CuentaDAOImpl implements CuentaDAO {

	@Override
	public List<Cuenta> getAll(String usu, String contra) {
		DataSource data = new DataSource("jdbc:mysql://172.16.22.16/test", "mysql", "admin");
		String sql = "Select c.id, c.usuario, c.contrasena, c.cuentaActiva, " 
				+ "p.id, p.nombre, p.sexo, p.fechaNacimiento, "
				+ "pf.id, pf.nombre, pf.descripcion FROM cuenta c, persona p, perfil pf "
				+ "WHERE c.persona_id=p.id and c.perfil_id = pf.id and "+"c.usuario='"+usu+"' and c.contrasena='"+contra+"'";
		
		
		ResultSet rs = data.executeQuery(sql);
		
		List<Cuenta> lista = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Cuenta c = new Cuenta();
				c.setId(rs.getInt(1) + "");
				c.setUsuario(rs.getString(2));
				c.setContrasena(rs.getString(3));
				c.setActivo(rs.getString(4));
				
				Persona p = new Persona();
				p.setId(rs.getInt(5) + "");
				p.setNombre(rs.getString(6));
				p.setSexo(rs.getString(7));
				p.setFechaNacimiento(rs.getString(8));
				
				Perfil pf = new Perfil();
				pf.setId(rs.getInt(9) + "");
				pf.setNombre(rs.getString(10));
				pf.setDescripcion(rs.getString(11));
				
				c.setPersona(p);
				c.setPerfil(pf);
				
				lista.add(c);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	
	

}
