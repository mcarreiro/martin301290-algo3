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
	
	public boolean subSetSum(ArrayList<Integer> numeros, int suma){
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
		
		String s = Arrays.deepToString(mat)
				   .replace("], ", "\n").replaceAll(",|\\[|\\]", "");

				System.out.println(s);
				System.out.println(numeros.get(0));
		return true;
	}
}
