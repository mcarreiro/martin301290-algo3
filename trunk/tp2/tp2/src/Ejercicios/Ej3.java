package Ejercicios;
import java.util.Iterator;
import java.util.Stack;


import Ejercicios.Grafo;
import Ejercicios.Grafo.Arista;
import Ejercicios.Grafo.Vertice;
public class Ej3 {
	public int ciclos_DFS;
	public int ciclos_esc;
	
	public Stack<String> Resolver(String[] nodos, int x, int y, int p, int q){
		//Me fijo si el salto puede ser directo
		ciclos_DFS = 0;
		ciclos_esc = 0;
		if(Math.abs(x-y) >= p && Math.abs(x-y) <= q)
		{
			ciclos_DFS++;
			Stack<String> pila = new Stack<String>();
			pila.add(String.valueOf(y));
			pila.add(String.valueOf(x));
			return pila;
		}
		Grafo g = GenerarEscenario(nodos, p, q); 				//O(n)
		Vertice inicio = g.obtenerVertice(String.valueOf(x));	
		Vertice fin = g.obtenerVertice(String.valueOf(y));		 
		Stack<String> pila = DFS(g, inicio, fin, x, y, p,q);
		if(pila!=null)
			pila.add(String.valueOf(x));
		return pila ;
	}
	
	private Stack<String> DFS(Grafo g, Vertice inicio, Vertice fin, int x, int y, int p, int q){
		if(Math.abs(x-y) >= p && Math.abs(x-y) <= q)
		{
			ciclos_DFS++;
			Stack<String> pila = new Stack<String>();
			pila.add(String.valueOf(y));
			return pila;
		}
		inicio.marcarVisitado(); //Lo marco visitado.
		
		Iterator<Arista> it = inicio.getAristas().iterator(); //O(20) = O(1)
		while(it.hasNext()){	//O(20) = O(1)
			ciclos_DFS++;
			Arista a = it.next();
			if(a.peso > 0)
			{
				Vertice opuesto = a.v2; 
				if(!opuesto.fueVisitado()){
					
					if(opuesto == fin){ //Ya encontré el ultimo :)
						Stack<String> pila =  new Stack<String>();
						pila.add(opuesto.getDato());
						return pila;
					}
					
					else //Si no lo encontre sigo...
					{
						opuesto.marcarVisitado();
						Stack<String> pila = DFS(g, opuesto, fin, Integer.parseInt(opuesto.getDato()), y, p, q);
						if(pila != null)
						{
							pila.add(opuesto.getDato());
							return pila;
						}
					}
				}
				
			}
		}
		return null;
	}
	
	private Grafo GenerarEscenario(String[] nodos,int p, int q){
		Grafo grafo = new Grafo();						//O(1)
		Vertice[] vertices = new Vertice[nodos.length];
		int i,j;
		//Agrego todos los nodos.
		for(i=0; i < nodos.length;i++,ciclos_esc++) 	//O(n)
			vertices[i] = grafo.insertarVertice(nodos[i], nodos[i]);		//O(1)
		//Uno con aristas los nodos que su distancia este entre p y q, maximo pueden ser 10.
		for(i=0; i < nodos.length;i++){ 				//O(10n) = O(n)
			j = i+1;
			while(j < nodos.length && CalcularDiferencia(nodos[j],nodos[i]) <= 10){ //O(10)
				if(CalcularDiferencia(nodos[j],nodos[i]) >= p && CalcularDiferencia(nodos[j],nodos[i]) <= q)
					grafo.agregarArista(vertices[i], vertices[j], CalcularDiferencia(nodos[j],nodos[i])); //O(1)
				j++;
				ciclos_esc++;
			}
		}
		return grafo;
	}
	
	private int CalcularDiferencia(String x, String y)
	{
		return Integer.parseInt(x) - Integer.parseInt(y);
	}
	
	public String ImprimirPila(Stack<String> pila){
		String res = "", paso;
		while(pila!= null && !pila.isEmpty()){	
			paso = pila.pop()+" ";
			System.out.print(paso);
			res+=paso;
		}
		System.out.println("");
		return res.trim();
	}
}
