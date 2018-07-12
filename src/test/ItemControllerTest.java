package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ItemController;

public class ItemControllerTest {

	private ItemCompravelController controller;

	@Before
	public void inciaItemController() {
		controller = new ItemController();
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemNomeVazio() {
		controller.adicionaItemPorQtd("", "higiene pessoal", 4, "gramas", "Mercado Central", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemNomeNull() {
		controller.adicionaItemPorQtd(null, "alimento industrializado", 2.0, "l", "Mercadinho BomD+", 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemCategoriaVazia() {
		controller.adicionaItemPorUnidade("Sabao", "", 1, "Mercado Central", 1.80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemCategoriaNull() {
		controller.adicionaItemPorUnidade("Bolacha", null, 2, "Supermercado Show", 3.50);

	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemCategoriaInexistente() {
		controller.adicionaItemPorQuilo("Carne Freeboy", "mamifero", 1.5, "Mercado Central", 12.30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQuiloNegativo() {
		controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", -2, "Mercado Central", 12.30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQuiloZero() {
		controller.adicionaItemPorQuilo("Frango Cocorico", "alimento industrializado", 0, "Mercadinho Legal", 9.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQtdNegativa() {
		controller.adicionaItemPorQtd("Nescau 4.0", "alimento industrializado", -2.0, "gramas", "Mercadinho BomD+",
				6.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemQtdZero() {
		controller.adicionaItemPorQtd("Molho Bolonhesa", "alimento industrializado", 0, "gramas", "Mercado Central",
				2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemUnidadeMedidaNull() {
		controller.adicionaItemPorQtd("Molho Bolonhesa", "alimento industrializado", 300, null, "Mercado Central",
				2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemUnidadeMedidaVazia() {
		controller.adicionaItemPorQtd("Nescau 4.0", "alimento industrializado", 200, "", "Mercadinho BomD+", 6.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorNegativo() {
		controller.adicionaItemPorUnidade("Shampoo Seda", "higiene pessoal", -2, "Mercado Central", 6.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorZero() {
		controller.adicionaItemPorUnidade("Detergente Limpol", "limpeza", 0, "Mercadinho DoBom", 1.80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemLocalNull() {
		controller.adicionaItemPorUnidade("Shampoo Seda", "higiene pessoal", 3, null, 6.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemLocalVazio() {
		controller.adicionaItemPorUnidade("Detergente Limpol", "limpeza", 2, "", 1.80);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorNegativo() {
		controller.adicionaItemPorQtd("Leite", "alimento industrializado", 2, "mililitro", "Mercadinho DoBom", -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraItemValorZero() {
		controller.adicionaItemPorQtd("Massa de bolo", "alimento industrializado", 2, "gramas", "Mercado do seu Zeh",
				0.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void exibeItemIdNegativo() {
		controller.adicionaItemPorUnidade("Talco PomPom", "higiene pessoal", 1, "Mercadinho DoBom", 4.80);
		controller.exibeItem(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void exibeItemIdInexistente() {
		controller.adicionaItemPorUnidade("Talco PomPom", "higiene pessoal", 1, "Mercadinho DoBom", 4.80);

		controller.exibeItem(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemInexistente() {
		int id1 = controller.adicionaItemPorQtd("Pimenta gota", "alimento industrializado", 200, "mililitro",
				"Super Mercado", 1.90);
		int id2 = controller.adicionaItemPorQuilo("Peito de flango", "alimento industrializado", 1.5,
				"Mercado do seu Zeh", 12.00);

		controller.atualizaItem(3, "nome", "blablabla");
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemAtributoInvalido() {
		int id1 = controller.adicionaItemPorQtd("Pimenta gota", "alimento industrializado", 200, "mililitro",
				"Super Mercado", 1.90);

		controller.atualizaItem(id1, "cheiro", "ovos");
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemAtributoVazio() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);

		controller.atualizaItem(id1, "", "leitche");
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemAtributoNull() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme de barbear", "higiene pessoal", 3, "Mercado Central", 8.90);

		controller.atualizaItem(id1, null, "banana");
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemNovoValorNull() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);

		controller.atualizaItem(id1, "nome", null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemNovoValorVazio() {
		int id1 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.atualizaItem(id1, "nome", "");

	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemCategoriaNaoExiste() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.atualizaItem(id2, "categoria", "comestiveis");

	}

	@Test(expected = IllegalArgumentException.class)
	public void atuaizaItemUnidadeInvalida() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.atualizaItem(id1, "unidades", "-4");
	}

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemQtdInvalida() {
		int id1 = controller.adicionaItemPorQtd("Leite Ninho", "alimento industrializado", 300, "gramas",
				"Mercadinho BomD+", 16.50);

		controller.atualizaItem(id1, "nome", "Leite Liquido");
		controller.atualizaItem(id1, "unidade de medida", "l");
		controller.atualizaItem(id1, "quantidade", "-2");
	}

	@Test(Expected = IllegalArgumentException.class)
	public void atualizaItemQuiloInvalido() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);

		controller.atualizaItem(id1, "nome", "Frango Seara");
		controller.aqualizaItem(id1, "kg", "-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemInexistente() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.adicionaPrecoItem(3, "Mercado Central", 6.99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemInvalido() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.adicionaPrecoItem(-4, "Mercado Central", 6.99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemLocalDeCompraVazio() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);

		controller.adicionaPrecoItem(id1, "", 3.99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemLocalDeCompraNull() {
		int id1 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);

		controller.adicionaPrecoItem(id1, null, 5.99);
	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemPrecoNegativo() {
		int id1 = controller.adicionaItemPorQtd("Leite Ninho", "alimento industrializado", 300, "gramas",
				"Mercadinho BomD+", 16.50);

		controller.adicionaPrecoItem(id1, "Mercado do seu Zeh", -19.00);
	}

	@Test(expected = IllegaArgumentException.class)
	public void adicionaPretoItemIdNegativo() {
		int id1 = controller.adicionaItemPorUnidade("Esmalte Risquei", "higiene pessoal", 1, "Mercadinho DoBom", 3.80);

		controller.adicionaPrecoItem(-3, "Mercado Central", 3.70);

	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemIdInexistente() {
		controller.adicionaPrecoItem(6, "Mercadinho BomD+", 9.90);

	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemLocalVazio() {
		controller.adicionaItemPorUnidade("Esmalte Risquei", "higiene pessoal", 1, "Mercadinho DoBom", 3.80);

		controller.adicionaPrecoItem(1, "", 9.90);

	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemLocalNull() {
		controller.adicionaItemPorUnidade("Esmalte Risquei", "higiene pessoal", 1, "Mercadinho DoBom", 3.80);

		controller.adicionaPrecoItem(1, null, 9.90);

	}

	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoItemPrecoInvalido() {
		controller.adicionaItemPorUnidade("Oleo Gizela", "alimento industrializado", 2, "Mercadinho BomD+", 2.90);

		controller.adicionaPrecoItem(1, "Mercado Central", -2.99);
	}

	@Test
	public void adicionaItemPorQuiloTest() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);

		assertEquals(id1 + ". Carne Freeboy, alimento industrializado, Preco por quilo: <Mercadinho Bomd+, R$ 27,00>",
				controller.exibeItem(id1));

	}

	@Test
	public void adicionaItemPorQtdTest() {
		int id1 = controller.adicionaItemPorQtd("Detergente", "limpeza", 180, "mililitro", "Mercadinho BomD+", 16.50);

		assertEquals(id1 + ". Detergente, limpeza, 180 mililitros, Preco: <Mercadinho BomD+, R$ 16,50>",
				controller.exibeItem(id1));

	}

	@Test
	public void adicionaItemPorUnidadeTest() {
		int id1 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", "Supermercado Nice", 3.99);

		assertEquals(id1 + ". Creme hidratante, higiene pessoal, Preco: <Supermercado Nice, R$ 3,99>",
				controller.exibeItem(id1));

	}

	@Test
	public void exibeItensVariadosPeloId() {
		int id1 = controller.adicionaItemPorQuilo("Carne Freeboy", "alimento industrializado", 2.0, "Mercadinho BomD+",
				27.00);
		int id2 = controller.adicionaItemPorUnidade("Creme hidratante", "higiene pessoal", 2, "Supermercado Nice",
				3.99);
		int id3 = controller.adicionaItemPorQtd("Leite Ninho", "alimento industrializado", 300, "gramas",
				"Mercadinho BomD+", 16.50);
		int id4 = controller.adicionaItemPorUnidade("Creme de barbear", "higiene pessoal", 3, "Mercado Central", 8.90);
		int id5 = controller.adicionaItemPorQtd("Algodao do campo", "higiene pessoal", 2, "gramas",
				"Mercado do seu Zeh", 1.40);
		int id6 = controller.adicionaItemPorQuilo("Peito de flango", "alimento industrializado", 1.5,
				"Mercado do seu Zeh", 12.00);
		int id7 = controller.adicionaItemPorQuilo("Mortadela Sadia", "alimento industrializado", 0.5,
				"Supermercado Top", 4.99);
		int id8 = controller.adicionaitemPorUnidade("Guardanapo", "limpeza", 4, "Super Mercado", 1.00);

		assertEquals(id1 + ". Carne Freeboy, alimento industrializado, Preco por quilo: <Mercadinho BomD+, R$ 27,00>",
				controller.exibeItem(id1));
		assertEquals(id2 + ". Creme hidratante, higiene pessoal, Preco: <Supermercado Nice, R$ 3,99>",
				controller.exibeItem(id2));
		asserEquals(id3 + ". Leite Ninho, alimento industrializado, 300 gramas, Precp: <Mercadinho BomD+, R$ 16,50>",
				controller.exibeItem(id3));
		assertEquals(id4 + ". Creme de barbear, higiene pessoal, Preco: <Mercado Central, R$ 8,90>",
				controller.exibeItem(id4));
		assertEquals(id5 + ". Algodao do campo, higiene pessoal, Preco: <Mercado do seu Zeh, R$ 1,40>",
				controller.exibeItem(id5));
		assertEquals(
				id6 + ". Peito de flango, alimento industrializado, Preco por quilo: <Mercado do seu Zeh, R$ 12,00",
				controller.exibeItem(id6));
		assertEquals(id7 + ". Mortadela Sadia, alimento industrializado, Preco por quilo: <Supermercado Top, R$ 4,99>",
				controller.exibeItem(id7));
		assertEquals(id8 + ". Guardanapo, limpeza, Preco: <Super Mercado, R$ 1,00>", controller.exibeItem(id8));

	}

	@Test
	public void atualizaItemPorQtdTest() {
		int id1 = controller.adicionaItemPorQtd("Talco para chuleh", "higiene pessoal", 250, "gramas",
				"Mercado Central", 6.80);
		assertEquals(id1 + ". Talco para chuleh, higiene pessoal, 150 gramas, Preco: <Mercado Central, R$ 6,80>",
				controller.exibeItem(id1));

		controller.atualizaItem(id1, "nome", "Talco para BB");
		controller.atualizaItem(id1, "quantidade", "200");

		assertEquals(id1 + ". Talco para BB, higiene pessoal, 200 gramas, Preco: <Mercado Central, R$ 6,80>",
				controller.exibeItem(id1));
	}

	@Test
	public void atualizaItemPorQuiloTest() {
		int id1 = controller.adicionaItemPorQuilo("Peito de flango", "alimento industrializado", 1.5,
				"Mercado do seu Zeh", 12.00);
		assertEquals(
				id1 + ". Peito de flango, alimento industrializado, Preco por quilo: <Mercado do seu Zeh, R$ 12,00",
				controller.exibeItem(id1));

		controller.atualizaItem(id1, "nome", "File Mignon");
		controller.atualizaItem(id1, "kg", "2.0");

		assertEquals(id1 + ". File Mignon, alimento industrializado, Preco por quilo: <Mercado do seu Zeh, R$ 12,00>",
				controller.exibeItem(id1));
	}

	@Test
	public void atualizaItemPorUnidadeTest() {
		int id1 = controller.adicionaItemPorUnidade("Creme de barbear", "higiene pessoal", 3, "Mercado Central", 8.90);
		assertEquals(id1 + ". Creme de barbear, higiene pessoal, Preco: <Mercado Central, R$ 8,90>",
				controller.exibeItem(id1));

		controller.atualizaItem(id1, "nome", "Oleo de peroba");
		controller.atualizaItem(id1, "categoria", "limpeza");
		assertEquals(id1 + ". Oleo de peroba, limpeza, Preco: <Mercado Central, R$ 8,90>", controller.exibeItem(id1));
	}

	@Test
	public void adicionaNovosPrecos() {
		int id1 = controller.adicionaItemPorUnidade("Esmalte Risquei", "higiene pessoal", 1, "Mercadinho DoBom", 3.80);
		int id2 = controller.adicionaItemPorQtd("Azeite", "alimento industrializado", 300, "gramas",
				"Mercado do seu Zeh", 9.80);
		int id3 = controller.adicionaItemPorQuilo("Queijo Mussarela", "alimento industrializado", 0.5,
				"Mercado Central", 9.00);

		controller.adicionaPrecoItem(id1, "Super Mercado", 3.70);
		controller.adicionaPrecoItem(id2, "Supermercado Top", 10.99);
		controller.adicionaPrecoItem(id3, "Mercadinho BomD+", 9.50);

		assertEquals(
				id1 + ". Esmalte Risquei, higiene pessoa, Preco: <Mercadinho DoBom, R$ 3,80; Super Mercado, R$ 3,70>",
				controller.exibeItem(id1));
		assertEquals(id2
				+ ". Azeite, alimento industrializado, 300 gramas, Preco: <Mercado do seu Zeh, R$ 9,80; Supermercado Top, R$ 10,99>",
				controller.exibeItem(id2));
		assertEquals(id3
				+ ". Queijo Mussarela, alimento industrializado, Preco por quilo: <Mercado Central, R$ 9,00; Mercadinho BomD+, R$ 9,50>",
				controller.exibeItem(id3));

	}

	@Test(expected = IllegalArgumentException.class)
	public void deletaItensExibe() {
		int id1 = controller.adicionaItemPorUnidade("Esmalte Risquei", "higiene pessoal", 1, "Mercadinho DoBom", 3.80);

		controller.deletaItem(id1);
		controller.exibeItem(id1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deletaItensAtualiza() {
		int id1 = controller.adicionaItemPorQtd("Azeite", "alimento industrializado", 300, "gramas",
				"Mercado do seu Zeh", 9.80);

		controller.deletaItem(id1);
		controller.atualizaItem(id1, "nome", "azedo");


	}

}
