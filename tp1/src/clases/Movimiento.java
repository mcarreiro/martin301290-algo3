package clases;

public class Movimiento{
	int fila;
	int columna;
	int direccion;
	
	public Movimiento(int f, int c, int d)
	{
		fila = f;
		columna = c;
		direccion = d;
	}
	
	public int Fila(){
		return fila;
	}
	public int Columna(){
		return columna;
	}
	public int Direccion(){
		return direccion;
	}
}
