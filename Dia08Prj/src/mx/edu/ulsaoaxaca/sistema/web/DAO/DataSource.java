package mx.edu.ulsaoaxaca.sistema.web.DAO;

import java.sql.*;

public class DataSource {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private Connection conn;
	private Statement stmt;
	
	public DataSource(String host, String user, String pass) throws SQLException {
		//STEP 2: Registrar driver
	      try {
	    	  // 2: Registrar driver
	    	Class.forName("com.mysql.jdbc.Driver");
	    	// 3: Abrir una conexion
			conn = DriverManager.getConnection(host, user, pass);
			if (conn != null) {
				System.out.println("Conexion exitosa");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ResultSet executeQuery(String sql) {
		ResultSet result = null;
		try {
			this.stmt = conn.createStatement();
			result = this.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			this.stmt = conn.createStatement();
			result = this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	
}
