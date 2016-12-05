package Entidades;

public class PersonaEL {
	private int id;
	private String apellidomaterno;
	private String apellidopaterno;
	private String celular;
	private String direccion;
	private String dni;
	private Boolean habilitado;
	private String nombre;
	private String ruc;
	private String telefono;
	private String razonSocial;
	private UsuarioEL usuario;
	
	public UsuarioEL getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEL usuario) {
		this.usuario = usuario;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "PersonaEL [id=" + id + ", apellidomaterno=" + apellidomaterno + ", apellidopaterno=" + apellidopaterno
				+ ", celular=" + celular + ", direccion=" + direccion + ", dni=" + dni + ", habilitado=" + habilitado
				+ ", nombre=" + nombre + ", ruc=" + ruc + ", telefono=" + telefono + ", razonSocial=" + razonSocial
				+ "]";
	}
	
	
	 public Boolean nombreVacio(String nombre) throws Exception
     {
         if (nombre.trim().length() == 0) throw new Exception("errornombre"); else return false;
     }
	 public Boolean ApellidoPVacio(String apellidoP) throws Exception
     {
         if (apellidoP.trim().length() == 0) throw new Exception("errorapellidoP"); else return false;
     }
	
	 public Boolean ApellidoMVacio(String apellidoM) throws Exception
     {
         if (apellidoM.trim().length() == 0) throw new Exception("errorapellidoM"); else return false;
     }
	
	 public Boolean DNIVacio(String dni) throws Exception
     {
         if (dni.trim().length() == 0) throw new Exception("erroradni"); else return false;
     }
	
	 public Boolean DNI8digitos(String dni) throws Exception
     {
         if (dni.trim().length() == 8)return true; else throw new Exception("erroradni2");
     }
	 
	 public Boolean RUC11digitos(String ruc) throws Exception
     {
         if (ruc.trim().length() == 11)return true; else throw new Exception("errorruc");
     }
	
	 public Boolean RUCSOloNumeros(String ruc) throws Exception
     {
		 
		 try {
			 double rucvalida=Double.parseDouble(ruc.trim());
			 
			 if(rucvalida<0)throw new Exception("errorruc2");else return true;
			 
		} catch (NumberFormatException e) {			
			   throw new Exception("errorruc2");
		}
	
     }
	 
	 public Boolean DNISOloNumeros(String dni) throws Exception
     {
		 
		 try {
			 int dnivalida=Integer.parseInt(dni.trim());
			 
			 if(dnivalida<0)throw new Exception("erroradni3");else return true;
			 
		} catch (NumberFormatException e) {			
			   throw new Exception("erroradni3");
		}
	
     }
	 
	 
}
