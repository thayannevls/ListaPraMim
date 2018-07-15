package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorQuilo;

public class ItemPorQuiloTest {

	private ItemPorQuilo item;
	private ItemPorQuilo chuchu;
	
	@Before
	public void criaItemPorUnidade(){
		chuchu = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
		chuchu.adicionaPreco("Baratao", 1.30);
	}
	
	@Test
	public void testConstrutor() {
		assertNull(item);
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
		assertNotNull(item);
	}

	@Test(expected=RuntimeException.class)
	public void testConstrutorDescricaoNula() {
		item = new ItemPorQuilo(null, 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorDescricaoVazia() {
		item = new ItemPorQuilo("", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorDescricaoApenasEspacos() {
		item = new ItemPorQuilo("            ", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorIDNegativo() {
		item = new ItemPorQuilo("Chuchu", -34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorIDZero() {
		item = new ItemPorQuilo("Chuchu", 0, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorCategoriaNula() {
		item = new ItemPorQuilo("Chuchu", 34, null, 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorCategoriaVazia() {
		item = new ItemPorQuilo("Chuchu", 34, "", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorCategoriaApenasEspacos() {
		item = new ItemPorQuilo("Chuchu", 34, "              ", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorCategoriaNaoCadastrada() {
		item = new ItemPorQuilo("Chuchu", 34, "fruto", 1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorKGNegativo() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", -1, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorKGZero() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 0, "Supermercado BaratoD+", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorLocalVazio() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, "", 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorLocalNulo() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, null, 1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorValorNegativo() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", -1.34);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorValorZero() {
		item = new ItemPorQuilo("Chuchu", 34, "alimentos nao industrializados", 1, "Supermercado BaratoD+", 0);
	}
	
	@Test
	public void testSetNome() {
		assertEquals("34. Chuchu, alimentos nao industrializados, Preco por quilo: <Supermercado BaratoD+, R$ 1,34; Baratão, R$ 1,30>", chuchu.toString());
		chuchu.setNome("Chuchu de Junior");
		assertEquals("34. Chuchu de Junior, alimentos nao industrializados, Preco por quilo: <Supermercado BaratoD+, R$ 1,34; Baratão, R$ 1,30>", chuchu.toString());
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
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testNotEquals() {
		assertFalse(chuchu.equals("chuchu"));
	}
	
	@Test
	public void testToString() {
		assertEquals("34. Chuchu, alimentos nao industrializados, Preco por quilo: <Supermercado BaratoD+, R$ 1,34;  Baratão, R$ 1,30>", chuchu.toString());
	}
	
}