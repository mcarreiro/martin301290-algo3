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
		instancia = "48 36 3;16 31 3;31 4 3;9 50 3;44 16 3;25 2 3;44 2 3;27 10 3;44 24 3;7 28 3;39 16 3;16 6 3;47 27 3;22 42 3;48 24 3;3 34 3;30 31 3;4 23 3;41 36 3;13 12 3;42 3 3;34 5 3;43 23 3;41 13 3;29 14 3;40 4 3;40 37 3;20 16 3;46 1 3;20 37 3;26 17 3;32 32 3;44 2 3;23 17 3;19 20 3;22 28 3;8 1 3;14 46 3;31 5 3;46 13 3;16 19 3;48 12 3;35 5 3;4 22 3;9 25 3;25 4 3;42 40 3;23 30 3;48 42 3;9 49 3;";
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
