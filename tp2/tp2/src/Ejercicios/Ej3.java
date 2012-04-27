package Ejercicios;
import java.util.HashSet;
import java.util.Iterator;

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
		return DFS(g, inicio, fin);
	}
	
	
	private Boolean DFS(Grafo g, Vertice inicio, Vertice fin){
		inicio.Dato="V"; //Lo marco visitado.
		
		HashSet<Arista> ady = inicio.getVerticesAdyacentes();
		Iterator<Arista> it =  ady.iterator();
		while(it.hasNext()){
			Arista a = it.next();
			if(a.peso > 0)
			{
				Vertice opuesto = g.obtenerVertice(a.v2); 
				if(opuesto.Dato != "V"){
					
					if(opuesto == fin)
						return true;
					else
					{
						opuesto.Dato = "V";
						return DFS(g, opuesto, fin);						
					}
				}
				
			}
		}
		return false;
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
