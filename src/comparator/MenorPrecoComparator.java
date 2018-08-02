package comparator;

import java.util.Comparator;

import model.ItemCompravel;

/**
 * Classe que compara um preco a outro, retornando o valor da comparacao.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
<<<<<<< HEAD
 * @author Siuanny Barbosa - Matricula: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratorio de
 *         Programacao 2 - Projeto de Laboratorio (Lista pra mim)
 *
=======
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
>>>>>>> a1d686855f4a766978d1e0d9f7ace14f1b5bde23
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
