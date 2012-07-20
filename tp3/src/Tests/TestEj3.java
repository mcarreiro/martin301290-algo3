package Tests;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;

import ejercicios.Grafo;
import ejercicios.Ej3;
import ejercicios.ej2;
import ejercicios.Grafo.Vertice;
import ej4.ConjuntoDominante;
import ej4.DosPorUnoDiffGrados;
import ej4.DosPorUnoMenorGradoVertice;
import ej4.DosPorUnoSumaTupla;
import ej4.ej4;
import ej4.ConjuntoDominante.Movimientos;
import ej4.ej4.Funciones;
import junit.framework.TestCase;
import ejercicios.ej5;


public class TestEj3 extends TestCase{
	List<Grafo.Vertice> conj;
	public void testArchivoIN(){
		java.io.File currentDir = new java.io.File("");
		ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();		
		ListaDeGrafos = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		String[] output = new String[ListaDeGrafos.size()]; 

		for(int i = 0; i < ListaDeGrafos.size(); i++){
			conj = Ej3.MCD_Greedy(ListaDeGrafos.get(i),1);
			output[i] = "";
			for(Vertice v : conj) {
				output[i] += v + " "; 
			}
		}
		String file = currentDir.getAbsolutePath()+ "/enunciado/Tp3Goloso.out";
		EscribirArchivo.escribir(file, output);
	}
	
	public void test(){
		//Ej3 ej3 = new Ej3();
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		g.insertarVertice("G", "G");
		g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(b, f, 0);
		conj = Ej3.MCD_Greedy(g,1);
	}
	
	public void test2() {
		//Ej3 ej3 = new Ej3();
		Grafo grafo = new Grafo();
		Grafo.Vertice a = grafo.insertarVertice("A", "A");
		Grafo.Vertice b = grafo.insertarVertice("B", "B");
		Grafo.Vertice c = grafo.insertarVertice("C", "C");
		Grafo.Vertice d = grafo.insertarVertice("D", "D");
		Grafo.Vertice e = grafo.insertarVertice("E", "E");
		Grafo.Vertice f = grafo.insertarVertice("F", "F");
		Grafo.Vertice g = grafo.insertarVertice("G", "G");
		Grafo.Vertice h = grafo.insertarVertice("H", "H");
		Grafo.Vertice i = grafo.insertarVertice("I", "I");
		Grafo.Vertice j = grafo.insertarVertice("J", "J");
		Grafo.Vertice k = grafo.insertarVertice("K", "K");
		Grafo.Vertice l = grafo.insertarVertice("L", "L");
		grafo.agregarArista(a, b, 0);
		grafo.agregarArista(a, c, 0);
		grafo.agregarArista(b, d, 0);
		grafo.agregarArista(a, e, 0);
		grafo.agregarArista(b, f, 0);
		grafo.agregarArista(g, f, 0);
		grafo.agregarArista(g, h, 0);
		grafo.agregarArista(g, i, 0);
		grafo.agregarArista(h, k, 0);
		grafo.agregarArista(k, l, 0);
		grafo.agregarArista(h, j, 0);

		conj = Ej3.MCD_Greedy(grafo,1);
	}
	public void testCompareExacto(){
		java.io.File currentDir = new java.io.File("");	
		ArrayList<Grafo>  ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		ArrayList<Grafo>  ListaDeGrafosE = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");

		for(int i = 0; i < ListaDeGrafosG.size(); i++){
			Ej3.ciclos=0;
			System.out.print("n="+ListaDeGrafosG.get(i).getVertices().size());
			long milisegundosactuales,milisegundos;
			
			milisegundosactuales = System.nanoTime();
			List<Grafo.Vertice> conjG = Ej3.MCD_Greedy(ListaDeGrafosG.get(i),1);
			milisegundos = System.nanoTime() - milisegundosactuales;

			List<Grafo.Vertice> conjE = ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafosE.get(i)); 
			if( conjG.size() != conjE.size() )
				System.out.print(" DISTINTO GR:" + conjG.size() + " EX:"+conjE.size()+" ");

			else
				System.out.print(" IGUAL ");
	        System.out.println("Ciclos:" + Ej3.ciclos + " Ns: "+ milisegundos);
		}
	}
	public void testCrearGrafo() {
		Ej3.ciclos = 0;
		//4 vertices
		String instancia = "1 2 2;1 2 4;2 3 2;2 3 3;2 3 8;3 1 1;3 1 3;3 1 5;1 4 2;1 4 9";
		Grafo g = ej2.crearGrafoDesdeInstancia(instancia);
		//@SuppressWarnings("unused")
		List<Grafo.Vertice> conj = Ej3.MCD_Greedy(g,1);
		assertEquals(conj.size(),1);
		assertEquals(conj.get(0).Dato,"1");
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
		conj.clear();
		Ej3.ciclos = 0;
		//8 vertices
		instancia = "1 2 2;1 3 4;1 4 2;5 6 3;5 7 8;5 8 1";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		assertEquals(conj.size(),2);
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
		conj.clear();
		Ej3.ciclos = 0;

        //10
        conj.clear();
		Ej3.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 9";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
        
        //12
        conj.clear();
		Ej3.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 200;11 200";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
        
        //14
        conj.clear();
		Ej3.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
        
      //16
        conj.clear();
		Ej3.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14;15 16";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
        
      //18
        conj.clear();
		Ej3.ciclos = 0;
		instancia = "1 2;3 4;4 5;5 6;6 7;8 9;10 11;11 12;13 14;15 16;17 18";
		g = ej2.crearGrafoDesdeInstancia(instancia);
		
		conj.addAll(Ej3.MCD_Greedy(g,1));
		System.out.print('\n');
        System.out.print(Ej3.ciclos);
        
	}
	
	public void testGrid(){
		int n = 40;
		int m = 25;
		long[] results = new long[m*n];
		for(int i = 1; i <= n*m; i++){
				results[i-1] = -1;
			}
		int itera = 10;

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				long milisegundosTot = 0;
				Grafo g=  Ej3.generarGrid(i, j);
				//System.out.print(g.getVertices().size());
				long milisegundosactuales,milisegundos;
				for(int h = 0; h < itera;h++){
					g =   Ej3.generarGrid(i, j);
					milisegundosactuales = System.nanoTime();
					ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);		
					milisegundosTot += System.nanoTime() - milisegundosactuales;
				}
				//System.out.println(" "+ milisegundosTot/100);
				if(results[g.getVertices().size()-1] == -1)
					results[g.getVertices().size()-1] = milisegundosTot/itera;				
		        
			}
		}
	
			for(int j = 1; j <= m*n; j++){
				long milisegundosTot = 0;
				Grafo g=  Ej3.generarGrid(1, j);
				//System.out.print(g.getVertices().size());
				if(results[g.getVertices().size()-1] == -1){
					long milisegundosactuales,milisegundos;
					for(int h = 0; h < itera;h++){
						g =   Ej3.generarGrid(1, j);
						milisegundosactuales = System.nanoTime();
						ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);		
						milisegundosTot += System.nanoTime() - milisegundosactuales;
					}
					//System.out.println(" "+ milisegundosTot/100);
					
						results[g.getVertices().size()-1] = milisegundosTot/itera;				
				}
			}
		
		for(int i = 1; i <= n*m; i++){
			if(results[i-1] != -1){
				System.out.print(i+" ");
				System.out.println(results[i-1]);
			}
		}
	}

public void testInstancias(){

		ArrayList<String>  instancias = new ArrayList<String>();
		instancias.add("2 2 0;1 1 0");
		instancias.add("3 3 0;1 3 0;3 1 0");
		instancias.add("2 2 0;2 4 0;2 1 0;1 1 0");
		instancias.add("1 2 0;2 5 0;4 4 0;5 5 0;2 2 0");
		instancias.add("4 5 0;5 1 0;3 2 0;6 4 0;1 1 0;5 4 0");
		instancias.add("1 5 0;7 3 0;5 3 0;4 6 0;3 1 0;4 4 0;3 2 0");
		instancias.add("8 7 0;3 1 0;6 5 0;7 1 0;3 7 0;5 8 0;7 6 0;4 8 0");
		instancias.add("2 9 0;4 7 0;7 6 0;8 8 0;2 8 0;3 7 0;8 9 0;6 4 0;8 1 0");
		instancias.add("1 2 0;10 7 0;2 6 0;6 10 0;7 5 0;2 1 0;3 4 0;6 10 0;8 6 0;6 7 0");
		instancias.add("2 3 0;10 8 0;4 3 0;4 10 0;9 9 0;6 9 0;10 11 0;3 11 0;10 8 0;4 7 0;4 6 0");
		instancias.add("9 2 0;1 6 0;9 4 0;5 6 0;3 1 0;7 6 0;11 7 0;3 8 0;3 12 0;1 4 0;1 11 0;8 12 0");
		instancias.add("9 11 0;10 6 0;11 3 0;5 11 0;1 4 0;7 10 0;6 5 0;13 7 0;9 3 0;10 5 0;12 9 0;5 4 0;10 3 0");
		instancias.add("2 13 0;2 12 0;6 10 0;14 12 0;6 9 0;7 14 0;5 11 0;11 1 0;1 4 0;11 11 0;7 5 0;3 3 0;6 1 0;5 11 0");
		instancias.add("12 3 0;2 13 0;13 10 0;12 6 0;12 14 0;3 8 0;9 8 0;2 15 0;10 5 0;8 7 0;13 9 0;10 13 0;6 2 0;15 13 0;3 15 0");
		instancias.add("3 1 0;14 1 0;3 6 0;10 3 0;1 3 0;1 2 0;10 4 0;4 16 0;13 10 0;12 6 0;14 15 0;11 9 0;13 11 0;5 9 0;15 11 0;9 16 0");
		instancias.add("14 2 0;16 10 0;13 4 0;9 5 0;4 11 0;4 4 0;12 16 0;12 9 0;2 10 0;16 7 0;13 9 0;5 17 0;12 6 0;4 6 0;9 14 0;15 10 0;6 7 0");
		instancias.add("11 18 0;8 8 0;11 15 0;14 7 0;8 7 0;7 7 0;5 7 0;4 7 0;6 8 0;16 13 0;16 7 0;11 13 0;2 8 0;6 9 0;6 7 0;4 7 0;1 4 0;7 2 0");
		instancias.add("16 19 0;2 13 0;10 17 0;16 2 0;3 2 0;9 5 0;1 12 0;10 15 0;15 13 0;17 5 0;13 7 0;14 16 0;11 18 0;10 7 0;19 6 0;1 19 0;5 13 0;11 5 0;10 11 0");
		instancias.add("1 13 0;17 16 0;15 18 0;10 3 0;15 15 0;18 7 0;17 3 0;9 12 0;15 15 0;9 2 0;7 17 0;10 8 0;11 2 0;14 8 0;9 6 0;12 17 0;15 7 0;9 3 0;1 8 0;2 13 0");
		instancias.add("4 18 0;1 13 0;15 12 0;20 10 0;21 11 0;5 3 0;4 19 0;20 4 0;3 6 0;4 13 0;20 9 0;7 9 0;5 19 0;16 16 0;17 20 0;17 4 0;11 1 0;3 4 0;19 20 0;9 12 0;16 12 0");
		instancias.add("7 9 0;5 11 0;14 4 0;9 2 0;1 4 0;22 9 0;1 22 0;8 4 0;4 21 0;16 16 0;8 4 0;5 8 0;3 1 0;11 15 0;13 16 0;15 20 0;9 15 0;10 17 0;6 3 0;2 4 0;21 21 0;4 9 0");
		instancias.add("9 1 0;15 2 0;22 11 0;20 23 0;5 14 0;11 17 0;4 21 0;19 19 0;21 12 0;4 20 0;13 15 0;9 8 0;2 11 0;4 7 0;7 2 0;6 12 0;3 22 0;7 17 0;23 9 0;17 3 0;20 1 0;7 21 0;14 8 0");
		instancias.add("3 18 0;9 3 0;13 24 0;21 19 0;13 11 0;10 13 0;21 15 0;11 15 0;13 2 0;13 24 0;17 6 0;7 17 0;17 20 0;5 21 0;10 8 0;16 11 0;21 5 0;10 21 0;14 19 0;4 18 0;24 2 0;7 24 0;14 20 0;6 9 0");
		instancias.add("6 13 0;13 16 0;18 1 0;6 22 0;2 2 0;9 24 0;18 16 0;16 22 0;21 13 0;15 21 0;24 6 0;25 8 0;17 11 0;10 10 0;9 21 0;19 16 0;10 7 0;3 21 0;4 11 0;14 9 0;17 3 0;7 25 0;10 13 0;25 25 0;15 2 0");
		instancias.add("26 23 0;9 20 0;8 9 0;16 20 0;26 8 0;10 13 0;16 3 0;5 8 0;19 14 0;4 13 0;8 21 0;24 19 0;12 24 0;15 9 0;5 20 0;2 23 0;14 22 0;8 26 0;15 18 0;26 11 0;18 9 0;5 9 0;23 23 0;16 8 0;7 1 0;10 14 0");
		instancias.add("22 8 0;12 5 0;27 12 0;21 13 0;14 23 0;26 14 0;21 24 0;20 18 0;20 20 0;26 11 0;15 16 0;24 27 0;20 2 0;2 11 0;6 22 0;24 10 0;27 8 0;13 16 0;1 12 0;12 3 0;24 20 0;2 4 0;16 13 0;21 26 0;7 25 0;21 14 0;11 16 0");
		instancias.add("13 2 0;15 19 0;24 12 0;2 27 0;24 22 0;5 16 0;18 28 0;23 12 0;2 8 0;6 26 0;20 28 0;8 24 0;4 17 0;26 16 0;15 12 0;26 13 0;5 4 0;25 12 0;26 28 0;26 1 0;15 27 0;24 2 0;21 14 0;24 28 0;2 18 0;9 4 0;3 5 0;17 15 0");
		instancias.add("4 20 0;9 12 0;17 29 0;12 25 0;29 27 0;27 19 0;26 26 0;16 27 0;4 12 0;19 6 0;18 11 0;7 4 0;29 24 0;16 7 0;3 14 0;26 23 0;25 5 0;9 22 0;2 12 0;11 3 0;28 1 0;23 19 0;24 16 0;15 23 0;28 18 0;29 22 0;1 1 0;19 27 0;5 26 0");
		instancias.add("22 3 0;2 11 0;17 21 0;15 5 0;29 7 0;23 9 0;7 16 0;18 29 0;24 11 0;10 28 0;30 2 0;15 27 0;12 18 0;25 23 0;7 10 0;2 11 0;23 3 0;16 9 0;23 28 0;3 20 0;18 25 0;28 3 0;21 11 0;13 1 0;14 21 0;13 24 0;13 6 0;11 16 0;12 26 0;19 8 0");
		/*
		for(int i = 0; i < instancias.size() && false; i++){
			long milisegundosTot = 0;
			Grafo gG =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			Ej3.ciclos=0;
			System.out.print(gG.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 1000;j++){
				gG =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				@SuppressWarnings("unused")
				List<Grafo.Vertice> conjG = Ej3.MCD_Greedy(gG,1);
				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/1000);
	        
		}*/
		
		System.out.println("LS");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gLS =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gLS.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 100;j++){
				gLS =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				@SuppressWarnings("unused")
				ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(gLS,1);		
				ArrayList<Vertice> dominados = ej4.getListaDominados(gLS, dominantes);		
				ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
				ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/100);
	        
		}
		/*
		for(int k = 1; k < 29; k++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(instancias.size()-1));
			Ej3.ciclos=0;
			System.out.print(k);
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(instancias.size()-1));
				milisegundosactuales = System.nanoTime();				
				ej5.MCD_Grasp(gGr,k);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10000000);
	        
		}*//*
		System.out.println("K=5");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gGr.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				
				ej5.MCD_Grasp(gGr,5);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10);
	        
		}System.out.println("K=10");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gGr.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				
				ej5.MCD_Grasp(gGr,10);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10);
	        
		}*/
		System.out.println("K=15");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gGr.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 100;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				
				ej5.MCD_Grasp(gGr,15);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/100);
	        
		}/*
		System.out.println("K=20");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gGr.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				
				ej5.MCD_Grasp(gGr,20);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10);
	        
		}
		System.out.println("K=25");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			System.out.print(gGr.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gGr =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				
				ej5.MCD_Grasp(gGr,25);

				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10);
	        
		}
		System.out.println("EXACTO");

		for(int i = 0; i < instancias.size(); i++){
			long milisegundosTot = 0;
			Grafo gE =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
			Ej3.ciclos=0;
			System.out.print(gE.getVertices().size());
			long milisegundosactuales,milisegundos;
			
			for(int j = 0; j < 10;j++){
				gE =  ej2.crearGrafoDesdeInstancia(instancias.get(i));
				milisegundosactuales = System.nanoTime();
				ej2.obtenerConjuntoDominanteMinimo(gE); 				
				milisegundosTot += System.nanoTime() - milisegundosactuales;
			}
			System.out.println(" "+ milisegundosTot/10);
			
			
			
	        
		}*/
	}
}
