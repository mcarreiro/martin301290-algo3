package Tests;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;

import ej4.ConjuntoDominante;
import ej4.DosPorUnoDiffGrados;
import ej4.DosPorUnoMenorGradoVertice;
import ej4.DosPorUnoSumaTupla;
import ej4.ej4;
import ej4.ConjuntoDominante.Movimientos;
import ej4.ej4.Funciones;
import ejercicios.Ej3;
import ejercicios.Grafo;
import ejercicios.ej2;
import ejercicios.Grafo.Vertice;
import junit.framework.TestCase;



public class TestEj4 extends TestCase {
	
	public void testVertices() {
		Grafo g = new Grafo();
		Vertice v = g.insertarVertice("v1", "dato");
		Vertice v2 =  g.insertarVertice("v2", "dato2");
		HashSet<Vertice> hs = new HashSet<Vertice>();
		hs.add(v); hs.add(v2);
		hs.remove(v); hs.remove(v2);
		assertEquals(hs.size(), 0);
	}
	
	public void testCalcularDominados() {
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
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		assertEquals(g.getVertices().size(), dominados.size() + dominantes.size() );
	}
	
	public void testCrearConjuntoDominante() {
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
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		assertEquals(g.getVertices().size(), cd.getDominados().size() + cd.getDominantes().size());
	}
	
	public void testLocalSearch() {
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
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		// size 4
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// size 4
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(cd.getDominantes().size(), solu.getDominantes().size());
	}
	
	public void testLocalSearchMejora1() {
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
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// agrego un no dominado a dominante para ver si encuentra algo mejor
		dominantes.add(dominados.remove(0));
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(solu.getDominantes().size(), 4);
	}
	
	public void testLocalSearchMejora2() {
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
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// agrego un no dominado para poder hacer 2 x 1
		dominantes.remove(b);
		dominados.add(b);
		dominantes.add(f); dominantes.add(d);
		dominados.remove(f); dominados.remove(d);
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(solu.getDominantes().size(), 4);
	}
	
	// aca testear el 1x1
	public void testLocalSearchMejora3() {
		Grafo g = new Grafo();
		Grafo.Vertice a = g.insertarVertice("A", "A");
		Grafo.Vertice b = g.insertarVertice("B", "B");
		Grafo.Vertice c = g.insertarVertice("C", "C");
		Grafo.Vertice d = g.insertarVertice("D", "D");
		Grafo.Vertice e = g.insertarVertice("E", "E");
		Grafo.Vertice f = g.insertarVertice("F", "F");
		Vertice gf = g.insertarVertice("G", "G");
		//Vertice h = g.insertarVertice("H", "H");
		g.agregarArista(a, b, 0);
		g.agregarArista(a, c, 0);
		g.agregarArista(a, e, 0);
		g.agregarArista(a, d, 0);
		g.agregarArista(b, d, 0);
		g.agregarArista(b, c, 0);
		g.agregarArista(b, e, 0);
		g.agregarArista(d, gf, 0);
		g.agregarArista(d, f, 0);;
		ArrayList<Grafo.Vertice> dominantes = Ej3.MCD_Greedy(g,1);
		ArrayList<Vertice> dominados = ej4.getListaDominados(g, dominantes);
		// agrego algo para que sea 1x1
		// creo el conjunto dominante, y busco la solucion
		ConjuntoDominante cd = new ConjuntoDominante(dominantes, dominados);
		ConjuntoDominante solu = ej4.MCD_LocalSearch(cd, new DosPorUnoDiffGrados());
		assertEquals(solu.getDominantes().size(), 2);
	}
	
	// aca escribe el archivo de salida, out
	public void testCatedra(){
		ArrayList<Vertice> conj, dominados;
		java.io.File currentDir = new java.io.File("");
		ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();		
		ArrayList<ConjuntoDominante> instancias = new ArrayList<ConjuntoDominante>();
		ListaDeGrafos = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		for(int i = 0; i < ListaDeGrafos.size(); i++){
			conj = Ej3.MCD_Greedy(ListaDeGrafos.get(i),1);
			dominados = ej4.getListaDominados(ListaDeGrafos.get(i), conj);
			instancias.add(new ConjuntoDominante(conj, dominados));
		}
		int solGreedy, solLocal, i = 0, nodos = 0;
		String[] output = new String[ListaDeGrafos.size()]; 
		for(ConjuntoDominante in : instancias ) {
			nodos = in.getDominantes().size() + in.getDominados().size();
			solGreedy = in.getDominantes().size();
			// utilizo la funcion que elegimos a partir de los resultados anteriores
			// DiffGrados
			ConjuntoDominante solu = ej4.MCD_LocalSearch(in, new DosPorUnoDiffGrados());
			solLocal = solu.getDominantes().size();
			//System.out.println(nodos + " " + solLocal);
			assertTrue(solLocal <= solGreedy);
			output[i] = "";
			for(Vertice v : solu.getDominantes()) {
				output[i] += v + " "; 
			}
			i++;
		}
		String file = currentDir.getAbsolutePath()+ "/enunciado/Tp3LocalSearch.out";
		// escribo archibos para el tiempo
		EscribirArchivo.escribir(file, output);
	}
	/*
	public void testComparacionMetodosGraficos() {
		java.io.File currentDir = new java.io.File("");	
		ArrayList<Grafo>  ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3_comp.in");
		ArrayList<Grafo>  ListaDeGrafosE = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3_comp.in");
		String[] outTExacto, outTGreedy, outTLocal, outNumExacto, outNumGreedy, outNumLocal;
		outTExacto = new String[ListaDeGrafosG.size()];
		outTGreedy = new String[ListaDeGrafosG.size()];
		outTLocal = new String[ListaDeGrafosG.size()];
		outNumExacto = new String[ListaDeGrafosG.size()];
		outNumGreedy = new String[ListaDeGrafosG.size()];
		outNumLocal = new String[ListaDeGrafosG.size()];
		ArrayList<Vertice> dominados, dominantes;
		for(int i = 0; i < ListaDeGrafosG.size(); i++){
			int repeticiones = 10, nodos = ListaDeGrafosE.get(i).getVertices().size();;
			long tExacto = 0, tGreedy = 0, tLocal = 0, actual = 0;
			int solExacto = 0, solGreedy = 0, solLocal = 0;
			for( int j = 0 ; j < repeticiones; j++ ) {
				System.out.println("Nodos: " + nodos);
				// calculo los valores para el exacto
				actual = System.nanoTime();
				List<Grafo.Vertice> conjE = ej2.obtenerConjuntoDominanteMinimo(ListaDeGrafosE.get(i));
				tExacto += System.nanoTime() - actual;
				solExacto += conjE.size();
				// calculo los valores para el greedy
				actual = System.nanoTime();
				dominantes = Ej3.MCD_Greedy(ListaDeGrafosG.get(i).desmarcarVertices(),1);
				tGreedy += System.nanoTime() - actual;
				solGreedy += dominantes.size();
				dominados = ej4.getListaDominados(ListaDeGrafosG.get(i).desmarcarVertices(), dominantes);
				// calculo los valores para el localSearch
				actual = System.nanoTime();
				ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(dominantes, dominados), 
						new DosPorUnoDiffGrados());
				tLocal += System.nanoTime() - actual;
				solLocal +=  solu.getDominantes().size();
			}
			// tiempos
			tExacto = tExacto / repeticiones;
			tLocal = tLocal / repeticiones;
			tGreedy = tGreedy / repeticiones;
			outTExacto[i] = nodos + " " + tExacto;
			outTGreedy[i] = nodos + " " + tGreedy;
			outTLocal[i] = nodos + " " + tLocal;
			// soluciones
			solExacto = solExacto / repeticiones;
			solLocal = solLocal / repeticiones;
			solGreedy = solGreedy / repeticiones;
			outNumExacto[i] = nodos + " " + solExacto;
			outNumLocal[i] = nodos + " " + solLocal;
			outNumGreedy[i] = nodos + " " + solGreedy;
		}
		String output = currentDir.getAbsolutePath()+ "/informe/graficos/ej4Data-";
		// escribo archibos para el tiempo
		EscribirArchivo.escribir(output + "tExacto", outTExacto);
		EscribirArchivo.escribir(output + "tLocal", outTLocal);
		EscribirArchivo.escribir(output + "tGreedy", outTGreedy);
		// para el cardinal de soluciones
		EscribirArchivo.escribir(output + "sExacto", outNumExacto);
		EscribirArchivo.escribir(output + "sLocal", outNumLocal);
		EscribirArchivo.escribir(output + "sGreedy", outNumGreedy);
	}
	
	@SuppressWarnings("unchecked")
	public void testNuevosGreedy() {
		java.io.File currentDir = new java.io.File("");	
		ArrayList<Grafo> ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		// leo el archivo
		ArrayList<Vertice> dominados, dominantes;
		int solGreedy, solLocal;
		for(int i = 0; i < ListaDeGrafosG.size(); i++){
			dominantes = Ej3.MCD_Greedy(ListaDeGrafosG.get(i),1);
			solGreedy = dominantes.size();
			dominados = ej4.getListaDominados(ListaDeGrafosG.get(i), dominantes);
			for( Funciones f : Funciones.values() ) {
				ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(
						((ArrayList<Vertice>)dominantes.clone()), (ArrayList<Vertice>)dominados.clone()), 
						ej4.getInstanciaFuncion(f));
				solLocal = solu.getDominantes().size();
				assertTrue(solLocal <= solGreedy);
				
			}
		}
	}
	
	// ademas, escribo el archivo de salida para el greedy
	@SuppressWarnings("unchecked")
	public void test100Nodos() {
		java.io.File currentDir = new java.io.File("");	
		ArrayList<Grafo> ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/scripts/TP3_Random_50-100.in");
		ArrayList<Vertice> dominados, dominantes;
		int solGreedy, solLocal;
		for(int i = 0; i < ListaDeGrafosG.size(); i++){
			dominantes = Ej3.MCD_Greedy(ListaDeGrafosG.get(i),1);
			solGreedy = dominantes.size();
			dominados = ej4.getListaDominados(ListaDeGrafosG.get(i), dominantes);
			for( Funciones f : Funciones.values() ) {
				ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(
						((ArrayList<Vertice>)dominantes.clone()), (ArrayList<Vertice>)dominados.clone()), 
						ej4.getInstanciaFuncion(f));
				solLocal = solu.getDominantes().size();
				assertTrue(solLocal <= solGreedy);
			}	
		}
	}*/
	
	public void testLocalSolucionCompleta() {
		java.io.File currentDir = new java.io.File("");	
		ArrayList<Grafo>  ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		ArrayList<Vertice> dominados, dominantes;
		int nodos = 0;
		for( Grafo g : ListaDeGrafosG) {
			nodos = g.getVertices().size();
			dominantes = new ArrayList<Vertice>(g.getVertices().values());
			dominados = ej4.getListaDominados(g, dominantes);
			ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(dominantes, dominados),
					new DosPorUnoSumaTupla());
			//System.out.println(nodos + " " + solu.getDominantes().size());
		}
	}
}
