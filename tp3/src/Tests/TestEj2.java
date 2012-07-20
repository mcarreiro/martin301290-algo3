package Tests;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;

import ejercicios.Ej3;
import ejercicios.grafoFactory;
import ejercicios.ej2;
import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;
import junit.framework.TestCase;

public class TestEj2 extends TestCase {
	List<Grafo.Vertice> conj;
	private void testArchivoIN(){
		java.io.File currentDir = new java.io.File("");
		ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();		
		ListaDeGrafos = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		String[] output = new String[ListaDeGrafos.size()]; 

		for(int i = 0; i < ListaDeGrafos.size(); i++){
			conj = ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafos.get(i));
			output[i] = "";
			for(Vertice v : conj) {
				output[i] += v + " "; 
			}
		}
		String file = currentDir.getAbsolutePath()+ "/enunciado/Tp3exacto.out";
		EscribirArchivo.escribir(file, output);
	}
	
	
	
	public void testCrearGrafo() {
		grafoFactory factory = new grafoFactory();
		ej2 ej2 = new ej2();
		for(int i =1;i<=20;i++){
			Grafo g = factory.grafoAleatorio(i, 1);
			List<Grafo.Vertice> CD = ej2.obtenerConjuntoDominanteMinimo(g);
			System.out.println(i+" "+ej2.ciclos);
			ej2.ciclos = 0;
		}
		
//		for(int i =2;i<=20;i++){
//			Grafo g = factory.estrella(i);
//			List<Grafo.Vertice> CD = ej2.obtenerConjuntoDominanteMinimo(g);
//			System.out.println(i+" "+ej2.ciclos);
//			ej2.ciclos = 0;
//		}
		
//		for(int i =3;i<=20;i++){
//			Grafo g = factory.clique2(i);
//			List<Grafo.Vertice> CD = ej2.obtenerConjuntoDominanteMinimo(g);
//			System.out.println(i+" "+ej2.ciclos);
//			ej2.ciclos = 0;
//		}
		
	}

}
