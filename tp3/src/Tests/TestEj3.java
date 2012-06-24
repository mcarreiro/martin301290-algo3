package Tests;

import java.util.ArrayList;

import java.util.List;

import archivos.LeerArchivos;

import ejercicios.Grafo;
import ejercicios.Ej3;
import ejercicios.ej2;
import junit.framework.TestCase;

public class TestEj3 extends TestCase{
	List<Grafo.Vertice> conj;
	public void testCatedra(){
		java.io.File currentDir = new java.io.File("");
		ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();		
		ListaDeGrafos = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/enunciado/Tp3.in");
		for(int i = 0; i < ListaDeGrafos.size(); i++){
			conj = Ej3.MCD_Greedy(ListaDeGrafos.get(i),1);
		}
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
}
