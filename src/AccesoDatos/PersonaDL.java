package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.HabitacionEL;
import Entidades.PersonaEL;
import Entidades.TipoHabitacionEL;
import Entidades.UsuarioEL;;
public class PersonaDL {
	//Singleton
	public static PersonaDL _instancia;
	private PersonaDL(){};
	public static PersonaDL instancia(){
		if(_instancia==null){
			_instancia = new PersonaDL();
		}
		return _instancia;
	}
	//endSingleton
	public PersonaEL GEN_buscarPersona(int id) throws Exception {
		Connection cn = null;
		PersonaEL p = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarPersona(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				p = new PersonaEL();
				p.setId(rs.getInt("id"));
				p.setApellidomaterno(rs.getString("apellidomaterno"));
				p.setApellidopaterno(rs.getString("apellidopaterno"));
				p.setCelular(rs.getString("celular"));
				p.setDireccion(rs.getString("direccion"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setNombre(rs.getString("nombre"));
				p.setRuc(rs.getString("ruc"));
				p.setTelefono(rs.getString("telefono"));
				p.setRazonSocial(rs.getString("razonSocial"));
			}
			return p;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public ArrayList<PersonaEL> GEN_listarPersonas() throws Exception {
		Connection cn = null;
		PersonaEL p = null;
		ArrayList<PersonaEL> lista = new ArrayList<PersonaEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_listarPersonas()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				p = new PersonaEL();
				p.setId(rs.getInt("id"));
				p.setApellidomaterno(rs.getString("apellidomaterno"));
				p.setApellidopaterno(rs.getString("apellidopaterno"));
				p.setCelular(rs.getString("celular"));
				p.setDireccion(rs.getString("direccion"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setNombre(rs.getString("nombre"));
				p.setRuc(rs.getString("ruc"));
				p.setTelefono(rs.getString("telefono"));
				p.setRazonSocial(rs.getString("razonSocial"));
				lista.add(p);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarPersona(PersonaEL p) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarPersona(?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, p.getApellidomaterno());
			cst.setString(2, p.getApellidopaterno());
			cst.setString(3, p.getCelular());
			cst.setString(4, p.getDireccion());
			cst.setString(5, p.getDni());
			cst.setBoolean(6, p.getHabilitado());
			cst.setString(7, p.getNombre());
			cst.setString(8, p.getRuc());
			cst.setString(9, p.getTelefono());
			cst.setString(10, p.getRazonSocial());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	public boolean GEN_editarPersona(PersonaEL p) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_editarPersona(?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, p.getId());
			cst.setString(2, p.getApellidomaterno());
			cst.setString(3, p.getApellidopaterno());
			cst.setString(4, p.getCelular());
			cst.setString(5, p.getDireccion());
			cst.setString(6, p.getDni());
			cst.setBoolean(7, p.getHabilitado());
			cst.setString(8, p.getNombre());
			cst.setString(9, p.getRuc());
			cst.setString(10, p.getTelefono());
			cst.setString(11, p.getRazonSocial());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	

	public int sp_Verificar_Cliente(int idPersona) throws Exception
	{		int resultado=0;
			 Connection cn=null;
		          try{
	            	cn=Conexion.instancia().Conectar();
	        		CallableStatement cst = cn.prepareCall("{call sp_Verificar_Cliente(?)}");
	        		cst.setInt(1, idPersona);
	    			
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
	
	

	public PersonaEL sp_Buscar_Cliente(int idPersona)throws Exception
    {
		Connection cn=null;
		PersonaEL persona = new PersonaEL();
        try
        {
        	cn=Conexion.instancia().Conectar();
        	CallableStatement cst= cn.prepareCall("{call sp_Buscar_Cliente(?)}");
        	cst.setInt(1, idPersona);
        	ResultSet rs=cst.executeQuery();
            while (rs.next())
            {
            	persona = new PersonaEL();           	
            	persona.setId(rs.getInt("id"));
            	persona.setApellidomaterno(rs.getString("apellidomaterno"));
            	persona.setApellidopaterno(rs.getString("apellidopaterno"));
            	persona.setCelular(rs.getString("celular"));
            	persona.setDireccion(rs.getString("direccion"));
            	persona.setDni(rs.getString("dni"));
            	persona.setHabilitado(rs.getBoolean("habilitado"));
            	persona.setNombre(rs.getString("nombre"));
            	persona.setRuc(rs.getString("ruc"));
            	persona.setTelefono(rs.getString("telefono"));
            	persona.setRazonSocial(rs.getString("razonSocial"));
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally {  cn.close(); }
        return persona;
    }
	
	
	
	public int sp_Verificar_Cliente_recurrente_mes(int idPersona, String fechaReserva) throws Exception
	{		int resultado=0;
			 Connection cn=null;
		          try{
	            	cn=Conexion.instancia().Conectar();
	        		CallableStatement cst = cn.prepareCall("{call sp_Verificar_Cliente_recurrente_mes(?,?)}");
	        		cst.setInt(1, idPersona);
	        		cst.setString(2, fechaReserva); 
	        		
	    			  ResultSet rs=cst.executeQuery();
	    			  if (rs.next())
	    	           {
	    				  resultado=rs.getInt("descuento");
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
	
	
	public int sp_Registrar_Usuario(PersonaEL p, UsuarioEL usuario) throws Exception {
		Connection cn = null;
		int resultado=0;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_Registrar_Usuario(?,?,?,?,?,?)}");
			cst.setString(1, p.getApellidomaterno());
			cst.setString(2, p.getApellidopaterno());
			cst.setString(3, p.getDni());
			cst.setString(4, p.getNombre());			
			cst.setString(5, usuario.getNickname());
			cst.setString(6, usuario.getContrasena());
		
			boolean i = cst.execute();
			
			if(!i){
				return 1;
			}
			else if(i){
				
	    		ResultSet rs=cst.executeQuery();
	    		while (rs.next())
	    			{
					resultado=rs.getInt("resultado");
		           }
				  if(resultado==1){
				      return 1;
				  }
				  else if(resultado==2){
					  throw new Exception("errorusuarioexistente");
				  }
				  else if(resultado==3){
					  throw new Exception("errorDNIexistente");
				  }
				  
				return 1;
			}
			
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return resultado;
	}
	
	public int sp_Actualizar_Usuario(PersonaEL p) throws Exception {
		Connection cn = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_Actualizar_Usuario(?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, p.getApellidomaterno());
			cst.setString(2, p.getApellidopaterno());
			cst.setString(3, p.getCelular());
			cst.setString(4, p.getDireccion());			
			cst.setString(5, p.getDni());
			cst.setInt(6, p.getId());
			cst.setString(7, p.getNombre());
			cst.setString(8, p.getRuc());
			cst.setString(9, p.getTelefono());	
			cst.setString(10, p.getRazonSocial());
					
			boolean i = cst.execute();
			
			if(!i){
				return 1;
			}	    	
				 			
		} catch (Exception ex) {
			throw new Exception("erroractualiza");
		} finally {
			cn.close();
		}
		return 0;
	}
	
	public boolean sp_DesactivarEmpleado (int id) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try{
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_DesactivarEmpleado(?)}");
			cst.setInt(1, id);
			int i = cst.executeUpdate();
			if (i>0) validacion = true;
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	public boolean sp_EditarEmpleados(PersonaEL p) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_EditarEmpleados(?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, p.getId());
			cst.setString(2, p.getApellidomaterno());
			cst.setString(3, p.getApellidopaterno());
			cst.setString(4, p.getCelular());
			cst.setString(5, p.getDireccion());			
			cst.setString(6, p.getDni());
			cst.setString(7, p.getNombre());
			cst.setString(8, p.getTelefono());	
			cst.setString(9, p.getUsuario().getNickname());
			cst.setString(10, p.getUsuario().getContrasena());
			cst.setString(11, p.getUsuario().getTipoUsuario());
			
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	public boolean sp_RegistrarEmpleado(PersonaEL p) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_RegistrarEmpleado(?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, p.getApellidomaterno());
			cst.setString(2, p.getApellidopaterno());
			cst.setString(3, p.getCelular());
			cst.setString(4, p.getDireccion());
			cst.setString(5, p.getDni());
			cst.setString(6, p.getNombre());
			cst.setString(7, p.getTelefono());	
			cst.setString(8, p.getUsuario().getNickname());
			cst.setString(9, p.getUsuario().getContrasena());
			cst.setString(10, p.getUsuario().getTipoUsuario());
			
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	public ArrayList<PersonaEL> sp_ListarEmpleados() throws Exception {
		Connection cn = null;
		PersonaEL p = null;
		UsuarioEL u = null;
		ArrayList<PersonaEL> lista = new ArrayList<PersonaEL>();
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_ListarEmpleados()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()) {
				p = new PersonaEL();
				//p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellidopaterno(rs.getString("apellidopaterno"));
				p.setApellidomaterno(rs.getString("apellidomaterno"));
				p.setDni(rs.getString("dni"));
					u = new UsuarioEL();
					u.setNickname(rs.getString("nickname"));
					u.setTipoUsuario(rs.getString("tipoUsuario"));
					p.setUsuario(u);
				lista.add(p);
			}
			return lista;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	
	public PersonaEL sp_SeleccionarEmpleado (int id) throws Exception {
		Connection cn = null;
		PersonaEL p = null;
		UsuarioEL u = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_SeleccionarEmpleado(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				p = new PersonaEL();
				p.setId(id);
				p.setApellidomaterno(rs.getString("apellidomaterno"));
				p.setApellidopaterno(rs.getString("apellidopaterno"));
				p.setCelular(rs.getString("celular"));
				p.setDireccion(rs.getString("direccion"));
				p.setDni(rs.getString("dni"));
				p.setNombre(rs.getString("nombre"));
				p.setTelefono(rs.getString("telefono"));
				u = new UsuarioEL();
				u.setContrasena(rs.getString("contrasena"));
				u.setNickname(rs.getString("nickname"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
				p.setUsuario(u);
			}
			return p;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	
}
