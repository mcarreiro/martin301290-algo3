package Ejercicios;
import Ejercicios.Grafo;
import Ejercicios.Grafo.Arista;
import Ejercicios.Grafo.Vertice;
public class Ej3 {
	public Boolean Resolver(String[] nodos, int x, int y, int p, int q){
		if(PuedeSaltar(x,y,p,q))
			return true;
		Grafo g = GenerarEscenario(nodos, p, q); 				//O(n)
		Vertice inicio = g.obtenerVertice(String.valueOf(x));	
		Vertice fin = g.obtenerVertice(String.valueOf(y));
		/* LISTO:
		 * - Crea el escenario en O(n)
		 * - El escenario solo tiene aristas posibles de salto
		 * 
		 * FALTA:
		 * - Poder borrar aristas
		 * - Si el grafo es conexo ya se que hay solución.
		 * - Ver como recorrer el grafo para encontrar solución rapida
		 */
		
		
		return true;
	}
	
	
	
	private Boolean PuedeSaltar(int x, int y, int p, int q)
	{
		int dif = Math.abs(y - x); 		
		return dif <= q && dif >= p;
	}
	
	private Grafo GenerarEscenario(String[] nodos,int p, int q){
		Grafo grafo = new Grafo();							//O(1)
		int i,j, peso;
		//Agrego todos los nodos.
		for(i=0; i < nodos.length;i++) 						//O(n)
			grafo.insertarVertice(nodos[i], "");		//O(1)
		//Uno con aristas los nodos que su distancia este entre p y q, maximo pueden ser 10.
		for(i=0; i < nodos.length;i++){ 					//O(10n) = O(n)
			j = i+1;
			peso = Integer.parseInt(nodos[j]) - Integer.parseInt(nodos[i]);
			while(j < nodos.length && peso <= 10 && peso >= p &&peso <= q) //O(10)
				grafo.agregarArista(nodos[i], nodos[j], peso); //O(1)
		}
		return null;
	}
}
