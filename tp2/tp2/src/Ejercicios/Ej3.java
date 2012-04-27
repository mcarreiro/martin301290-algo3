package Ejercicios;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import Ejercicios.Grafo;
import Ejercicios.Grafo.Arista;
import Ejercicios.Grafo.Vertice;
public class Ej3 {
	public Stack<String> Resolver(String[] nodos, int x, int y, int p, int q){
		Grafo g = GenerarEscenario(nodos, p, q); 				//O(n)
		Vertice inicio = g.obtenerVertice(String.valueOf(x));	
		Vertice fin = g.obtenerVertice(String.valueOf(y));		 
		Stack<String> pila = DFS(g, inicio, fin);
		if(pila!=null)
			pila.add(String.valueOf(x));
		return pila ;
	}
	
	
	private Stack<String> DFS(Grafo g, Vertice inicio, Vertice fin){
		inicio.Dato="V"; //Lo marco visitado.
		
		Iterator<Arista> it = inicio.getVerticesAdyacentes().iterator();
		while(it.hasNext()){	//O(20) = O(1)
			Arista a = it.next();
			if(a.peso > 0)
			{
				Vertice opuesto = g.obtenerVertice(a.v2); 
				if(opuesto.Dato != "V"){
					
					if(opuesto == fin){
						Stack<String> pila =  new Stack<String>();
						pila.add(a.v2);
						return pila;
					}
					
					else
					{
						opuesto.Dato = "V";
						Stack<String> pila = DFS(g, opuesto, fin);
						if(pila != null)
						{
							pila.add(a.v2);
							return pila;
						}
					}
				}
				
			}
		}
		return null;
	}
	
	private Boolean PuedeSaltar(int x, int y, int p, int q)
	{
		int dif = Math.abs(y - x); 		
		return dif <= q && dif >= p;
	}
	
	private Grafo GenerarEscenario(String[] nodos,int p, int q){
		Grafo grafo = new Grafo();							//O(1)
		int i,j;
		//Agrego todos los nodos.
		for(i=0; i < nodos.length;i++) 						//O(n)
			grafo.insertarVertice(nodos[i], "");		//O(1)
		//Uno con aristas los nodos que su distancia este entre p y q, maximo pueden ser 10.
		for(i=0; i < nodos.length;i++){ 					//O(10n) = O(n)
			j = i+1;
			while(j < nodos.length && CalcularDiferencia(nodos[j],nodos[i]) <= 10){ //O(10)
				if(CalcularDiferencia(nodos[j],nodos[i]) >= p && CalcularDiferencia(nodos[j],nodos[i]) <= q)
					grafo.agregarArista(nodos[i], nodos[j], CalcularDiferencia(nodos[j],nodos[i])); //O(1)
				j++;
			}
		}
		return grafo;
	}
	private int CalcularDiferencia(String x, String y)
	{
		return Integer.parseInt(x) - Integer.parseInt(y);
	}
}
