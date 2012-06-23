package ejercicios;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
//import java.util.Hashtable;

import ejercicios.Grafo;
import ejercicios.Grafo.Arista;
import ejercicios.Grafo.Vertice;
import java.util.Collection;

public class ej2 {
	
	static Collection<Grafo.Vertice> grafoOriginal;
	
	public static Grafo crearGrafoDesdeInstancia(String instancia) {
		Grafo g = new Grafo();
		String enlaceDelim = ";";
		String[] in = instancia.split(enlaceDelim);
		for(int i =0; i < in.length; i++) {
			String enlace = in[i];
			String delim = " ";
			String[] enlaceInfo = enlace.split(delim);
			Vertice v1 = g.insertauObtenerVertice(enlaceInfo[0], enlaceInfo[0]); 
			Vertice v2 = g.insertauObtenerVertice(enlaceInfo[1], enlaceInfo[1]);
			if(enlaceInfo.length > 2){
				g.agregarArista(v1, v2, new Integer(enlaceInfo[2]));
			}
		}
		return g;
	}
	
	public static List<Grafo.Vertice> obtenerConjuntoDominanteMinimo(Grafo graph) {
		Collection<Grafo.Vertice> vertices  = new ArrayList<Grafo.Vertice>(); 
		vertices.addAll(graph.getVertices().values());
		grafoOriginal = new ArrayList<Grafo.Vertice>();
		grafoOriginal.addAll(vertices);
		List<Grafo.Vertice> conjuntoDominanteMinimo = new ArrayList<Grafo.Vertice>();
		return conjuntoDominanteMinimo = buscar_minimo(vertices, conjuntoDominanteMinimo);
		
	}
	
	//El minimo de usar un vertice para el conjunto dominante o no usarlo
	private static List<Grafo.Vertice> buscar_minimo(Collection<Grafo.Vertice> vertices, List<Grafo.Vertice> conjuntoDominanteMinimo){
		if(es_dominante(conjuntoDominanteMinimo)){
			return conjuntoDominanteMinimo;
		}else{			
			Iterator<Grafo.Vertice> it = vertices.iterator();
			//veo si quedan vertices
			if(it.hasNext()){				
				Grafo.Vertice v = it.next();
				it.remove();
				//Creo el conjunto sin v
				List<Grafo.Vertice> conjuntoDominanteMinimoSinV = new ArrayList<Grafo.Vertice>(); 
				conjuntoDominanteMinimoSinV.addAll(conjuntoDominanteMinimo);
				
				//creo el conjunto con v 
				conjuntoDominanteMinimo.add(v);
				//copio los vertice (porq sino los objetos los envia por referencia)
				Collection<Grafo.Vertice> verticesCopia = new ArrayList<Grafo.Vertice>();
				verticesCopia.addAll(vertices);	
				
				//Busco el conjunto dominante minimo que contiene a v
				conjuntoDominanteMinimo = buscar_minimo(vertices, conjuntoDominanteMinimo);
				
				//Busco el conjunto dominante minimo que no contiene a v
				conjuntoDominanteMinimoSinV = buscar_minimo(verticesCopia, conjuntoDominanteMinimoSinV);
				
				if(conjuntoDominanteMinimo.size() > conjuntoDominanteMinimoSinV.size()){
					return conjuntoDominanteMinimoSinV;
				}else{
					return conjuntoDominanteMinimo;
				}	
			}else{
				//Si no hay mas vertices quiere decir que estoy en una rama en la que ya no puede devolverme un conjunto dominante
				//entonces devuelvo el grafo completo que seguro es dominante
				List<Grafo.Vertice> dominante = new ArrayList<Grafo.Vertice>();
				dominante.addAll(grafoOriginal);
				return dominante;
			}
		}
	}
	
	private static boolean es_dominante(List<Grafo.Vertice>conjuntoDominanteMinimo){
		boolean esta;
		//me fijo por cada vertice del grafo original
		for(Grafo.Vertice vertice : grafoOriginal){
			//si el vertice pertence al conjunto dominante
			if(conjuntoDominanteMinimo.contains(vertice)){
				continue;
			}else{
				esta = false;
				//o si pertence a alguno de sus adyacentes
				for(Grafo.Vertice verticeDominante : conjuntoDominanteMinimo){
					ArrayList<Arista> aristas = verticeDominante.getAristas();
					for(Arista arista : aristas){
						if(arista.v1 == vertice || arista.v2 == vertice){
							esta = true;
							break;
						}
					}
					if(esta){
						break;
					}
				}
				//si no pertence ni a sus adyacentes ni es parte del conjunto dominante entonces el conjnto no es dominante
				if(esta){
					continue;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}
