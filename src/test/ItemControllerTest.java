package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ItemController;

public class ItemControllerTest {
	
	private ItemController controller;
	
	@Before
	public void inciaItemController() {
		controller = new ItemController();
	}
	
	@Test
	public void adicionaItemPorQuiloTest() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+", 27.00);
		int id2 = controller.adicionaItemPorQuilo("Peito de flango", "alimento industrializado", 1.5, "Mercado do seu Zeh", 12.00);
		
		assertEquals(id1 + ". Carne Freeboy, alimento industrializado, Preco por quilo: <Mercadinho Bomd+, R$ 27,00>");
		assertEquals(id2 + ". Peito de flango, alimento industrializado, Preco por quilo: <Mercado do seu Zeh, R$ 12,00>");
	}
	
	@Test
	public void adicionaItemPorQtdTest() {
		int id3 = controller.adicionaItemPorQtd("Fralda Xo Xixi", "higiene pessoal", 3, "Mercadinho BomD+", 16.50);
		int id4 = controller.adicionaItemPorQtd("Algodao do campo", "higiene pessoal", 2, "Mercado do seu Zeh", 1.40);
		
		assertEquals(id3 + ". Fralda Xo Xixi, higiene pessoal, Preco: <Mercadinho BomD+, R$ 16,50");
		assertEquals(id4 + ". Algodao do campo, higiene pessoal, Preco: <Mercado do seu Zeh, R$ 1,40");
	}
	

}
