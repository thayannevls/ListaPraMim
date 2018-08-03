package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.ItemCompravel;
/**
 * Ordena item em dois niveis, primeiramente pela sua categoria em ordem definida, e depois pelo seu nome
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
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
