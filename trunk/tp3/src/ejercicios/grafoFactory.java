package ejercicios;

import java.util.Random;
import java.util.UUID;

import ejercicios.Grafo.Vertice;

public class grafoFactory {
	public Grafo grafoAleatorio(int n, int proba){
		Grafo g = new Grafo();
		for(int i=0;i<n;i++){
			String v = i+"";
			g.insertarVertice(v, v);
		}
		Random r = new Random();
		
		for(int i=0;i<n;i++){
			String v = i+"";
			Vertice ver = g.obtenerVertice(v);
			for(int a=i;a<n;a++){
				if(r.nextInt(100) < proba){
					v = a+"";
					Vertice ver2 = g.obtenerVertice(v);
					
						g.agregarArista(ver, ver2, 1);
				}
				
			}
		}
		
		
		
		return g;
	}
	
	public Grafo estrella(int n){
		Grafo g = new Grafo();
		for(int i=0;i<n;i++){
			String v = i+"";
			g.insertarVertice(v, v);
		}
		Random r = new Random();
		int val = r.nextInt(n-1);
		for(int i=0;i<n;i++){
			if(i == val){
			String v = i+"";
			Vertice ver = g.obtenerVertice(v);
			for(int a=0;a<n;a++){
				    
					v = a+"";
					Vertice ver2 = g.obtenerVertice(v);
					g.agregarArista(ver, ver2, 1);
				
				
			}
			}
		}
		
		
		
		return g;
	}
	
	public Grafo CI2(int n){
		Grafo g = new Grafo();
		for(int i=0;i<n;i++){
			String v = i+"";
			g.insertarVertice(v, v);
		}
		Random r = new Random();
		int val = r.nextInt(n-1);
		
		int noTeRelaciones;
		for(int i=n/2;i<n;i++){
			noTeRelaciones = n - i-1;
			String v = i+"";
			Vertice ver = g.obtenerVertice(v);
			for(int a=0;a<n/2;a++){
				    if(a != noTeRelaciones){
						v = a+"";
						Vertice ver2 = g.obtenerVertice(v);
						g.agregarArista(ver, ver2, 1);
				    }
				
			}
			
		}
		
		
		
		
		return g;
	}
	
	public static Grafo arbolCliques(int n){
		Grafo g = new Grafo();
		Vertice[][] vertices = new Vertice[n][n];
		int k = 0;
		
		//Agrego tods los nodos.
		for(int i = 1; i<=n;i++)
		{
			for(int j = 0; j<i;j++,k++){
				vertices[i-1][j] = g.insertarVertice(Integer.toString(k), Integer.toString(k));
			}
		}
		
		//Formo completos.
		for(int i = 1; i<=n;i++)
		{
			for(int j = 0; j<i;j++){
				for(int h=j+1;h<i;h++){
					g.agregarArista(vertices[i-1][j], vertices[i-1][h], 0);
				}
			}
			g.agregarArista(vertices[i-1][0], vertices[i%n][0],0);
		}
		return g;
	}

	public static Grafo arbolBinario(int altura){
		Grafo g = new Grafo();
		int k = 0;
		Vertice padre = g.insertarVertice("PADRE", "PADRE");
		AgregarHijos(padre, 0, altura, g);
		return g;
	}
	
	private static void AgregarHijos(Vertice v, int i, int n, Grafo g){
		if(i != n){
			Vertice h1 = g.insertarVertice(UUID.randomUUID().toString(), UUID.randomUUID().toString());
			Vertice h2 = g.insertarVertice(UUID.randomUUID().toString(), UUID.randomUUID().toString());
			g.agregarArista(v, h1, 0);
			g.agregarArista(v, h2, 0);
			AgregarHijos(h1, i+1,n,g);
			AgregarHijos(h2, i+1,n,g);
		}
	}
	
	public static Grafo completoEntreFilas(int n){
		Grafo g = new Grafo();
		Vertice[] completo = new Vertice[n];
		Vertice[] izq = new Vertice[n];
		Vertice[] der = new Vertice[n];
		int k = 0;
		for(int i = 0; i<n;i++,k+=3){
			completo[i] = g.insertarVertice(Integer.toString(k), Integer.toString(k));
			izq[i] = g.insertarVertice(Integer.toString(k+1), Integer.toString(k+1));
			der[i] = g.insertarVertice(Integer.toString(k+2), Integer.toString(k+2));
		}
		for(int j = 0; j<n;j++){
			for(int h=j+1;h<n;h++){
				g.agregarArista(completo[j], completo [h], 0);
			}
		}
		for(int j = 0; j<n;j++){
			g.agregarArista(izq[j], completo[(j+1)%n], 0);
			g.agregarArista(izq[j], completo[(j+2)%n], 0);
			g.agregarArista(der[j], completo[(j+3)%n], 0);
			g.agregarArista(der[j], completo[(j+4)%n], 0);
		}
		
		return g;
	}

	public static Grafo hipercubo(int n){
		Grafo g = new Grafo();
		if(n == 1){
			g.insertarVertice(UUID.randomUUID().toString(), UUID.randomUUID().toString());
		}else{
			Grafo g1 = hipercubo(n-1);
			Grafo g2 = hipercubo(n-1);
			int tam = g1.getVertices().size();
			Vertice[][] vertices = new Vertice[tam][2];
			int i = 0;
			for(Vertice v : g1.getVertices().values()){			
				vertices[i][0] = g.insertaVertice(v);i++;
			}
			i = 0;
			for(Vertice v : g2.getVertices().values()){
				vertices[i][1] = g.insertaVertice(v);i++;		
			}
			for(i = 0; i<tam;i++)
			{
				g.agregarArista(vertices[i][0], vertices[i][1], 0);
			}
		}
		return g;
	}

	public static Grafo arbolDesnivelado (int n, Vertice[] ver){
		Grafo g = new Grafo();
		if(n%2==1)n--;
		Vertice raiz = g.insertarVertice(UUID.randomUUID().toString(), UUID.randomUUID().toString());
		ver[0] = raiz;
		int k = 0;
		for(int i = 0;i<n;i++)
		{
			Vertice[] auxRaiz = new Vertice[1];
			Grafo aux = arbolDesnivelado(n-2, auxRaiz);
			Vertice vaux  = auxRaiz[0];
			for(Vertice v : aux.getVertices().values()){			
				g.insertaVertice(v);
			}
			g.agregarArista(raiz, vaux, 0);
		}
		return g;
	}
}
