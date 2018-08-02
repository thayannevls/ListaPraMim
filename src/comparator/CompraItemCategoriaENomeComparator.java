package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.Compra;
import model.ItemCompravel;

/**
 * Classe que compara itens por dois níveis: 1 - pela categoria; 2 - por sua
 * descricao.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class CompraItemCategoriaENomeComparator implements Comparator<Compra> {

	private List<String> categorias;
	
	public CompraItemCategoriaENomeComparator() {
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
