package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.ListaPraMim;
import easyaccept.EasyAccept;

/**
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class Facade {

	ListaPraMim sistema;

	public static void main(String[] args) {
		args = new String[] { "ui.Facade", "acceptance_test/use_case1.txt", "acceptance_test/use_case1_exception.txt",
				"acceptance_test/use_case2.txt", "acceptance_test/use_case2_exception.txt",
				"acceptance_test/use_case3.txt", "acceptance_test/use_case3_exception.txt",
				"acceptance_test/use_case4.txt", "acceptance_test/use_case4_exception.txt",
				"acceptance_test/use_case5.txt", "acceptance_test/use_case7.txt" };

		EasyAccept.main(args);
	}

	/**
	 * Inicializa os atributos do Facade.
	 */
	public Facade() {
		this.sistema = new ListaPraMim();
	}

	/**
	 * Adiciona um Item com quantidade fixa
	 * 
	 * @param nome
	 *            nome do produto
	 * @param categoria
	 *            categoria a que pertence
	 * @param qnt
	 *            quantidade
	 * @param unidadeDeMedida
	 *            unidade de medida adotada
	 * @param localDeCompra
	 *            local de compra do produto
	 * @param preco
	 *            preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.sistema.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Adiciona um item por quilo
	 * 
	 * @param nome
	 *            nome do produto
	 * @param categoria
	 *            categoria a que pertence
	 * @param kg
	 *            peso do item
	 * @param localDeCompra
	 *            local de compra do produto
	 * @param preco
	 *            preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.sistema.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Adiciona item por unidade
	 * 
	 * @param nome
	 *            nome do produto
	 * @param categoria
	 *            categoria a que pertence
	 * @param unidade
	 *            unidades
	 * @param localDeCompra
	 *            local de compra do produto
	 * @param preco
	 *            preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.sistema.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	/**
	 * Retorna representacao textual de um item
	 * 
	 * @param id
	 *            id do item
	 * @return String item
	 */
	public String exibeItem(int id) {
		return this.sistema.exibeItem(id);
	}

	/**
	 * Adiciona um preco ao mapa de compras do item
	 * 
	 * @param id
	 *            id do item a ser adicionado
	 * @param localDeCompra
	 *            local de compra do produto
	 * @param preco
	 *            preco nesse local de compra
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.sistema.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Atualiza item com id especificado
	 * 
	 * @param id
	 *            id do item
	 * @param atributo
	 *            atributo a ser modificado
	 * @param novoValor
	 *            novo valor do atributo
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.sistema.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Deleta item que contem id especificado
	 * 
	 * @param id
	 */
	public void deletaItem(int id) {
		this.sistema.deletaItem(id);
	}

	/**
	 * Exibe item ordenado por ordem alfabetica.
	 * 
	 * @param posicao
	 *            identificador do item
	 * @return String - representacao do item
	 */
	public String getItem(int posicao) {
		return this.sistema.getItem(posicao);
	}

	/**
	 * Exibe item ordenado por uma dada categoria em ordem alfabetica.
	 * 
	 * @param categoria
	 *            categoria do item
	 * @param posicao
	 *            identificador do item
	 * @return String - representacao do item
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.sistema.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Exibe item ordenado em ordem crescente pelo menor preco cadastrado.
	 * 
	 * @param posicao
	 *            identificador do item
	 * @return String - representacao do item
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.sistema.getItemPorMenorPreco(posicao);
	}

	/**
	 * Exibe item ordenado por pesquisa inserida pelo usuario.
	 * 
	 * @param strPesquisada
	 *            String a ser pesquisada
	 * @param posicao
	 *            identificador do item
	 * @return String - representacao do item
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.sistema.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Cria uma lista de compras.
	 * 
	 * @param descricao
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 */
	public String adicionaListaDeCompras(String descricao) {
		return this.sistema.adicionaListaDeCompras(descricao);
	}

	/**
	 * Adiciona uma item na lista de compra especificada.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param quantidade
	 *            quantidade do item
	 * @param itemId
	 *            identificador do item
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.sistema.adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	/**
	 * Pesquisa uma lista pelo seu descritor
	 * 
	 * @param descritor
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @return String - representando a lista encontrada
	 */
	public String pesquisaListaDeCompras(String descritor) {
		return this.sistema.pesquisaListaDeCompras(descritor);
	}

	/**
	 * Pesquisa por lista de compras especificada pelo descritor.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param itemId
	 *            identificador do item
	 * @return String - representando a lista encontrada pela pesquisa
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return this.sistema.pesquisaCompraEmLista(descritorLista, itemId);
	}

	/**
	 * Atualiza item especificado a partir da quantidade.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param itemId
	 *            identificador do item
	 * @param operacao
	 *            operacao escolhida para a atualizacao
	 * @param quantidade
	 *            quantidade a ser atualizada
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.sistema.atualizaCompraDeLista(descritorLista, itemId, operacao, quantidade);
	}

	/**
	 * Deleta determinado item da lista.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param itemId
	 *            identificador do item a ser deletado
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.sistema.deletaCompraDeLista(descritorLista, itemId);
	}

	/**
	 * Finaliza a lista de compras, adicionando o local da compra e o valor final da
	 * compra.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param localDaCompra
	 *            local onde a compra foi feita
	 * @param valorFinalDaCompra
	 *            valor final da compra
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) {
		this.sistema.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	/**
	 * Retorna um item da lista especificada.
	 * 
	 * @param descritorLista
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 * @param posicaoItem
	 *            posicao do item buscado
	 * @return String - representando o item especificado
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.sistema.getItemLista(descritorLista, posicaoItem);
	}

	/**
	 * Retorna data atual
	 * 
	 * @return String - representando a data
	 */
	public String dataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * Retorna a lista cadastrada em uma determinada data em uma dada posicao.
	 * 
	 * @param data
	 *            data do cadastro
	 * @param posicaoLista
	 *            posicao da lista de compras em ordem lexicografica
	 * @return string - representando a descritor de uma lista
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return this.sistema.getItemListaPorData(data, posicaoLista);
	}

	/**
	 * Retorna os descritores das listas que contem uma compra relacionada ao item
	 * pesquisado.
	 * 
	 * @param id
	 *            id do item o qual se deseja pesquisar
	 * @param posicaoLista
	 *            posicao da lista de compras apos ser ordenada pela data de criacao
	 *            das listas que possuem o item pesquisado.
	 * @return string - representando o descritor da lista
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.sistema.getItemListaPorItem(id, posicaoLista);
	}

	/**
	 * Pesquisa no sistema por todas as listas cadastradas em uma determinada data.
	 * 
	 * @param data
	 *            data a ser pesquisada no sistema
	 * @return String - contendo uma listagem de todas as listas cadastradas em uma
	 *         determinada data passada como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.sistema.pesquisaListasDeComprasPorData(data);
	}

	/**
	 * Pesquisa listas de compras que contem aquele item
	 * 
	 * @param id
	 *            id do item
	 * @return String representacao textual das listas
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.sistema.pesquisaListasDeComprasPorItem(id);
	}

	/**
	 * Gera automaticamente uma lista com base na ultima lista adicionada ao sistema
	 * 
	 * @return String descritor da nova lista automatica criada
	 */
	public String geraAutomaticaUltimaLista() {
		return this.sistema.geraAutomaticaUltimaLista();
	}

	/**
	 * Gera automaticamente uma lista com base em uma lista que contempre o item
	 * desejado.
	 * 
	 * @return String - representando o descritor da lista automatica criada
	 */
	public String geraAutomaticaItem(String descritorItem) {
		return this.sistema.geraAutomaticaItem(descritorItem);
	}

	/**
	 * Gera automaticamente uma lista com base nos itens que estao mais presentes
	 * nas listas do app.
	 * 
	 * @return String - representando o descitor da lista automatica criada
	 */
	public String geraAutomaticaItensMaisPresentes() {
		return this.sistema.geraAutomaticaItensMaisPresentes();
	}

	/**
	 * @see ListaPraMim#iniciaSistema()
	 */
	public void iniciaSistema() {
		this.sistema.iniciaSistema();
	}

	/**
	 * @see ListaPraMim#fechaSistema()
	 */
	public void fechaSistema() {
		this.sistema.fechaSistema();
	}
	
}
