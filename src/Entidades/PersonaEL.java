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
	
	
	
}
