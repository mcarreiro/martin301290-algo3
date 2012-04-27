package Tests;

import java.io.Console;
import java.util.Stack;

import junit.framework.TestCase;

import Ejercicios.Ej3;

public class TestEj3  extends TestCase {
	public void test(){
		Ej3 ej3 = new Ej3();
		String nodos[]= {"1","3","4","5","7","10"};
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 7, 3, 5));
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 3, 3, 5));
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 1, 3, 5));
	}
	public void test1(){
		Ej3 ej3 = new Ej3();
		String nodos[]= {"1","2","4","8","10"};
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 8, 3, 5));
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 2, 3, 5));
		ej3.ImprimirPila(ej3.Resolver(nodos, 4, 1, 3, 5));
		
	}
	public void test2(){
		Ej3 ej3 = new Ej3();
		String nodos[]= {"1","3","6","8","9", "11", "12", "15","18", "21", "23", "24"};
		ej3.ImprimirPila(ej3.Resolver(nodos, 3, 8, 4, 6));
		ej3.ImprimirPila(ej3.Resolver(nodos, 12, 1, 4, 6));
		ej3.ImprimirPila(ej3.Resolver(nodos, 24, 9, 4, 6));
		
	}
}
