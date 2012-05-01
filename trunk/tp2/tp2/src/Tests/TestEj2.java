package Tests;

import Ejercicios.Ej2;
import Ejercicios.Grafo;
import junit.framework.TestCase;

public class TestEj2 extends TestCase {
	
	public void testCrearGrafo() {
		String instancia = "1 2 2;1 2 4;2 3 2;2 3 3;2 3 8;3 1 1;3 1 3;3 1 5;1 4 2;1 4 9";
		Grafo g = Ej2.crearGrafoDesdeInstancia(instancia);
		@SuppressWarnings("unused")
		Grafo agm = g.getAgm();
	}
	
	public void testDoit() {
		String input = "/home/pablo/Software/java/algo3/tp2/enunciado/Tp1Ej2.in";
		String output = "/home/pablo/Software/java/algo3/tp2/enunciado/Tp1Ej2.out.bak";
		Ej2.doIt(input, output);
	}

}
