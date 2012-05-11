package Ejercicios;

import java.util.*;

public class Ej1 {
	
	public int ciclos = 0;
	
	public int resolver(int capacidad, int energia, ArrayList< Integer > pisos){
		
		int totalPersonas = SumaTotalPersonas(pisos);
		return BusquedaBinariaPersonas(0,totalPersonas, totalPersonas,energia,capacidad,pisos);
		 
	}
	private int SumaTotalPersonas(ArrayList< Integer > pisos){
		int acum = 0;		
		int i;
		for(i = 0; i < pisos.size();i++){
			acum = acum + pisos.get(i);	
			this.ciclos++;
		}
		return acum;
	}
	
	private int BusquedaBinariaPersonas(int desde, int hasta, int total, int energia, int capacidad, ArrayList< Integer > pisos){
		int medio = (desde + hasta)/2;
		this.ciclos++;
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
			this.ciclos++;
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
		int piso = info[0],
		personasTotal = info[1],
		cuantoLevante = 0,
		noLevante = 0,
		restaDeCapacidad = capacidad;		
			for(;piso >= 0;piso--){
				this.ciclos++;
				if(TengoEnergiaParaLlegar(energia, piso) && pisos.get(piso) > 0){ //Si tengo energia para llegar a ese piso y hay alguien a quien rescatar...
					energia = energia - (piso+1)*2;
					if(pisos.get(piso) > capacidad){ //Si hay mas gente en el piso que la capacidad, es decir, lleno el ascensor.
						cuantoLevante = cuantoLevante + capacidad; //Sumo lo que levante
						pisos.set(piso, pisos.get(piso)  -capacidad); //Resto los que agarre
						piso++; //Le doy una oportunidad mas para procesar este piso por si puedo seguir agarrando
						//Me voy a PB para dejar la gente.
					}else{ //Si puedo levantar todo el piso
						restaDeCapacidad = restaDeCapacidad - pisos.get(piso); //A la capacidad de mi ascensor le resto lo que agarre.
						cuantoLevante = cuantoLevante + pisos.get(piso); //Sumo lo que levante
						pisos.set(piso, 0);		//Vacio el piso				
						//Como no llene el ascensor no me tengo que ir a PB, entonces bajo en el ascensor agarrando lo que puedo de los pisos de abajo.
						for(int pisoMenor = (piso-1);pisoMenor >= 0;pisoMenor--){ 
							this.ciclos++;
							//Bajo del ascensor agarrando lo que pueda de los pisos inferiores
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
				}else{ //Si no tengo energia para llegar a ese piso...
					noLevante = noLevante + pisos.get(piso);
					if(noLevante > (personasTotal - personasABuscar)){	
						//Si ya levante lo que tenia que levantar.
						break;
					}
				}
			}
		
		return (cuantoLevante >= personasABuscar); //Levanté la cantidad que queria?
	}
}

















