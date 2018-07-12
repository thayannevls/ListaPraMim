package test;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorUnidade;

public class ItemPorUnidadeTest {

	private ItemPorUnidade itemUni1;
	
	@Before
	public void criaItemPorUnidade(){
		itemUni1 = new ItemPorUnidade("Lata de Brigadeiro", 1, "alimento nao industrializado", 1, "Mercadinho Barato e do Bom", 6.99);
	}
	
	@Test
	public void test() {
		System.out.println(itemUni1.toString());
	}
}
