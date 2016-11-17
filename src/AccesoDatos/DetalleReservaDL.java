package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidades.DetalleReservaEL;
import Entidades.ReservaEL;
import Entidades.HabitacionEL;
public class DetalleReservaDL {
	//Singleton
	public static DetalleReservaDL _instancia;
	private DetalleReservaDL(){};
	public static DetalleReservaDL instancia(){
		if(_instancia==null){
			_instancia = new DetalleReservaDL();
		}
		return _instancia;
	}
	//endSingleton
	public DetalleReservaEL GEN_buscarDetalleReserva(int id) throws Exception {
		Connection cn = null;
		DetalleReservaEL dr = null;
		ReservaEL r = null;
		HabitacionEL h = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarDetalleReserva(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				dr = new DetalleReservaEL();
				dr.setId(rs.getInt("id"));
					h = new HabitacionEL();
					h.setId(rs.getInt("idHabitacion"));
					dr.setHabitacion(h);
					r = new ReservaEL();
					r.setId(rs.getInt("idReserva"));
					dr.setReserva(r);
			}
			return dr;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<DetalleReservaEL> GEN_listarDetallesReserva() throws Exception {
		Connection cn = null;
		DetalleReservaEL dr = null;
		ReservaEL r = null;
		HabitacionEL h = null;
		ArrayList<DetalleReservaEL> lista = new ArrayList<DetalleReservaEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarDetallesReserva()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				dr = new DetalleReservaEL();
				dr.setId(rs.getInt("id"));
					h = new HabitacionEL();
					h.setId(rs.getInt("idHabitacion"));
					dr.setHabitacion(h);
					r = new ReservaEL();
					r.setId(rs.getInt("idReserva"));
					dr.setReserva(r);
				lista.add(dr);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarDetalleReserva(DetalleReservaEL dr) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarDetalleReserva(?,?)}");
				cst.setInt(1, dr.getHabitacion().getId());
				cst.setInt(2, dr.getReserva().getId());
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
