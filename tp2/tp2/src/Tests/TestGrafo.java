package Tests;

import java.util.Hashtable;
import java.util.PriorityQueue;

import junit.framework.TestCase;

import Ejercicios.Grafo;
import Ejercicios.Grafo.Arista;
import Ejercicios.Grafo.Vertice;

public class TestGrafo extends TestCase {
	
	public void testGetVertices() {
		//Grafo g = new Grafo();
		
	}
	
	public void testMarcarVertices() {
		Grafo g = new Grafo();
		g.insertarVertice("v1", "v1");
		g.insertarVertice("v2", "v2");
		g.insertarVertice("v3", "v3");
		Vertice v1 = g.obtenerVertice("v1");
		Vertice v2 = g.obtenerVertice("v2");
		v1.marcarVisitado();
		v2.marcarVisitado();
		Vertice v = g.obtenerVertice("v2");
		assertTrue(v.fueVisitado());
		v = g.obtenerVertice("v3");
		assertTrue(!v.fueVisitado());
	}

	
	public void testInsertarVertice() {
		Grafo g = new Grafo();
		g.insertarVertice("Ciudad 1", "1");
		Hashtable <String,Vertice> vertices = g.getVertices();
		assertTrue(vertices.containsKey("Ciudad 1"));
		assertEquals(vertices.get("Ciudad 1").getDato(), "1");
	}
	
	public void testObtenerVertice(){
		Grafo g = new Grafo();
		g.insertarVertice("Ciudad 1", "1");
		Vertice v = g.obtenerVertice("Ciudad 1");
		assertEquals(v.getDato(), "1");		
	}
	
	public void testGetAristas() {
		Grafo g = new Grafo();
		Vertice v1 = g.insertarVertice("C1", "1");
		Vertice v2 = g.insertarVertice("C2", "1");
		Vertice v3 = g.insertarVertice("C3", "3");
		g.agregarArista(v1, v2, new Integer(20));
		g.agregarArista(v1, v3, new Integer(30));
		g.agregarArista(v2, v3, new Integer(15));
		assertEquals(g.obtenerVertice("C1").getAristas().size(), 2);
		assertEquals(g.obtenerVertice("C2").getAristas().size(), 2);
		assertEquals(g.obtenerVertice("C3").getAristas().size(), 2);
	}
	
	public void testCrearAgm() {
		Grafo g = new Grafo();
		g.insertarVertice("C1", "1");
		g.insertarVertice("C2", "2");
		g.insertarVertice("C3", "3");
		g.agregarArista(g.obtenerVertice("C1"), g.obtenerVertice("C2"), new Integer(20));
		g.agregarArista(g.obtenerVertice("C1"), g.obtenerVertice("C3"), new Integer(30));
		g.agregarArista(g.obtenerVertice("C2"), g.obtenerVertice("C3"), new Integer(15));
		@SuppressWarnings("unused")
		Grafo agm = g.getAgm();
	}
	
	public void testCrearAgm2() {
		Grafo g = new Grafo();
		g.insertarVertice("A", "A");
		g.insertarVertice("B", "B");
		g.insertarVertice("C", "C");
		g.insertarVertice("D", "D");
		g.insertarVertice("E", "E");
		g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.agregarArista(g.obtenerVertice("A"), g.obtenerVertice("B"), 7);
		g.agregarArista(g.obtenerVertice("A"), g.obtenerVertice("D"), 5);
		g.agregarArista(g.obtenerVertice("D"), g.obtenerVertice("F"), 6);
		g.agregarArista(g.obtenerVertice("D"), g.obtenerVertice("E"), 15);
		g.agregarArista(g.obtenerVertice("F"), g.obtenerVertice("E"), 8);
		g.agregarArista(g.obtenerVertice("F"), g.obtenerVertice("G"), 11);
		g.agregarArista(g.obtenerVertice("E"), g.obtenerVertice("G"), 9);
		g.agregarArista(g.obtenerVertice("C"), g.obtenerVertice("E"), 5);
		g.agregarArista(g.obtenerVertice("B"), g.obtenerVertice("E"), 7);
		g.agregarArista(g.obtenerVertice("B"), g.obtenerVertice("C"), 8);
		@SuppressWarnings("unused")
		Grafo agm = g.getAgm();
	}
	
}
