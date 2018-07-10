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

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemNomeInvalido() {
		controller.adicionaItemPorQtd("", "higiene pessoal", 4, "gramas", "Mercado Central", 2.50);
		controller.adicionaItemPorQtd(null, "alimento industrializado", 2.0, "l", "Mercadinho BomD+", 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemCategoriaInvalida() {
		controller.adicionaItemPorUnidade("Sabao", "", 1, "Mercado Central", 1.80);
		controller.adicionaItemPorUnidade("Bolacha", null, 2, "Supermercado Show", 3.50);

	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemCategoriaInexistente() {
		controller.adicionaItemPorQuilo("Carne Freeboy", "mamifero", 1.5, "Mercado Central", 12.30);
		controller.adicionaItemPorQuilo("Frango Cocorico", "ave", 2.0, "Mercadinho Legal", 9.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQuiloInvalido() {
		controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", -2, "Mercado Central", 12.30);
		controller.adicionaItemPorQuilo("Frango Cocorico", "alimento industrializado", 0, "Mercadinho Legal", 9.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQtdInvalida() {
		controller.adicionaItemPorQtd("Molho Bolonhesa", "alimento industrializado", 0, "gramas", "Mercado Central",
				2.50);
		controller.adicionaItemPorQtd("Nescau 4.0", "alimento industrializado", -2.0, "gramas", "Mercadinho BomD+",
				6.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemMedidaInvalida() {
		controller.adicionaItemPorQtd("Molho Bolonhesa", "alimento industrializado", 3, null, "Mercado Central", 2.50);
		controller.adicionaItemPorQtd("Nescau 4.0", "alimento industrializado", 2, "", "Mercadinho BomD+", 6.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorNegativo() {
		controller.adicionaItemPorUnidade("Shampoo Seda", "higiene pessoal", -2, "Mercado Central", 6.50);
		controller.adicionaItemPorUnidade("Detergente Limpol", "limpeza", 0, "Mercadinho DoBom", 1.80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemLocalInvalido() {
		controller.adicionaItemPorUnidade("Shampoo Seda", "higiene pessoal", 3, null, 6.50);
		controller.adicionaItemPorUnidade("Detergente Limpol", "limpeza", 2, "", 1.80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorInvalido() {
		controller.adicionaItemPorQtd("Massa de bolo", "alimento industrializado", 2, "gramas", "Mercado do seu Zeh", 0.00);
		controller.adicionaItemPorQtd("Leite", "alimento industrializado", 2, "mililitro", "Mercadinho DoBom", -3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exibeItemIdInvalido() {
		controller.adicionaItem
	}

	@Test
	public void adicionaItemPorQuiloTest() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+", 27.00);
		int id2 = controller.adicionaItemPorQuilo("Peito de flango", "alimento industrializado", 1.5,
				"Mercado do seu Zeh", 12.00);

		assertEquals(id1 + ". Carne Freeboy, alimento industrializado, Preco por quilo: <Mercadinho Bomd+, R$ 27,00>");
		assertEquals(id2 + ". Peito de flango, alimento industrializado, Preco por quilo: <Mercado do seu Zeh, R$ 12,00>");
	}

	@Test
	public void adicionaItemPorQtdTest() {
		int id1 = controller.adicionaItemPorQtd("Fralda Xo Xixi", "higiene pessoal", 3, "gramas", "Mercadinho BomD+",
				16.50);
		int id2 = controller.adicionaItemPorQtd("Algodao do campo", "higiene pessoal", 2, "gramas", "Mercado do seu Zeh", 1.40);

		assertEquals(id1 + ". Fralda Xo Xixi, higiene pessoal, 400 gramas, Preco: <Mercadinho BomD+, R$ 16,50", método);
		assertEquals(id2 + ". Algodao do campo, higiene pessoal, 150 gramas, Preco: <Mercado do seu Zeh, R$ 1,40");
	}

}
