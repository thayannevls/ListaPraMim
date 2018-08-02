package comparator;

import java.util.Comparator;

import model.ListaDeCompras;

/**
 * Classe que compara a data de criação de duas listas de compras.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class ListaDataComparator implements Comparator<ListaDeCompras> {

	@Override
	public int compare(ListaDeCompras l1, ListaDeCompras l2) {
		return l1.getDataCriacao().compareTo(l2.getDataCriacao());
	}

}
