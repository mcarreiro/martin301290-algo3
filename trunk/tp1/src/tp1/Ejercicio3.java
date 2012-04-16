package tp1;

import java.util.Stack;
import clases.Movimiento;
import clases.Tablero;
import clases.Ficha;


public class Ejercicio3 {
		public int universal;
		public int ciclos;
		
		public Ejercicio3()
		{
		 universal = 0;
		 ciclos=0;
		}
		public Stack<Movimiento> doIT(Tablero tablero){ 
			 Stack<Movimiento> pila = new  Stack<Movimiento>();
			 Solucion(tablero, pila);
			 return pila;
		}
		
		public Boolean Solucion(Tablero tablero,Stack<Movimiento> pila){
			if(tablero.CantFichas()==1){
				//CASO BASE
				//Si la cantidad de fichas del tablero es 1 devuelvo que ya se encontro soluci�n al tablero
				return true;
			}else{
				
				for(int i=0;i < tablero.fichas.length;i++){	//Recorro todas las fichas					//O(t)
					Ficha ficha = tablero.fichas[i]; 		//Recupero la ficha de la lista				//O(1)
					if(ficha.activo) 						//Si es una ficha que no fue comida...									//O(1)
							for(int direccion=0;direccion < 4;direccion++){ 							//O(4)
							//direccion = MOVIMIENTOS: 0=ARRIBA 1=ABAJO 2=IZQ 3=DER
																
								//-- Cuenta los ciclos de ejecucion
								universal++;
								if(universal < 0)
								{
									universal =0;
									ciclos++;
								}
								//--
								
								Movimiento mov = new Movimiento(ficha.fila, ficha.columna, direccion);
			  					//Me fijo si se puede realizar ese movimiento...
								if(tablero.EsMovimientoLegal(mov)){						//O(1)
			  						tablero.MoverFicha(mov); //Realizo el movimiento	//O(1)
			  						pila.push(mov);			 //Lo apilo					//O(1)
			  						Boolean res = Solucion(tablero, pila);	//Busco una solucion para esta instancia del tablero //O(4t^t)
			  						if(res)	//Si se encontro una solucion..										//O(1)
										return true; 	
			  						//Si no se encontro...
			  						tablero.DeshacerMoverFicha(mov, i);	//Deshago el movimiento	//O(1)
									pila.pop();	 //Desapilo el movimiento antes realizado		//O(1)
			  					}
			  				}
		  				
				}
				return false;
			}
		}
		
		
}
		
		