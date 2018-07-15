package util;

import java.util.Comparator;

import model.ItemCompravel;
/**
 * Classe que compara um preco a outro, retornando o valor da comparacao.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratorio de
 *         Programacao 2 - Projeto de Laboratorio (Lista pra mim)
 *
 */
public class MenorPrecoComparator implements Comparator<ItemCompravel> {

	@Override
	public int compare(ItemCompravel obj1, ItemCompravel obj2) {
		Double aux1 = Double.MAX_VALUE;
		Double aux2 = Double.MAX_VALUE;
		
		for (Double precos : obj1.getMapaDePrecos().values()) {
			if (precos < aux1) {
				aux1 = precos;
			}
		}
		for (Double precos : obj2.getMapaDePrecos().values()) {
			if (precos < aux2) {
				aux2 = precos;
			}

		}
		return (aux1.compareTo(aux2));
	}

}
