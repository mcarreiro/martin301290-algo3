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
    public int ciclos_DFS;
    public int ciclos_esc;
    
    public ArrayList<Vertice> MCD_Greedy(Grafo g){
    	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    	Iterator<Vertice> itVertice = g.getVertices().values().iterator();
    	while(itVertice.hasNext())
    		vertices.add(itVertice.next());
        ArrayList<Vertice> dominantes = new ArrayList<Vertice>();
        Vertice elegido;
        while(!TodasCubiertas(g, vertices)){
            elegido = ElegirVertice(vertices);
            ActualizarGradoSinDominar(elegido);
            dominantes.add(elegido);            
        }
        return dominantes;
    }
    
    //Ordena por mayor adyacentes sin dominar y devuelve el mayor.
    public Vertice ElegirVertice(ArrayList<Vertice> vertices){
    	Vertice max = vertices.get(0);
    	int indiceMax = 0;
    	for(int i=0; i < vertices.size();i++)
    		if(vertices.get(i).gradoSinDominar > max.gradoSinDominar){
    			max = vertices.get(i);
    			indiceMax = i;
    		}
        vertices.remove(indiceMax);
    	return max; //Devuelvo el que mas adyacentes sin dominar tiene
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
   public boolean TodasCubiertas(Grafo g, ArrayList<Vertice> vertices){
    	Iterator<Vertice> it = vertices.iterator();
    	while(it.hasNext())
    		if(!it.next().dominada)
    			return false;
    	return true;
    }
   
    private Grafo GenerarGrafo(String[] instancia, ArrayList<Vertice> vertices){
        Grafo grafo = new Grafo();                        //O(1)
        /*int i,j;
        //Agrego todos los nodos.
        for(i=0; i < nodos.length;i++,ciclos_esc++)     //O(n)
            vertices.add(grafo.insertarVertice(nodos[i], nodos[i]));        //O(1)
        //Uno con aristas los nodos que su distancia este entre p y q, maximo pueden ser 10.
        for(i=0; i < nodos.length;i++){                 //O(10n) = O(n)
            j = i+1;
            while(j < nodos.length){
                    //grafo.agregarArista(vertices[i], vertices[j], null); //O(1)
                j++;
                ciclos_esc++;
            }
        }*/
        return grafo;
    }
    
   
}
