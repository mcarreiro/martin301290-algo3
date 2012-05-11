package Tests;

import java.io.Console;
import java.util.Stack;
import java.util.ArrayList;
import Archivos.*;

import junit.framework.TestCase;

import Ejercicios.Ej3;

public class TestEj3  extends TestCase {
	public void testCatedra(){
		java.io.File currentDir = new java.io.File("");
		LeerArchivos reader = new LeerArchivos();
		ArrayList<String> inputs = reader.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp1Ej3.in");
		String result = "", estadistica = "";
		Ej3 ej3 = new Ej3();
		for(int i=0;i<inputs.size();i=i+3){
			String[] limiteSalto = inputs.get(i).split(" ");
			String[] nodos = inputs.get(i+1).split(" ");
			String[] instancias = inputs.get(i+2).split(";");

			int p = Integer.parseInt(limiteSalto[0]);
			int q = Integer.parseInt(limiteSalto[1]);
							
			for(int j=0;j<instancias.length;j++){
				String[] posicion = instancias[j].trim().split(" ");
				int x = Integer.parseInt(posicion[0]);
				int y = Integer.parseInt(posicion[1]);
				Stack<String> resul = ej3.Resolver(nodos, x, y, p, q);
				if(resul != null)
					assertEquals(true, ej3.ProbarSolucion(nodos, x, y, p, q, (Stack<String>)resul.clone()));
				String cadena = ej3.ImprimirPila(resul);
				result+= cadena + ";";
				estadistica+=cadena +" - #Fichas: " + nodos.length + " - Ciclos: "+ (ej3.ciclos_DFS)+ ";";

			}
			
			
			
		}
		
		String[] res = result.substring(0, result.length()).split(";");
		String[] est = estadistica.substring(0, estadistica.length()).split(";");
		EscribirArchivo.escribir(currentDir.getAbsolutePath() + "/enunciado/Tp1Ej3.out",res);		
		EscribirArchivo.escribir(currentDir.getAbsolutePath() + "/enunciado/Tp1Ej3_Estadisticas.out",est);
		
	}
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
