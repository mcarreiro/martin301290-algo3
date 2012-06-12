package archivos;
import java.io.*;
import java.util.*;
public class LeerArchivos {
	public static ArrayList<String> leer (String dir) {
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
	      return result;
	      
	      
	      
	   }

}
