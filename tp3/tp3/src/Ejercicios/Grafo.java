package Ejercicios;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;


public class Grafo {

	private Hashtable<String,Vertice> Vertices;
	private ArrayList<Arista> aristas;
	public int ciclos;

	public Grafo() {
		this.Vertices = new Hashtable<String, Grafo.Vertice>();
		this.aristas = new ArrayList<Grafo.Arista>();
		this.ciclos = 0;
	}
	
	public int getCiclos(){
		return this.ciclos;
	}
	
	public String toString() {
		String res = "";
		Iterator<Arista> i = this.aristas.iterator();
		while(i.hasNext()) res += i.next() + ";";
		return res;
	}
	
	public Hashtable<String,Vertice> getVertices() {
		return this.Vertices;
	}
	
	public Vertice insertarVertice(String clave, String dato){
		Vertice v = new Vertice(dato);
		this.Vertices.put(clave, v);
		return v;
	}
	
	/**
	 * Método para insertar vértice a partir de un vértice ya creado
	 * @param v
	 */
	public Vertice insertaVertice(Vertice v) {
		Vertice aux = new Vertice(v.Dato);
		this.Vertices.put(v.Dato, aux );
		return aux;
	}
	
	public Vertice obtenerVertice(String clave) {
		return this.Vertices.get(clave);
	}
	
	public void agregarArista(Vertice v1, Vertice v2, Integer peso) {
		v1.agregarArista(v2, peso);
		//v2.agregarArista(v1, peso);
		this.aristas.add(new Arista(v1, v2, peso));
	}	
	
	public boolean hasVertex(String v){
		return this.Vertices.containsKey(v);
	}

	public Grafo getAgm() {
		Grafo g = new Grafo();
		// saco un vertice al azar y lo agrego al árbol
		Iterator<Vertice> j = this.getVertices().values().iterator();
		Vertice v1 = j.next();
		Vertice v2;
		g.insertaVertice(v1);
		PriorityQueue<Arista> aristas = new PriorityQueue<Grafo.Arista>();
		aristas.addAll(v1.getAristas());
		v1.marcarVisitado();
		Arista min;
		// mientras que el agm no tenga todos los nodos, sigo agregando
		while(g.getVertices().size() < this.getVertices().size() ){
			// agrego las aristas de los nuevos vertices
			min = aristas.poll();
			v1 = min.v1;
			v2 = min.v2;
			if ( !( v1.fueVisitado() ) ){
				g.agregarArista(g.insertaVertice(v1), v2, min.getPeso());
				v1.marcarVisitado();
				aristas.addAll(v1.getAristas());
			}
			if(!( v2.fueVisitado() )){
				g.agregarArista(g.insertaVertice(v2), v1, min.getPeso());
				v2.marcarVisitado();
				aristas.addAll(v2.getAristas());
			}
			g.ciclos++;
		}
		return g;
	}
	
	public Vertice insertauObtenerVertice(String clave, String dato) {
		Vertice v = this.obtenerVertice(clave);
		if ( v == null ) {
			v = this.insertarVertice(clave, dato);
		}
		return v;
	}
	
	
	public class Vertice {
		public String Dato; // que tipo de dato deberia ser?
		public ArrayList<Arista> aristas;
		public boolean visitado;
        public HashSet<Arista> adyacentes;
		
		public Vertice(String dato) {
			this.Dato = new String(dato);
			this.aristas = new ArrayList<Grafo.Arista>(); // modificar esto
			this.visitado = false;
		}
		
		public String toString() {
			return this.Dato;
		}
		
		public ArrayList<Arista> getAristas() {
			return this.aristas;
		}
		
		
		 
		public void agregarArista(Vertice v, Integer peso) {
			this.aristas.add(new Arista(this, v, peso));
			v.aristas.add(new Arista(v, this, peso));
			
		}
		
		public String getDato() {
			return this.Dato;
		}
		
		public boolean fueVisitado() {
			return this.visitado;
		}
		
		public void marcarVisitado() {
			this.visitado = true;
		}
		
		public void desmarcarVisitado() {
			this.visitado = false;
		}
	}
	
	public class Arista implements Comparable<Arista>{
		public Vertice v1;
		public Vertice v2;
		public Integer peso;
		public boolean agregada;
		
		public Arista(Vertice v1, Vertice v2, Integer p) {
			this.v1 = v1;
			this.v2 = v2;
			this.peso = p;
			this.agregada = false;
		}
		
		public Integer getPeso() {
			return this.peso;
		}

		public int compareTo(Arista that) {
			return this.peso - that.peso;
		}
		
		public String toString() {
			return new String("" + this.v1 + " " + this.v2 + " " + this.peso);
		}
		
		public boolean fueAgregada() {
			return this.agregada;
		}
		
		public void marcarAgregada() {
			this.agregada = true;
		}
		
		public void desmarcarAgregada() {
			this.agregada = false;
		}
		
		
	}

}