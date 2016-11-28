package Entidades;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class ReservaEL {
	
	public ReservaEL(){
		setListaHabitaciones(new ArrayList<HabitacionEL>());
	}
	
	private int id;
	private Date fechafinal;
	private Date fechaInicio;
	private String inicio;
	private String fin;
	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}

	private Date fechareserva;
	private PersonaEL persona;	// idPersona
	private List<HabitacionEL> listaHabitaciones;
	
	public List<HabitacionEL> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(List<HabitacionEL> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}
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
