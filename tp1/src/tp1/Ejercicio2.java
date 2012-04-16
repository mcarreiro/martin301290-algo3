package tp1;

import java.util.*;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;

public class Ejercicio2 {
	
	public Ejercicio2() {
		this.ciclos = 0;
		this.columnas = 0;
		this.filas = 0;
	}
	
	public int ciclos;
	public int columnas;
	public int filas;
	
	public int contar(ArrayList<ArrayList<Integer>> var1, ArrayList<ArrayList<Integer>> var2, int f, int c) {
		var2.get(f).set(c, new Integer(1));
		int cont = 1;
		// cuento arriba
		if (0 < f && var1.get(f).get(c) == var1.get(f-1).get(c) && var2.get(f-1).get(c) == 0 ) {
			cont += contar(var1, var2, f-1, c);
		}
		// cuento izquierda
		if (0 < c && var1.get(f).get(c) == var1.get(f).get(c-1) && var2.get(f).get(c-1) == 0) {
			cont += contar(var1, var2, f, c-1);
		}
		// cuento abajo
		if ( f < (var1.size()-1) && var1.get(f).get(c) == var1.get(f+1).get(c) && var2.get(f+1).get(c) == 0 ){
			cont += contar(var1, var2, f+1, c);
		}
		// cuento derecha
		if (c < var1.get(f).size() -1 && var1.get(f).get(c) == var1.get(f).get(c+1) && var2.get(f).get(c+1) == 0 ) {
			cont += contar(var1, var2, f, c+1);
		}
		this.ciclos++;
		return cont;
	}
	
	public int resolver(ArrayList<ArrayList<Integer>> var1) {
		ArrayList<ArrayList<Integer>> var2 = new ArrayList<ArrayList<Integer>>();
		int cont = 0, acum = 0;
		// Inicializo un nuevo array con el mismo tamaño que el otro con todas
		// las posiciones en 0
		for(int f=0; f< var1.size(); f++) {
			for(int c=0; c < var1.get(f).size(); c++) {
				if ( c == 0) var2.add(new ArrayList<Integer>());
				var2.get(f).add(c, new Integer(0));
				this.ciclos++;
			}
		}
		//O(count($var1)+count($var2)) = O(|var1|+ |var2|)
		for(int f=0; f < var1.size(); f++) {
			for(int c=0; c < var1.get(f).size();c++){
				if( var2.get(f).get(c) == 0 ){ // ver si es new Integer(0)
					cont = this.contar(var1, var2, f, c);
					if (cont > acum) acum = cont;
				}
			}
		}
		return acum;
	}
	
	public ArrayList<ArrayList<Integer>> crearArray(int n, int m, String numbers ) {
		this.columnas = n;
		this.filas = m;
		String delim = " ";
		String[] in = numbers.split(delim);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i < m; i++ ) {
			res.add( new ArrayList<Integer>());
			for(int j=0; j < n; j++) {
				// agrego los numeros para celda i,j
				res.get(i).add(Integer.parseInt(in[(i*n) + j]));
				this.ciclos++;
			}
		}
		return res;
	}
	
	public static void correrEjercicio(String inputFile, String outputFile) {
		ArrayList<String> inputs = LeerArchivos.leer(inputFile);
		String[] out = new String[inputs.size() / 2];
		int j = 0;
		for(int i=0;i<inputs.size();i=i+2){
			// leo cada 2 lineas
			String delim = " ";
			String[] in = inputs.get(i).split(delim);
			String numeros = inputs.get(i+1);
			// creo la instancia del ej. 2
			// leo el archivo de entrada, y creo tantas instancias de EJ2 como sea necesario
			Ejercicio2 ej = new Ejercicio2();
			ArrayList<ArrayList<Integer>> var1 = ej.crearArray(Integer.parseInt(in[0]), Integer.parseInt(in[1]) , numeros);
			int res = ej.resolver(var1);
			//System.out.println( ej.columnas * ej.filas + " " + ej.ciclos);
			// escribo en el archivo de salida
			out[j] = Integer.toString(res);
			j++;
		}
		EscribirArchivo.escribir(outputFile, out);
	}
	
}