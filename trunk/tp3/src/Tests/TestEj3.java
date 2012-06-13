package Tests;

import java.util.List;

import ejercicios.Grafo;
import ejercicios.Ej3;
import junit.framework.TestCase;

public class TestEj3 extends TestCase{
	public void testCrearGrafo() {
		Ej3 ej3 = new Ej3();
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		List<Grafo.Vertice> conj = ej3.MCD_Greedy(g);
	}
}
