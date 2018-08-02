package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.ItemCompravel;

public class ItemCategoriaENomeComparator implements Comparator<ItemCompravel> {
	private List<String> categorias;
	
	public ItemCategoriaENomeComparator() {
		categorias = Arrays.asList("higiene pessoal", "limpeza", "alimento industrializado", "alimento nao industrializado");
	}
	
	@Override
	public int compare(ItemCompravel i1, ItemCompravel i2) {
		if (i1.getCategoria().compareTo(i2.getCategoria()) == 0) {
			return i1.getNome().compareTo(i2.getNome());
		}
		return categorias.indexOf(i1.getCategoria()) - categorias.indexOf(i2.getCategoria());
	}
}
