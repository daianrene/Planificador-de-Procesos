import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;



public class Planificador {
	Integer cont;
	Vector<String> secuencia;
	
	public Vector<String> FCFS(Vector<Proceso> vProcesos) {
		
		cont = 0;
		secuencia = new Vector<String>();
		Queue<Proceso> cEspera = new LinkedList<Proceso>();
		
		while(rafagasActivas(vProcesos)) {
			
			for(Proceso p : vProcesos) {
				if(cont == p.getOrden()) {
					cEspera.offer(p);
				}
			}
			
			cont++;
			
			if(!cEspera.isEmpty()) {
				
				Proceso p_actual = cEspera.peek();
				p_actual.setRafaga(p_actual.getRafaga()-1);
				
				secuencia.add(p_actual.getNombre());
				
				if(p_actual.getRafaga()==0) {
					p_actual.setTiempos(cont);
					cEspera.poll();
				}
			}else secuencia.add("-");
			
			
		}
		return secuencia;
		
	}
	
	

	public Vector<String>  SRT(Vector<Proceso> vProcesos) {
		cont = 0;
		secuencia = new Vector<String>();
		Vector<Proceso> vEspera = new Vector<Proceso>();
		
		while(rafagasActivas(vProcesos)) {
			for(Proceso p : vProcesos) {
				if(cont == p.getOrden()) {
					vEspera.add(p);
				}
			}
			Collections.sort(vEspera);
			
			cont++;
			
			if(!vEspera.isEmpty()) {
				
				Proceso p_actual = vEspera.firstElement();
				p_actual.setRafaga(p_actual.getRafaga()-1);
				
				secuencia.add(p_actual.getNombre());
				
				if(p_actual.getRafaga()==0) {
					p_actual.setTiempos(cont);
					vEspera.remove(p_actual);
				}
			}else secuencia.add("-");
			
		
		}

		return secuencia;
	}


	public Vector<String> RR(Vector<Proceso> vProcesos, Integer quantum) {
		cont = 0;
		secuencia = new Vector<String>();
		Integer q_aux = quantum;
		Queue<Proceso> cEspera = new LinkedList<Proceso>();
		Boolean agregar_procesos = true;
		
		while(rafagasActivas(vProcesos)) {
			
			if(agregar_procesos) {
				for(Proceso p : vProcesos) {
					if(cont == p.getOrden()) {
						cEspera.offer(p);
					}
				}
			}
			cont++;
			
			agregar_procesos = true;
			
			if(!cEspera.isEmpty()) {
				Proceso p_actual = cEspera.peek();
				p_actual.setRafaga(p_actual.getRafaga()-1);
				q_aux--;
				
				secuencia.add(p_actual.getNombre());
				
				if(p_actual.getRafaga()==0) {

					p_actual.setTiempos(cont);
					cEspera.poll();
					
					q_aux = quantum;
				}else {
					if(q_aux == 0) {
						cEspera.poll();
						
						for(Proceso p : vProcesos) {
							if(cont == p.getOrden()) {
								cEspera.offer(p);
							}
						}
						agregar_procesos = false;
						
						cEspera.offer(p_actual);
						q_aux = quantum;
					}
				}
			}else secuencia.add("-");
			
		}
		return secuencia;
	}
	
	
	private boolean rafagasActivas(Vector<Proceso> vProcesos) {
		for (Proceso p : vProcesos) {
			if(p.getRafaga()!=0) return true;
		}
		return false;
	}
}

