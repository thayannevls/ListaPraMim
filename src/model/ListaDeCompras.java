package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import comparator.CompraItemCategoriaENomeComparator;
import comparator.EstabelecimentoPrecoComparator;
import comparator.ItemCategoriaENomeComparator;
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

public class ListaDeCompras implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 *            string contendo uma representacao para descricao da lista de
	 *            compras
	 */
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		this.listaDeCompras = new HashMap<>();
		this.dataCriacao = new Date(System.currentTimeMillis());
		this.finalizada = false;
	}

	/**
	 * Retorna a lista de compras.
	 * @return Map - com os identificadores da compra como chave e as compras como os valores
	 */
	public Map<Integer, Compra> getListaDeCompras() {
		return this.listaDeCompras;
	}

	/**
	 * Altera os dados da lista de compras.
	 * @param listaDeCompras novos dados para a lista de compra
	 */
	public void setListaDeCompras(Map<Integer, Compra> listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

	/**
	 * Retorna o a data da criacao da lista.
	 * @return Date - representado a data
	 */
	public Date getDataCriacao() {
		return this.dataCriacao;
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
	public String getDataCriacaoStr() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(this.dataCriacao);
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
<<<<<<< HEAD
		List<Compra> compras = new ArrayList<>(listaDeCompras.values());
		Collections.sort(compras, new CompraItemCategoriaENomeComparator());
=======
		List<Compra> compras = new ArrayList<>(this.listaDeCompras.values());
		Collections.sort(compras, new ItemCategoriaENomeComparador());
>>>>>>> a1d686855f4a766978d1e0d9f7ace14f1b5bde23

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
		return this.listaDeCompras.get(id).toString();
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
		this.analisaExistencia(id, ErrosListasComprasController.P_COMPRA_INEXISTENTE.toString());
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
	 * Retorna uma compra apartir do id.
	 * 
	 * @param id
	 *            identificador da compra
	 * @return Compra - representando uma compra de um item
	 */
	public Compra getCompra(int id) {
		return this.listaDeCompras.get(id);
	}
	
	/**
	 * Retorna a representacao textual da lista de compras.
	 */
	@Override
	public String toString() {
		return this.getDataCriacaoStr() + " - " + this.descritor;
	}

	public String sugereMelhorEstabelecimento(int posicaoEstabelecimento, int posicaoLista) {
//		Map<String, Double> estabelecimentos = new HashMap<>();
//        
//		for(Compra compra: this.listaDeCompras.values()){
//			compra.getItem().getMapaDePrecos().forEach(
//					(k, v) -> estabelecimentos.merge(k, v, (v1, v2) -> ((v1) * compra.getQtd() + v2)));
//		}
//		System.out.println(estabelecimentos.entrySet());
//		EstabelecimentoPrecoComparator bvc = new EstabelecimentoPrecoComparator(estabelecimentos);
//        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
//        sorted_map.putAll(estabelecimentos);
//        String key = (String)sorted_map.keySet().toArray()[posicaoEstabelecimento];
//        
//        List<Compra> itensPesquisados = this.listaDeCompras.values().stream()
//				.filter((Compra compra) -> compra.getItem().getMapaDePrecos().containsKey(key))
//				.collect(Collectors.toList());
//        return (String) (sorted_map.keySet().toArray()[posicaoEstabelecimento] + itensPesquisados.get(posicaoLista).getItem().toString());
		String estabelecimento = (String) this.retornaEstabelecimentosOrdenados().keySet().toArray()[posicaoEstabelecimento];
		
		if(posicaoLista == 0)
			return estabelecimento + ": R$ " + this.retornaEstabelecimentosOrdenados().get(estabelecimento);
		return "- " + retornaItensPorEstabelecimento(estabelecimento).get(posicaoLista).toString();
		
		
		
	}
	
	public TreeMap<String, Double> retornaEstabelecimentosOrdenados(){
		Map<String, Double> estabelecimentos = new HashMap<>();
        
		for(Compra compra: this.listaDeCompras.values()){
			compra.getItem().getMapaDePrecos().forEach((k, v) -> 
						estabelecimentos.merge(k, v, (v1, v2) -> 
						((v1) * compra.getQtd() + v2)));
		}
		EstabelecimentoPrecoComparator bvc = new EstabelecimentoPrecoComparator(estabelecimentos);
        TreeMap<String, Double> estabelecimentos_ordenados = new TreeMap<String, Double>(bvc);
        estabelecimentos_ordenados.putAll(estabelecimentos);
        
        return estabelecimentos_ordenados;
	}
	
	public List<ItemCompravel> retornaItensPorEstabelecimento(String estabelecimento){
		List<ItemCompravel> itensPesquisados = this.listaDeCompras.values().stream()
				.map(Compra::getItem)
				.filter((ItemCompravel item) -> item.getMapaDePrecos().containsKey(estabelecimento))
				.collect(Collectors.toList());
		
		Collections.sort(itensPesquisados, new ItemCategoriaENomeComparator());
		return itensPesquisados;
	}

}
