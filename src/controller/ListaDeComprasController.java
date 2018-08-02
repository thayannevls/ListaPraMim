package controller;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.ListaDataComparator;
import model.Compra;
import model.ItemCompravel;
import model.ListaDeCompras;
import persistence.Persistencia;
import util.ErrosListasComprasController;
import util.Utils;
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

		if (!this.listasDeCompras.containsKey(descritor)) {
			ListaDeCompras lista = new ListaDeCompras(descritor);
			this.listasDeCompras.put(descritor, lista);
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
		listaExiste(descritor, ErrosListasComprasController.LISTA_INEXISTENTE.toString());
		listaNaoFinalizada(descritor, ErrosListasComprasController.LISTA_FINALIZADA.toString());
		

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
		Validator.idValido(id, ErrosListasComprasController.P_ID_INVALIDO.toString());
		listaExiste(descritor, ErrosListasComprasController.LISTA_INEXISTENTE.toString());
		this.listasDeCompras.get(descritor).analisaExistencia(id,
				ErrosListasComprasController.P_COMPRA_INEXISTENTE.toString());
		return this.listasDeCompras.get(descritor).getItemPeloId(id);
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
		//
		if (!this.listasDeCompras.containsKey(descritor))
			throw new IllegalArgumentException(ErrosListasComprasController.P_LISTA_INEXISTENTE.toString());

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
		Validator.operacaoValida(operacao, ErrosListasComprasController.A_OPERACAO_INVALIDA.toString());
		listaNaoFinalizada(descritor, ErrosListasComprasController.LISTA_FINALIZADA.toString());
		Validator.ehPositivo(novaQtd, ErrosListasComprasController.A_NOVA_QTD_INVALIDA.toString());

		this.listasDeCompras.get(descritor).analisaExistencia(id,
				ErrosListasComprasController.A_COMPRA_INEXISTENTE.toString());
		if (operacao.equals("adiciona")) {
			this.listasDeCompras.get(descritor).setQntCompra(id, novaQtd);
		} else {
			this.listasDeCompras.get(descritor).setQntCompra(id, -novaQtd);
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
		listaExiste(descritor, ErrosListasComprasController.LISTA_INEXISTENTE.toString());
		this.listasDeCompras.get(descritor).analisaExistencia(id,
				ErrosListasComprasController.E_COMPRA_INEXISTENTE.toString());
		//
		this.listasDeCompras.get(descritor).deletaCompra(id);
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
		if (posicao < 0) {
			throw new IllegalArgumentException();
		}
		return this.listasDeCompras.get(descritor).getItemLista(posicao);
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
		listaExiste(descritor, ErrosListasComprasController.LISTA_INEXISTENTE.toString());
		//
		this.listasDeCompras.get(descritor).finalizaCompras(localDaCompra, valorTotal);
	}

	/**
	 * Imprime uma lista cadastrada em uma determinada data cuja sua posicao apos a
	 * ordenacao e passada como parametro.
	 * 
	 * @param data
	 *            data na qual se deseja obter as listas cadastradas
	 * @param posicaoLista
	 *            posicao de uma determinada lista apos a ordenacao por ordem
	 *            crescente de criacao
	 * @return string - contendo o descritor de uma determinada lista.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		List<String> aux = new ArrayList<>();
		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.getDataCriacaoStr().equals(data)) {
				aux.add(lista.getDescritor());
			}
		}

		Collections.sort(aux, Collator.getInstance());

		return (aux.size() == 0) ? "" : aux.get(posicaoLista);
	}

	/**
	 * Imprime uma lista onde um determinado item com id e sua posicao apos a
	 * ordenacao está inserido.
	 * 
	 * @param id
	 *            identificador do item
	 * @param posicaoLista
	 *            posicao do item na lista apos a ordenacao
	 * @return String - contendo a data da criacao da lista e seu descritor
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		List<String> aux = new ArrayList<>();
		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.analisaExistencia(id))
				aux.add(lista.toString());
		}

		Collections.sort(aux, Collator.getInstance());

		return (aux.size() == 0) ? "" : aux.get(posicaoLista);
	}

	/**
	 * Retorna uma listagem para todas as listas cadastradas em uma determinada data
	 * passada como parametro.
	 * 
	 * @param data
	 *            string informando a data a ser pesquisada
	 * @return string - contendo a listagem de todas as listas cadastradas em uma
	 *         determinada data.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		Validator.campoValido(data, ErrosListasComprasController.P_DATA_VAZIA_OU_NULA.toString());
		Validator.dataValida(data, ErrosListasComprasController.P_DATA_FORMATO_IVALIDO.toString());
		List<String> aux = new ArrayList<>();
		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.getDataCriacaoStr().equals(data)) {
				aux.add(lista.getDescritor());
			}
		}

		Collections.sort(aux, Collator.getInstance());

		String listagem = "";
		for (String descricao : aux) {
			listagem += descricao + System.lineSeparator();
		}

		return listagem;
	}

	/**
	 * Retorna uma listagem de todas as listas de compras que contém um determinado
	 * id em suas compras.
	 * 
	 * @param id
	 *            item a ser pesquisado.
	 * @return string - contendo todas as listas que possuem um determinado id em
	 *         suas compras.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		List<String> aux = new ArrayList<>();
		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.analisaExistencia(id))
				aux.add(lista.toString());
		}

		Collections.sort(aux, Collator.getInstance());

		String listagem = "";
		for (String descricao : aux)
			listagem += descricao + System.lineSeparator();

		if (("").equals(listagem))
			throw new IllegalArgumentException(ErrosListasComprasController.P_COMPRA_INEXISTENTE.toString());

		return listagem;
	}

	/**
	 * Gera lista automatica com base na ultima lista adicionada ao sistema
	 * 
	 * @return String descritor da nova lista automatica
	 */
	public String geraAutomaticaUltimaLista() {
		String descritor = "Lista automatica 1 " + Utils.dataAtual();

		ListaDeCompras lista = new ListaDeCompras(descritor);
		lista.setListaDeCompras(getUltimaLista().getListaDeCompras());
		listasDeCompras.put(descritor, lista);

		return descritor;
	}

	/**
	 * Gera automaticamente uma lista com base no item pesquisado, a lista gerada eh igual
	 * a ultima lista cadastrada que contempla o item.
	 * 
	 * @param descritorItem
	 * 
	 * @return String - representando o descitor da lista automatica criada
	 */
	public String geraAutomaticaItem(String descritorItem) {
		String descritor = "Lista automatica 2 " + Utils.dataAtual();
		ListaDeCompras lista = null;
		List<ListaDeCompras> listasOrdenadas = new ArrayList<>(listasDeCompras.values());
		listasOrdenadas.sort(new ListaDataComparator());

		for (ListaDeCompras listaOrd : listasOrdenadas) {
			Map<Integer, Compra> listaCasatrada = listaOrd.getListaDeCompras();

			for (Compra compra : listaCasatrada.values()) {
				if (compra.getNome().equals(descritorItem))
					lista = listaOrd;
			}
		}

		if (lista == null)
			throw new IllegalArgumentException(ErrosListasComprasController.G_COMPRA_NAO_CADASTRADA.toString());

		this.listasDeCompras.put(descritor, lista);
		return descritor;
	}

	/**
	 * Gera lista automatica com base nos itens que mais aparecem em outras listas.
	 * 
	 * @param qtdItens
	 *            quantidade de itens cadastrados no app.
	 * @return String - representando o descritor da lista automatica
	 */
	public String geraAutomaticaItensMaisPresentes(int qtdItens) {
		String descritor = "Lista automatica 3 " + Utils.dataAtual();
		ListaDeCompras lista = new ListaDeCompras(descritor);

		for (int id = 0; id < qtdItens; id++) {
			Compra compra = null;
			int repeticaoDoItemNasListas = 0;
			int qtdCompradaEmOutrasListas = 0;

			for (ListaDeCompras listaCadastrada : listasDeCompras.values()) {

				if (listaCadastrada.analisaExistencia(id)) {
					compra = listaCadastrada.getCompra(id);
					repeticaoDoItemNasListas++;
					qtdCompradaEmOutrasListas += listaCadastrada.getCompra(id).getQtd();
				}
			}

			if (repeticaoDoItemNasListas >= ((int) this.listasDeCompras.size() / 2))
				lista.adicionaItemLista(id, (int) Math.floor(qtdCompradaEmOutrasListas / repeticaoDoItemNasListas),
						compra.getItem());
		}

		this.listasDeCompras.put(descritor, lista);
		return descritor;
	}

	/**
	 * Metodo que verifica se a lista ainda nao foi finalizada
	 * 
	 * @param descritor
	 *            descritor da lista a ser verificada
	 * @param mensagem
	 *            mensagem de erro a ser retorna se tiver sido finalizada
	 * @return boolean true se nao tiver sido finalizada
	 */
	private boolean listaNaoFinalizada(String descritor, String mensagem) {
		if (listasDeCompras.get(descritor).getFinalizada())
			throw new IllegalArgumentException(mensagem);
		return true;
	}

	/**
	 * Retorna ultima lista de compras cadastrada no sistema
	 * 
	 * @return ListaDeCompras ultima lista cadastrada no sistema
	 */
	private ListaDeCompras getUltimaLista() {
		List<ListaDeCompras> listasOrdenadas = new ArrayList<>(listasDeCompras.values());
		listasOrdenadas.sort(new ListaDataComparator());
		ListaDeCompras ultimaLista = listasOrdenadas.get(listasOrdenadas.size() - 1);
		return ultimaLista;
	}

	/**
	 * Salva listas cadastradas em um arquivo
	 * 
	 * @see Persistencia#salvarListas(Object)
	 */
	public void salvar() {
		try {
			Persistencia.salvarListas(listasDeCompras);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Carrega listas e registra no sistema
	 * 
	 * @see Persistencia#carregarListas()
	 */
	@SuppressWarnings("unchecked")
	public void carregar() {
		try {
			listasDeCompras = (Map<String, ListaDeCompras>) Persistencia.carregarListas();
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Verifica se uma lista existe
	 * 
	 * @param descritor
	 *            descritor da lista
	 * @param msg
	 *            mensagem que sera lancada
	 */
	private void listaExiste(String descritor, String msg) {
		if (!this.listasDeCompras.containsKey(descritor))
			throw new IllegalArgumentException(msg);
	}

}
