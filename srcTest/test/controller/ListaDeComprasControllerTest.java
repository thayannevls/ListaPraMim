package test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.ItemCompravelController;
import controller.ListaDeComprasController;
import util.CategoriaEnum;

public class ListaDeComprasControllerTest {
	ListaDeComprasController controller;
	ItemCompravelController itemController;

	@Before
	public void setUp() {
		controller = new ListaDeComprasController();
		itemController = new ItemCompravelController();
		controller.adicionaListaDeCompras("feira");
	}

	@Test()
	public void testCriar() {
		new ListaDeComprasController();
	}

	// --------------- TESTA CRIAR UMA LISTA DE COMPRAS --------------------//
	@Test
	public void testAdicionaListaDeCompras() {
		assertEquals("Verifica se adicionou lista de compras ao sistema corretamente", "feira semanal",
				controller.adicionaListaDeCompras("feira semanal"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasDescritorVazio() {
		assertEquals("Verifica se adicionou lista de compras ao sistema corretamente", "feira semanal",
				controller.adicionaListaDeCompras(" "));
	}

	// ---------------- TESTA ADICIONAR COMPRA A LISTA--------------------//
	@Test
	public void testAdicionaCompraALista() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		assertEquals("Verifica se adicionou compra a lista de compras", controller.getItemLista("feira", 0),
				controller.getItemLista("feira", 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaDescritorVazio() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		controller.adicionaCompraALista(" ", 2, itemController.getItemCadastrado(itemId));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalida() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		controller.adicionaCompraALista("opaopa", 2, itemController.getItemCadastrado(itemId));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaQuantidadeInvalida() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		controller.adicionaCompraALista(" ", 0, itemController.getItemCadastrado(itemId));
		controller.adicionaCompraALista(" ", -2, itemController.getItemCadastrado(itemId));
	}

	// ---------------- TESTA PESQUISAR ITEM NA LISTA--------------------//
	@Test
	public void testPesquisaCompraEmLista() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		assertEquals("Verifica pesquisa esta funcionando", controller.getItemLista("feira", 0),
				controller.pesquisaCompraEmLista("feira", itemId));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalida() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.pesquisaCompraEmLista("AAAA", itemId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaVazia() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.pesquisaCompraEmLista("", itemId);
	}

	// ---------------- TESTA ATUALIZAR ITEM NA LISTA--------------------//
	@Test
	public void testAtualizaCompraDeListaAdicionar() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		controller.atualizaCompraDeLista("feira", itemId, "adiciona", 2);

		assertEquals("Verifica se atualizou quantidade do item", controller.getItemLista("feira", 0),
				controller.pesquisaCompraEmLista("feira", itemId));
	}

	@Test
	public void testAtualizaCompraDeListaDiminui() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		controller.atualizaCompraDeLista("feira", itemId, "diminui", 1);

		assertEquals("Verifica se atualizou quantidade do item", controller.pesquisaCompraEmLista("feira", itemId),
				controller.pesquisaCompraEmLista("feira", itemId));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaItemInvalido() {
		controller.atualizaCompraDeLista("feira", -2, "diminui", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaItemInexistente() {
		controller.atualizaCompraDeLista("feira", 4, "diminui", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaValorNegativo() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		controller.atualizaCompraDeLista("feira", itemId, "diminui", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaOperacaoInvalido() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		controller.atualizaCompraDeLista("feira", itemId, "peguei", 1);
	}

	// ---------------- TESTA DELETAR ITEM NA LISTA--------------------//
	@Test
	public void testDeletaCompraDeLista() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.adicionaCompraALista("feira", 2, itemController.getItemCadastrado(itemId));

		controller.deletaCompraDeLista("feira", itemId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaDescritorInvalido() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.deletaCompraDeLista("", itemId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaIdInvalido() {
		controller.deletaCompraDeLista("feira", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInexistente() {
		int itemId = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);
		controller.deletaCompraDeLista("opaaa", itemId);
	}

	// ---------------- TESTA GET ITEM POR POSICAO --------------------//
	@Test
	public void testGetItemLista() {
		int itemId1 = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		int itemId2 = itemController.adicionaItemPorUnidade("melao",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 7.6);

		int itemId3 = itemController.adicionaItemPorUnidade("banana",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 4.0);

		controller.adicionaCompraALista("feira", 1, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("feira", 1, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("feira", 1, itemController.getItemCadastrado(itemId3));

		assertEquals("Verifica se getItemLista() esta funcionando", controller.pesquisaCompraEmLista("feira", itemId1),
				controller.getItemLista("feira", 0));

		assertEquals("Verifica se getItemLista() esta funcionando", controller.pesquisaCompraEmLista("feira", itemId3),
				controller.getItemLista("feira", 1));

		assertEquals("Verifica se getItemLista() esta funcionando", controller.pesquisaCompraEmLista("feira", itemId2),
				controller.getItemLista("feira", 2));
	}

	@Test
	public void testGetItemListaPosicaoComNenhumItem() {
		assertEquals("Verifica se getItemLista() retorna vazio quando nao tem item na posicao", "",
				controller.getItemLista("feira", 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPosicaoInvalida() {
		controller.getItemLista("feira", -1);
	}

	// ---------------- TESTA FINALIZAR LISTA --------------------//
	@Test
	public void testFinalizarListaDeCompras() {
		controller.adicionaListaDeCompras("papai");

		int itemId1 = itemController.adicionaItemPorUnidade("abacate",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 2.4);

		int itemId2 = itemController.adicionaItemPorUnidade("melao",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 7.6);

		int itemId3 = itemController.adicionaItemPorUnidade("banana",
				CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 2, "haha", 4.0);

		controller.adicionaCompraALista("papai", 1, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("papai", 1, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("papai", 1, itemController.getItemCadastrado(itemId3));

		controller.finalizarListaDeCompras("papai", "supermercado", 14.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasLocalDeCompraVazio() {
		controller.adicionaListaDeCompras("papai");

		controller.finalizarListaDeCompras("papai", "", 14.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasDescritorVazio() {
		controller.finalizarListaDeCompras("", "supermercado", 14.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInexistente() {
		controller.finalizarListaDeCompras("mamae", "supermercado", 14.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasValorNegativo() {
		controller.adicionaListaDeCompras("papai");

		controller.finalizarListaDeCompras("papai", "supermercado", -2);
	}

	// ---------------- TESTA CASE 5, GERACAO DE LISTA AUTOMATICA 1 --------------------//
	@Test
	public void getUltimaListaTest() {
		controller.adicionaListaDeCompras("vovo");

		int itemId1 = itemController.adicionaItemPorUnidade("pasta", "higiene pessoal", 1, "mercadao", 2.90);
		int itemId2 = itemController.adicionaItemPorUnidade("abacaxi", "alimento nao industrializado", 3,
				"supermercado", 3.50);
		int itemId3 = itemController.adicionaItemPorQuilo("carne seara", "alimento industrializado", 2.0, "mercadinho",
				15.00);

		controller.adicionaCompraALista("vovo", 2, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("vovo", 1, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("vovo", 3, itemController.getItemCadastrado(itemId3));

		assertEquals("2 pasta, higiene pessoal", controller.getItemLista(controller.geraAutomaticaUltimaLista(), 0));
		assertEquals("3 carne seara, alimento industrializado",
				controller.getItemLista(controller.geraAutomaticaUltimaLista(), 1));
		assertEquals("1 abacaxi, alimento nao industrializado",
				controller.getItemLista(controller.geraAutomaticaUltimaLista(), 2));

	}
	
	// ---------------- TESTA CASE 5, GERACAO DE LISTA AUTOMATICA 2 --------------------//
	@Test
	public void geraAutomaticaItemTest() {
		controller.adicionaListaDeCompras("frutineas");

		int itemId1 = itemController.adicionaItemPorUnidade("pera", "alimento nao industrializado", 4, "mercadao", 1.90);
		int itemId2 = itemController.adicionaItemPorUnidade("abacaxi", "alimento nao industrializado", 3,
				"supermercado", 3.50);
		int itemId3 = itemController.adicionaItemPorQuilo("maca", "alimento nao industrializado", 2, "mercadinho",
				0.80);
		
		controller.adicionaCompraALista("frutineas", 2, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("frutineas", 3, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("frutineas", 4, itemController.getItemCadastrado(itemId3));
		
		controller.geraAutomaticaItem("abacaxi");
		assertEquals("3 abacaxi, alimento nao industrializado", controller.getItemLista(controller.geraAutomaticaItem("abacaxi"), 0));
		assertEquals("4 maca, alimento nao industrializado", controller.getItemLista(controller.geraAutomaticaItem("abacaxi"), 1));
		assertEquals("2 pera, alimento nao industrializado", controller.getItemLista(controller.geraAutomaticaItem("abacaxi"), 2));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
		public void geraAutomatiaItemInexistente() {
			controller.geraAutomaticaItem("banana");
		}
	
	
	// ---------------- TESTA CASE 5, GERACAO DE LISTA AUTOMATICA 3 --------------------//
	@Test
	public void geraAutomaticaItensMaisPresentesTest() {
		// ---- criando primeira lista de compras ---- //
		controller.adicionaListaDeCompras("destilados");

		int itemId1 = itemController.adicionaItemPorUnidade("smirnoff", "alimento industrializado", 2, "mercadao", 15.50);
		int itemId2 = itemController.adicionaItemPorUnidade("balantines", "alimento industrializado", 3,
				"supermercado", 23.50);
		int itemId3 = itemController.adicionaItemPorUnidade("sky vodka", "alimento industrializado", 4, "mercadinho",
				16.80);
		controller.adicionaCompraALista("destilados", 4, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("destilados", 3, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("destilados", 2, itemController.getItemCadastrado(itemId3));
		
		// ---- criando segunda lista de compras ---- //
		controller.adicionaListaDeCompras("outrolados");
		int itemId4 = itemController.adicionaItemPorUnidade("smirnoff", "alimento industrializado", 2, "mercadao", 15.50);
		int itemId5 = itemController.adicionaItemPorUnidade("ciroc", "alimento industrializado", 1,
				"supermercado", 23.50);
		int itemId6 = itemController.adicionaItemPorUnidade("balantines", "alimento industrializado", 1, "mercadinho",
				16.80);
		
		controller.adicionaCompraALista("outrolados", 2, itemController.getItemCadastrado(itemId4));
		controller.adicionaCompraALista("outrolados", 3, itemController.getItemCadastrado(itemId5));
		controller.adicionaCompraALista("outrolados", 4, itemController.getItemCadastrado(itemId6));
		
		controller.geraAutomaticaItensMaisPresentes(6);
		assertEquals("3 balantines, alimento industrializado", controller.getItemLista(controller.geraAutomaticaItensMaisPresentes(6), 0));
		assertEquals("3 ciroc, alimento industrializado", controller.getItemLista(controller.geraAutomaticaItensMaisPresentes(6), 1));
		assertEquals("2 sky vodka, alimento industrializado", controller.getItemLista(controller.geraAutomaticaItensMaisPresentes(6), 2));
		assertEquals("4 smirnoff, alimento industrializado", controller.getItemLista(controller.geraAutomaticaItensMaisPresentes(6), 3));
	}
	
	
	// ---------------- TESTA CASE 6, SUGESTAO DE MELHOR ESTABELECIMENTO --------------------//
	
	@Test
	public void sugereMelhorEstabelecimentoTest() {
		// ---- cadastrando itens ---- //
		
		int itemId1 = itemController.adicionaItemPorQuilo("Peito peru ", "alimento industrializado", 2.0, "Mercadinho Bem Barato", 34.49);
		int itemId2 = itemController.adicionaItemPorUnidade("Batata Chips", "alimento industrializado", 3, "Supermercado UauMart", 3.69);
		int itemId3 = itemController.adicionaItemPorQtd("Capsulas tres coracoes", "alimento industrializado", 8, "capsulas", "Mercadinho Bem Barato", 11.69);
		int itemId4 = itemController.adicionaItemPorQuilo("Macaxeira", "alimento nao industrializado", 0.5, "Mercadinho Bem Barato", 3.69);
		int itemId5 = itemController.adicionaItemPorUnidade("Veja so", "limpeza", 3, "Mercadinho Bem Barato", 3.69);
		
		// ---- adicionando mais precos ---- //
		itemController.adicionaPrecoItem(itemId1, "SuperMercado UauMart", 43.69);
		itemController.adicionaPrecoItem(itemId1, "Supermercado BuyMore", 33.09);
		itemController.adicionaPrecoItem(itemId2, "Mercadinho Bem Barato", 3.99);
		itemController.adicionaPrecoItem(itemId2, "Supermercado BuyMore", 4.09);
		itemController.adicionaPrecoItem(itemId2, "Supermercado Excepcional", 3.79);
		itemController.adicionaPrecoItem(itemId3, "Supermercado UauMart", 10.89);
		itemController.adicionaPrecoItem(itemId3, "Supermercado BuyMore", 10.89);
		itemController.adicionaPrecoItem(itemId3, "Supermercado Excepcional", 9.49);
		itemController.adicionaPrecoItem(itemId4, "Supermercado UauMart", 4.49);
		itemController.adicionaPrecoItem(itemId4, "Supermercado Excepcional", 4.19);
		itemController.adicionaPrecoItem(itemId5, "Supermercado BuyMore", 3.50);
		
		// ---- iniciado lista de compras e adicionando itens  ---- //
		controller.adicionaListaDeCompras("fefeira");
		controller.adicionaCompraALista("fefeira", 1, itemController.getItemCadastrado(itemId1));
		controller.adicionaCompraALista("fefeira", 3, itemController.getItemCadastrado(itemId2));
		controller.adicionaCompraALista("fefeira", 1, itemController.getItemCadastrado(itemId3));
		controller.adicionaCompraALista("fefeira", 2, itemController.getItemCadastrado(itemId4));
		controller.adicionaCompraALista("fefeira", 1, itemController.getItemCadastrado(itemId5));
		
		// ---- testando os precos totais ---- //
		assertEquals("Supermercado Excepcional: R$ 29,24", controller.sugereMelhorEstabelecimento("fefeira", 0, 0));
		assertEquals("Supermercado BuyMore: R$ 59,75", controller.sugereMelhorEstabelecimento("fefeira", 1, 0));
		assertEquals("Mercadinho Bem Barato: R$ 71,62", controller.sugereMelhorEstabelecimento("fefeira", 2, 0));
		assertEquals("Supermercado UauMart: R$ 74,63", controller.sugereMelhorEstabelecimento("fefeira", 3, 0));
		
		// ---- testando os itens ---- //
		assertEquals("- 3 Batata Chips, alimento industrializado", controller.sugereMelhorEstabelecimento("fefeira", 0, 1));
		assertEquals("", controller.sugereMelhorEstabelecimento("fefeira", 0, 4));
		
		assertEquals("- Veja so, limpeza", controller.sugereMelhorEstabelecimento("fefeira", 1, 1));
		assertEquals("", controller.sugereMelhorEstabelecimento("fefeira", 1, 5));
		
		assertEquals("- Veja so, limpeza", controller.sugereMelhorEstabelecimento("fefeira", 2, 1));
		assertEquals("- Macaxeira, alimento nao industrializado", controller.sugereMelhorEstabelecimento("fefeira", 2, 5));
		
		assertEquals("- Batata Chips, alimento industrializado", controller.sugereMelhorEstabelecimento("fefeira", 3, 1));
		assertEquals("", controller.sugereMelhorEstabelecimento("fefeira", 3, 5));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sugereMelhorEstabelecimentoSemDados() {
		controller.adicionaListaDeCompras("drogon");
		controller.sugereMelhorEstabelecimento("drogon", 0, 0);
		
	}
	
}
