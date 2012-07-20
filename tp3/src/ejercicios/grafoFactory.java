package ejercicios;

import java.util.Random;

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
			for(int a=0;a<n;a++){
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
	
}
