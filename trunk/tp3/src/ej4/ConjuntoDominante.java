
package ej4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import ejercicios.Grafo;
import ejercicios.Grafo.Arista;
import ejercicios.Grafo.Vertice;

public class ConjuntoDominante {
	
	private ArrayList<Vertice> dominantes;
	private ArrayList<Vertice> dominados;
	private int estrategiaFailed;
	private ArrayList<Tupla<Vertice, Vertice>> intercambiosRealizados;
	
	static public enum Movimientos { DosPorUno, QuitarUno, UnoPorUno   }
	
	public ConjuntoDominante(ArrayList<Vertice> dominantes, ArrayList<Vertice> dominados) {
		this.dominantes = dominantes;
		this.dominados = dominados;
		this.estrategiaFailed = 0;
		this.intercambiosRealizados = new ArrayList<Tupla<Vertice,Vertice>>();
	}
	
	public int getEstrategiaFailed() {
		return this.estrategiaFailed;
	}
	
	public ArrayList<Vertice> getDominantes() {
		return this.dominantes;
	}
	
	public ArrayList<Vertice> getDominados() {
		return this.dominados;
	}
	
	public void selectStrategy(Comparator<DosPorUnoSet> funcion) {
		for(Movimientos m: Movimientos.values() ) {
			if( tryStrategy(m, funcion) ) return;
		}
	}
	
	public boolean tryStrategy(Movimientos m, Comparator<DosPorUnoSet> funcion) {
		switch(m) {
			case DosPorUno: return tryDosPorUno(funcion);
			case QuitarUno: return tryQuitarUno();
			case UnoPorUno: return tryUnoPorUno();
		}
		return false;
	}
	
	private boolean tryDosPorUno(Comparator<DosPorUnoSet> funcion) {
		PriorityQueue<DosPorUnoSet> intercambiables = this.getNodosIntercambiables(funcion);
		if( !intercambiables.isEmpty() ) {
			// busco el 2x1 que tenga mejor priorida de acuerdo a la funcion establecida
			DosPorUnoSet in = intercambiables.poll();
			// hago el 2 x 1
			this.intercambiarNodos(in);
			this.estrategiaFailed = 0;
			return true;
		}
		return false;
	}

	private boolean tryQuitarUno() {
		for(Vertice v: this.dominantes ) {
			if( this.sigueDominante(v) ) {
				this.dominantes.remove(v);
				return true;
			}
		}
		return false;
	}
	
	private boolean sigueDominante(Vertice nodoSacado) {
		HashSet<Vertice> adyac = new HashSet<Grafo.Vertice>();
		if ( nodoSacado.getAristas().size() == 0 ) return false;
		for(Arista a : nodoSacado.getAristas() ) {
			if( !nodoSacado.equals(a.v1) ) {
				adyac.add(a.v1);
			} else {
				adyac.add(a.v2);
			}
		}
		for(Vertice v : this.dominantes) {
			if( !v.equals(nodoSacado) ) {
				// me fijo si tengo las aristas
				for(Arista a : v.getAristas() ) {
					if( adyac.contains(a.v1) ) adyac.remove(a.v1);
					if( adyac.contains(a.v2) ) adyac.remove(a.v2);
					if ( adyac.size() == 0 ) return true;
				}
			}
		}
		return false;
	}
	
	private boolean tryUnoPorUno() {
		// recordar cuales intercambie
		// para no intercambiarlos infinitamente
		for(Vertice v: this.dominantes) {
			for(Vertice d: this.dominados) {
				ArrayList<Vertice> list = new ArrayList<Grafo.Vertice>();
				list.add(v);
				if ( !this.intercambioRealizado(v, d) && this.nodosSonReemplazables(list, d) ) {
					// intercambio los vertices
					this.intercambiarVertices(v,d);
					this.intercambiosRealizados.add(new Tupla<Grafo.Vertice, Grafo.Vertice>(v, d));
					this.estrategiaFailed = 0;
					return true;
				}
			}
		}
		this.estrategiaFailed++;
		return false;
	}
	
	private boolean intercambioRealizado(Vertice v1, Vertice v2) {
		for(Tupla<Vertice,Vertice> t : this.intercambiosRealizados ) {
			if( v1.equals(t.getDato1()) || v1.equals(t.getDato2()) && 
					(v2.equals(t.getDato1()) || v2.equals(t.getDato2())) ) 
				return true;
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
				if (!v.equals(v2)) {
					for(Vertice d : this.dominados ) {
						ArrayList<Vertice> lis = new ArrayList<Grafo.Vertice>();
						lis.add(v); lis.add(v2);
						// si es reemplazable, tomo como posibles del 2x1
						if(v.getAristas().size() > 0 && v2.getAristas().size() > 0 ) {
							if( this.nodosSonReemplazables(lis, d) ) {
								Tupla<Vertice, Vertice> t = new Tupla<Grafo.Vertice, Grafo.Vertice>(v, v2);
								intercambiables.add(new DosPorUnoSet(t, d));
							}
						}
					}
				}
			}
		}
		return intercambiables;
	}
	
	private boolean nodosSonReemplazables(ArrayList<Vertice> candidatos, Vertice reemplazo) {
		// me fijo si la union de las aristas de v1,v2 es igual a las aristas de reemplazo
		Set<Vertice> hs = new HashSet<Vertice>();
		int agrego = 0;
		for(Vertice v : candidatos) {
			for(Arista a : v.getAristas() ) {
				hs.add(a.v1);
				hs.add(a.v2);
				agrego++;
			}
		}
		// saco los del reemplazo
		for( Arista a: reemplazo.getAristas() ) {
			hs.remove(a.v1);
			hs.remove(a.v2);
		}
		// si tienen len > 0, no son reemplazables
		return agrego > 0 && !(hs.size() > 0);
	}

}
