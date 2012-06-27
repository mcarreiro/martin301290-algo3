package ej4;

import java.util.Comparator;


public class DosPorUnoSumaTupla implements Comparator<DosPorUnoSet> {

	@Override
	public int compare(DosPorUnoSet dp1, DosPorUnoSet dp2) {
		return dp1.getSumaGradosTupla() - dp2.getSumaGradosTupla();
	}
	
	public String __toString(){
		return "Mayor valor de la suma de los grados de los vertices de la tupla.";
	}

}
