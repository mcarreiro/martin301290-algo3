package clases;

import clases.Movimiento;
import clases.Ficha;
import java.util.Stack;

public class Tablero
{
	public int filas;
	public int columnas;			 
	public int[][] matriz;
	public int cantFichas;
	public Ficha[] fichas;
	
	public Tablero(int f, int c){
		filas = f;
		columnas = c;
		cantFichas = 0;
		matriz = new int[f][c];
		cantFichas = 0;
		fichas = new Ficha[0];
		for(int fc = 0; fc < f; fc++){
			for(int cc = 0; cc < c; cc++){
				matriz[fc][cc] = -1;
			}
		}
	}
	
	public void AgregarFicha(int f, int c){
		if(matriz[f][c] < 0){
			matriz[f][c] = cantFichas;
			//Agrando el arreglo y lo copio
			Ficha[] nuevo = new Ficha[cantFichas+1];
			for(int i = 0; i < fichas.length;i++)
				nuevo[i] = fichas[i];
			fichas = nuevo;
			fichas[cantFichas] = new Ficha(f,c);
			cantFichas++;
		}
	}
	public Boolean HayFicha(int f, int c){
		return matriz[f][c] >= 0 && fichas[matriz[f][c]].activo;
	}
	public int CantFichas(){
		return cantFichas;
	}
	public int Filas(){
		return filas;
	}
	public int Columnas(){
		return columnas;
	}
	
	public void MoverFicha(Movimiento mov){
		CambioValorFichas(mov, true, -1);
		cantFichas--;
		
	}
	
	public void DeshacerMoverFicha(Movimiento mov, int indice){
		CambioValorFichas(mov, false, indice);
		cantFichas++;
	}
	
	private void CambioValorFichas(Movimiento mov, Boolean esMovimiento, int indiceAnt){
		int filaActual 	= mov.Fila();
		int colActual 	= mov.Columna();
		int filaComida	= mov.Fila();
		int filaSalto	= mov.Fila();
		int colComida	= mov.Columna();
		int colSalto	= mov.Columna();
		int direccion 	= mov.Direccion();
		
		switch(direccion){
		case 0: //ARRIBA
			filaComida = filaActual-1;
			filaSalto = filaActual-2;	
		break;
		case 1: //ABAJO
			filaComida = filaActual+1;
			filaSalto = filaActual+2;	
		break;
		case 2: //IZQ
			colComida = colActual-1;
			colSalto = colActual-2;		
		break;
		case 3://DER
			colComida = colActual+1;
			colSalto = colActual+2;	
		break;	
		}
		
		if(esMovimiento){
			//Actualizo la que come
			int indice = matriz[filaActual][colActual];
			fichas[indice].fila  = filaSalto;
			fichas[indice].columna = colSalto;
			fichas[indice].pila.push(matriz[filaComida][colComida]);
			matriz[filaSalto][colSalto] = indice;
 			matriz[filaActual][colActual] = -1; 			
 			
 			//Actualiza la comida
 			fichas[matriz[filaComida][colComida]].activo = false; 
 			matriz[filaComida][colComida] = -1;
		}else{
			//Actualizo la que come
			int indice = indiceAnt;
			
			fichas[indice].fila  = filaActual;
			fichas[indice].columna = colActual;
			matriz[filaActual][colActual] = indice;
 			matriz[filaSalto][colSalto] = -1;
 			
 			int indiceComida = fichas[indice].pila.pop();
 			//Actualiza la comida
 			fichas[indiceComida].activo = true;
 			matriz[filaComida][colComida] = indiceComida;

		}
	}
	
	public Boolean EsMovimientoLegal(Movimiento mov){
		int filaActual 	= mov.Fila();
		int colActual 	= mov.Columna();
		int filaComible	= mov.Fila();
		int filaSalto	= mov.Fila();
		int colComible	= mov.Columna();
		int colSalto	= mov.Columna();
		if(!HayFicha(filaActual,colActual)) return false;
		switch(mov.Direccion()){
		case 0: //ARRIBA
		filaComible = filaActual-1; 
		filaSalto = filaActual-2;
		break;
		case 1: //ABAJO
		filaComible = filaActual+1; 
		filaSalto = filaActual+2;
		break;
		case 2: //IZQ
		colComible = colActual-1;
		colSalto = colActual-2;	
		break;
		case 3://DER
		colComible = colActual+1;
		colSalto = colActual+2;	
		break;	
		}

		return (filaComible >= 0 && 
				filaSalto >= 0 && 
				colComible >= 0 && 
				colSalto >= 0 && 
				filas > filaComible && 
				filas > filaSalto && 
				columnas > colComible && 
				columnas > colSalto && 
				HayFicha(filaComible,colComible) && 
				!HayFicha(filaSalto,colSalto));
	}
	
}


