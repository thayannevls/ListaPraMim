package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.Compra;

public class ComparadorPorCategoriaEPorNivel implements Comparator<Compra>{

	private List<String> categorias;
	
	public ComparadorPorCategoriaEPorNivel() {
		categorias = Arrays.asList("higiene pessoal", "limpeza", "alimento industrializado", "alimento nao industrializado");
	}
	
	@Override
	public int compare(Compra c0, Compra c1) {
		if (c0.getCategoria().compareTo(c1.getCategoria()) == 0) {
			return c0.getNome().compareTo(c1.getNome());
		}
		return categorias.indexOf(c0.getCategoria()) - categorias.indexOf(c1.getCategoria());
	}
	
}
