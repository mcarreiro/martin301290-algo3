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
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		pisos.add(10);
		int result = ej1.resolver(6, 10, pisos);
		assertEquals(result,20);
		result = ej1.resolver(12, 5, pisos);
		assertEquals(result,20); 
	}

}
