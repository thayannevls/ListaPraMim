package controller;

import persistence.Persistencia;
import util.ErrosListasComprasController;

/**
 * Classe que controla todo o sistema
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matricula: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class ListaPraMim {

	private ItemCompravelController itemController;
	private ListaDeComprasController listasDeComprasController;

	/**
	 * Inicializa os atributos da classe ListaPraMim.
	 */
	public ListaPraMim() {
		this.itemController = new ItemCompravelController();
		this.listasDeComprasController = new ListaDeComprasController();
	}

	/**
	 * Adiciona item por quilo
	 * 
	 * @param nome
	 *            nome do item
	 * @param categoria
	 *            categoria do item
	 * @param kg
	 *            quilo
	 * @param localDeCompra
	 *            local de compra do item
	 * @param preco
	 *            preco do item
	 * @return int retorna id gerado para o item
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.itemController.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Adiciona item por unidade
	 * 
	 * @param nome
	 *            nome do item
	 * @param categoria
	 *            categoria do item
	 * @param unidade
	 *            unidade
	 * @param localDeCompra
	 *            local de compra do item
	 * @param preco
	 *            preco do item
	 * @return int retorna id gerado para o item
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.itemController.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	/**
	 * Adiciciona item por quantidade de medida
	 * 
	 * @param nome
	 *            nome do item
	 * @param categoria
	 *            categoria do item
	 * @param qnt
	 *            quantidade
	 * @param unidadeDeMedida
	 *            unidade de medida
	 * @param localDeCompra
	 *            local de compra do item
	 * @param preco
	 *            preco do item
	 * @return int retorna id gerado para o item
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.itemController.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Retorna representacao textual do item
	 * 
	 * @param id
	 *            id do item a ser exibido
	 * @return String representacao textual do item
	 */
	public String exibeItem(int id) {
		return this.itemController.exibeItem(id);
	}

	/**
	 * Adiciona um preco ao item
	 * 
	 * @param id
	 *            id do item a ser adicionado rpeco
	 * @param localDeCompra
	 *            local de compra que teve esse preco
	 * @param preco
	 *            novo preco a ser adicionado
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.itemController.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * atualiza algum atributo de item escolhido
	 * 
	 * @param id
	 *            id do item a ser atualizado
	 * @param atributo
	 *            atributo a ser modificdo
	 * @param novoValor
	 *            novo valor que recebera o atributo
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.itemController.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Deleta um item do sistema
	 * 
	 * @param id
	 *            id do item a ser deletado
	 */
	public void deletaItem(int id) {
		this.itemController.deletaItem(id);
	}

	/**
	 * Retorna item ordenado de forma alfabetica.
	 * 
	 * @param posicao
	 *            posicao do item
	 * @return String - representacao textual do item retornado
	 */
	public String getItem(int posicao) {
		return this.itemController.getItem(posicao);
	}

	/**
	 * Retorna item ordenado por sua categoria
	 * 
	 * @param categoria
	 *            categoria do item
	 * @param posicao
	 *            posicao requerida
	 * @return String - representaçao textual do item retornado
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.itemController.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Retorna item ordenado pelo menor preco.
	 * 
	 * @param posicao
	 *            posicao do item
	 * @return String - representacao textual do item retornado
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.itemController.getItemPorMenorPreco(posicao);
	}

	/**
	 * Retorna item que contem strPesquisada em seu nome na posicao indicada
	 * 
	 * @param strPesquisada
	 *            string a ser pesquisada
	 * @param posicao
	 *            posicao requerida
	 * @return String representacao textual do item retornado
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.itemController.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Cria lista de compra
	 * 
	 * @param descritor descritor
	 * @return String - representação da lista com seu descritor
	 */
	public String adicionaListaDeCompras(String descritor) {
		return this.listasDeComprasController.adicionaListaDeCompras(descritor);
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
		this.listasDeComprasController.adicionaCompraALista(descritorLista, quantidade, itemController.getItemCadastrado(itemId));
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
		return this.listasDeComprasController.pesquisaListaDeCompras(descritor);
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
		return this.listasDeComprasController.pesquisaCompraEmLista(descritorLista, itemId);
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
		this.listasDeComprasController.atualizaCompraDeLista(descritorLista, itemId, operacao, quantidade);
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
		itemController.itemExiste(itemId, ErrosListasComprasController.E_ITEM_INEXISTENTE.toString());
		//
		this.listasDeComprasController.deletaCompraDeLista(descritorLista, itemId);
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
		this.listasDeComprasController.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
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
		return this.listasDeComprasController.getItemLista(descritorLista, posicaoItem);
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
		return this.listasDeComprasController.getItemListaPorData(data, posicaoLista);
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
		return this.listasDeComprasController.getItemListaPorItem(id, posicaoLista);
	}

	/**
	 * Pesquisa por todas as listas de compras cadastradas em uma determinada data.
	 * 
	 * @param data
	 *            string contendo a data para ser pesquisada no sistema.
	 * @return string contendo uma representacao textual pra todas as listas
	 *         cadastradas em uma determinada data passada como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.listasDeComprasController.pesquisaListasDeComprasPorData(data);
	}

	/**
	 * Pesquisa as listas de compras que cotem um determinado item.
	 * 
	 * @param id
	 *            identificador do item
	 * @return String - representando as listas cadastradas que contem o item
	 *         requerido
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.listasDeComprasController.pesquisaListasDeComprasPorItem(id);
	}

	/**
	 * Gera lista automatica com base na ultima lista adicionada ao sistema
	 * 
	 * @return String descritor da nova lista automatica
	 */
	public String geraAutomaticaUltimaLista() {
		return listasDeComprasController.geraAutomaticaUltimaLista();
	}

	/**
	 * Gera automaticamente uma lista com base em uma lista que contempre o item
	 * desejado.
	 * 
	 * @param descritorItem
	 *            descritor do item que sera usado como base
	 * 
	 * @return String - representando o descritor da lista automatica criada
	 */
	public String geraAutomaticaItem(String descritorItem) {
		return this.listasDeComprasController.geraAutomaticaItem(descritorItem);
	}

	/**
	 * Gera automaticamente uma lista com base nos itens que estao mais presentes
	 * nas listas do app.
	 * 
	 * @return String - representando o descitor da lista automatica criada
	 */
	public String geraAutomaticaItensMaisPresentes() {
		return this.listasDeComprasController.geraAutomaticaItensMaisPresentes(getQtdItensNoSistema());
	}

	/**
	 * Retorna a quantidade de itens cadastrados no sistema.
	 * 
	 * @return int - representando a quantidade de itens no sistema
	 */
	private int getQtdItensNoSistema() {
		return this.itemController.gteQtdItensNoSistema();
	}
	
	public String sugereMelhorEstabelecimento(String descritorLista, int posicaoEstabelecimento, int posicaoLista){
		return this.listasDeComprasController.sugereMelhorEstabelecimento(descritorLista, posicaoEstabelecimento, posicaoLista);
	}
	
	/** 
	 * Salva todos os itens e listas cadastrados localmente
	 */
	public void fechaSistema(){
		itemController.salvar();
		listasDeComprasController.salvar();
	}

	/**
	 * Recupera todas as listas e itens cadastrados que foram salvos
	 */
	public void iniciaSistema(){
		if(Persistencia.arquivosNaoCriados()){
			this.fechaSistema();
			throw new IllegalArgumentException("Sistema iniciado pela primeira vez. Arquivo criado.");
		}
		itemController.carregar();
		listasDeComprasController.carregar();
	}

}
