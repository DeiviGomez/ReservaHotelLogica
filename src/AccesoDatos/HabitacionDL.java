package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.HabitacionEL;
import Entidades.TipoHabitacionEL;;
public class HabitacionDL {
	//Singleton
	public static HabitacionDL _instancia;
	private HabitacionDL(){};
	public static HabitacionDL instancia(){
		if(_instancia==null){
			_instancia = new HabitacionDL();
		}
		return _instancia;
	}
	//endSingleton
	public HabitacionEL GEN_buscarHabitacion(int id) throws Exception {
		Connection cn = null;
		TipoHabitacionEL th = null;
		HabitacionEL h = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarHabitacion(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				h = new HabitacionEL();
				h.setId(rs.getInt("id"));
				h.setCodigo(rs.getString("codigo"));
				h.setHabilitado(rs.getBoolean("habilitado"));
				h.setOcupado(rs.getBoolean("ocupado"));
					th = new TipoHabitacionEL();
					th.setId(rs.getInt("idTipoHabitacion"));
					h.setTipoHabitacion(th);
			}
			return h;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<HabitacionEL> GEN_listarHabitaciones() throws Exception {
		Connection cn = null;
		HabitacionEL h = null;
		TipoHabitacionEL th = null;
		ArrayList<HabitacionEL> lista = new ArrayList<HabitacionEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarHabitaciones()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				h = new HabitacionEL();
				h.setId(rs.getInt("id"));
				h.setCodigo(rs.getString("codigo"));
				h.setHabilitado(rs.getBoolean("habilitado"));
				h.setOcupado(rs.getBoolean("ocupado"));
					th = new TipoHabitacionEL();
					th.setId(rs.getInt("idTipoHabitacion"));
					h.setTipoHabitacion(th);
				lista.add(h);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarHabitacion(HabitacionEL h) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarHabitacion(?,?,?,?)}");
			cst.setString(1, h.getCodigo());
			cst.setBoolean(2, h.getHabilitado());
			cst.setBoolean(3, h.getOcupado());
			cst.setInt(4, h.getTipoHabitacion().getId());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	public boolean GEN_editarHabitacion(HabitacionEL h) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_editarHabitacion(?,?,?,?,?)}");
			cst.setInt(1, h.getId());
			cst.setString(2, h.getCodigo());
			cst.setBoolean(3, h.getHabilitado());
			cst.setBoolean(4, h.getOcupado());
			cst.setInt(5, h.getTipoHabitacion().getId());
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
