package Ejercicios;

public class Grafo {

	public Hastable<String,Vertice> Vertices;

	public function Grafo() {
		this.Vertices = new Hastable();
	}

	private class Vertice {
		public Object Dato; // que tipo de dato deberia ser?
		public Hashtable adyacentes;
		
		public function Vertice() {
			this.Dato = new Object();
			this.adyacentes = new Hashtable();
		}
		
		public function getVerticesAdyacentes() {
			return this.adyacentes;
		}
		
		public function getPesoArista(Vertice v) {
			return this.adyacentes.getKey(v.Dato)
		}
	}
	
	public function getPesoArista(Vertice v1, Vertice v2) {
		return v1.getPesoArista(v2);
	}

	

}
