package Tests;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;

import junit.framework.TestCase;

import Ejercicios.Grafo;
import Ejercicios.Grafo.Arista;
import Ejercicios.Grafo.Vertice;

public class TestGrafo extends TestCase {
	
	public void testGetVertices() {
		//Grafo g = new Grafo();
		
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
	
	public void testAgregarArista() {
		Grafo g = new Grafo();
		g.insertarVertice("C1", "1");
		g.insertarVertice("C2", "1");
		g.agregarArista("C1", "C2", new Integer(20));
		Vertice v1, v2;
		v1 = g.obtenerVertice("C1");
		v2 = g.obtenerVertice("C2");
		// existe un vertice adyacente a c1, que es c2
		assertTrue(v1.getVerticesAdyacentes().containsKey("C2"));
		// existe un vertice adyacente a c2, que es c1
		assertTrue(v2.getVerticesAdyacentes().containsKey("C1"));
		// el peso de <c1,c2> es 20
		assertEquals(v1.getVerticesAdyacentes().get("C2"), new Integer(20));
		// el peso de <c2,c1> es 20
		assertEquals(v2.getVerticesAdyacentes().get("C1"), new Integer(20));
	}
	
	public void testGetAristas() {
		Grafo g = new Grafo();
		g.insertarVertice("C1", "1");
		g.insertarVertice("C2", "1");
		g.insertarVertice("C3", "3");
		g.agregarArista("C1", "C2", new Integer(20));
		g.agregarArista("C1", "C3", new Integer(30));
		g.agregarArista("C2", "C3", new Integer(15));
		PriorityQueue<Arista> cola = g.getAristas();
		assertEquals(cola.size(), 3);
	}
	
	public void testCrearAgm() {
		Grafo g = new Grafo();
		g.insertarVertice("C1", "1");
		g.insertarVertice("C2", "1");
		g.insertarVertice("C3", "3");
		g.agregarArista("C1", "C2", new Integer(20));
		g.agregarArista("C1", "C3", new Integer(30));
		g.agregarArista("C2", "C3", new Integer(15));
		@SuppressWarnings("unused")
		Grafo agm = g.getArbolRecubridoMinimo();
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
		g.agregarArista("A", "B", 7);
		g.agregarArista("A", "D", 5);
		g.agregarArista("D", "F", 6);
		g.agregarArista("D", "E", 15);
		g.agregarArista("F", "E", 8);
		g.agregarArista("F", "G", 11);
		g.agregarArista("E", "G", 9);
		g.agregarArista("C", "E", 5);
		g.agregarArista("B", "E", 7);
		g.agregarArista("B", "C", 8);
		@SuppressWarnings("unused")
		Grafo agm = g.getArbolRecubridoMinimo();
	}
	
}