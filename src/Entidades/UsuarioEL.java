package Entidades;
public class UsuarioEL {
	private int id;
	private String nickname;
	private String contrasena;
	private PersonaEL persona;			// idPersona
	private String tipoUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public PersonaEL getPersona() {
		return persona;
	}
	public void setPersona(PersonaEL persona) {
		this.persona = persona;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "UsuarioEL [id=" + id + ", nickname=" + nickname + ", contrasena=" + contrasena + ", persona=" + persona
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
