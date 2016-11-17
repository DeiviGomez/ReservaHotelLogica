package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidades.PagoEL;
import Entidades.ReservaEL;
public class PagoDL {
	//Singleton
	public static PagoDL _instancia;
	private PagoDL(){};
	public static PagoDL instancia(){
		if(_instancia==null){
			_instancia = new PagoDL();
		}
		return _instancia;
	}
	//endSingleton
			
	public PagoEL GEN_buscarPago(int id) throws Exception {
		Connection cn = null;
		PagoEL p = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarPago(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				p = new PagoEL();
				p.setId(rs.getInt("id"));
				p.setEsFactura(rs.getBoolean("esFactura"));
				p.setFechapagototal(rs.getDate("fechapagototal"));
					ReservaEL r = new ReservaEL();
					r.setId(rs.getInt("idReserva"));
					p.setReserva(r);
				p.setNumerocorrelativo(rs.getInt("numerocorrelativo"));
				p.setPagototal(rs.getDouble("pagototal"));
				p.setSerie(rs.getString("serie"));
			}
			return p;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<PagoEL> GEN_listarPagos() throws Exception {
		Connection cn = null;
		PagoEL p = null;
		ArrayList<PagoEL> lista = new ArrayList<PagoEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarPagos()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				p = new PagoEL();
				p.setId(rs.getInt("id"));
				p.setEsFactura(rs.getBoolean("esFactura"));
				p.setFechapagototal(rs.getDate("fechapagototal"));
					ReservaEL r = new ReservaEL();
					r.setId(rs.getInt("idReserva"));
					p.setReserva(r);
				p.setNumerocorrelativo(rs.getInt("numerocorrelativo"));
				p.setPagototal(rs.getDouble("pagototal"));
				p.setSerie(rs.getString("serie"));
				lista.add(p);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarPago(PagoEL p) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarPago(?,?,?,?,?,?)}");
			cst.setBoolean(1, p.getEsFactura());
			cst.setDate(2, p.getFechapagototal());
			cst.setInt(3, p.getReserva().getId());
			cst.setInt(4, p.getNumerocorrelativo());
			cst.setDouble(5, p.getPagototal());
			cst.setString(6, p.getSerie());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	
	public int sp_Verficar_Pago(int idReserva) throws Exception
	{		int resultado=0;
			 Connection cn=null;
		          try{
	            	cn=Conexion.instancia().Conectar();
	        		CallableStatement cst = cn.prepareCall("{call sp_Verficar_Pago(?)}");
	        		cst.setInt(1, idReserva);
	    			
	    			  ResultSet rs=cst.executeQuery();
	    			  if (rs.next())
	    	           {
	    				  resultado=rs.getInt("resultado");
	    	           }
	    			  if(resultado==1){
	    				  return 1;
	    			  }
	    			  else if(resultado==2){
	    				  return 2;
	    			  }
	    				
	            }
	            catch (Exception e)
	            {          	 
	            	return 0;
	            }
	         finally { cn.close(); }
		     return 0;
	}
	
	public int sp_Registrar_Pago(int idReserva, String numerocorrelativo, double pagototal,
								String serie, boolean esFactura) throws Exception {
		Connection cn = null;
		int resultado=0;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_Registrar_Pago(?,?,?,?,?)}");
			cst.setString(1, numerocorrelativo);
			cst.setDouble(2, pagototal);
			cst.setString(3, serie);
			cst.setBoolean(4, esFactura);
			cst.setInt(5, idReserva);
			ResultSet rs=cst.executeQuery();
			  if (rs.next())
	           {
				  resultado=rs.getInt("insertado");
	           }
			  if(resultado==1){
				  return 1;
			  }
			
			
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return 0;
	}
	
	
	
}
