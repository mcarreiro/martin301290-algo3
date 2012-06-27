package ej4;

import java.util.Comparator;


public class DosPorUnoMenorGradoVertice implements Comparator<DosPorUnoSet> {

	@Override
	public int compare(DosPorUnoSet dp1, DosPorUnoSet dp2) {
		return dp2.getGradoVertice() - dp1.getGradoVertice();
	}
	
	public String __toString(){
		return "Menor Grado Vertice a Reemplazar";
	}

}
