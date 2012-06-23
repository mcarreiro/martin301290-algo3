package ej4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;

public class ConjuntoDominante {
	
	private ArrayList<Vertice> dominantes;
	private ArrayList<Vertice> dominados;
	private int estrategiaFailed;
	
	static public enum Movimientos { QuitarUno, UnoPorUno, AgregarUno   }
	
	public ConjuntoDominante(ArrayList<Vertice> dominantes, ArrayList<Vertice> dominados) {
		this.dominantes = dominantes;
		this.dominados = dominados;
		this.estrategiaFailed = 0;
	}
	
	public int getEstrategiaFailed() {
		return this.estrategiaFailed;
	}
	
	public ArrayList<Vertice> getDominantes() {
		return this.dominantes;
	}
	
	public void alternativeStrategy() {
		for(Movimientos m: Movimientos.values() ) {
			if( tryStrategy(m) ) return;
		}
	}
	
	public boolean tryStrategy(Movimientos m) {
		switch(m) {
			case QuitarUno: return tryQuitarUno();
			case UnoPorUno: return tryUnoPorUno();
			case AgregarUno: return tryAgregarUno();
		}
		return false;
	}
	
	private boolean tryQuitarUno() {
		for(Vertice v: this.dominantes) {
			this.dominantes.remove(v);
			/*if( esConjuntoDominante(this) ){
			 	// le saque uno y sigue siendo dominante
				return true;
			}
			*/
			this.dominantes.add(v);
		}
		return false;
	}
	
	private boolean tryUnoPorUno() {
		for(Vertice v: this.dominantes) {
			for(Vertice d: this.dominados) {
				// intercambio los vertices
				this.intercambiarVertices(v,d);
				//if ( esConjuntoDominante(this) ) return true;
				// vuelvo a intercambiarlos, pq no es dominante
				this.intercambiarVertices(d,v);
			}
		}
		return false;
	}
	
	private void intercambiarVertices(Vertice v1, Vertice v2) {
		// los saco de su conjunto anterior
		this.dominantes.remove(v1);
		this.dominados.remove(v2);
		// los agrego en su nuevo conjunto
		this.dominantes.add(v2);
		this.dominados.add(v1);
	}
	
	private boolean tryAgregarUno() {
		// le agrego a los dominantes cualquiera de los dominados, sigue siendo dominante
		this.dominantes.add(this.dominados.get(0));
		// le agrego uno porque me esta "deformando" la solucion"
		this.estrategiaFailed++;
		return true;
	}
	
	public void intercambiarNodos(DosPorUnoSet d) {
		// los saco de sus conjuntos actuales
		this.dominantes.remove(d.getTuplaReemplazable().getDato1());
		this.dominantes.remove(d.getTuplaReemplazable().getDato2());
		this.dominados.remove(d.getReemplazante());
		// ahora los agrego a sus nuevos conjuntos
		this.dominantes.add(d.getReemplazante());
		this.dominados.add(d.getTuplaReemplazable().getDato1());
		this.dominados.add(d.getTuplaReemplazable().getDato2());
		// reseteo el contador de estrategia fallida
		this.estrategiaFailed = 0;
	}
	
	public PriorityQueue<DosPorUnoSet> getNodosIntercambiables(Comparator<DosPorUnoSet> funcion) {
		// la funcion pasada por parametro es la que establece el criterio para elegir a los elementos a cambiar
		PriorityQueue<DosPorUnoSet> intercambiables = new PriorityQueue<DosPorUnoSet>(10, funcion);
		for(Vertice v : this.dominantes ) {
			for(Vertice v2 : this.dominantes ){
				for(Vertice d : this.dominados ) {
					// me fijo si sacando <v1,v2> y agregando d, los vertices siguen siendo dominantes
					// hago una copia de la solucion, le saco los vertices
					// le pregunto si es dominante
					boolean esDominante = true; // cambia por metodo
					if( esDominante ) {
						Tupla<Vertice, Vertice> t = new Tupla<Grafo.Vertice, Grafo.Vertice>(v, v2);
						intercambiables.add(new DosPorUnoSet(t, d));
					}
				}
			}
		}
		return intercambiables;
	}

}
