package Entidades;
import java.sql.Date;
public class ReservaEL {
	private int id;
	private Date fechafinal;
	private Date fechaInicio;
	private Date fechareserva;
	private PersonaEL persona;	// idPersona
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechafinal() {
		return fechafinal;
	}
	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}
	public PersonaEL getPersona() {
		return persona;
	}
	public void setPersona(PersonaEL persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "ReservaEL [id=" + id + ", fechafinal=" + fechafinal + ", fechaInicio=" + fechaInicio + ", fechareserva="
				+ fechareserva + ", persona=" + persona + "]";
	}
	
	
}
