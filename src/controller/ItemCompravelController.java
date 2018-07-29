package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import comparator.ItemNomeComparator;
import comparator.MenorPrecoComparator;
import model.ItemCompravel;
import model.ItemPorQtd;
import model.ItemPorQuilo;
import model.ItemPorUnidade;
import persistence.Persistencia;
import util.ErrosItemController;
import util.ErrosListasComprasController;
import util.Validator;

/**
 * Classe responsável por controlar itens comŕavel no sistema
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratório de
 *         Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemCompravelController {

	private Map<Integer, ItemCompravel> itens;
	private int qtdItens;

	/**
	 * Construtor da classe ItemCompravel.
	 */
	public ItemCompravelController() {
		this.itens = new HashMap<>();
		this.qtdItens = 0;
	}

	/**
	 * Adiciona item por quilo.
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
		Validator.ehPositivo(kg, ErrosItemController.CADASTRO_QUILO_NEGATIVO.toString());
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());

		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQuilo(nome, id, categoria, kg, localDeCompra, preco);
		itens.put(id, item);
		qtdItens++;
		return id;
	}

	/**
	 * Adiciona item por unidade.
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
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.ehPositivo(unidade, ErrosItemController.CADASTRO_UNIDADE_NEGATIVA.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());

		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorUnidade(nome, id, categoria, unidade, localDeCompra, preco);
		itens.put(id, item);
		qtdItens++;
		return id;
	}

	/**
	 * Adiciciona item por quantidade de medida.
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
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {

		Validator.ehPositivo(qnt, ErrosItemController.CADASTRO_QUANTIDADE_NEGATIVA.toString());
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());
		Validator.campoValido(unidadeDeMedida, ErrosItemController.CADASTRO_UNIDADE_NULA.toString());

		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQtd(nome, id, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
		itens.put(id, item);
		qtdItens++;
		return id;
	}

	/**
	 * Retorna representacao textual do item.
	 * 
	 * @param id
	 *            id do item a ser exibido
	 * @return String representacao textual do item
	 */
	public String exibeItem(int id) {
		idValido(id, ErrosItemController.LISTAGEM_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.LISTAGEM_ITEM_INEXISTENTE.toString());

		return itens.get(id).toString();
	}

	/**
	 * Adiciona um preco ao item.
	 * 
	 * @param id
	 *            id do item a ser adicionado rpeco
	 * @param localDeCompra
	 *            local de compra que teve esse preco
	 * @param preco
	 *            novo preco a ser adicionado
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		idValido(id, ErrosItemController.PRECO_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.PRECO_ITEM_INEXISTENTE.toString());
		Validator.ehPositivo(preco, ErrosItemController.PRECO_ITEM_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.PRECO_LOCAL_NULO.toString());

		itens.get(id).adicionaPreco(localDeCompra, preco);
	}

	/**
	 * atualiza algum atributo de item escolhido.
	 * 
	 * @param id
	 *            id do item a ser atualizado
	 * @param atributo
	 *            atributo a ser modificdo
	 * @param novoValor
	 *            novo valor que recebera o atributo
	 * @exception quando
	 *                se tem id, atributo ou novo valor invalido
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		Validator.campoValido(atributo, ErrosItemController.ATUALIZA_ATRIBUTO_NULO.toString());
		Validator.campoValido(novoValor, ErrosItemController.ATUALIZA_VALOR_NULO.toString());
		idValido(id, ErrosItemController.ATUALIZA_ITEM_INEXISTENTE.toString());

		itemExiste(id, ErrosItemController.ATUALIZA_ITEM_INEXISTENTE.toString());

		switch (atributo) {
		case "nome":
			itens.get(id).setNome(novoValor);
			break;
		case "categoria":
			Validator.categoriaValida(novoValor, ErrosItemController.ATUALIZA_CATEGORIA_INEXISTENTE.toString());
			itens.get(id).setCategoria(novoValor);
			break;
		case "quantidade":
			int quantidade = Integer.parseInt(novoValor);
			Validator.ehPositivo(quantidade, ErrosItemController.ATUALIZA_QUANTIDADE_NEGATIVO.toString());
			((ItemPorQtd) itens.get(id)).setQuantidade(quantidade);
			break;
		case "unidade de medida":
			((ItemPorQtd) itens.get(id)).setUnidade(novoValor);
			break;
		case "unidades":
			int unidade = Integer.parseInt(novoValor);
			Validator.ehPositivo(unidade, ErrosItemController.ATUALIZA_QUANTIDADE_NEGATIVO.toString());
			((ItemPorUnidade) itens.get(id)).setUnidade(unidade);
			break;
		case "kg":
			double kg = Double.parseDouble(novoValor);
			Validator.ehPositivo(kg, ErrosItemController.ATUALIZA_QUILO_NEGATIVO.toString());

			((ItemPorQuilo) itens.get(id)).setQuilo(kg);
			break;
		default:
			throw new IllegalArgumentException(ErrosItemController.ATUALIZA_ATRIBUTO_INEXISTENTE.toString());
		}
	}

	/**
	 * Deleta um item do sistema
	 * 
	 * @param id
	 *            id do item a ser deletado
	 */
	public void deletaItem(int id) {
		idValido(id, ErrosItemController.DELETA_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.DELETA_ID_INVALIDO.toString());
		itens.remove(id);
	}

	/**
	 * Retorna item ordenado de forma alfabetica.
	 * 
	 * @param posicao
	 *            posicao do item
	 * @return String - representacao textual do item retornado
	 */
	public String getItem(int posicao) {
		List<ItemCompravel> itensOrdenados = new ArrayList<>();
		itensOrdenados.addAll(itens.values());

		Collections.sort(itensOrdenados, new ItemNomeComparator());

		return (posicao >= itensOrdenados.size())? "" : itensOrdenados.get(posicao).toString();
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
		Validator.categoriaValida(categoria, ErrosItemController.LISTAGEM_CATEGORIA_INEXISTENTE.toString());
		List<ItemCompravel> itensCategoria = new ArrayList<>();
		for (ItemCompravel i : itens.values()) {
			if (i.getCategoria().equals(categoria)) {
				itensCategoria.add(i);
			}
		}

		Collections.sort(itensCategoria, new ItemNomeComparator());

		return (posicao >= itensCategoria.size())? "" : itensCategoria.get(posicao).toString();
	}

	/**
	 * Retorna item ordenado pelo menor preco.
	 * 
	 * @param posicao
	 *            posicao do item
	 * @return String - representacao textual do item retornado
	 */
	public String getItemPorMenorPreco(int posicao) {
		List<ItemCompravel> itensPreco = new ArrayList<>();
		itensPreco.addAll(itens.values());

		Collections.sort(itensPreco, new MenorPrecoComparator());

		return (posicao >= itensPreco.size())? "" : itensPreco.get(posicao).toString();
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
		List<ItemCompravel> itensPesquisados = new ArrayList<>();
		itensPesquisados.addAll(itens.values());

		itensPesquisados = itensPesquisados.stream()
				.filter((ItemCompravel item) -> item.getNome().toLowerCase().contains(strPesquisada.toLowerCase()))
				.collect(Collectors.toList());

		Collections.sort(itensPesquisados, new ItemNomeComparator());

		return (posicao >= itensPesquisados.size())? "" : itensPesquisados.get(posicao).toString();
	}

	/**
	 * verifica se id eh valido
	 * 
	 * @param id
	 *            id a ser verificado
	 * @param mensagem
	 *            mensagem de erro caso nao seja valido
	 * @return boolean true se eh valido
	 * @exception IllegalArgumentException
	 *                quando id nao eh valido
	 */
	private void idValido(int id, String mensagem) {
		if (id < 1)
			throw new IllegalArgumentException(mensagem);
	}

	/**
	 * Verifica se item existe no sistema de acordo com id
	 * 
	 * @param id
	 *            id a ser verificado
	 * @param mensagem
	 *            mensagem de erro caso nao exista
	 * @return boolean true se eh valido
	 * @exception IllegalArgumentException
	 *                quando item nao existe
	 */
	public void itemExiste(int id, String mensagem) {
		if (!itens.containsKey(id))
			throw new IllegalArgumentException(mensagem);
	}

	/**
	 * Retorna um item especificado pelo id.
	 * 
	 * @param id
	 *            id do item buscado
	 * @return ItemCompravel - representando o item
	 */
	public ItemCompravel getItemCadastrado(int id) {
		itemExiste(id, ErrosListasComprasController.ADD_ITEM_INEXISTENTE.toString());
		return itens.get(id);
	}
	
	/**
	 * Salva itens em um arquivo
	 * @see Persistencia#salvarItens(Object)
	 */
	public void salvar(){
		try {
			Persistencia.salvarItens(itens);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * Carrega itens de arquivo e adiciona ao sistema
	 * @see Persistencia#carregarItens()
	 */
	@SuppressWarnings("unchecked")
	public void carregar(){
		try {
			itens = (Map<Integer, ItemCompravel>)Persistencia.carregarItens();
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Retorna a quantidade de itens cadastrados no sistema.
	 * 
	 * @return int - representando a quantidade de itens no sistema
	 */
	public int gteQtdItensNoSistema() {
		return this.qtdItens;
	}
}
