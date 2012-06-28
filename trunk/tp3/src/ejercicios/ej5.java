package ejercicios;

import java.util.ArrayList;

import java.util.Comparator;
//import java.util.Hashtable;
import java.util.Iterator;

import ej4.ConjuntoDominante;
import ej4.DosPorUnoSet;
import ejercicios.Grafo.Vertice;
import ej4.DosPorUnoSumaTupla;
import ej4.ej4;

public class ej5 {
	/**
	 * Calcular conjunto dominante a través de GRASP, obtener k soluciónes random greedy y mejorarlas localmente 
	 * y ver si es mejor que la anterior
	 * 
	 * @param Grafo g
	 * @param CantIteraciones k
	 * @return ConjuntoDominante
	 */
	
	public static ConjuntoDominante MCD_Grasp(Grafo g, int k){
		
		//Que me devuelvan todos que es el peor caso posible
		//Hashtable<String,Vertice> vertices = g.getVertices();
		ArrayList<Vertice> todosLosVertices = calcularDominados(g,new ArrayList<Vertice>()); 
		ConjuntoDominante mejorSolucion = new ConjuntoDominante(todosLosVertices, new ArrayList<Vertice>());
		Grafo gOriginal = g;
		for(int i = 0;i<k;i++){
			g = g.desmarcarVertices();
			ArrayList<Vertice> instanciaSolucion = Ej3.MCD_Greedy(g,k);
			ConjuntoDominante cd = new ConjuntoDominante(instanciaSolucion, calcularDominados(g, instanciaSolucion));
			//VER CUAL FUNCIONA MEJOR EN LA MAYORIA DE LOS CASOS DE LOS TESTS
			Comparator<DosPorUnoSet> funcion = new DosPorUnoSumaTupla(); 
			ConjuntoDominante nuevaSolucion = ej4.MCD_LocalSearch(cd,funcion);
			if(cantNodosDominantes(nuevaSolucion)<cantNodosDominantes(mejorSolucion)){
				mejorSolucion = nuevaSolucion;
			}
		}		
		return mejorSolucion;
	}
	
	/**
	 * Cantidad nodos dominantes
	 * 
	 * @param Conjunto Dominante cd
	 * @return Cantidad
	 */
	
	public static int cantNodosDominantes(ConjuntoDominante cd){
		
		ArrayList<Vertice> dominantes = cd.getDominantes();
		return dominantes.size();		
	}
	
	/**
	 * A partir de un grafo y sus dominantes, saber cuáles son los dominados
	 * 
	 * @param Grafo g
	 * @param ArrayList<Vertice> dominantes
	 * @return ArrayList<Vertice>
	 */
	
	public static ArrayList<Grafo.Vertice> calcularDominados(Grafo g, ArrayList<Vertice> dominantes){
		
		ArrayList<Grafo.Vertice> dominados = new ArrayList<Vertice>();
		Grafo.Vertice vert;
		
		Iterator<Grafo.Vertice> itVertice = g.getVertices().values().iterator();		
		while(itVertice.hasNext()){
				vert = itVertice.next();
				if(!dominantes.contains(vert)){
					dominados.add(vert);
				}
			}
		return dominados;
	}	
}
