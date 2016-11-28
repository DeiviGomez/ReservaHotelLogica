package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import Entidades.UsuarioEL;
import Entidades.PersonaEL;
public class UsuarioDL {
	//Singleton
	public static UsuarioDL _instancia;
	private UsuarioDL(){};
	public static UsuarioDL instancia(){
		if(_instancia==null){
			_instancia = new UsuarioDL();
		}
		return _instancia;
	}
	//endSingleton
	public UsuarioEL GEN_buscarUsuario(int id) throws Exception {
		Connection cn = null;
		UsuarioEL u = null;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_buscarUsuario(?)}");
			cst.setInt(1, id);
			ResultSet rs = cst.executeQuery();
			if(rs.next()) {
				u = new UsuarioEL();
				u.setId(rs.getInt("id"));
				u.setNickname(rs.getString("nickname"));
				u.setContrasena(rs.getString("contrasena"));
					PersonaEL p = new PersonaEL();
					p.setId(rs.getInt("idPersona"));
					u.setPersona(p);
				u.setTipoUsuario(rs.getString("tipoUsuario"));
			}
			return u;
		} catch (Exception ex) {
			throw ex;
		}finally{cn.close();}
	}
	public boolean GEN_registrarUsuario(UsuarioEL u) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_registrarUsuario(?,?,?,?)}");
			cst.setString(1, u.getNickname());
			cst.setString(2, u.getContrasena());
			cst.setInt(3, u.getPersona().getId());
			cst.setString(4, u.getTipoUsuario());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	public boolean GEN_editarUsuario(UsuarioEL u) throws Exception {
		Connection cn = null;
		boolean validacion = false;
		try {
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call GEN_editarUsuario(?,?,?,?,?)}");
			cst.setInt(1, u.getId());
			cst.setString(2, u.getNickname());
			cst.setString(3, u.getContrasena());
			cst.setInt(4, u.getPersona().getId());
			cst.setString(5, u.getTipoUsuario());
			int i = cst.executeUpdate();
			if(i>0){validacion=true;}		
		} catch (Exception ex) {
			throw ex;
		} finally {
			cn.close();
		}
		return validacion;
	}
	
	public PersonaEL VerificarAcessoPorPlataforma(String nickname, String contrasena, String tipoUsuario) throws Exception{
		Connection cn = null;
		PersonaEL persona = null;
		try{
			cn = Conexion.instancia().Conectar();
			CallableStatement cst = cn.prepareCall("{call sp_VerificarUsuario(?,?)}");
			cst.setString(1, nickname);
			cst.setString(2, contrasena);
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
			
				String tipo = rs.getString("tipoUsuario");
				if(!tipo.equals(tipoUsuario))
					throw new Exception("No tiene los permisos para acceder por aquí");
				
				persona = new PersonaEL();
				persona.setId(rs.getInt("idPersona"));
				persona.setApellidopaterno(rs.getString("apellidoPaterno"));
				persona.setApellidomaterno(rs.getString("apellidoMaterno"));
				persona.setNombre(rs.getString("nombre"));
			}
			
			if (persona == null)
				throw new Exception("Usuario y/o Password Incorrectos");
			
			return persona;
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
		}
	}	
	
	public UsuarioEL VerificarAcceso_Rest(String _usuario, String _password)throws Exception{	
		Connection cn=null;
		UsuarioEL u=null;			
		try {
			cn=Conexion.instancia().Conectar();
			CallableStatement cst= cn.prepareCall("{call sp_VerificarUsuario(?,?)}");
			cst.setString(1, _usuario);
			cst.setString(2, _password);
			ResultSet rs=cst.executeQuery();
			if(rs.next()){
				u=new UsuarioEL();
				u.setTipoUsuario(rs.getString("tipoUsuario"));
								
			}			
			return u;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			cn.close();
		}
		
	}
	
	
}
