package controller;

import java.util.HashMap;
import java.util.Map;

import model.ItemCompravel;
import model.ListaDeCompras;
import util.ErrosListasComprasController;
import util.Validator;

/**
 * Classe responsavel por controlar lista de compras no sistema.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratorio de
 *         Programacao 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ListaDeComprasController {
	private Map<String, ListaDeCompras> listasDeCompras;

	public ListaDeComprasController() {
		this.listasDeCompras = new HashMap<>();

	}

	/**
	 * Metodo que adiciona uma lista de compras ao HashMap.
	 * 
	 * @param descritor
	 * @return descritor da lista de compras
	 */
	public String adicionaListaDeCompras(String descritor) {
		Validator.campoValido(descritor, ErrosListasComprasController.C_DESCRITOR_INVALIDO.toString());
		ListaDeCompras lista = new ListaDeCompras(descritor);
		if (!listasDeCompras.containsKey(descritor)) {
			listasDeCompras.put(descritor, lista);
		}
		return descritor;
	}

	/**
	 * Metodo que adiciona um item a lista de compras.
	 * 
	 * @param descritor
	 *            descritor da lista de compras.
	 * @param item
	 *            item que sera adicionado
	 * @param qtd
	 *            quantidade do item
	 */
	public void adicionaCompraALista(String descritor, int qtd, ItemCompravel item) {
		Validator.campoValido(descritor, ErrosListasComprasController.ADD_DESCRITOR_INVALIDO.toString());
		Validator.ehPositivo(qtd, ErrosListasComprasController.ADD_QTD_INVALIDA.toString());

		if (listasDeCompras.containsKey(descritor)) {
			this.listasDeCompras.get(descritor).adicionaItemLista(item.getId(), qtd, item);
		}
	}

	/**
	 * Metodo que pesquisa uma compra em uma lista e retorna sua representacao
	 * textual.
	 * 
	 * @param descritor
	 *            descritor da lista de compras
	 * @param id
	 *            identificador do item(compra)
	 * @return representacao textual da compra
	 */
	public String pesquisaCompraEmLista(String descritor, int id) {
		Validator.campoValido(descritor, ErrosListasComprasController.P_DESCRITOR_INVALIDO.toString());
		idValido(id, ErrosListasComprasController.P_ID_INVALIDO.toString());
		listasDeCompras.get(descritor).analisaExistencia(id, ErrosListasComprasController.P_COMPRA_INEXISTENTE.toString());
		return listasDeCompras.get(descritor).getItemPeloId(id);

	}

	/**
	 * Metodo que pesquisa uma lista de compras
	 * 
	 * @param descritor
	 *            descricao da lista
	 * @return descricao da lista de compras
	 */
	public String pesquisaListaDeCompras(String descritor) {
		Validator.campoValido(descritor, ErrosListasComprasController.PL_DESCRITOR_INVALIDO.toString());
		if (!this.listasDeCompras.containsKey(descritor))
			throw new IllegalArgumentException();
		return descritor;

	}

	/**
	 * Metodo que atualiza uma compra em uma lista, podendo adicionar ou diminuir a
	 * quantidade da compra.
	 * 
	 * @param descritor
	 *            descritor da lista de compras
	 * @param id
	 *            identificacao do item comprado
	 * @param operacao
	 *            operacao que se deseja realizar (adicionar ou diminuir)
	 * @param qtd
	 *            quantidade que sera adicionada ou diminuida
	 */
	public void atualizaCompraDeLista(String descritor, int id, String operacao, int novaQtd) {
		Validator.campoValido(descritor, ErrosListasComprasController.A_DESCRITOR_INVALIDO.toString());
		operacaoValida(operacao, ErrosListasComprasController.A_OPERACAO_INVALIDA.toString());
		listasDeCompras.get(descritor).analisaExistencia(id,
				ErrosListasComprasController.A_COMPRA_INEXISTENTE.toString());
		if (operacao.equals("adiciona")) {
			listasDeCompras.get(descritor).setQntCompra(id, novaQtd);
		} else if (operacao.equals("diminui")) {
			listasDeCompras.get(descritor).setQntCompra(id, -novaQtd);
		}
	}

	/**
	 * Metodo que deleta uma compra de uma lista.
	 * 
	 * @param descritor
	 *            descritor da lista de compras
	 * @param id
	 *            identificador do item
	 */
	public void deletaCompraDeLista(String descritor, int id) {
		Validator.campoValido(descritor, ErrosListasComprasController.E_DESCRITOR_INVALIDO.toString());
		listasDeCompras.get(descritor).analisaExistencia(id, ErrosListasComprasController.E_COMPRA_INEXISTENTE.toString());
		listasDeCompras.get(descritor).analisaExistencia(id, ErrosListasComprasController.E_ITEM_INEXISTENTE.toString());
		listasDeCompras.get(descritor).deletaCompra(id);
	}

	/**
	 * Metodo que imprime um item de uma lista de compras no formato id + nome +
	 * categoria + qtd (se houver).
	 * 
	 * @param descritor
	 *            descritor da lista de compras
	 * @param posicao
	 *            posicao em que o item esta
	 * @return representacao textual do item
	 */
	public String getItemLista(String descritor, int posicao) {
		return listasDeCompras.get(descritor).getItemLista(posicao);
	}

	/**
	 * Metodo que finaliza uma lista de compras.
	 * 
	 * @param descritor
	 *            descritor da lista de compras
	 * @param localDaCompra
	 *            local em que a compra foi realizada
	 * @param valorTotal
	 *            valor final da lista de compras
	 */
	public void finalizarListaDeCompras(String descritor, String localDaCompra, double valorTotal) {
		Validator.campoValido(descritor, ErrosListasComprasController.F_DESCRITOR_INVALIDO.toString());
		Validator.campoValido(localDaCompra, ErrosListasComprasController.F_LOCAL_INVALIDO.toString());
		Validator.ehPositivo(valorTotal, ErrosListasComprasController.F_VALOR_FINAL_INVALIDO.toString());
		listasDeCompras.get(descritor).finalizaCompras(localDaCompra, valorTotal);
	}

	/**
	 * Verifica se o id de um item eh valido.
	 * 
	 * @param id
	 *            identificacao do item
	 * @param msg
	 * @return valor booleano
	 */
	private boolean idValido(int id, String msg) {
		if (id < 1)
			throw new IllegalArgumentException(msg);
		return true;
	}

	/**
	 * Verifica se a operacao de atualizacao da lista de compras eh valida.
	 * 
	 * @param operacao
	 *            operacao que sera realizada
	 * @param msg
	 *            mensagem que sera lancada
	 * @return valor booleano
	 */
	private boolean operacaoValida(String operacao, String msg) {
		if (operacao.equals("adiciona") || operacao.equals("diminui"))
			return true;
		throw new IllegalArgumentException(msg);
	}
}