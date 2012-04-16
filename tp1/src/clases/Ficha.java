package clases;

import java.util.Stack;

public class Ficha {
	public int fila;
	public int columna;
	public Boolean activo;
	public Stack<Integer> pila;
	
	public Ficha(int f, int c){
		fila =f ;
		columna = c;
		activo = true;
		pila = new Stack<Integer>();
	}
}
