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
			pisosAux = pisos;
			for(int a=i; a>=0; a--){
				if(energiaAux >= ((a+1)*2)){
					energiaAux = energiaAux - ((a+1)*2);
					if(pisosAux.get(a) > capacidad){
						cantPersonasAux += capacidad;						
						pisosAux.set(a, pisosAux.get(a) - capacidad);
						a++;
					}else{
						cantPersonasAux += pisosAux.get(a);
					}
				}else{
					break;
				}
			}
			if(cantPersonasAux > cantPersonas){
				cantPersonas = cantPersonasAux;
			}
		}
		return cantPersonas;
	}
}
