package Tests;

import java.util.ArrayList;
import java.util.HashSet;

import ej4.ConjuntoDominante;
import ej4.DosPorUnoDiffGrados;
import ej4.ej4;
import ejercicios.Ej3;
import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;
import junit.framework.TestCase;

public class TestEj4 extends TestCase {
	
	public void testVertices() {
		Grafo g = new Grafo();
		Vertice v = g.insertarVertice("v1", "dato");
		Vertice v2 =  g.insertarVertice("v2", "dato2");
		HashSet<Vertice> hs = new HashSet<Vertice>();
		hs.add(v); hs.add(v2);
		hs.remove(v); hs.remove(v2);
		assertEquals(hs.size(), 0);
	}
	
	public void testCalcularDominados() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		assertEquals(g.getVertices().size(), dominados.size() + dominantes.size() );
	}
	
	public void testCrearConjuntoDominante() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		assertEquals(g.getVertices().size(), cd.getDominados().size() + cd.getDominantes().size());
	}
	
	public void testLocalSearch() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		// size 4
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// size 4
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(cd.getDominantes().size(), solu.getDominantes().size());
	}
	
	public void testLocalSearchMejora1() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// agrego un no dominado a dominante para ver si encuentra algo mejor
		dominantes.add(dominados.remove(0));
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(solu.getDominantes().size(), 4);
	}
	
	public void testLocalSearchMejora2() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// agrego un no dominado para poder hacer 2 x 1
		dominantes.remove(b);
		dominados.add(b);
		dominantes.add(f); dominantes.add(d);
		dominados.remove(f); dominados.remove(d);
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(solu.getDominantes().size(), 4);
	}
	
}
