package Tests;

import java.io.Console;

import junit.framework.TestCase;

import Ejercicios.Ej3;

public class TestEj3  extends TestCase {
	public void test(){
		Ej3 ej3 = new Ej3();
		String nodos[]= {"1","3","4","5","7","10"};
		Boolean res = ej3.Resolver(nodos, 4, 7, 3, 5);
		Boolean res1 = ej3.Resolver(nodos, 4, 3, 3, 5);
		System.out.println(res);
		System.out.println(res1);
	}
	public void test1(){
		Ej3 ej3 = new Ej3();
		String nodos[]= {"1","2","4","8","10"};
		Boolean res = ej3.Resolver(nodos, 4, 8, 3, 5);
		Boolean res1 = ej3.Resolver(nodos, 4, 2, 3, 5);
		Boolean res2 = ej3.Resolver(nodos, 4, 1, 3, 5);
		System.out.println(res);
		System.out.println(res1);
		System.out.println(res2);
	}
}
