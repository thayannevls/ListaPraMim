package comparator;

import java.util.Comparator;

import model.ListaDeCompras;

public class ListaDataComparator implements Comparator<ListaDeCompras>{

	@Override
	public int compare(ListaDeCompras l1, ListaDeCompras l2) {
		return l1.getDataCriacao().compareTo(l2.getDataCriacao());
	}

}
