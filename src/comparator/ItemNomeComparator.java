package comparator;

import java.util.Comparator;

import model.ItemCompravel;

/**
 * Compara pelo alfabeto strings
 * @author Thayanne
 */
public class ItemNomeComparator implements Comparator<ItemCompravel> {

	@Override
	public int compare(ItemCompravel i1, ItemCompravel i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
}
