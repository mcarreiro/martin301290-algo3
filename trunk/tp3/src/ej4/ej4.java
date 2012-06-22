package ej4;
import java.util.Comparator;
import java.util.PriorityQueue;


public class ej4 {
	
	// paso por parametro tmb la funcion de prioridad de los nodos
	// todavia no se que voy a devolver
	public static ConjuntoDominante MCD_LocalSearch(ConjuntoDominante cd, Comparator<DosPorUnoSet> funcion) {
		int maxIterations = 5; // fijo? o lo hago aleatorio?
		while(cd.getEstrategiaFailed() < maxIterations ) {
			PriorityQueue<DosPorUnoSet> intercambiables = cd.getNodosIntercambiables(funcion);
			if( !intercambiables.isEmpty() ) {
				// busco el 2x1 que tenga mejor priorida de acuerdo a la funcion establecida
				DosPorUnoSet in = intercambiables.poll();
				// hago el 2 x 1
				cd.intercambiarNodos(in);
			} else{
				// si no pueod hacer el 2x1, trato una de las estrategias alternativas
				cd.alternativeStrategy();
			}
		}
		// encontre una "solucion", un nuevo conjunto dominante, caminando siempre por una "llanura" de soluciones cercanas
		return cd;
	}
}
