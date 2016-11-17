package Entidades;

public class TipoHabitacionEL {
	private int id;
	private int capacidadpersonas;
	private Double costoxdia;
	private String descripcion;
	private String direccionimagen;
	private Boolean habilitado;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidadpersonas() {
		return capacidadpersonas;
	}
	public void setCapacidadpersonas(int capacidadpersonas) {
		this.capacidadpersonas = capacidadpersonas;
	}
	public Double getCostoxdia() {
		return costoxdia;
	}
	public void setCostoxdia(Double costoxdia) {
		this.costoxdia = costoxdia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccionimagen() {
		return direccionimagen;
	}
	public void setDireccionimagen(String direccionimagen) {
		this.direccionimagen = direccionimagen;
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
	@Override
	public String toString() {
		return "TipoHabitacionEL [id=" + id + ", capacidadpersonas=" + capacidadpersonas + ", costoxdia=" + costoxdia
				+ ", descripcion=" + descripcion + ", direccionimagen=" + direccionimagen + ", habilitado=" + habilitado
				+ ", nombre=" + nombre + "]";
	}
	
	
}
