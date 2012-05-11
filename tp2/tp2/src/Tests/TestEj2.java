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
	
	public void testAristasFijas() {
		java.io.File currentDir = new java.io.File("");
		for(int j=10; j < 41; j=j+10){
			int[] prom = new int[100];
			String[] vert = new String[100];
			int inpSize = 0;
			for(int ins = 1; ins < 11; ins++) {
				String input = currentDir.getAbsolutePath()+ "/enunciado/instEFijos_" + new Integer(j).toString() + "-" + new Integer(ins).toString() + ".in";
				ArrayList<String> inputs = LeerArchivos.leer(input);
				int aux = 0;
				inpSize = inputs.size();
				for(int i=0; i < inputs.size(); i+=2){
					Grafo g = Ej2.crearGrafoDesdeInstancia(inputs.get(i + 1));
					Grafo agm = g.getAgm();
					prom[aux] += agm.getCiclos();
					vert[aux] = inputs.get(i);
					aux++;
				}
			}
			String[] out = new String[inpSize/2];
			for(int ij =0; ij < inpSize / 2;  ij++) {
				prom[ij] = prom[ij] / 10;
				out[ij] = vert[ij] + " " + new Integer(prom[ij]).toString();
			}
			String output = currentDir.getAbsolutePath()+ "/enunciado/instEFijos_" + new Integer(j).toString() + ".out";
			EscribirArchivo.escribir(output, out);
		}
	}
	
	
	public void testVerticesFijos() {
		java.io.File currentDir = new java.io.File("");
		for(int j=10; j < 41; j=j+10){
			int[] prom = new int[100];
			String[] vert = new String[100];
			int inpSize = 0;
			for(int ins = 1; ins < 11; ins++) {
				String input = currentDir.getAbsolutePath()+ "/enunciado/instVFijos_" + new Integer(j).toString() + "-" + new Integer(ins).toString() + ".in";
				ArrayList<String> inputs = LeerArchivos.leer(input);
				int aux = 0;
				inpSize = inputs.size();
				for(int i=0; i < inputs.size(); i+=2){
					Grafo g = Ej2.crearGrafoDesdeInstancia(inputs.get(i + 1));
					Grafo agm = g.getAgm();
					prom[aux] += agm.getCiclos();
					vert[aux] = inputs.get(i);
					aux++;
				}
			}
			String[] out = new String[inpSize/2];
			for(int ij =0; ij < inpSize / 2;  ij++) {
				prom[ij] = prom[ij] / 10;
				out[ij] = vert[ij] + " " + new Integer(prom[ij]).toString();
			}
			String output = currentDir.getAbsolutePath()+ "/enunciado/instVFijos_" + new Integer(j).toString() + ".out";
			EscribirArchivo.escribir(output, out);
		}
	}
}