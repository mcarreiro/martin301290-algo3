package Ejercicios;

import java.util.ArrayList;

import Archivos.*;
import Ejercicios.Grafo.Vertice;



public class Ej2 {
	
	public Ej2() {
		
	}
	
	public static Grafo crearGrafoDesdeInstancia(String instancia) {
		Grafo g = new Grafo();
		String enlaceDelim = ";";
		String[] in = instancia.split(enlaceDelim);
		for(int i =0; i < in.length; i++) {
			String enlace = in[i];
			String delim = " ";
			String[] enlaceInfo = enlace.split(delim);
			Vertice v1 = g.insertauObtenerVertice(enlaceInfo[0], enlaceInfo[0]); 
			Vertice v2 = g.insertauObtenerVertice(enlaceInfo[1], enlaceInfo[1]);
			g.agregarArista(v1, v2, new Integer(enlaceInfo[2]));
		}
		return g;
	}
	
	public static void doIt(String inputFile, String outputFile) {
		ArrayList<String> inputs = LeerArchivos.leer(inputFile);
        String[] out = new String[inputs.size()];
        for(int i=0;i<inputs.size();i++){
                Grafo res = Ej2.crearGrafoDesdeInstancia(inputs.get(i));
                out[i] = res.getAgm().toString();
        }
        EscribirArchivo.escribir(outputFile, out);
	}


}
