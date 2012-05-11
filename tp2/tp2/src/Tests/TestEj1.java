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
		int result = ej1.resolver(10, 6, pisosAux);
//		System.out.print(ej1.ciclos);
//		System.out.print('\n');
//		ej1.ciclos = 0;
//		assertEquals(result,20);
//		pisosAux = (ArrayList< Integer >)pisos.clone();
//		result = ej1.resolver(5, 12, pisosAux);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,20);
//		
//		ArrayList< Integer > pisosAux2 = new ArrayList< Integer >();
//		pisosAux2.add(0);
//		pisosAux2.add(3);
//		pisosAux2.add(4);
//		result = ej1.resolver(3, 12, pisosAux2);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,6); 
//
//		ArrayList< Integer > tincher = new ArrayList< Integer >();
//		tincher.add(20);
//		tincher.add(20);
//		tincher.add(0);
//		tincher.add(0);
//		tincher.add(0);
//		tincher.add(30);
//		result = ej1.resolver(30, 12, tincher);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,40);
//		
//		ArrayList< Integer > pablo = new ArrayList< Integer >();
//		pablo.add(0);
//		pablo.add(10);
//		pablo.add(10);
//		pablo.add(30);
//		pablo.add(20);
//		pablo.add(20);
//		result = ej1.resolver(70, 12, pablo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,70);
//		
//		ArrayList< Integer > kevin = new ArrayList< Integer >();
//		kevin.add(8);
//		kevin.add(7);
//		kevin.add(6);
//		kevin.add(5);
//		kevin.add(4);
//		kevin.add(3);
//		kevin.add(2);
//		kevin.add(1);		
//		result = ej1.resolver(8, 30, kevin);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,30);
//		
//		kevin.clear();
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(1);
//		result = ej1.resolver(4, 10, kevin);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,4);
//		
//		kevin.clear();
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(10);
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(10);
//		result = ej1.resolver(2, 34, kevin);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,9);
//		
//		kevin.clear();
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(10);
//		kevin.add(1);
//		kevin.add(1);
//		kevin.add(10);
//		result = ej1.resolver(1, 34, kevin);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,5);
//		
//		//Le conviene levantar todo menos le ultimo piso
		ArrayList< Integer > manolo = new ArrayList< Integer >();
//		manolo.add(4);
//		manolo.add(4);
//		manolo.add(3);
//		manolo.add(10);
//		result = ej1.resolver(10, 8, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,11);
//		
//		//Le conviene levantar desde el 5 piso
//		manolo.clear();
//		manolo.add(0);
//		manolo.add(40);
//		manolo.add(9);
//		manolo.add(10);
//		manolo.add(10);
//		manolo.add(10);
//		manolo.add(40);
//		result = ej1.resolver(39, 14, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,69);
//		
//		//Le conviene levantar todo menos le ultimo piso
//		manolo.clear();
//		manolo.add(10);
//		manolo.add(10);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(99);
//		result = ej1.resolver(100, 14, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,100);
//		
//		//Le conviene levantar del ultimo piso nada mas 
//		manolo.clear();
//		manolo.add(8);
//		manolo.add(10);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(20);
//		manolo.add(99);
//		result = ej1.resolver(99, 14, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,99);
//		
//		//Caseo catedra
//		manolo.clear();
//		manolo.add(4);
//		manolo.add(0);
//		manolo.add(0);
//		manolo.add(1);
//		manolo.add(5);
//		result = ej1.resolver(5, 12, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,9);
//		
//		//Caso random 1
//		manolo.clear();
//		manolo.add(46);
//		manolo.add(59);
//		manolo.add(21);
//		manolo.add(89);
//		manolo.add(4);
//		manolo.add(84);
//		manolo.add(57);
//		result = ej1.resolver(78, 7, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,105);
//		
//		//Caso random 2
//		manolo.clear();
//		manolo.add(4);
//		manolo.add(11);
//		manolo.add(66);
//		manolo.add(46);
//		manolo.add(38);
//		manolo.add(8);
//		manolo.add(18);
//		result = ej1.resolver(47, 97, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,191);
//		
//		//Caso random 2 bis
//		manolo.clear();
//		manolo.add(4);
//		manolo.add(11);
//		manolo.add(66);
//		manolo.add(46);
//		manolo.add(38);
//		manolo.add(8);
//		manolo.add(18);
//		result = ej1.resolver(22, 97, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		
//		ej1.ciclos = 0;
//		assertEquals(result,191);
//		
//		//Caso random 3
//		manolo.clear();
//		manolo.add(27);
//		manolo.add(63);
//		manolo.add(9);
//		manolo.add(25);
//		manolo.add(96);
//		manolo.add(27);
//		manolo.add(4);
//		result = ej1.resolver(73, 18, manolo);
//		System.out.print('\n');
//		System.out.print(ej1.ciclos);
//		ej1.ciclos = 0;
//		assertEquals(result,146);
		
		
		//Edificio para test de grafcos		
		manolo.clear();
		manolo.add(4);
		manolo.add(11);
		manolo.add(66);
		manolo.add(46);
		manolo.add(38);
		manolo.add(8);
		manolo.add(45);
		manolo.add(80);
		manolo.add(90);
		manolo.add(60);
		manolo.add(20);
		manolo.add(45);
		ej1.ciclos = 0;
		result = ej1.resolver(30, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(25, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(15, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(10, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(2, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(1, 9700, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		System.out.print("aaaaaaaaa");
		System.out.print('\n');
		
		ej1.ciclos = 0;
		result = ej1.resolver(5, 600, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 400, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 200, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 100, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 50, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 25, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
		ej1.ciclos = 0;
		result = ej1.resolver(5, 10, manolo);
		System.out.print(ej1.ciclos);
		System.out.print('\n');
	}
	

}
