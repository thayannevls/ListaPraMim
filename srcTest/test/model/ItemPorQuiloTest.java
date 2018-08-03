package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorQuilo;

public class ItemPorQuiloTest {

	private ItemPorQuilo item;
	private ItemPorQuilo chuchu;
	
	@Before
	public void criaItemPorUnidade(){
		chuchu = new ItemPorQuilo("Chuchu", 34, "alimento nao industrializado", 1, "Supermercado BaratoD+", 1.34);
		chuchu.adicionaPreco("Baratao", 1.30);
	}
	
	@Test
	public void testConstrutor() {
		assertNull(item);
		item = new ItemPorQuilo("Chuchu", 34, "alimento nao industrializado", 1, "Supermercado BaratoD+", 1.34);
		assertNotNull(item);
	}

	
	@Test
	public void testSetNome() {
		assertEquals("34. Chuchu, alimento nao industrializado, Preco por quilo: <Baratao, R$ 1,30;Supermercado BaratoD+, R$ 1,34;>", chuchu.toString());
		chuchu.setNome("Chuchu de Junior");
		assertEquals("34. Chuchu de Junior, alimento nao industrializado, Preco por quilo: <Baratao, R$ 1,30;Supermercado BaratoD+, R$ 1,34;>", chuchu.toString());
	}
	
	@Test
	public void testGetQuilo() {
		assertEquals(1.0, chuchu.getQuilo(), 0);
	}
	
	@Test
	public void testGetID() {
		assertEquals(34, chuchu.getId());
	}
	
	@Test
	public void testSetQuilo() {
		assertEquals(1, chuchu.getQuilo(), 0);
		chuchu.setQuilo(2);
		assertEquals(2, chuchu.getQuilo(), 0);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(chuchu.hashCode(), chuchu.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertTrue(chuchu.equals(chuchu));
	}
	
	@Test
	public void testNotEquals() {
		assertFalse(chuchu.equals("chuchu"));
	}
	
	@Test
	public void testToString() {
		assertEquals("34. Chuchu, alimento nao industrializado, Preco por quilo: <Baratao, R$ 1,30;Supermercado BaratoD+, R$ 1,34;>", chuchu.toString());
	}
	
	@Test
	public void testAtualiza(){
		chuchu.atualiza("44");
		assertEquals("34. Chuchu, alimento nao industrializado, Preco por quilo: <Baratao, R$ 1,30;Supermercado BaratoD+, R$ 1,34;>", chuchu.toString());
	}
	
}