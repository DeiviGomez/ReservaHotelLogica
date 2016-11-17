package Entidades;
public class DetalleReservaEL {
	private int id;
	private HabitacionEL habitacion;	// idHabitacion
	private ReservaEL reserva;			// idReserva
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HabitacionEL getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(HabitacionEL habitacion) {
		this.habitacion = habitacion;
	}
	public ReservaEL getReserva() {
		return reserva;
	}
	public void setReserva(ReservaEL reserva) {
		this.reserva = reserva;
	}
	@Override
	public String toString() {
		return "DetalleReservaEL [id=" + id + ", habitacion=" + habitacion + ", reserva=" + reserva + "]";
	}
	
	
	
}
