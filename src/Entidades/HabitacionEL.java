package Entidades;

public class HabitacionEL {
	private int id;
	private String codigo;
	private Boolean habilitado;
	private Boolean ocupado;
	private TipoHabitacionEL tipoHabitacion;		// idTipoHabitacion
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	public TipoHabitacionEL getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacionEL tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	@Override
	public String toString() {
		return "HabitacionEL [id=" + id + ", codigo=" + codigo + ", habilitado=" + habilitado + ", ocupado=" + ocupado
				+ ", tipoHabitacion=" + tipoHabitacion + "]";
	}
	
	
	
}
