package Ejercicios;

import java.util.*;

public class Ej1 {
	public int resolver(int energia, int capacidad, ArrayList< Integer > pisos){
		int acum = 0;		
		int i;
		for(i = 0; i < pisos.size();i++){
			acum = acum + pisos.get(i);			
		}
		int cantPersonas = BusquedaBinariaPersonas(0,acum, acum,energia,capacidad,pisos);
		return cantPersonas;
	}
	
	public int BusquedaBinariaPersonas(int desde, int hasta, int total, int energia, int capacidad, ArrayList< Integer > pisos){
		int medio = (desde + hasta)/2;
		if(desde > hasta) return 0;
		boolean res = sePuedeLevantar(energia, capacidad, pisos, medio);
		if(res){
			if(total != medio )
				if(!sePuedeLevantar(energia, capacidad, pisos, medio+1))
					return medio;
				else 
					return BusquedaBinariaPersonas(medio+1, hasta, total, energia, capacidad, pisos);
			else return medio;
		}else{
			return BusquedaBinariaPersonas(desde, medio, total, energia, capacidad, pisos);
		}			
	}
	
	public boolean sePuedeLevantar(int energia, int capacidad, ArrayList< Integer > pisosOrig, int cant){
		int acum = 0;		
		int i;
		ArrayList< Integer > pisos = (ArrayList< Integer >)pisosOrig.clone();
		for(i = 0; i < pisos.size();i++){
			acum = acum + pisos.get(i);
			if(acum >= cant){			
				break;
			}
		}
		int cuantoLevante = 0;
		int noLevante = 0;
		int restaDeCapacidad = capacidad;		
			for(;i >= 0;i--){
				if(energia >= (i+1)*2){
					energia = energia - (i+1)*2;
					if(pisos.get(i) > capacidad){
						cuantoLevante = cuantoLevante + capacidad;
						pisos.set(i, pisos.get(i)  -capacidad);
						i++;
					}else{
						restaDeCapacidad = restaDeCapacidad - pisos.get(i);
						cuantoLevante = cuantoLevante + pisos.get(i);
						pisos.set(i, 0);						
						for(int a = (i-1);a >= 0;a--){
							if(restaDeCapacidad > 0 && pisos.get(a) > 0){
								if(restaDeCapacidad >= pisos.get(a)){
									restaDeCapacidad = restaDeCapacidad - pisos.get(a);
									cuantoLevante+= pisos.get(a);
									pisos.set(a, 0);									
								}else{
									cuantoLevante+= restaDeCapacidad;
									pisos.set(a, pisos.get(a) - restaDeCapacidad);									
									restaDeCapacidad = 0;									
								}
							}
						}
					}
				}else{
					noLevante = noLevante + pisos.get(i);
					if(noLevante > (acum - cant)){						
						break;
					}
				}
			}
		
		return (cuantoLevante >= cant);
	}
}

















