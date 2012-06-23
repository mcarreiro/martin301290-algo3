package ejercicios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;


import ejercicios.Grafo;
import ejercicios.Grafo.Arista;
import ejercicios.Grafo.Vertice;
//
public class Ej3 {
   
    public static ArrayList<Vertice> MCD_Greedy(Grafo g, int k){
    	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    	Iterator<Vertice> itVertice = g.getVertices().values().iterator();
    	while(itVertice.hasNext())
    		vertices.add(itVertice.next());
        ArrayList<Vertice> dominantes = new ArrayList<Vertice>();
        Vertice elegido;
        while(!TodasCubiertas(vertices)){
        	vertices = OrdenarVertices(vertices);
            elegido = ElegirVertice(vertices, k);
            vertices.remove(elegido);
            ActualizarGradoSinDominar(elegido);
            dominantes.add(elegido);            
        }
        return dominantes;
    }
    
    public static Vertice ElegirVertice(ArrayList<Vertice> vertices, int k){
    	if(k > vertices.size()) k = vertices.size();
    	int randomNum = (int)(Math.random()*(k)); 
    	Vertice elegido = vertices.get(randomNum);    	
    	return elegido; 
    }
    
    public static ArrayList<Vertice> OrdenarVertices(ArrayList<Vertice> vertices){
    	mergeSort(vertices);
    	//SelectionSort(vertices);
    	return vertices;

    }
   

	public static void ActualizarGradoSinDominar(Vertice elegido){
       Iterator<Arista> it = elegido.aristas.iterator();
       Boolean dominacionElegido = elegido.dominada;
       elegido.dominada = true;
       ArrayList<Vertice> unionAdyacentes = new ArrayList<Vertice>();
       while(it.hasNext()){
    	   Vertice ady = it.next().v2;
    	   if(!dominacionElegido)
    		   ady.gradoSinDominar--;
    	   if(!ady.dominada){
    		   Iterator<Arista> itAdy = ady.aristas.iterator();
    		   while(itAdy.hasNext())
    			   unionAdyacentes.add(itAdy.next().v2);
    	   }
    	   ady.dominada = true;
    	   if(ady.gradoSinDominar == 0)
    		  it.remove(); 
       }
      Iterator<Vertice> itUnion = unionAdyacentes.iterator();
      while(itUnion.hasNext()){
    	  Vertice ady = itUnion.next();
    	  ady.gradoSinDominar--;
      }
    }
   public static boolean TodasCubiertas(ArrayList<Vertice> vertices){
    	Iterator<Vertice> it = vertices.iterator();
    	while(it.hasNext())
    		if(!it.next().dominada)
    			return false;
    	return true;
    }   

   
	private static void SelectionSort(ArrayList<Vertice> vertices) {
   
           int i = 0;
           while(i < vertices.size())
           {
                   int max = i;
                   for(int j = i; j < vertices.size(); j++){
                           if(vertices.get(max).gradoSinDominar < vertices.get(j).gradoSinDominar){
                                   max = j;
                           }
                   }
                   Vertice aux = vertices.get(i);
                   vertices.set(i, vertices.get(max));
                   vertices.set(max, aux);

                   i++;
           }
   }
public static  void mergeSort (ArrayList<Vertice> in) {
		
		int n = in.size();
	    if (n < 2) 
	    	return;  // the in list is already sorted in this case
	    // divide
	    ArrayList<Vertice> in1 = new ArrayList<Vertice>(); 
	    ArrayList<Vertice> in2 = new ArrayList<Vertice>(); 
	    int i = 0;
	    
	    while (i < n/2) {
	      in1.add(in.remove(0)); // move the first n/2 elements to in1
	      i++;
	    }
	    while (!in.isEmpty())
	      in2.add(in.remove(0)); // move the rest to in2
	    // recur
	    mergeSort(in1);
	    mergeSort(in2);
	    //conquer
	    merge(in1,in2,in); 
	}
	
	public static void merge(ArrayList<Vertice> in1, ArrayList<Vertice> in2, ArrayList<Vertice> in) {
		
		while (!in1.isEmpty() && !in2.isEmpty())
			if ((in1.get(0).gradoSinDominar > (in2.get(0).gradoSinDominar)))
				in.add(in1.remove(0));
			else
				if(in1.get(0).gradoSinDominar == in2.get(0).gradoSinDominar && in1.get(0).gradoSinDominar - in1.get(0).grado > in2.get(0).gradoSinDominar - in2.get(0).grado)
					in.add(in1.remove(0));
				else
					in.add(in2.remove(0));
		while(!in1.isEmpty()) // move the remaining elements of in1
			in.add(in1.remove(0));
	    while(!in2.isEmpty()) // move the remaining elements of in2
	    	in.add(in2.remove(0));
	}

}