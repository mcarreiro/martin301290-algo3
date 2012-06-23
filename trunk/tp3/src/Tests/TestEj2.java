package Tests;

import java.util.ArrayList;

import java.util.List;

import archivos.LeerArchivos;

import ejercicios.ej2;
import ejercicios.Grafo;
import junit.framework.TestCase;

public class TestEj2 extends TestCase {
	
	public void testCrearGrafo() {
		ej2.ciclos = 0;
		//4 vertices
		String instancia = "1 2 2;1 2 4;2 3 2;2 3 3;2 3 8;3 1 1;3 1 3;3 1 5;1 4 2;1 4 9";
		Grafo g = ej2.crearGrafoDesdeInstancia(instancia);
		//@SuppressWarnings("unused")
		List<Grafo.Vertice> conj = ej2.obtenerConjuntoDominanteMinimo(g);
		assertEquals(conj.size(),1);
		assertEquals(conj.get(0).Dato,"1");
		System.out.print('\n');
        System.out.print(ej2.ciclos);
		conj.clear();
		ej2.ciclos = 0;
		//8 vertices
		instancia = "1 2 2;1 3 4;1 4 2;5 6 3;5 7 8;5 8 1";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		assertEquals(conj.size(),2);
		System.out.print('\n');
        System.out.print(ej2.ciclos);
		conj.clear();
		ej2.ciclos = 0;
//		//8 vertices
//		instancia = "1 2 2;1 3 4;1 4 2;5 6 3;5 7 8;5 8 1;1 5 200";
//		g = ej2.crearGrafoDesdeInstancia(instancia);
//		
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
//		assertEquals(conj.size(),2);
//		assertTrue(conj.get(0).Dato.equals("1") || conj.get(0).Dato.equals("5"));
//		assertTrue(conj.get(1).Dato.equals("1") || conj.get(1).Dato.equals("5"));
//		assertTrue((conj.get(0) != conj.get(1)));
//		System.out.print('\n');
//        System.out.print(ej2.ciclos);
//		conj.clear();
//		ej2.ciclos = 0;
//		//11 vertices
//		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 200";
//		g = ej2.crearGrafoDesdeInstancia(instancia);
//		
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
//		assertEquals(conj.size(),11);
//		System.out.print('\n');
//        System.out.print(ej2.ciclos);
//		conj.clear();
//		ej2.ciclos = 0;
//		instancia = "1 2 2;2 3 3;3 4 5;4 5 5;5 6 6;6 7 2;7 8 1;8 9 1;9 1 1";
//		g = ej2.crearGrafoDesdeInstancia(instancia);
//		
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
//		assertEquals(conj.size(),3);
//		assertTrue((conj.get(0) != conj.get(1) && conj.get(1)  != conj.get(2) && conj.get(0)  != conj.get(2) ));
//		System.out.print('\n');
//        System.out.print(ej2.ciclos);
        
        //10
        conj.clear();
		ej2.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 9";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		System.out.print('\n');
        System.out.print(ej2.ciclos);
        
        //12
        conj.clear();
		ej2.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 200;11 200";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		System.out.print('\n');
        System.out.print(ej2.ciclos);
        
        //14
        conj.clear();
		ej2.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		System.out.print('\n');
        System.out.print(ej2.ciclos);
        
      //16
        conj.clear();
		ej2.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14;15 16";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		System.out.print('\n');
        System.out.print(ej2.ciclos);
        
      //18
        conj.clear();
		ej2.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14;15 16;17 18";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(g));
		System.out.print('\n');
        System.out.print(ej2.ciclos);
        
//		ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();
//		
//		java.io.File currentDir = new java.io.File("");
//		ListaDeGrafos = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/../enunciado/Tp3.in");
//		conj.clear();
//		
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafos.get(0)));
//		assertEquals(conj.size(),1);
//		
//		conj.clear();
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafos.get(1)));
//		assertEquals(conj.size(),2);
//		
//		conj.clear();
//		conj.addAll(ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafos.get(2)));
//		assertEquals(conj.size(),1);
		
	}

}
