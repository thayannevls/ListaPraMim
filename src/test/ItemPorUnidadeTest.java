package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorUnidade;

public class ItemPorUnidadeTest {

	private ItemPorUnidade item;
	private ItemPorUnidade queijo;

	@Before
	public void init() {
		queijo = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "Baratao", 4.30);
	}
	
	@Test
	public void testConstrutor() {
		assertNull(item);
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "Baratao", 4.30);
		assertNotNull(item);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorDescricaoVazia() {
		item = new ItemPorUnidade("", 87, "alimentos industrializados", 1, "Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorDescricaoNula() {
		item = new ItemPorUnidade(null, 87, "alimentos industrializados", 1, "Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorDescricaoApenasEspacos() {
		item = new ItemPorUnidade("           ", 87, "alimentos industrializados", 1, "Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorIDNegativo() {
		item = new ItemPorUnidade("Queijo minas Dali", -87, "alimentos industrializados", 1, "Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorIDZero() {
		item = new ItemPorUnidade("Queijo minas Dali", 0, "alimentos industrializados", 1, "Baratao", 4.30);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCategoriaVazia() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "", 1,"Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCategoriaNula() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, null, 1, "Baratao", 4.30);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCategoriaApenasEspacos() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "         ", 1, "Baratao", 4.30);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorCategoriaNaoDefinida() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "queijo", 1, "Baratao", 4.30);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorLocalVazio() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "", 4.30);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorLocalNulo() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, null, 4.30);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorLocalApenasEspacos() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "              ", 4.30);
	}

	@Test(expected=RuntimeException.class)
	public void testConstrutorValorNegativo() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "Baratao", -4.30);
	}
	
	@Test(expected=RuntimeException.class)
	public void testConstrutorValorZero() {
		item = new ItemPorUnidade("Queijo minas Dali", 87, "alimentos industrializados", 1, "Baratao", 0.0);
	}
	
	@Test
	public void testGetUnidade() {
		assertEquals(1, queijo.getUnidade());
	}
	
	@Test
	public void testSetUnidade() {
		assertEquals(1, queijo.getUnidade());
		queijo.setUnidade(5);
		assertEquals(5, queijo.getUnidade());
	}
	
	@Test
	public void testSetCategoria() {
		assertEquals("87. Queijo minas Dali, alimentos industrializados, Preco: <Baratao, R$ 4,30>", queijo.toString());
		queijo.setCategoria("alimentos nao industrializados");
		assertEquals("87. Queijo minas Dali, alimentos nao industrializados, Preco: <Baratao, R$ 4,30>", queijo.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetUnidadeNegativa() {
		queijo.setUnidade(-5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetUnidadeZero() {
		queijo.setUnidade(0);
	}
	
	@Test
	public void testToString() {
		assertEquals("87. Queijo minas Dali, alimentos industrializados, Preco: <Baratao, R$ 4,30>", queijo.toString());
	}

}
