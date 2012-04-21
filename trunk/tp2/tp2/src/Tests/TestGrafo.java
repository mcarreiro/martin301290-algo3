package Tests;

import java.util.Hashtable;

import junit.framework.TestCase;

import Ejercicios.Grafo;
import Ejercicios.Grafo.Vertice;

public class TestGrafo extends TestCase {

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
	
	public void testGetPesoArista() {
		Grafo g =  new Grafo();
		g.insertarVertice("C1", "1");
		g.insertarVertice("C2", "1");
		g.insertarVertice("C3", "3");
		g.agregarArista("C1", "C2", new Integer(20));
		g.agregarArista("C1", "C3", new Integer(10));
		g.agregarArista("C2", "C3", new Integer(15));
		assertEquals(g.getPesoArista("C1", "C2"), new Integer(20));
		assertEquals(g.getPesoArista("C1", "C3"), new Integer(10));
		assertEquals(g.getPesoArista("C3", "C2"), new Integer(15));		
	}
	
}
