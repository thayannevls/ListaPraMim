package comparator;

import java.util.Comparator;

import model.ItemCompravel;

/**
 * Classe que compara, por ordem lexicografica, a descricao de dois itens compraveis.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class ItemNomeComparator implements Comparator<ItemCompravel> {

	@Override
	public int compare(ItemCompravel i1, ItemCompravel i2) {
		return i1.getNome().compareTo(i2.getNome());
	}
	
}
