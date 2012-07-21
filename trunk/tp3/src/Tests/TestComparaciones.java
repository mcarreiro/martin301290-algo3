package Tests;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;

import ejercicios.Ej3;
import ej4.DosPorUnoDiffGrados;
import ej4.ej4;
import ejercicios.ej5;
import ejercicios.grafoFactory;
import ejercicios.ej2;
import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;

import ej4.ConjuntoDominante;

public class TestComparaciones extends TestCase{
	
	public void testCrearGrafo() {
		grafoFactory factory = new grafoFactory();
		ej2 ej2 = new ej2();
		Ej3 ej3 = new Ej3();
		ej4 ej4 = new ej4();
		ej5 ej5 = new ej5();
		long milisegundosS,milisegundosE = 0;
		ArrayList<Grafo.Vertice> CDGreedy;
		ConjuntoDominante CDGrasp,CDLocalSearch;
		List<Grafo.Vertice> CD;
		int kGrasp;
		int kGreedy =1;
		ArrayList<String> listaExacto = new ArrayList<String>();
		ArrayList<String> listaGreedy = new ArrayList<String>();
		ArrayList<String> listaLocal = new ArrayList<String>();
		ArrayList<String> listaGrasp = new ArrayList<String>();
		
		ArrayList<String> listaExactoNodos = new ArrayList<String>();
		ArrayList<String> listaGreedyNodos = new ArrayList<String>();
		ArrayList<String> listaLocalNodos = new ArrayList<String>();
		ArrayList<String> listaGraspNodos = new ArrayList<String>();
		for(int i =1;i<=100;i++){
			Grafo g = factory.grafoAleatorio(i, 30);
			
			if(i < 25){
			milisegundosS = System.nanoTime();	
			CD = ej2.obtenerConjuntoDominanteMinimo(g);
			milisegundosE = System.nanoTime();
			listaExacto.add(i+" "+ (milisegundosE-milisegundosS));
			listaExactoNodos.add(i+" "+CD.size());
			}
			milisegundosS = System.nanoTime();			
			CDGreedy = ej3.MCD_Greedy(g, kGreedy);
			milisegundosE = System.nanoTime();
			listaGreedy.add(i+" "+ (milisegundosE-milisegundosS));
			listaGreedyNodos.add(i+" "+CDGreedy.size());
			g.desmarcarVertices();
			ArrayList<Vertice> dominados = ej4.getListaDominados(g, CDGreedy);
			ConjuntoDominante cd = new ConjuntoDominante(CDGreedy, dominados);
			milisegundosS = System.nanoTime();			
			CDLocalSearch = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
			milisegundosE = System.nanoTime();
			listaLocal.add(i+" "+ (milisegundosE-milisegundosS));
			listaLocalNodos.add(i+" "+CDLocalSearch.getDominantes().size());
			g.desmarcarVertices();
			kGrasp = i/10;
			milisegundosS = System.nanoTime();
			CDGrasp = ej5.MCD_Grasp(g, kGrasp);
			milisegundosE = System.nanoTime();
			listaGrasp.add(i+" "+ (milisegundosE-milisegundosS));
			listaGraspNodos.add(i+" "+ CDGrasp.getDominantes().size());
		}
		
		
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaExacto.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaGreedy.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaLocal.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaGrasp.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaExactoNodos.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaGreedyNodos.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaLocalNodos.get(i));
		}
		System.out.println("e");
		for(int i=0;i<listaExacto.size();i++){
			System.out.println(listaGraspNodos.get(i));
		}
		System.out.println("e");
	}

}
