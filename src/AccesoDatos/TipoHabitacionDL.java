package AccesoDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidades.TipoHabitacionEL;;
public class TipoHabitacionDL {
	//Singleton
	public static TipoHabitacionDL _instancia;
	private TipoHabitacionDL(){};
	public static TipoHabitacionDL instancia(){
		if(_instancia==null){
			_instancia = new TipoHabitacionDL();
		}
		return _instancia;
	}
	//endSingleton
	public TipoHabitacionEL GEN_buscarTipoHabitacion(int id) throws Exception {
		Connection cn = null;
		TipoHabitacionEL th = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarTipoHabitacion(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				th = new TipoHabitacionEL();
				th.setId(rs.getInt("id"));
				th.setCapacidadpersonas(rs.getInt("cantidadpersonas"));
				th.setCostoxdia(rs.getDouble("costoxdia"));
				th.setDescripcion(rs.getString("descripcion"));
				th.setHabilitado(rs.getBoolean("habilitado"));
				th.setNombre(rs.getString("nombre"));
			}
			return th;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<TipoHabitacionEL> GEN_listarTipoHabitaciones() throws Exception {
		Connection cn = null;
		TipoHabitacionEL th = null;
		ArrayList<TipoHabitacionEL> lista = new ArrayList<TipoHabitacionEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarTipoHabitaciones()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				th = new TipoHabitacionEL();
				th.setId(rs.getInt("id"));
				th.setCapacidadpersonas(rs.getInt("cantidadpersonas"));
				th.setCostoxdia(rs.getDouble("costoxdia"));
				th.setDescripcion(rs.getString("descripcion"));
				th.setHabilitado(rs.getBoolean("habilitado"));
				th.setNombre(rs.getString("nombre"));
				lista.add(th);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarTipoHabitacion(TipoHabitacionEL th) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarTipoHabitacion(?,?,?,?,?,?)}");
			cst.setInt(1, th.getCapacidadpersonas());
			cst.setDouble(2, th.getCostoxdia());
			cst.setString(3, th.getDescripcion());
			cst.setString(4, th.getDireccionimagen());
			cst.setBoolean(5, th.getHabilitado());
			cst.setString(6, th.getNombre());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	public boolean GEN_editarTipoHabitacion(TipoHabitacionEL th) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_editarTipoHabitacion(?,?,?,?,?,?,?)}");
			cst.setInt(1, th.getId());
			cst.setInt(2, th.getCapacidadpersonas());
			cst.setDouble(3, th.getCostoxdia());
			cst.setString(4, th.getDescripcion());
			cst.setString(5, th.getDireccionimagen());
			cst.setBoolean(6, th.getHabilitado());
			cst.setString(7, th.getNombre());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
}
