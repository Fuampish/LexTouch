package net.visualflip.lextouch;

import java.sql.*;

public class Conexion {
	public Connection getConexion(){
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/lextouch";
			c = DriverManager.getConnection(url,"adminnLnmxWA","Hxnw3aYz-g3W");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
