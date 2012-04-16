package tp1.test;

import junit.framework.TestCase;
import java.util.*;

import tp1.Ejercicio2;

public class Ejercicio2Test extends TestCase {

	
	public void testResolver() {
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<ArrayList<Integer>> arr = ej2.crearArray(3,2,"1 2 2 4 5 6");
		assertEquals(2, ej2.resolver(arr));
	}
	
	public void testResolverMatrizGrande() {
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<ArrayList<Integer>> arr = ej2.crearArray(10,10,"1 1 1 2 2 2 3 3 3 4 2 2 2 1 1 1 3 3 3 4 4 4 4 3 3 3 2 2 2 1 1 2 3 4 5 6 7 8 9 0 2 3 1 4 4 5 1 3 2 1 1 2 1 5 4 4 1 3 2 2 1 4 1 1 8 7 9 9 8 2 1 6 8 1 1 1 8 9 2 2 1 1 1 1 7 1 8 8 6 5 5 6 8 1 1 1 7 6 9 9");
		assertEquals(18, ej2.resolver(arr));
	}
	
	public void testResolverSinMeseta() {
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<ArrayList<Integer>> arr = ej2.crearArray(3,3,"1 2 3 3 1 2 2 3 1");
		assertEquals(1, ej2.resolver(arr));
	}
	
	public void testEj() {
		java.io.File currentDir = new java.io.File("");
		String in = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_test.in";
		String out = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2.bak.out";
		//Ejercicio2.correrEjercicio(in, out);		
	}
	
	public void testEjAleatorio() {
		java.io.File currentDir = new java.io.File("");
		String in = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_test_aleatorios.in";
		String out = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_aleatorios.out";
		Ejercicio2.correrEjercicio(in, out);
	}
	
	public void testEjIguales() {
		java.io.File currentDir = new java.io.File("");
		String in = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_test_iguales.in";
		String out =currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_aleatorios.out";
		Ejercicio2.correrEjercicio(in, out);
	}
	
	public void testEjDiferentes() {
		java.io.File currentDir = new java.io.File("");
		String in = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_test_diferentes.in";
		String out = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2_aleatorios.out";
		Ejercicio2.correrEjercicio(in, out);
	}
	
	public void testCatedra() {
		java.io.File currentDir = new java.io.File("");
		String in = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2.in";
		String out = currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej2.out";
		Ejercicio2.correrEjercicio(in, out);
	}

}