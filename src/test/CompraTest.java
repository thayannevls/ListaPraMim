package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Compra;
import model.ItemPorUnidade;

public class CompraTest {

	
	private ItemPorUnidade item;
	private Compra compra;
	private Compra c;

	@Before
	public void init() {
		item = new ItemPorUnidade("Iogurte Lactivia", 15, "alimento industrializado", 35, "SuperTop", 0.2);
		compra = new Compra(6, item);
	}
	
	@Test
	public void testConstrutorCompra() {
		assertNull(c);
		c = new Compra(10, item);
		assertNotNull(c);
 	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCompraQntZero() {
		c = new Compra(0, item);
 	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutorCompraQntNegativa() {
		c = new Compra(-1, item);
 	}

	@Test
	public void testSetQtd() {
		assertEquals(6, compra.getQtd());
		compra.setQtd(12);
		assertEquals(12, compra.getQtd());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetQtdValorNegativo() {
		compra.setQtd(-12);
	}

	@Test
	public void testGetCategoria() {
		assertEquals("alimento industrializado", compra.getCategoria());
	}

	@Test
	public void testGetNome() {
		assertEquals("Iogurte Lactivia", compra.getNome());
	}

	@Test
	public void testToString() {
		assertEquals("6 Iogurte Lactivia, alimento industrializado", compra.toString());
	}
	
}
