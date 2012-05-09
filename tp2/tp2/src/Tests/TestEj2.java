package Tests;

import java.util.ArrayList;

import Archivos.EscribirArchivo;
import Archivos.LeerArchivos;
import Ejercicios.Ej2;
import Ejercicios.Grafo;
import junit.framework.TestCase;

public class TestEj2 extends TestCase {
	
	public void testCrearGrafo() {
		String instancia = "1 2 2;1 2 4;2 3 2;2 3 3;2 3 8;3 1 1;3 1 3;3 1 5;1 4 2;1 4 9";
		Grafo g = Ej2.crearGrafoDesdeInstancia(instancia);
		@SuppressWarnings("unused")
		Grafo agm = g.getAgm();
	}
	
	public void resuelveConsigna() {
		java.io.File currentDir = new java.io.File("");
		String input = currentDir.getAbsolutePath()+ "/enunciado/Tp1Ej2.in";
		String output = currentDir.getAbsolutePath()+ "/enunciado/Tp1Ej2.out.bak";
		Ej2.doIt(input, output);
	}
	
	/**
	 * Tests para verificar que funcione en casos de borde
	 */
	
	
	public void testCasoBorde1(){
		
	}
	
	public void testCasoBorde2(){
		
	}
	
	/*
	 * A partir de un archivo con instancias aleatorias, verifico la eficiencia de la solucion
	 * obtenida
	 */
	public void testAleatorios1() {
		java.io.File currentDir = new java.io.File("");
		for(int j=10; j < 41; j=j+10){
			String input = currentDir.getAbsolutePath()+ "/enunciado/graficos_ej2eFijo" + new Integer(j).toString() + ".in";
			String output = currentDir.getAbsolutePath()+ "/enunciado/graficos_ej2eFijo" + new Integer(j).toString() + ".out";
			ArrayList<String> inputs = LeerArchivos.leer(input);
			String[] out = new String[inputs.size()/2];
			int aux = 0;
			for(int i=0; i < inputs.size(); i+=2){
				//out[i] = inputs.get(i);
				Grafo g = Ej2.crearGrafoDesdeInstancia(inputs.get(i + 1));
				Grafo agm = g.getAgm();
				out[aux] = inputs.get(i) + " " + new Integer(agm.getCiclos()).toString();
				aux++;
			}
			EscribirArchivo.escribir(output, out);
		}
	}
	
	public void testAleatorios2() {
		java.io.File currentDir = new java.io.File("");
		for(int j=10; j < 41; j=j+10){
			String input = currentDir.getAbsolutePath()+ "/enunciado/graficos_ej2vFijo" + new Integer(j).toString() + ".in";
			String output = currentDir.getAbsolutePath()+ "/enunciado/graficos_ej2vFijo" + new Integer(j).toString() + ".out";
			ArrayList<String> inputs = LeerArchivos.leer(input);
			String[] out = new String[inputs.size()/2];
			int aux = 0;
			for(int i=0; i < inputs.size(); i+=2){
				//out[i] = inputs.get(i);
				Grafo g = Ej2.crearGrafoDesdeInstancia(inputs.get(i + 1));
				Grafo agm = g.getAgm();
				out[aux] = inputs.get(i) + " " + new Integer(agm.getCiclos()).toString();
				aux++;
			}
			EscribirArchivo.escribir(output, out);
		}
	}
}