package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemPorQtdTest {

	private ItemPorQtd item;
	private ItemPorQtd sabonete;

	@Before
	public void init() {
		sabonete = new ItemPorQtd("Sabonete de aveia Dorene", 13255, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
		algodao = new ItemPorQtd("Algodão Clemer", 219, "higiene pessoal", 300, "gramas", "Supermercado BaratoD+", 2.33);
		algodao.adicionaPreco("Baratao", 2.30);
	}

	@Test
	public void testConstrutor() {
		assertNull(item);
		item = new ItemPorQtd("Sabonete de aveia Dorene", 13255, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
		assertNotNull(item);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorDescicaoVazia() {
		item = new ItemPorQtd("", 13255, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorDescicaoNula() {
		item = new ItemPorQtd(null, 13255, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorIDNegativo() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", -13255, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorIDZero() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 0, "higiene pessoal", 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCategoriaVazia() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "", 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCategoriaNula() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, null, 5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorQuantidadeNegativa() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", -5, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorQuantidadeZero() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 0, "gramas", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorUnidadeDeMedidaVazia() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorUnidadeDeMedidaApenasEspacos() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "      ", "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorUnidadeDeMedidaNula() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, null, "BaratoD+", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorLocalVazio() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "gramas", "", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorLocalApenasEspacos() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "gramas", "            ", 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorLocalNull() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "gramas", null, 15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorValorNegativo() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "gramas", "BaratoD+", -15.00);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorValorZero() {
		item = new ItemPorQtd("Sabonete de aveia Dorene", 1254884, "higiene pessoal", 5, "gramas", "BaratoD+", 0);
	}

	@Test
	public void testGetQuantidade() {
		assertEquals(5, sabonete.getQuantidade());
	}

	@Test
	public void testGetUnidadeDeMedida() {
		assertEquals("gramas", sabonete.getUnidadeDeMedida());
	}

	@Test
	public void testSetQuantidade() {
		assertEquals(5, sabonete.getQuantidade());
		sabonete.setQuantidade(10);
		assertEquals(10, sabonete.getQuantidade());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetQuantidadeNegativa() {
		sabonete.setQuantidade(-10);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetQuantidadeZero() {
		sabonete.setQuantidade(0);
	}

	@Test
	public void testSetUnidadeDeMedida() {
		assertEquals("gramas", sabonete.getUnidadeDeMedida());
		sabonete.setUnidade("kg");
		assertEquals("kg", sabonete.getUnidadeDeMedida());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetUnidadeDeMedidaVazia() {
		sabonete.setUnidade("");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetUnidadeDeMedidaApenasEspacos() {
		sabonete.setUnidade("             ");
	}

	@Test(expected=RuntimeException.class)
	public void testSetUnidadeDeMedidaNula() {
		sabonete.setUnidade(null);
	}

	@Test
	public void testToString() {
		assertEquals("219. Algodão Clemer, higiene pessoal, 300 gramas, Preco: <Supermercado BaratoD+, R$ 2,33;  Baratão, R$ 2,30>", abonete.toString());
	}

}
