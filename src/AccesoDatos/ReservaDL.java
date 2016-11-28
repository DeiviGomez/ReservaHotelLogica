package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.ReservaEL;
import Entidades.TipoHabitacionEL;
import Entidades.DetalleReservaEL;
import Entidades.HabitacionEL;
import Entidades.PersonaEL;
public class ReservaDL {
	//Singleton
	public static ReservaDL _instancia;
	private ReservaDL(){};
	public static ReservaDL instancia(){
		if(_instancia==null){
			_instancia = new ReservaDL();
		}
		return _instancia;
	}
	//endSingleton
	public ReservaEL GEN_buscarReserva(int id) throws Exception {
		Connection cn = null;
		ReservaEL r = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarReserva(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				r = new ReservaEL();
				r.setId(rs.getInt("id"));
				r.setFechafinal(rs.getDate("fechafinal"));
				r.setFechaInicio(rs.getDate("fechainicio"));
				r.setFechareserva(rs.getDate("fechareserva"));
					PersonaEL p = new PersonaEL();
					p.setId(rs.getInt("idPersona"));
				r.setPersona(p);
			}
			return r;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<ReservaEL> GEN_listarReservas() throws Exception {
		Connection cn = null;
		ReservaEL r = null;
		ArrayList<ReservaEL> lista = new ArrayList<ReservaEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarReservas()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				r = new ReservaEL();
				r.setId(rs.getInt("id"));
				r.setFechafinal(rs.getDate("fechafinal"));
				r.setFechaInicio(rs.getDate("fechainicio"));
				r.setFechareserva(rs.getDate("fechareserva"));
					PersonaEL p = new PersonaEL();
					p.setId(rs.getInt("idPersona"));
				r.setPersona(p);
				lista.add(r);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarReserva(ReservaEL r) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarReserva(?,?,?,?)}");
			cst.setDate(1, r.getFechafinal());
			cst.setDate(2, r.getFechaInicio());
			cst.setDate(3, r.getFechareserva());
			cst.setInt(4, r.getPersona().getId());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	public boolean GEN_editarReserva(ReservaEL r) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_editarReserva(?,?,?,?,?)}");
			cst.setInt(1, r.getId());
			cst.setDate(2, r.getFechafinal());
			cst.setDate(3, r.getFechaInicio());
			cst.setDate(4, r.getFechareserva());
			cst.setInt(5, r.getPersona().getId());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	public boolean sp_RegistrarReservaXML(ReservaEL reserva) throws Exception{
		Connection cn = null;
		boolean x = false;
		String xml = 
			"<root> " + 
			"  <Reserva FECHAFINAL = \"" + reserva.getFin() + "\" FECHAINICIO = \"" + reserva.getInicio() + "\" IDPERSONA = \"" + reserva.getPersona().getId() + "\"> ";
		for(HabitacionEL habitacion : reserva.getListaHabitaciones()) {
			xml += 
				"    <DetalleReserva IDHABITACION = \"" + habitacion.getId() + "\"/> ";
		}
		xml += 
			"  </Reserva> " + 
			"</root> ";
		try{
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_registrarReserva(?)}");
			cst.setString(1, xml);
			int i = cst.executeUpdate();
			if (i>0) x = true;
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return x;
	}
	
	public List<DetalleReservaEL> sp_Buscar_Reserva(int idReserva, int idPersona) throws Exception {
		Connection cn = null;
		
		List<DetalleReservaEL> lista = new ArrayList<DetalleReservaEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_Buscar_Reserva(?,?)}");
			cst.setInt(1, idReserva);
			cst.setInt(2, idPersona);
			
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
			 ReservaEL r = new ReservaEL();
				r.setId(rs.getInt("id"));
				r.setFechafinal(rs.getDate("fechafinal"));
				r.setFechaInicio(rs.getDate("fechainicio"));	
				r.setFechareserva(rs.getDate("fechareserva"));	
				HabitacionEL h= new HabitacionEL();
					h.setId(rs.getInt("idHabitacion"));
					h.setCodigo(rs.getString("codigo"));
					   TipoHabitacionEL th=new TipoHabitacionEL();
							th.setNombre(rs.getString("nombre"));
							th.setCostoxdia(rs.getDouble("costoxdia"));
				    h.setTipoHabitacion(th);
				    
				DetalleReservaEL d= new DetalleReservaEL();
				d.setHabitacion(h);
				d.setReserva(r);
				
				
				lista.add(d);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	

	
	
	
	
	
}
