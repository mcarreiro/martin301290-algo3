package ej4;
import java.util.ArrayList;
import java.util.Comparator;

import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;


public class ej4 {
	
	// paso por parametro tmb la funcion de prioridad de los nodos
	// todavia no se que voy a devolver
	public static ConjuntoDominante MCD_LocalSearch(ConjuntoDominante cd, Comparator<DosPorUnoSet> funcion) {
		int maxIterations = 5; // fijo? o lo hago aleatorio?
		while(cd.getEstrategiaFailed() < maxIterations ) {
			cd.selectStrategy(funcion);
		}
		// encontre una "solucion", un nuevo conjunto dominante, caminando siempre por una "llanura" de soluciones cercanas
		return cd;
	}
	
	public static ArrayList<Vertice> getListaDominados(Grafo g, ArrayList<Vertice> dominantes) {
		ArrayList<Vertice> dominados = new ArrayList<Grafo.Vertice>();
		for(Vertice v : g.getVertices().values() ) {
			if( !dominantes.contains(v) ) {
				dominados.add(v);
			}
		}
		return dominados;
	}
}
