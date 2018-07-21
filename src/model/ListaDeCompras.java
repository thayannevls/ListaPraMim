package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.ItemCategoriaENomeComparador;

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
 * 		   UFCG/2018.1 - Laboratório de
 *         Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ListaDeCompras {

	private String descritor;
	private Map<Integer, Compra> listaDeCompras;
	private Date dataCriacao;
	private boolean finalizada;
	private String localCompra;
	private double valorTotal;
	
	/**
	 * Contrutor da classe Lista de Compras. Inicializa os atriburos da classe.
	 * 
	 * @param descritor
	 *            string contendo uma representacao para descricao da lista de compras
	 */
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		this.listaDeCompras = new HashMap<>();
		this.dataCriacao = new Date(System.currentTimeMillis());
		this.finalizada = false;
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
		this.analisaExistencia(id, "");
		this.analisaEstado("");
		//
		this.listaDeCompras.put(item.getId(), new Compra(qtd, item));
	}
	
	/**
	 * Remove um irem da lista de compras.
	 * 
	 * @param id
	 *            identificador do item a ser removido.
	 */
	public void deletaCompra(int id) {
		this.analisaExistencia(id, "");
		this.analisaEstado("");
		//
		this.listaDeCompras.remove(id);
	}

	/**
	 * Analisa se a lista foi finalizada
	 * 
	 * @param msg
	 *            mensagem de erro a ser exibida caso se queira realizar uma
	 *            atividade nao desejada em uma lista finalizada
	 */
	private void analisaEstado(String msg) {
		if(this.finalizada)
			throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Retorna uma listagem de todas as compras cadastradas na lista de compras.
	 * 
	 * @return string contendo uma representacao textual de todas as compras cadastradas na lista.
	 */
	public String getItemLista(int id) {
		List<Compra> compras = new ArrayList<>(listaDeCompras.values());
		compras.sort(new ItemCategoriaENomeComparador());
		//
		return compras.get(id).toString();
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
		this.analisaEstado("");
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
	 * Altera a quantidade de itens que serao comprados.
	 * [Caso a nova quantidade a ser comprada for 0 (zero),
	 * a compra será removida da lista]
	 * 
	 * @param id
	 *            identificador da compra a ser alterada
	 * @param nQtd
	 *            nova quantidade a ser comprada
	 */
	public void setCompra(int id, int nQtd) {
		this.analisaExistencia(id, "");
		//
		if(nQtd == 0) {
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
	private void analisaExistencia(int id, String msg) {
		if(this.listaDeCompras.containsKey(id)) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Retorna a representacao textual da lista de compras.
	 */
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(this.dataCriacao) + " " + this.descritor;
	}
	
}
