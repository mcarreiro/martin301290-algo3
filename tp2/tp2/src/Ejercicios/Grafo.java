package Ejercicios;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;


public class Grafo {

	private Hashtable<String,Vertice> Vertices;
	private PriorityQueue<Arista> Aristas;

	public Grafo() {
		this.Vertices = new Hashtable<String, Grafo.Vertice>();
		this.Aristas = new PriorityQueue<Grafo.Arista>();
	}
	
	public Hashtable<String,Vertice> getVertices() {
		return this.Vertices;
	}
	
	public void insertarVertice(String clave, String dato){
		Vertice v = new Vertice(dato);
		this.Vertices.put(clave, v);
	}
	
	public Vertice obtenerVertice(String clave) {
		return this.Vertices.get(clave);
	}
	
	public boolean agregarArista(String v1, String v2, Integer peso) {
		if (this.obtenerVertice(v1) != null && this.obtenerVertice(v2) != null) {
			this.Vertices.get(v1).agregarArista(v2, peso);
			this.Vertices.get(v2).agregarArista(v1, peso);
			this.Aristas.add(new Arista(v1, v2, peso)); 
			return true;
		}
		return false;
	}
	
	public Hashtable<String,Vertice> obtenerListaVertices() {
		return this.Vertices;
	}
	
	public HashSet<Arista> obtenerVerticesAdyacentes(String vertice){
		return this.obtenerVertice(vertice).getVerticesAdyacentes();
	}
	
	public PriorityQueue<Arista> getAristas() {
		return this.Aristas;
	}
	
	public boolean hasVertex(String v){
		return this.Vertices.containsKey(v);
	}
	
	/**
	 * Dada una instancia de un grafo, devuelve el arbol recubridor minimo (que es un grafo)
	 * utilizando el algoritmo de o prim (decidir)
	 * @return Grafo arbol recubridor minimo
	 */
	public Grafo getArbolRecubridoMinimo(){
		Hashtable<String, Vertice> v = ((Hashtable<String,Vertice>)this.getVertices().clone());
		int initialSize = v.size();
		PriorityQueue<Arista> aristasGrafo = this.getAristas();
		Grafo agm = new Grafo();
		// agrego la arista de menor peso
		Arista aristaMin = aristasGrafo.poll();
		// agrego los vertices de la arista a la lista de vertices
		agm.insertarVertice(aristaMin.v1, aristaMin.v1);
		agm.insertarVertice(aristaMin.v2, aristaMin.v2);
		agm.agregarArista(aristaMin.v1, aristaMin.v2, aristaMin.peso);
		// elimino los vertices de la lista de vertices
		v.remove(aristaMin.v1);
		v.remove(aristaMin.v2);
		while(agm.getVertices().size() < initialSize ){
			ArrayList<Arista> aristaSinUsar = new ArrayList<Grafo.Arista>();
			// desencolo una arista de peso minimo
			Hashtable<String, Vertice> verticesAgm = agm.getVertices();
			Arista a = aristasGrafo.poll();
			// me fijo si a tiene un extremo en this y otro en agm 
			String v1 = a.v1;
			String v2 = a.v2;
			while( !(this.hasVertex(v1) && agm.hasVertex(v2)) && 
					!(this.hasVertex(v2) && agm.hasVertex(v1))  ){
				aristaSinUsar.add(a);
				if(aristasGrafo.isEmpty()) break;
				a = aristasGrafo.poll();
				v1 = a.v1;
				v2 = a.v2;
			}
			// de ser asi, agrego el vertice y la arista a agm
			if ( (v.containsKey(v1) && !v.containsKey(v2)) && 
					(verticesAgm.containsKey(v2) && !verticesAgm.containsKey(v1) )) {
				v.remove(v1);
				agm.insertarVertice(v1, v1);
				agm.agregarArista(v1, v2, a.peso);
			}
			if ( (v.containsKey(v2) && !v.containsKey(v1)) && 
					(verticesAgm.containsKey(v1) && !verticesAgm.containsValue(v2)) ) {
				v.remove(v2);
				agm.insertarVertice(v2, v1);
				agm.agregarArista(v1, v2, a.peso);
			}
			Iterator<Arista> i = aristaSinUsar.iterator();
			while(i.hasNext()) aristasGrafo.add(i.next());
		}
		return agm;
	}

	
	
	public class Vertice {
		public String Dato; // que tipo de dato deberia ser?
		public HashSet<Arista> adyacentes;
		
		public Vertice(String dato) {
			this.Dato = new String(dato);
			this.adyacentes = new HashSet<Grafo.Arista>(); // modificar esto
		}
		
		public HashSet<Arista> getVerticesAdyacentes() {
			return this.adyacentes;
		}
		
		
		public void agregarArista(String v, Integer peso) {
			this.adyacentes.add(new Arista(this.Dato, v, peso));
		}
		
		public String getDato() {
			return this.Dato;
		}
	}
	
	public class Arista implements Comparable<Arista>{
		public String v1;
		public String v2;
		public Integer peso;
		
		public Arista(String v1, String v2, Integer p) {
			this.v1 = v1;
			this.v2 = v2;
			this.peso = p;
		}

		public int compareTo(Arista that) {
			return this.peso - that.peso;
		}
		
		public String toString() {
			return new String("<" + this.v1 + "," + this.v2 + "> | Peso: " + this.peso);
		}
		
		
	}

}
