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
	public List<Cuenta> getAll() {
		DataSource data = new DataSource("jdbc:mysql://172.16.22.16/test", "mysql", "admin");
		String sql = "Select c.id, c.usuario, c.contrasena, c.cuentaActiva, " 
				+ "p.id, p.nombre, p.sexo, p.fechaNacimiento, "
				+ "pf.id, pf.nombre, pf.descripcion FROM cuenta c, persona p, perfil pf "
				+ "WHERE c.persona_id = p.id AND c.perfil_id = pf.id";
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
	
	@Override
	public Cuenta validate(String user, String pass) {
		DataSource data = new DataSource("jdbc:mysql://172.16.22.16/test", "mysql", "admin");
		String sql = "Select c.id, c.usuario, c.contrasena, c.cuentaActiva, " 
				+ "p.id, p.nombre, p.sexo, p.fechaNacimiento, "
				+ "pf.id, pf.nombre, pf.descripcion FROM cuenta c, persona p, perfil pf "
				+ "WHERE c.persona_id = p.id AND c.perfil_id = pf.id AND c.usuario='" + user + 
				"' AND c.contrasena='" + pass + "'";
		ResultSet rs = data.executeQuery(sql);
		try {
			if ( ! rs.next())
				return null;
			else {
				try {
					Cuenta cuenta = new Cuenta();
					cuenta.setId(rs.getInt(1) + "");
					cuenta.setUsuario(rs.getString(2));
					cuenta.setContrasena(rs.getString(3));
					cuenta.setActivo(rs.getString(4));
					
					Persona p = new Persona();
					p.setId(rs.getInt(5) + "");
					p.setNombre(rs.getString(6));
					p.setSexo(rs.getString(7));
					p.setFechaNacimiento(rs.getString(8));
					
					Perfil pf = new Perfil();
					pf.setId(rs.getInt(9) + "");
					pf.setNombre(rs.getString(10));
					pf.setDescripcion(rs.getString(11));
					
					cuenta.setPersona(p);
					cuenta.setPerfil(pf);
					
					System.out.println(cuenta);
					return cuenta;
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
