package tp1.test;

import junit.framework.TestCase;

import java.awt.print.Printable;
import java.io.Console;
import java.util.*;

import archivos.EscribirArchivo;
import archivos.LeerArchivos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import tp1.Ejercicio3;
import clases.Movimiento;
import clases.Tablero;
import clases.Tablero;


public class Ejercicio3Test extends TestCase {

	
	public void test3(){
		java.io.File currentDir = new java.io.File("");
		LeerArchivos reader = new LeerArchivos();
		ArrayList<String> inputs = reader.leer(currentDir.getAbsolutePath()+ "/enunciadoTP1/Tp1Ej3.in");
		String[] resultado = new String[inputs.size()/2];
		String[] estadistica = new String[inputs.size()*2];
		String[] logs = new String[inputs.size()*2];

		int est = 0;
		for(int i=0;i<inputs.size();i=i+2){
			String[] medidas = inputs.get(i).split(" ");
			String[] fichas = inputs.get(i+1).split(";");
			
			int filas = Integer.parseInt(medidas[0]);
			int columnas = Integer.parseInt(medidas[1]);
			
			Tablero tablero = new Tablero(filas, columnas);				
			String sFichas = "";
			int f=0;
			for(f=0;f<fichas.length;f++){
				String[] posicion = fichas[f].trim().split(" ");
				int fila = Integer.parseInt(posicion[0]);
				int columna = Integer.parseInt(posicion[1]);
				sFichas += fila + " " + columna + ";";
				tablero.AgregarFicha(fila-1, columna-1);
			}
			Ejercicio3 ej3 = new Ejercicio3();
			Stack<Movimiento> cola = ej3.doIT(tablero);
			Boolean result = cola.size() > 0;
			
			
			String linea = "";
			if(result)
			{
				int index = 0;
				while(index < cola.size())
				{
					Movimiento mov = cola.elementAt(index);
					
					int fila = mov.Fila() + 1;
					int col = mov.Columna() +1;
			
					linea+=(fila + " " +col + ";");
					switch(mov.Direccion()){
					case 0:	linea+=((fila-2) + " " +col + ";"); break;
					case 1:	linea+=((fila+2) + " " + col + ";"); break;
					case 2:	linea+=(fila + " " + (col-2) + ";"); break;
					case 3:	linea+=(fila + " " + (col+2) + ";"); break;

					}
					index++;
				}
				linea = linea.substring(0, linea.length()-1);
			}else
				linea+=("");
			
			resultado[i/2] = linea;			
			estadistica[est] ="FxC: "+ filas + " " + columnas;
			estadistica[est+1] = "Fichas: " + sFichas;
			estadistica[est+2] = "Solucion: " + linea;
			estadistica[est+3] = "Ciclos: " + ej3.universal + " + 2'32 * " + ej3.ciclos;
			logs[est] =" ";
			logs[est+1] = "Fichas: " + (f);
			logs[est+2] = "Solucion: " + (result ? "Si": "No");
			logs[est+3] = "Ciclos: " + ej3.universal + (ej3.ciclos > 0 ? ( " + 2'32 * " + ej3.ciclos ): "");
			est = est +4;
			
		}
		EscribirArchivo.escribir(currentDir.getAbsolutePath() + "/enunciadoTP1/Tp1Ej3.out",resultado);
		EscribirArchivo.escribir(currentDir.getAbsolutePath() + "/enunciadoTP1/Tp1Ej3_Estadisticas.out",estadistica);
		EscribirArchivo.escribir(currentDir.getAbsolutePath() + "/enunciadoTP1/Tp1Ej3_Logs.out",logs);

		for(int a = 0; a < estadistica.length; a++)
			System.out.println(estadistica[a]);
		System.out.println("FIN ARCHIVOS");
	}
}