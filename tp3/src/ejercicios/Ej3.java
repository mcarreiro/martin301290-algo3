package ejercicios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;


import ejercicios.Grafo;
import ejercicios.Grafo.Arista;
import ejercicios.Grafo.Vertice;

public class Ej3 {
   
    public ArrayList<Vertice> MCD_Greedy(Grafo g, int k){
    	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    	Iterator<Vertice> itVertice = g.getVertices().values().iterator();
    	while(itVertice.hasNext())
    		vertices.add(itVertice.next());
        ArrayList<Vertice> dominantes = new ArrayList<Vertice>();
        Vertice elegido;
        while(!TodasCubiertas(vertices)){
        	vertices = OrdenarVertices(vertices);
            elegido = ElegirVertice(vertices, k);
            ActualizarGradoSinDominar(elegido);
            dominantes.add(elegido);            
        }
        return dominantes;
    }
    
    public Vertice ElegirVertice(ArrayList<Vertice> vertices, int k){
    	int randomNum = (int)(Math.random()*(k-1)); 
    	Vertice elegido = vertices.get(randomNum);    	
    	return elegido; 
    }
    
    public ArrayList<Vertice> OrdenarVertices(ArrayList<Vertice> vertices){
    	//return MergeSort(vertices, 0, vertices.size()-1);
    	SelectionSort(vertices);
    	return vertices;

    }
   

	public void ActualizarGradoSinDominar(Vertice elegido){
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
   public boolean TodasCubiertas(ArrayList<Vertice> vertices){
    	Iterator<Vertice> it = vertices.iterator();
    	while(it.hasNext())
    		if(!it.next().dominada)
    			return false;
    	return true;
    }   

   public void MergeSort(ArrayList<Vertice> vertices, int d, int h){
       if (d < h){
               int m = (d+h)/2;
               MergeSort(vertices, d, m);
               MergeSort(vertices, m+1, h);
               Merge(vertices, d, m, h);
       }
     
   }
	private void SelectionSort(ArrayList<Vertice> vertices) {
   
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
	 public void Merge(ArrayList<Vertice> v, int l, int m, int r)
     {
ArrayList<Vertice> helper = new ArrayList<Grafo.Vertice>();
// Copy both parts into the helper array
             for (int i = l; i <= r; i++) {
                     helper.add(v.get(i));
             }

             int i = l;
             int j = m + 1;
             int k = l;
             // Copy the smallest values from either the left or the right side back
             // to the original array
             while (i <= m && j <= r) {
                     if (helper.get(i).gradoSinDominar <= helper.get(j).gradoSinDominar) {
                             v.add(k, helper.get(i));
                             i++;
                     } else {
         