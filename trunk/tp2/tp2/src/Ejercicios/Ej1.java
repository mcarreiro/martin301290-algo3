package Ejercicios;

import java.util.*;

public class Ej1 {
	public int resolver(int energia, int capacidad, ArrayList< Integer > pisos){
		int cantPersonas = 0;
		int cantPersonasAux = 0;
		int energiaAux;
		ArrayList< Integer > pisosAux;
		for(int i = (pisos.size() - 1); i >= 0 ;i--){
			energiaAux = energia;
			cantPersonasAux = 0;
			pisosAux = (ArrayList< Integer >)pisos.clone();
			//levanto de cada piso de forma tal q me llene la capacidad
			for(int a=i; a>=0; a--){
				if(energiaAux >= ((a+1)*2)){
					
					if(pisosAux.get(a) >= capacidad){
						energiaAux = energiaAux - ((a+1)*2);
						cantPersonasAux += capacidad;						
						pisosAux.set(a, pisosAux.get(a) - capacidad);
						a++;
					}else{
						//cantPersonasAux += pisosAux.get(a);
					}
				}else{
					break;
				}
			}
			//levanto lo que queda (que ya se que no me llena la capacidad)
			for(int a=i; a>=0; a--){
				if(energiaAux >= ((a+1)*2)){					
					if(pisosAux.get(a) > 0){
						energiaAux = energiaAux - ((a+1)*2);
						cantPersonasAux += pisosAux.get(a);						
						pisosAux.set(a, pisosAux.get(a) - capacidad);
						//aca deberia levantar de los pisos que hay abajo de forma optima
					}
				}
			}
			if(cantPersonasAux > cantPersonas){
				cantPersonas = cantPersonasAux;
			}
		}
		return cantPersonas;
	}
}
