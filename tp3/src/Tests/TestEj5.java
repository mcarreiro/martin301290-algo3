package Tests;

import java.util.ArrayList;
//
//import archivos.LeerArchivos;

import java.util.List;

import ejercicios.ej5;
import ejercicios.ej2;
import ejercicios.Grafo;
import junit.framework.TestCase;
import ej4.ConjuntoDominante;

public class TestEj5 extends TestCase {
	ConjuntoDominante conj;
	List<Grafo.Vertice> conjExacto;
	int k;
	public void testCrearGrafo() {
		String instancia = "1 2 2;2 3 2;3 1 1;1 4 9";
		Grafo g = ej2.crearGrafoDesdeInstancia(instancia);
		k = 1;
		conjExacto = ej2.obtenerConjuntoDominanteMinimo(g);
		conj = ej5.MCD_Grasp(g,k);
		ArrayList<Grafo.Vertice> conjDominanteGrasp = conj.getDominantes();
		k = 3;
		/*k = 2;
		conj = ej5.MCD_Grasp(g,k);
		k = 3;
		conj = ej5.MCD_Grasp(g,k);
		k = 10;*/
	}

}
