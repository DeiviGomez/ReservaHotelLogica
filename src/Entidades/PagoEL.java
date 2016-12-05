package Entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import AccesoDatos.PagoDL;
public class PagoEL {
	private int id;
	private Boolean esFactura;
	private Date fechapagototal;
	private ReservaEL reserva;		// idReserva
	private int numerocorrelativo;
	private Double pagototal;
	private String serie;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getEsFactura() {
		return esFactura;
	}
	public void setEsFactura(Boolean esFactura) {
		this.esFactura = esFactura;
	}
	public Date getFechapagototal() {
		return fechapagototal;
	}
	public void setFechapagototal(Date fechapagototal) {
		this.fechapagototal = fechapagototal;
	}
	public ReservaEL getReserva() {
		return reserva;
	}
	public void setReserva(ReservaEL reserva) {
		this.reserva = reserva;
	}
	public int getNumerocorrelativo() {
		return numerocorrelativo;
	}
	public void setNumerocorrelativo(int numerocorrelativo) {
		this.numerocorrelativo = numerocorrelativo;
	}
	public Double getPagototal() {
		return pagototal;
	}
	public void setPagototal(Double pagototal) {
		this.pagototal = pagototal;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	@Override
	public String toString() {
		return "PagoEL [id=" + id + ", esFactura=" + esFactura + ", fechapagototal=" + fechapagototal + ", reserva="
				+ reserva + ", numerocorrelativo=" + numerocorrelativo + ", pagototal=" + pagototal + ", serie=" + serie
				+ "]";
	}
	
	
	public double calcularDescuentoPorRecurrenciaMes( List<HabitacionEL>listad, int desconcurrencia, Date fecha,ReservaEL reserva ){
		double descuento=0, totalreserva=0;int i=0;
		 
	
		  totalreserva=calcularPagosinDescuentos(listad, reserva);
		  
		  if(desconcurrencia==1){
		     descuento=totalreserva*0.05;
		  }
		  
		return descuento;
	}
	
	  public double calcularDescuentoFestivalMarinera(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFestivalMarinera = 0;
          if (mes== 1 && dia >= 24 && dia<= 31)
          {
        	 
        	  totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  
        	  if(totalreserva>0)
        	     descuentoFestivalMarinera=totalreserva*0.05;
      		return descuentoFestivalMarinera;
        	  
          }
          else
              return 0;
      }
	
	  public double calcularDescuentoDiaCancionCriolla(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  		  
          double descuentoDiaCancionCriolla = 0;
          if (mes== 10 && dia >= 30 && dia<= 31)
          {
        	 
        		totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	      descuentoDiaCancionCriolla=totalreserva*0.05;
      		return descuentoDiaCancionCriolla;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoDiaPolloBrasa(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoDiaPolloBrasa = 0;
          if (mes== 2 && dia ==21 )
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	    descuentoDiaPolloBrasa=totalreserva*0.05;
      		return descuentoDiaPolloBrasa;
        	  
          }
          else
              return 0;
      }
	  
	  public double calcularDescuentoFiestasPatrias(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFiestasPatrias = 0;
          if (mes== 7 && dia >= 28 && dia<= 29)
          {
        	 
        	totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	      descuentoFiestasPatrias=totalreserva*0.05;
      		return descuentoFiestasPatrias;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoFundacionTrujillo(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFundacionTrujillo = 0;
          if (mes== 11 && dia >= 30 && dia<= 31)
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	    descuentoFundacionTrujillo=totalreserva*0.05;
      		return descuentoFundacionTrujillo;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoSanValentin(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
		  
          double descuentoSanValentin = 0;
          if (mes== 2 && dia ==14)
          {
        	 
        	totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	     descuentoSanValentin=totalreserva*0.05;
      		return descuentoSanValentin;
        	  
          }
          else
              return 0;
      }
	  
	  public double calcularDescuentoSemanaSanta(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoSemanaSanta = 0;
          if (mes== 3 && dia >= 20 && dia<= 28)
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad,reserva);
        	  if(totalreserva>0)
        	    descuentoSemanaSanta=totalreserva*0.05;
      		return descuentoSemanaSanta;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoNavidad(int anio, int mes, int dia, List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;		  		  
          double descuentoNavidad = 0;
          if (mes== 12 && dia ==24)
          {
        	
        		totalreserva=calcularPagosinDescuentos(listad,reserva);
        	    if(totalreserva>0)
        		     descuentoNavidad=totalreserva*0.05;
      		return descuentoNavidad;
        	  
          }
          else
              return 0;
      }
	  
	  
	  
	  
	  public double calcularImpuestoIGV(int tipocomprobante, List<HabitacionEL>listad,Date fecha, int desconcurrencia, ReservaEL reserva )
      {		 
		  double  totalreserva=0, redondeoIGV=0;		  
		  
          double descuentoIGV= 0;
       
          
          if (tipocomprobante==2)
          {
        	 
        	  totalreserva=calcularPagosinDescuentos(listad,reserva)-calculoDescuentoGeneralFiestas(fecha,listad, reserva)-
        			  		calcularDescuentoPorRecurrenciaMes(listad, desconcurrencia,fecha, reserva );
        	 
        	  if(totalreserva>0){
        		 // descuentoIGV=(totalreserva/1.18)*0.18;
        		  descuentoIGV=totalreserva*0.18;
        		  redondeoIGV = Math.round(descuentoIGV * 100.0) / 100.0;
        	  }
        	      
        	  
        	  return redondeoIGV;
          }
          else
              return totalreserva;
      }
	
    public double calcularPagosinDescuentos(List<HabitacionEL>listad, ReservaEL reserva)
      {		 
		  double  totalreserva=0;int i=0;
	
		  long diferenciaEn_ms = reserva.getFechafinal().getTime()-
				  				reserva.getFechaInicio().getTime();
		  long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		  if(dias==0)dias=1;
		  
		
        	  for (HabitacionEL detalleReservaEL : listad) {
      			 totalreserva=totalreserva+listad.get(i++).getTipoHabitacion().getCostoxdia();
      			
        	  }
        	   if(totalreserva>0)
        		   return totalreserva = totalreserva*dias;

        	  
        return totalreserva;

      }
	  
	public double calculoDescuentoGeneralFiestas(Date fecha, List<HabitacionEL>listad, ReservaEL reserva){
		double redondeoDescuentoTotalFiestas=0;
		  Calendar calendario = Calendar.getInstance();
		  calendario.setTime(fecha);
		  int anio=calendario.get(Calendar.YEAR);
		  int mes=calendario.get(Calendar.MONTH)+1;
		  int dia=calendario.get(Calendar.DAY_OF_MONTH);
		  
		double descuentoTotalFiestas=
			calcularDescuentoFestivalMarinera(anio,mes,dia,listad,reserva)+
			calcularDescuentoDiaCancionCriolla(anio,mes,dia, listad, reserva)
			+ calcularDescuentoDiaPolloBrasa(anio,mes,dia, listad,reserva)+
			calcularDescuentoFiestasPatrias(anio,mes,dia, listad,reserva)+
			calcularDescuentoFundacionTrujillo(anio,mes,dia, listad, reserva)+
			calcularDescuentoSanValentin(anio,mes,dia, listad,reserva)+
			calcularDescuentoSemanaSanta(anio,mes,dia, listad,reserva)+
			calcularDescuentoNavidad(anio,mes,dia, listad,reserva);
			
		
		return descuentoTotalFiestas;
	}
	
	
	
	public double pagoTotal(Date fecha,List<HabitacionEL>listad,int tipocomprobante, int desconcurrencia, ReservaEL reserva){
	double totalPago=0,redondeopagoTotal=0;
	if(tipocomprobante==2){
		
		totalPago=(calcularPagosinDescuentos(listad,reserva)-calculoDescuentoGeneralFiestas(fecha, listad,reserva)-
				  calcularDescuentoPorRecurrenciaMes(listad,desconcurrencia,fecha,reserva))+calcularImpuestoIGV(tipocomprobante, listad,fecha, desconcurrencia,reserva);
	}else{
		
		totalPago=(calcularPagosinDescuentos(listad,reserva)-calculoDescuentoGeneralFiestas(fecha, listad,reserva))
				-calcularDescuentoPorRecurrenciaMes(listad, desconcurrencia,fecha,reserva);
	}

	
	 return totalPago;//redondeopagoTotal=Math.round(totalPago*100)/100;
	}
	
	  
	public String numerocomprobante(int tipocomprobante){
		try{
		String numero="";
		if(tipocomprobante==2){
			numero="1000"+PagoDL.instancia().sp_Numero_Documento();
		}else{
			numero="500"+PagoDL.instancia().sp_Numero_Documento();
		}
		return numero;
		}catch(Exception e){
			return null;
		}
	}
	
    public String seriecomprobante(int tipocomprobante){
    	String serie="";
    	
    	if(tipocomprobante==2){
    		serie="02";
		}else{
			serie="01";
		}
		return serie;
    	
	}
	
}
