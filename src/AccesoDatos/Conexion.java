package AccesoDatos;
import java.sql.*;
public class Conexion {
	//Singleton
	public static Conexion _instancia;
	private Conexion(){};
	public static Conexion instancia(){
		if(_instancia==null){
			_instancia = new Conexion();
		}
		return _instancia;
	}
	//endSingleton
	public Connection Conectar() throws Exception{
		Connection cn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
						"databaseName=BDReservaHotelSOWAD", "sa", "123456");
		} catch (Exception e) {
			throw e;
		}
		return cn;
	}
}
