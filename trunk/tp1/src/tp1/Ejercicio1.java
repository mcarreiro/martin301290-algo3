package tp1;

import java.util.ArrayList;

public class Ejercicio1 {
	
	/**
	 * Pre(ordenado?(vector1) ^ ordenado?(vector2))
	 * */
	public int doIt(ArrayList<Integer> vector1, ArrayList<Integer> vector2){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		int ciclos = 0;
		
		//Uno los dos arrays en 1 solo
		//O(count($var1)+count($var2)) = O(|var1|+ |var2|)		
		for(int i = 0;i< vector1.size()+vector2.size();i++){
			ciclos++;
			//Si alguno de los dos vectores no tienen elementos
			if(a >= vector1.size() || b >= vector2.size()){
				//Si el vector1 no tiene mas elementos entonces resta agregar los del vector2
				if(a >= vector1.size()){
					result.add(vector2.get(b));
					b++;
				}else{
					//Si el vector2 no tiene mas elementos entonces resta agregar los del vector1
					result.add(vector1.get(a));
					a++;
				}
			}else if(vector1.get(a) < vector2.get(b)){ //Sino agrego el menor
				
				result.add(vector1.get(a));
				a++;
			}else{
				result.add(vector2.get(b));
				b++;
			}
		}
		
		int acum = 0;
		int cont = 0;
		//O(count($var1)+count($var2)) = O(|var1|+ |var2|)
		//Recorro todo el array resultante de unir los otros 2
		for(int i = 0;i< result.size() -1;i++){	
			ciclos++;
			if(result.get(i) == result.get(i+1)){
				//Si el valor de las pos en la q estoy es igual a su siguiente sumo 1 
				//al contador de longitud de la meseta
		        cont++;
		    }else{
		        if(cont > acum){
		        	//Si la meseta mas larga hasta ahora es menor a la contabilizada recien la nueva pasa a ser la mayor
		            acum = cont;
		        }
		        cont = 0;
		    }
		}
		if(cont > acum){
            acum = cont;
        }
        //Imprimo los ciclos consumidos y la longitud edl array
		//System.out.println("Longitud:"+result.size());
		//System.out.println("Ciclos:"+ciclos);
		
		
		
		return acum+1;
	}
}
