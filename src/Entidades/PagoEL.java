package Entidades;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
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
	
	
	public double calcularDescuentoPorRecurrenciaMes( List<DetalleReservaEL>listad, int desconcurrencia){
		double descuento=0, totalreserva=0;int i=0;
		 
	
		  totalreserva=calcularPagosinDescuentos(listad);
		  
		  if(desconcurrencia==1){
		     descuento=totalreserva*0.05;
		  }
		  
		return descuento;
	}
	
	  public double calcularDescuentoFestivalMarinera(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFestivalMarinera = 0;
          if (mes== 1 && dia >= 24 && dia<= 31)
          {
        	 
        	  totalreserva=calcularPagosinDescuentos(listad);
        	  
        	  if(totalreserva>0)
        	     descuentoFestivalMarinera=totalreserva*0.05;
      		return descuentoFestivalMarinera;
        	  
          }
          else
              return 0;
      }
	
	  public double calcularDescuentoDiaCancionCriolla(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  		  
          double descuentoDiaCancionCriolla = 0;
          if (mes== 10 && dia >= 30 && dia<= 31)
          {
        	 
        		totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	      descuentoDiaCancionCriolla=totalreserva*0.05;
      		return descuentoDiaCancionCriolla;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoDiaPolloBrasa(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoDiaPolloBrasa = 0;
          if (mes== 2 && dia ==21 )
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	    descuentoDiaPolloBrasa=totalreserva*0.05;
      		return descuentoDiaPolloBrasa;
        	  
          }
          else
              return 0;
      }
	  
	  public double calcularDescuentoFiestasPatrias(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFiestasPatrias = 0;
          if (mes== 7 && dia >= 28 && dia<= 29)
          {
        	 
        	totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	      descuentoFiestasPatrias=totalreserva*0.05;
      		return descuentoFiestasPatrias;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoFundacionTrujillo(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoFundacionTrujillo = 0;
          if (mes== 11 && dia >= 30 && dia<= 31)
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	    descuentoFundacionTrujillo=totalreserva*0.05;
      		return descuentoFundacionTrujillo;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoSanValentin(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
		  
          double descuentoSanValentin = 0;
          if (mes== 2 && dia ==14)
          {
        	 
        	totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	     descuentoSanValentin=totalreserva*0.05;
      		return descuentoSanValentin;
        	  
          }
          else
              return 0;
      }
	  
	  public double calcularDescuentoSemanaSanta(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  
          double descuentoSemanaSanta = 0;
          if (mes== 3 && dia >= 20 && dia<= 28)
          {
        	
        	totalreserva=calcularPagosinDescuentos(listad);
        	  if(totalreserva>0)
        	    descuentoSemanaSanta=totalreserva*0.05;
      		return descuentoSemanaSanta;
        	  
          }
          else
              return 0;
      }
	  
	  
	  public double calcularDescuentoNavidad(int anio, int mes, int dia, List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;		  		  
          double descuentoNavidad = 0;
          if (mes== 12 && dia ==24)
          {
        	
        		totalreserva=calcularPagosinDescuentos(listad);
        	    if(totalreserva>0)
        		     descuentoNavidad=totalreserva*0.05;
      		return descuentoNavidad;
        	  
          }
          else
              return 0;
      }
	  
	  
	  
	  
	  public double calcularImpuestoIGV(int tipocomprobante, List<DetalleReservaEL>listad,Date fecha, int desconcurrencia )
      {		 
		  double  totalreserva=0, redondeoIGV=0;		  
		  
          double descuentoIGV= 0;
       
          
          if (tipocomprobante==2)
          {
        	 
        	  totalreserva=calcularPagosinDescuentos(listad)-calculoDescuentoGeneralFiestas(fecha,listad)-
        			  		calcularDescuentoPorRecurrenciaMes(listad, desconcurrencia);
        	 
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
	
    public double calcularPagosinDescuentos(List<DetalleReservaEL>listad)
      {		 
		  double  totalreserva=0;int i=0;
	
		  long diferenciaEn_ms = listad.get(i).getReserva().getFechafinal().getTime()-
				  				listad.get(i).getReserva().getFechaInicio().getTime();
		  long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		  if(dias==0)dias=1;
		  
		
        	  for (DetalleReservaEL detalleReservaEL : listad) {
      			 totalreserva=totalreserva+listad.get(i++).getHabitacion().getTipoHabitacion().getCostoxdia();
      			
        	  }
        	   if(totalreserva>0)
        		   return totalreserva = totalreserva*dias;

        	  
        return totalreserva;

      }
	  
	public double calculoDescuentoGeneralFiestas(Date fecha, List<DetalleReservaEL>listad){
		double redondeoDescuentoTotalFiestas=0;
		  Calendar calendario = Calendar.getInstance();
		  calendario.setTime(fecha);
		  int anio=calendario.get(Calendar.YEAR);
		  int mes=calendario.get(Calendar.MONTH)+1;
		  int dia=calendario.get(Calendar.DAY_OF_MONTH);
		  
		double descuentoTotalFiestas=
			calcularDescuentoFestivalMarinera(anio,mes,dia,listad)+
			calcularDescuentoDiaCancionCriolla(anio,mes,dia, listad)
			+ calcularDescuentoDiaPolloBrasa(anio,mes,dia, listad)+
			calcularDescuentoFiestasPatrias(anio,mes,dia, listad)+
			calcularDescuentoFundacionTrujillo(anio,mes,dia, listad)+
			calcularDescuentoSanValentin(anio,mes,dia, listad)+
			calcularDescuentoSemanaSanta(anio,mes,dia, listad)+
			calcularDescuentoNavidad(anio,mes,dia, listad);
			
		
		return descuentoTotalFiestas;
	}
	
	
	
	public double pagoTotal(Date fecha,List<DetalleReservaEL>listad,int tipocomprobante, int desconcurrencia){
	double totalPago=0,redondeopagoTotal=0;
	if(tipocomprobante==2){
		
		totalPago=(calcularPagosinDescuentos(listad)-calculoDescuentoGeneralFiestas(fecha, listad)-
				  calcularDescuentoPorRecurrenciaMes(listad,desconcurrencia))+calcularImpuestoIGV(tipocomprobante, listad,fecha, desconcurrencia);
	}else{
		
		totalPago=(calcularPagosinDescuentos(listad)-calculoDescuentoGeneralFiestas(fecha, listad))
				-calcularDescuentoPorRecurrenciaMes(listad, desconcurrencia);
	}

	
	 return totalPago;//redondeopagoTotal=Math.round(totalPago*100)/100;
	}
	
	  
	public String numerocomprobante(int tipocomprobante,String idReserva){
		String numero="";
		if(tipocomprobante==2){
			numero="1000"+String.valueOf(idReserva);
		}else{
			numero="500"+String.valueOf(idReserva);
		}
		return numero;
	}
	
    public String seriecomprobante(int tipocomprobante,String idReserva){
    	String serie="";
    	
    	if(tipocomprobante==2){
    		serie="02";
		}else{
			serie="01";
		}
		return serie;
    	
	}
	
}
