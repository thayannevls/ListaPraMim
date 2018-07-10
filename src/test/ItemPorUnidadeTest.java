package test;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorUnidade;

public class ItemPorUnidadeTest {

	private ItemPorUnidade dados;
	
	@Before
	public void criaItemPorQtd(){
		dados = new ItemPorUnidade("Sabão", 1000001, "limpeza", 2, "Baratão", 5.8);
	}
	
	@Test
	public void test() {
		System.out.println(dados.toString());
	}

}
