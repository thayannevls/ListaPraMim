package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.ItemCategoriaENomeComparador;
import util.ErrosListasComprasController;

/**
 * Entidade usada para representar uma lista de compras. Em uma lista de compras
 * e possível adicionar uma nova compra, deletar uma determinada compra, alterar
 * a quantidade de itens que serao comprados, entre outras atividades.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
/**
 * @author siuannybsr
 *
 */
public class ListaDeCompras {

	private String descritor;
	private Map<Integer, Compra> listaDeCompras;
	private String dataCriacao;
	private boolean finalizada;
	private String localCompra;
	private double valorTotal;

	/**
	 * Contrutor da classe Lista de Compras. Inicializa os atriburos da classe.
	 * 
	 * @param descritor
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 */
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		this.listaDeCompras = new HashMap<>();
		this.dataCriacao = this.getDate();
		this.finalizada = false;
	}

	/**
	 * Captura do sistema a data atual da criacao da lista.
	 * 
	 * @return string - no formato dd/MM/yyyy contendo a data capturada do sistema
	 *         na qual a lista foi criada.
	 */
	private String getDate() {
		Date data = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(data);
	}

	/**
	 * Adiciona uma nova compra na lista de compras.
	 * 
	 * @param id
	 *            identificador do item a ser comprado
	 * @param qtd
	 *            quantidade a ser comprada
	 * @param item
	 *            item que sera comprado
	 */
	public void adicionaItemLista(int id, int qtd, ItemCompravel item) {
		this.listaDeCompras.put(item.getId(), new Compra(qtd, item));
	}

	/**
	 * Retorna para o sistema a data na qual a lista de compras foi criada.
	 * 
	 * @return string - no formato dd/MM/yyyy contendo a data na qual a lista foi
	 *         cadastrada.
	 */
	public String getDataCriacao() {
		return dataCriacao.toString();
	}

	/**
	 * Remove um irem da lista de compras.
	 * 
	 * @param id
	 *            identificador do item a ser removido.
	 */
	public void deletaCompra(int id) {
		this.listaDeCompras.remove(id);
	}

	/**
	 * Analisa se a lista foi finalizada
	 * 
	 * @param msg
	 *            mensagem de erro a ser exibida caso se queira realizar uma
	 *            atividade nao desejada em uma lista finalizada
	 */
	public boolean getEstado() {
		return this.finalizada;
	}

	/**
	 * Retorna uma listagem de todas as compras cadastradas na lista de compras.
	 * 
	 * @return string contendo uma representacao textual de todas as compras
	 *         cadastradas na lista.
	 */
	public String getItemLista(int pos) {
		List<Compra> compras = new ArrayList<>(listaDeCompras.values());
		Collections.sort(compras, new ItemCategoriaENomeComparador());

		return (pos >= compras.size()) ? "" : compras.get(pos).toString();
	}

	/**
	 * Retorna uma representação do Item pelo seu id.
	 * 
	 * @param id
	 *            identificador do item
	 * @return String - com sua representação
	 */
	public String getItemPeloId(int id) {
		return listaDeCompras.get(id).toString();
	}

	/**
	 * Encerra uma lista de compras.
	 * 
	 * @param localCompra
	 *            local onde foram realizadas as compras da lista
	 * @param valorTotal
	 *            quantia total gasta em todas as compras
	 */
	public void finalizaCompras(String localCompra, double valorTotal) {
		this.localCompra = localCompra;
		this.valorTotal = valorTotal;
		this.finalizada = true;
	}

	/**
	 * Disponibiliza para outras classes o descritor de uma lista de compras.
	 * 
	 * @return string contendo o descritor da lista
	 */
	public String getDescritor() {
		return this.descritor;
	}

	/**
	 * Altera a quantidade de itens que serao comprados. [Caso a nova quantidade a
	 * ser comprada for 0 (zero), a compra será removida da lista]
	 * 
	 * @param id
	 *            identificador da compra a ser alterada
	 * @param nQtd
	 *            nova quantidade a ser comprada
	 */
	public void setQntCompra(int id, int nQtd) {
		analisaExistencia(id, ErrosListasComprasController.P_COMPRA_INEXISTENTE.toString());
		int qtdAtual = this.listaDeCompras.get(id).getQtd();
		if (qtdAtual + nQtd == 0) {
			this.deletaCompra(id);
		} else {
			this.listaDeCompras.get(id).setQtd(nQtd);
		}
	}

	/**
	 * Analisa se existe uma compra cadastrada com um determinado id
	 * 
	 * @param id
	 *            identificacao a ser buscada
	 * @param msg
	 *            mensagem de erro a ser exibida caso nao exista compra cadastrada
	 *            com o id especificado
	 */
	public void analisaExistencia(int id, String msg) {
		if (!this.listaDeCompras.containsKey(id))
			throw new IllegalArgumentException(msg);
	}

	/**
	 * Analisa se um determinado id encontra-se cadastrado na lista de compras.
	 * 
	 * @param id
	 *            identificador a ser buscado
	 * @return boolean - true se o id estiver cadastrado, caso contrario, false.
	 */
	public boolean analisaExistencia(int id) {
		return this.listaDeCompras.containsKey(id);
	}

	/**
	 * Retorna a representacao textual da lista de compras.
	 */
	@Override
	public String toString() {
		return this.dataCriacao + " - " + this.descritor;
	}

}
