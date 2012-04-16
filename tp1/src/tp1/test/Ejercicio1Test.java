package tp1.test;

import java.util.ArrayList;

import tp1.Ejercicio1;


import archivos.LeerArchivos;
import archivos.EscribirArchivo;
import junit.framework.TestCase;

public class Ejercicio1Test extends TestCase{
	/**
	 * Este test en realidad genera inputs aleatorios
	 * */
	public void test1(){
		int x;
		int y;
		int valor;
		int valorOld = 0;
		//limites entre los cuales generar cada valor de lso arreglos
		int min=0;
		int max=5;
		String vector1 = "";
		String vector2 = "";
		String[] vectores = new String[196];
		
		for(int i=5;i<200;i = i+2){
			//x es la longitud del 1º array y es un randon entre 1 e i
			//y es la longitud del 2º array y es un randon entre 1 e x
			x = (int) (Math.random() * i + 1);
			y = (int) (Math.random() * x + 1);
			vector1 = "";
			vector2 = "";
			for(int a = 0;a<x;a++){
				//Genero cada valor haciendo un random entre min y max
				valor = (int) (Math.random() * max+min);
				//Validacion extra 
				if(valor >= valorOld){
					vector1 = vector1 + Integer.toString(valor)+" ";
					valorOld = valor;
					//Una vez almacenado el valor cambio los limites
					min = max;
					max = max+5;
				}
			}
			valorOld = 0;
			min=0;
			max=5;
			//Lo mismo que el vecto 1
			for(int a = 0;a<y;a++){
				valor = (int) (Math.random() * max+min);
				if(valor >= valorOld){
					min = max;
					max = max+5;
					valorOld = valor;
					vector2 = vector2 + Integer.toString(valor)+" ";
				}
				
			}
			//Reinicio los limites
			min=0;
			max=5;
			valorOld = 0;
			
			//Almaceno los valores
			vectores[i-5] = vector1;
			vectores[i-4] = vector2;
			
		}
		//Guardo todos los vectores generados
		java.io.File currentDir = new java.io.File("");
		EscribirArchivo.escribir(currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej1Test2.in",vectores);
	
	}
	
	/**
	 * Testea en base a los inputs deseados 
	 * */
	public void test2(){
		
		LeerArchivos reader = new LeerArchivos();
		//Descomentando esto sepuede testear contra el output (1)
		java.io.File currentDir = new java.io.File("");
		//ArrayList<String> output = reader.leer(currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej1.out");
		ArrayList<String> inputs = reader.leer(currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej1Test2.in");
		String[] resultados = new String[inputs.size()/2];
		int a = 0;
		String delim = " ";
		for(int i=0;i<inputs.size();i=i+2){
			//Parseo los 2 arrays
			String[] in = inputs.get(i).split(delim);
			String[] in2 = inputs.get(i+1).split(delim);
		
			Ejercicio1 ej1 = new Ejercicio1();
			ArrayList<Integer> vector1 = new ArrayList<Integer>();			
			ArrayList<Integer> vector2 = new ArrayList<Integer>();
			
			//Transformo la cadena de strings en arays de int
			for(int f=0;f<in.length;f++){
				vector1.add(Integer.parseInt(in[f]));
			}
			for(int f=0;f<in2.length;f++){
				vector2.add(Integer.parseInt(in2[f]));
			}
			//Testeo
			int result = ej1.doIt(vector1, vector2);
			
			//Descomentando esto sepuede testear contra el output (2)
			//assertEquals(result,Integer.parseInt(output.get(a)));
			resultados[a] = (Integer.toString(result));
			a++;
		}
		//Escribe en el output
		EscribirArchivo.escribir(currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej1.out",resultados);
	}
	
	
	
	
}
