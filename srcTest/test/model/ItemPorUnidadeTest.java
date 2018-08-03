package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorUnidade;

public class ItemPorUnidadeTest {

	private ItemPorUnidade item;
	private ItemPorUnidade queijo;

	@Before
	public void init() {
		queijo = new ItemPorUnidade("Queijo minas Dali", 87, "alimento industrializado", 1, "Baratao", 4.30);
	}
	
	@Test
	public void testConstrutor() {
		assertNull(item);
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimento industrializado", 1, "Baratao", 4.30);
		assertNotNull(item);
	}
	
	@Test
	public void testGetUnidade() {
		assertEquals(1, queijo.getUnidade());
	}
	
	@Test
	public void testSetCategoria() {
		assertEquals("87. Queijo minas Dali, alimento industrializado, Preco: <Baratao, R$ 4,30;>", queijo.toString());
		queijo.setCategoria("alimento nao industrializado");
		assertEquals("87. Queijo minas Dali, alimento nao industrializado, Preco: <Baratao, R$ 4,30;>", queijo.toString());
	}
	
	@Test
	public void testToString() {
		assertEquals("87. Queijo minas Dali, alimento industrializado, Preco: <Baratao, R$ 4,30;>", queijo.toString());
	}
	
	@Test
	public void testAtualiza(){
		queijo.atualiza("2");
		assertEquals("87. Queijo minas Dali, alimento industrializado, Preco: <Baratao, R$ 4,30;>", queijo.toString());
	}

}
