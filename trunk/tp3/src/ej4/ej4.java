package ej4;
import java.util.ArrayList;
import java.util.Comparator;

import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;


public class ej4 {
	
	static public enum Funciones { DiffGrados, MenorGrado, SumaTupla   }
	
	public static Comparator<DosPorUnoSet> getInstanciaFuncion(Funciones f) {
		switch (f) {
			case DiffGrados: return new DosPorUnoDiffGrados();
			case MenorGrado: return new DosPorUnoMenorGradoVertice();
			case SumaTupla: return new DosPorUnoSumaTupla();			
		}
		return null;
	}
	
	// paso por parametro tmb la funcion de prioridad de los nodos
	// todavia no se que voy a devolver
	public static ConjuntoDominante MCD_LocalSearch(ConjuntoDominante cd, Comparator<DosPorUnoSet> funcion) {
		//int maxIterations = (int) Math.floor(Math.random()*(20-10+1)+10);; // aletorio entre 10 y 20
		while(cd.getEstrategiaFailed() < 1 ) {
			cd.selectAndExecuteStrategy(funcion);
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
