
public class Proceso implements Comparable<Proceso>{
	private String nombre;
	private Integer orden;
	private Integer rafaga_static;
	private Integer rafaga;
	
	private Integer t_espera;
	private Integer t_servicio;
	private Float i_servicio;
	
	public Proceso(String nombre, int orden, int rafaga) {
		this.nombre=nombre;
		this.orden= orden;
		this.rafaga_static=rafaga;
		this.rafaga=rafaga;
	}
	
	public Proceso(Proceso p) {
		this.nombre=p.nombre;
		this.orden= p.orden;
		this.rafaga_static=p.rafaga;
		this.rafaga=p.rafaga;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public Integer getOrden() {
		return orden;
	}

	public Integer getRafaga() {
		return rafaga;
	}

	public void setRafaga(int rafaga) {
		this.rafaga = rafaga;
	}
	
	public int compareTo(Proceso p) {
		return this.getRafaga().compareTo(p.getRafaga());
	}
	
	public Integer getT_Servicio() {
		return t_servicio;
	}
	
	public Integer getT_Espera() {
		return t_espera;
	}
	
	public Float getI_Servicio() {
		return i_servicio;
	}

	public void setTiempos(Integer cont) {
		this.t_servicio=cont-orden;
		this.t_espera=t_servicio-rafaga_static;
		this.i_servicio=((float) rafaga_static/ (float) t_servicio);
		
	}

}