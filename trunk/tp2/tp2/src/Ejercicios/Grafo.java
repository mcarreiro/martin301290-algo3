package Ejercicios;

import java.util.Hashtable;

public class Grafo {

	private Hashtable<String,Vertice> Vertices;

	public Grafo() {
		this.Vertices = new Hashtable<String, Grafo.Vertice>();
	}
	
	public Integer getPesoArista(Vertice v1, Vertice v2) {
		return v1.getPesoArista(v2.getDato());
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
			return true;
		}
		return false;
	}
	
	public Hashtable<String,Vertice> obtenerListaVertices() {
		return this.Vertices;
	}
	
	public Hashtable<String,Integer> obtenerVerticesAdyacentes(String vertice){
		return this.Vertices.get(vertice).getVerticesAdyacentes();
	}

	private class Vertice {
		public String Dato; // que tipo de dato deberia ser?
		public Hashtable<String, Integer> adyacentes;
		
		public Vertice(String dato) {
			this.Dato = new String(dato);
			this.adyacentes = new Hashtable<String, Integer>();
		}
		
		public Hashtable<String, Integer> getVerticesAdyacentes() {
			return this.adyacentes;
		}
		
		public void agregarArista(String clave, Integer peso) {
			this.adyacentes.put(clave, peso);
		}
		
		public Integer getPesoArista(String vecino) {
			return this.adyacentes.get(vecino);
		}
		
		public String getDato() {
			return this.Dato;
		}
	}

}
