package net.visualflip.lextouch;

import java.sql.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "Usuario", targetNamespace = "http://lextouch-rfiscal.rhcloud.com/Usuario")
public class Usuario {
	private String nombre;
	private String usuario;
	private String email;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@WebMethod(action = "http://lextouch-rfiscal.rhcloud.com/Usuario/buscarPorId")
	@WebResult(name = "buscarPorId", partName = "buscarPorId")
	public String buscarPorId(@WebParam(name = "id") int id){
		Conexion c = new Conexion();
		Statement stm = null;
		ResultSet fila = null;
		try {
			stm = c.getConexion().createStatement();
			fila = stm.executeQuery("select * from usuarios where id='" + id + "'");
			while(fila.next()){
				setNombre(fila.getString("nombre"));
				setEmail(fila.getString("email"));
				setUsuario(fila.getString("usuario"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "El id " + id + "le pertenece a: " + getNombre();
	}
}
