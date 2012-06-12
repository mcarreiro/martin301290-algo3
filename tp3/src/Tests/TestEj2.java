package Tests;

import java.util.ArrayList;
import java.util.List;


import ejercicios.ej2;
import ejercicios.Grafo;
import junit.framework.TestCase;

public class TestEj2 extends TestCase {
	
	public void testCrearGrafo() {
		String instancia = "1 2 2;1 2 4;2 3 2;2 3 3;2 3 8;3 1 1;3 1 3;3 1 5;1 4 2;1 4 9";
		Grafo g = ej2.crearGrafoDesdeInstancia(instancia);
		@SuppressWarnings("unused")
		List<Grafo.Vertice> conj = ej2.obtenerConjuntoDominanteMinimo(g);
		assertEquals(conj.size(),1);
	}

}
