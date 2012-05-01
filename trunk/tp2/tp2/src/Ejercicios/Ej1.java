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
						//Me fijo cual es la suma maxima que puedo hacer con la gente del resto de los pisos
						int sumaMax = this.subSetSum(pisosAux.subList(0, a-1), capacidad - pisosAux.get(a));
						if(sumaMax > 0){
							//ACA TENGO QUE VER QUE NUMEROS SUMAR PARA OBTENER SUMAMAX Y EN CASO DE HABER MAS DE 1 ELEGIR EL Q TENGA GENTE EN LOS PISOS DE MAS ARRIBA
						}
					}
				}
			}
			if(cantPersonasAux > cantPersonas){
				cantPersonas = cantPersonasAux;
			}
		}
		return cantPersonas;
	}
	
	/**
	 * Se fija si se puede sumar 'suma' con los valores de 'numeros' en caso negatvio busca la suma mas cercana y devuelve esa suma
	 * 
	 * @param numeros
	 * @param suma
	 * @return
	 */
	public int subSetSum(List<Integer> numeros, int suma){
		Boolean[][] mat = new Boolean[numeros.size()+1][suma+1];
		
		for(int i = 0;i <= numeros.size() ;i++){
			mat[i][0] = true;
		}
		for(int i = 1;i <= suma;i++){
			mat[0][i] = false;
		}
		for (int i = 1; i <= numeros.size(); i++){
		      for (int j = 1; j <= suma; j++){
		        if (j >=  numeros.get(i - 1)){
		        	mat[i][j] = mat[i - 1][j] || mat[i - 1][j - numeros.get(i - 1)];
		        }else{
		        	mat[i][j] = mat[i - 1][j];
		        }
		      }
		}
		//Busco cual es la suma maxima
		int sumaMaxima = 0;
		for(int i = suma;i > 0;i--){
			if(mat[numeros.size()][i] == true){
				sumaMaxima = i;
				break;
			}
		}
		
		return sumaMaxima;
	}
}
