package comparator;

import java.util.Comparator;

import model.ListaDeCompras;

/**
 * Comparator que ordena os id de lista de forma crescente
 * @author Thayanne
 *
 */
public class ListaIdComparator implements Comparator<ListaDeCompras> {

	@Override
	public int compare(ListaDeCompras l1, ListaDeCompras l2) {
		return l1.getId() - l2.getId();
	}

}
