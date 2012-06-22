package ej4;

import java.util.Comparator;


public class DosPorUnoSumaTupla implements Comparator<DosPorUnoSet> {

	@Override
	public int compare(DosPorUnoSet dp1, DosPorUnoSet dp2) {
		return dp1.getSumaGradosTupla() - dp2.getSumaGradosTupla();
	}

}
