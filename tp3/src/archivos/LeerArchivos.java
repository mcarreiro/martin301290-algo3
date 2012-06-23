package archivos;
import java.io.*;

import java.util.*;
import ejercicios.Grafo;
//import ejercicios.Grafo.Arista;
import ejercicios.Grafo.Vertice;


public class LeerArchivos {
	public static ArrayList<Grafo> leer (String dir) {
	      File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      ArrayList<String>  result = new ArrayList<String>();
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (dir);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;	        
	         while((linea=br.readLine())!=null){
	        	result.add(linea);	        		        	
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	      // En el finally cerramos el fichero, para asegurarnos
	      // que se cierra tanto si todo va bien como si salta 
	      // una excepcion.
	      try{                    
	         if( null != fr ){   
	            fr.close();     
	         }                  
	      }catch (Exception e2){ 
	         e2.printStackTrace();
	      }
	      
	      return crearGrafo(result);
	      
	      
	      
	      
	   }
	
	   public static ArrayList<Grafo> crearGrafo (ArrayList<String> dir) {
			int n;
			ArrayList<Grafo> ListaDeGrafos = new ArrayList<Grafo>();
			Grafo g;
			Vertice v;
			Vertice v2;
			String linea;
			String delim = " ";
			int i = 0;
			while( i<dir.size()){
				n = new Integer(dir.get(i));
				g = new Grafo();
				if(n > 0){
					v = g.insertauObtenerVertice(Integer.toString(1), Integer.toString(1));
					for(int a = i+1; a < (n+i);a++){					
						v = g.insertauObtenerVertice(Integer.toString(a), Integer.toString(a));
						linea = dir.get(a);
						String[] adyacentes = linea.split(delim);
						for(int b = 0; b < adyacentes.length;b++){
							v2 = g.insertauObtenerVertice(adyacentes[b], adyacentes[b]);
							g.agregarArista(v, v2, 1);
						}
					}
				}
				ListaDeGrafos.add(g);
				i += n;
			}
			return ListaDeGrafos;
		}

}
