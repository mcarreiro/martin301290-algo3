package Ejercicios;

import java.util.*;

public class Ej1 {
	public int resolver(int energia, int capacidad, ArrayList< Integer > pisos){
		
		int totalPersonas = SumaTotalPersonas(pisos);
		return BusquedaBinariaPersonas(0,totalPersonas, totalPersonas,energia,capacidad,pisos);
		 
	}
	private int SumaTotalPersonas(ArrayList< Integer > pisos){
		int acum = 0;		
		int i;
		for(i = 0; i < pisos.size();i++){
			acum = acum + pisos.get(i);			
		}
		return acum;
	}
	
	private int BusquedaBinariaPersonas(int desde, int hasta, int total, int energia, int capacidad, ArrayList< Integer > pisos){
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
	
	private void BuscarPisoMaximo(ArrayList< Integer > pisos, int personasABuscar, int[] infoReturn){
		int personasTotal = 0;		
		int i;
		for(i = 0; i < pisos.size();i++){
			personasTotal = personasTotal + pisos.get(i);
			if(personasTotal >= personasABuscar){			
				break;
			}
		}
		
		infoReturn[0] = i;
		infoReturn[1] = personasTotal;
	}
	private boolean TengoEnergiaParaLlegar(int energia, int piso){
		return energia >= (piso+1)*2;
	}
	private boolean sePuedeLevantar(int energia, int capacidad, ArrayList< Integer > pisosOrig, int personasABuscar){
		
		ArrayList< Integer > pisos = (ArrayList< Integer >)pisosOrig.clone();
		int[] info = new int [2];
		BuscarPisoMaximo(pisos, personasABuscar, info);
		int piso = info[0];
		int personasTotal = info[1];
		int cuantoLevante = 0;
		int noLevante = 0;
		int restaDeCapacidad = capacidad;		
			for(;piso >= 0;piso--){
				if(TengoEnergiaParaLlegar(energia, piso)){
					energia = energia - (piso+1)*2;
					if(pisos.get(piso) > capacidad){
						cuantoLevante = cuantoLevante + capacidad;
						pisos.set(piso, pisos.get(piso)  -capacidad);
						piso++;
					}else{
						restaDeCapacidad = restaDeCapacidad - pisos.get(piso);
						cuantoLevante = cuantoLevante + pisos.get(piso);
						pisos.set(piso, 0);						
						for(int pisoMenor = (piso-1);pisoMenor >= 0;pisoMenor--){
							if(restaDeCapacidad > 0 && pisos.get(pisoMenor) > 0){
								if(restaDeCapacidad >= pisos.get(pisoMenor)){
									restaDeCapacidad = restaDeCapacidad - pisos.get(pisoMenor);
									cuantoLevante+= pisos.get(pisoMenor);
									pisos.set(pisoMenor, 0);									
								}else{
									cuantoLevante+= restaDeCapacidad;
									pisos.set(pisoMenor, pisos.get(pisoMenor) - restaDeCapacidad);									
									restaDeCapacidad = 0;									
								}
							}
						}
					}
				}else{
					noLevante = noLevante + pisos.get(piso);
					if(noLevante > (personasTotal - personasABuscar)){						
						break;
					}
				}
			}
		
		return (cuantoLevante >= personasABuscar);
	}

}

















