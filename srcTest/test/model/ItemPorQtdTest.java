package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ItemPorQtd;

public class ItemPorQtdTest {

	private ItemPorQtd item;
	private ItemPorQtd sabonete;
	private ItemPorQtd algodao;

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

	@Test
	public void testToString() {
		assertEquals("219. Algodão Clemer, higiene pessoal, 300 gramas, Preco: <Baratao, R$ 2,30;Supermercado BaratoD+, R$ 2,33;>", algodao.toString());
	}
	
	@Test
	public void testGetDescricaoBasica(){
		assertEquals("Testa descricao basica", "Sabonete de aveia Dorene, higiene pessoal, 5 gramas", sabonete.getDescricaoBasica());
	}
	
	@Test
	public void testAtualiza(){
		sabonete.atualiza("litros");
		assertEquals("Testa descricao basica", "Sabonete de aveia Dorene, higiene pessoal, 5 litros", sabonete.getDescricaoBasica());
	}
}
