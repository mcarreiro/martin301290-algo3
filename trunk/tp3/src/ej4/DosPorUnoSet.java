package ej4;


import ejercicios.Grafo.Vertice;

public class DosPorUnoSet {
	
	private Tupla<Vertice, Vertice> tuplaReemplazable;
	private Vertice reemplazante;
	
	public DosPorUnoSet(Tupla<Vertice, Vertice> reemplazable, Vertice reemplazante ){
		this.tuplaReemplazable = reemplazable;
		this.reemplazante = reemplazante;
	}

	public Tupla<Vertice, Vertice> getTuplaReemplazable() {
		return tuplaReemplazable;
	}

	public Vertice getReemplazante() {
		return reemplazante;
	}
	
	public int getSumaGradosTupla() {
		return this.tuplaReemplazable.getDato1().grado + this.tuplaReemplazable.getDato2().grado;
	}
	
	public int getGradoVertice() {
		return this.reemplazante.grado;
	}

}
