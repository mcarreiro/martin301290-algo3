package Tests;

import java.io.Console;
import java.util.Stack;
import java.util.ArrayList;
import Archivos.*;

import junit.framework.TestCase;

import Ejercicios.Ej1;


public class TestEj1  extends TestCase {
	public void test(){
		Ej1 ej1 = new Ej1();
		ArrayList< Integer > pisos = new ArrayList< Integer >();
		ArrayList< Integer > pisosAux = new ArrayList< Integer >();
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisosAux = (ArrayList< Integer >)pisos.clone();
		int result = ej1.resolver(6, 10, pisosAux);
		assertEquals(result,20);
		pisosAux = (ArrayList< Integer >)pisos.clone();
		result = ej1.resolver(12, 5, pisosAux);
		assertEquals(result,20);
		
		ArrayList< Integer > pisosAux2 = new ArrayList< Integer >();
		pisosAux2.add(0);
		pisosAux2.add(3);
		pisosAux2.add(4);
		result = ej1.resolver(12, 3, pisosAux2);
		assertEquals(result,6); 

		ArrayList< Integer > tincher = new ArrayList< Integer >();
		tincher.add(20);
		tincher.add(20);
		tincher.add(0);
		tincher.add(0);
		tincher.add(0);
		tincher.add(30);
		result = ej1.resolver(12, 30, tincher);
		assertEquals(result,40);
		
		ArrayList< Integer > pablo = new ArrayList< Integer >();
		pablo.add(0);
		pablo.add(10);
		pablo.add(10);
		pablo.add(30);
		pablo.add(20);
		pablo.add(20);
		result = ej1.resolver(12, 70, pablo);
		assertEquals(result,70);
		
		ArrayList< Integer > kevin = new ArrayList< Integer >();
		kevin.add(8);
		kevin.add(7);
		kevin.add(6);
		kevin.add(5);
		kevin.add(4);
		kevin.add(3);
		kevin.add(2);
		kevin.add(1);		
		result = ej1.resolver(30, 8, kevin);
		assertEquals(result,30);
		
		kevin.clear();
		kevin.add(1);
		kevin.add(1);
		kevin.add(1);
		kevin.add(1);
		result = ej1.resolver(10, 4, kevin);
		assertEquals(result,4);
		
		kevin.clear();
		kevin.add(1);
		kevin.add(1);
		kevin.add(1);
		kevin.add(10);
		kevin.add(1);
		kevin.add(1);
		kevin.add(10);
		result = ej1.resolver(34, 2, kevin);
		assertEquals(result,9);
		
		kevin.clear();
		kevin.add(1);
		kevin.add(1);
		kevin.add(1);
		kevin.add(10);
		kevin.add(1);
		kevin.add(1);
		kevin.add(10);
		result = ej1.resolver(34, 1, kevin);
		assertEquals(result,5);
	}
	

}
