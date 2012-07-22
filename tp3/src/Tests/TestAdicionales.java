package Tests;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import archivos.LeerArchivos;
import ej4.ConjuntoDominante;
import ej4.DosPorUnoDiffGrados;
import ej4.DosPorUnoMenorGradoVertice;
import ej4.DosPorUnoSumaTupla;
import ej4.ej4;
import ejercicios.Ej3;
import ejercicios.Grafo;
import ejercicios.Grafo.Vertice;
import ejercicios.ej2;
import junit.framework.TestCase;

public class TestAdicionales extends TestCase {
	/*
	public void testLocalSolucionCompleta() {
		java.io.File currentDir = new java.io.File("");
		String file = "test2.in";
		ArrayList<Grafo>  ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/scripts/instancias/" + file);
		ArrayList<Vertice> dominados, dominantes;
		int nodos = 0;
		for( Grafo g : ListaDeGrafosG) {
			nodos = g.getVertices().size();
			dominantes = Ej3.MCD_Greedy(g, 1);
			String gre = "GREEDY: " + dominantes.size();
			dominados = ej4.getListaDominados(g, dominantes);
			ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(dominantes, dominados),
					new DosPorUnoSumaTupla());
			System.out.println("NODOS: " + nodos + "|" + gre + " | LOCAL: " + solu.getDominantes().size());
		}
	}
	
	public void testExacta() {
		java.io.File currentDir = new java.io.File("");
		String file = "TP3_Random_20-0.2.in";
		ArrayList<Grafo>  ListaDeGrafosG = LeerArchivos.leer(currentDir.getAbsolutePath()+ "/scripts/instancias/" + file);
		ArrayList<Vertice> dominados, dominantes;
		int nodos = 0;
		for( Grafo g : ListaDeGrafosG) {
			nodos = g.getVertices().size();
			//ArrayList<Vertice> solu = new ArrayList<Vertice>(ej2.obtenerConjuntoDominanteMinimo(g));
			//System.out.println("NODOS: " + nodos + "| EXACTA: " + solu.size());
			/*for(Vertice v: solu) {
				System.out.println(v);
			}
		}
	}*/
	
	public void testGraficos() {
		
	}
	
	public void testGrid_GreedyVsExacto(){ // PEOR CASO
		Grafo gG, gE, gL;
		int te, tg, tl;
		int n = 25;
		int m = 20;
		long[][] results = new long[m*n][2];
		ArrayList<Vertice> dominados, dominantes;
		for(int i = 1; i <= n*m; i++){
				results[i-1][0] = -1;
			}
		for(int i = 1; i<=n;i+=1){
			for(int j = 1; j<=m;j+=1){
			
			gG = Ej3.generarGrid(i, j);
			gE = Ej3.generarGrid(i, j);
			gL = Ej3.generarGrid(i, j);
			dominantes = Ej3.MCD_Greedy(gG, 1);
			tg = dominantes.size();
			//te = ej2.obtenerConjuntoDominanteMinimo(gE).size();
			dominados = ej4.getListaDominados(gL, dominantes);
			ConjuntoDominante solu = ej4.MCD_LocalSearch(new ConjuntoDominante(dominantes, dominados),
					new DosPorUnoDiffGrados());
			tl = solu.getDominantes().size();
			System.out.println(gG.getVertices().size()+" " + tg + " " + tl);
			}
		}
	}
	/*
	public void testMobius(){ //PEOR CASO
		Grafo gL, gG;
	
		int n = 500;
		int itera = 3;
		ArrayList<Vertice> dominantes, dominados;

		for(int i = 2; i <= n; i = i +2 ){
				long milisegundosTot = 0;
				gG =  Ej3.generarMobius(i);
				System.out.print(gG.getVertices().size() + " ");
				long milisegundosactuales;
				for(int h = 0; h < itera;h++){
					gG =  Ej3.generarMobius(i);
					gL =  Ej3.generarMobius(i);
					dominantes = Ej3.MCD_Greedy(gG,1);		
					dominados = ej4.getListaDominados(gL, dominantes);
					milisegundosactuales = System.nanoTime();
					
					ej4.MCD_LocalSearch(new ConjuntoDominante(dominantes, dominados),
							new DosPorUnoDiffGrados());
					milisegundosTot += System.nanoTime() - milisegundosactuales;
				}
				System.out.println( milisegundosTot / itera);
				
		}
	}*/

}
