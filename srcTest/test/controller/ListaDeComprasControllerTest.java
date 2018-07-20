package test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.ItemCompravelController;
import util.CategoriaEnum;

public class ListaDeComprasControllerTest {
	ListaDeComprasController controller;
	ItemCompravelController itemController;
	
	@Before
	public void setUp(){
		controller = new ListaDeComprasController();
		itemController = new ItemCompravelController();
		controller.adicionaListaDeCompras("feira");
	}
	
	@Test()
	public void testCriar() {
		new ListaDeComprasController();
	}
	
	//--------------- TESTA CRIAR UMA LISTA DE COMPRAS --------------------//
	@Test
	public void testAdicionaListaDeCompras(){
		assertEquals("Verifica se adicionou lista de compras ao sistema corretamente", "feira semanal", 
				controller.adicionaListaDeCompras("feira semanal"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaListaDeComprasDescritorVazio(){
		assertEquals("Verifica se adicionou lista de compras ao sistema corretamente", "feira semanal", 
				controller.adicionaListaDeCompras(" "));
	}
	
	//---------------- TESTA ADICIONAR COMPRA A LISTA--------------------//
	@Test
	public void testAdicionaCompraALista(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		controller.adicionaCompraALista("feira", itemId, 2);
		
		assertEquals("Verifica se adicionou compra a lista de compras", "2 "+ itemController.exibeItem(itemId), 
				controller.getItemLista("feira", 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaCompraAListaDescritorVazio(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		controller.adicionaCompraALista(" ", itemId, 2);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalida(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		controller.adicionaCompraALista("opaopa", itemId, 2);

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaCompraAListaQuantidadeInvalida(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		controller.adicionaCompraALista(" ", itemId, 0);
		controller.adicionaCompraALista(" ", itemId, -2);
	}
	
	//---------------- TESTA PESQUISAR ITEM NA LISTA--------------------//
	@Test
	public void testPesquisaCompraEmLista(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		assertEquals("Verifica pesquisa esta funcionando", "2 "+ itemController.exibeItem(itemId), 
				controller.pesquisaCompraEmLista("feira", itemId));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalida(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.pesquisaCompraEmLista("AAAA", itemId);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaCompraEmListaVazia(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.pesquisaCompraEmLista("", itemId);
	}
	
	//---------------- TESTA ATUALIZAR ITEM NA LISTA--------------------//
	@Test
	public void testAtualizaCompraDeListaAdicionar(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		controller.atualizaCompraDeLista("feira", itemId, "adiciona", 2);
		
		assertEquals("Verifica se atualizou quantidade do item", "4 "+ itemController.exibeItem(itemId), 
				controller.pesquisaCompraEmLista("feira", itemId));
	}
	
	@Test
	public void testAtualizaCompraDeListaDiminui(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		controller.atualizaCompraDeLista("feira", itemId, "diminui", 1);
		
		assertEquals("Verifica se atualizou quantidade do item", "1 "+ itemController.exibeItem(itemId), 
				controller.pesquisaCompraEmLista("feira", itemId));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaCompraDeListaItemInvalido(){
		controller.atualizaCompraDeLista("feira", -2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaCompraDeListaItemInexistente(){
		controller.atualizaCompraDeLista("feira", 4, "diminui", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaCompraDeListaValorNegativo(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		controller.atualizaCompraDeLista("feira", itemId, "diminui", -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaCompraDeListaOperacaoInvalido(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		controller.atualizaCompraDeLista("feira", itemId, "peguei", 1);
	}
	
	//---------------- TESTA DELETAR ITEM NA LISTA--------------------//
	@Test
	public void testDeletaCompraDeLista(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.adicionaCompraALista("feira", itemId, 2);
		
		controller.deletaCompraDeLista("feira", itemId);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeletaCompraDeListaDescritorInvalido(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.deletaCompraDeLista("", itemId);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeletaCompraDeListaIdInvalido(){
		controller.deletaCompraDeLista("feira", -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeletaCompraDeListaInexistente(){
		int itemId = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		controller.deletaCompraDeLista("opaaa", itemId);
	}
	
	//---------------- TESTA GET ITEM POR POSICAO --------------------//
	@Test
	public void testGetItemLista(){
		int itemId1 = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		int itemId2 = itemController.adicionaItemPorUnidade("melao", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 7.6);
		
		int itemId3 = itemController.adicionaItemPorUnidade("banana", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 4.0);
		
		controller.adicionaCompraALista("feira", itemId1, 1);
		controller.adicionaCompraALista("feira", itemId2, 1);
		controller.adicionaCompraALista("feira", itemId3, 1);

		
		assertEquals("Verifica se getItemLista() esta funcionando", "1 "+ itemController.exibeItem(itemId1), 
				controller.getItemLista("feira", 0));
		
		assertEquals("Verifica se getItemLista() esta funcionando", "1 "+ itemController.exibeItem(itemId2), 
				controller.getItemLista("feira", 1));
		
		assertEquals("Verifica se getItemLista() esta funcionando", "1 "+ itemController.exibeItem(itemId3), 
				controller.getItemLista("feira", 2));
	}
	
	@Test
	public void testGetItemListaPosicaoComNenhumItem(){
		assertEquals("Verifica se getItemLista() retorna vazio quando nao tem item na posicao", "", 
				controller.getItemLista("feira", 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetItemListaPosicaoInvalida(){
		controller.getItemLista("feira", -1);
	}
	
	//---------------- TESTA FINALIZAR LISTA --------------------//
	@Test
	public void testFinalizarListaDeCompras(){
		controller.adicionaListaDeCompras("papai");
		
		int itemId1 = itemController.adicionaItemPorUnidade("abacate", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 2.4);
		
		int itemId2 = itemController.adicionaItemPorUnidade("melao", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 7.6);
		
		int itemId3 = itemController.adicionaItemPorUnidade("banana", CategoriaEnum.ALIMENTOS_NAO_INDUSTRIALIZADOS.toString(), 
				2, "haha", 4.0);
		
		controller.adicionaCompraALista("papai", itemId1, 1);
		controller.adicionaCompraALista("papai", itemId2, 1);
		controller.adicionaCompraALista("papai", itemId3, 1);
		
		controller.finalizarListaDeCompras("papai", "supermercado", 14.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasLocalDeCompraVazio(){
		controller.adicionaListaDeCompras("papai");
		
		controller.finalizarListaDeCompras("papai", "", 14.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasDescritorVazio(){
		controller.finalizarListaDeCompras("", "supermercado", 14.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInexistente(){
		controller.finalizarListaDeCompras("mamae", "supermercado", 14.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasValorNegativo(){
		controller.adicionaListaDeCompras("papai");

		controller.finalizarListaDeCompras("papai", "supermercado", -2);
	}
}
