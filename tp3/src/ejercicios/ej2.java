package ejercicios;

import java.util.ArrayList;
import java.util.Hashtable;

import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;
import java.util.Collection;

public class ej2 {
	
	public static Grafo crearGrafoDesdeInstancia(String instancia) {
		Grafo g = new Grafo();
		String enlaceDelim = ";";
		String[] in = instancia.split(enlaceDelim);
		for(int i =0; i < in.length; i++) {
			String enlace = in[i];
			String delim = " ";
			String[] enlaceInfo = enlace.split(delim);
			Vertice v1 = g.insertauObtenerVertice(enlaceInfo[0], enlaceInfo[0]); 
			Vertice v2 = g.insertauObtenerVertice(enlaceInfo[1], enlaceInfo[1]);
			g.agregarArista(v1, v2, new Integer(enlaceInfo[2]));
		}
		return g;
	}
	
	public static void doIt(Grafo graph) {
		Collection<Grafo.Vertice> vertices  = graph.getVertices().values();
		boolean encontre = false;
		while(!encontre){
			//todas las combinaciones de vertuces primero de 1 nodo depsues de 2 despues de 3 y asi
		}
	}
	
}
