package comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * Ordena estabelecimentos com base no preco
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matricula: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class EstabelecimentoPrecoComparator implements Comparator<String> {

	Map<String, Double> base;

    public EstabelecimentoPrecoComparator(Map<String, Double> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
    	return base.get(a).compareTo(base.get(b));

    }
}
