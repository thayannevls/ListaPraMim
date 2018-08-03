package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import util.CategoriaEnum;
import util.ErrosItemCompravel;
import util.Utils;

/**
 * Classe responsável por registrar e manipular os dados de um Item compravel. É
 * a classe pai das classes: ItemPorQtd, ItemPorQuilo e ItemPorUnidade.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public abstract class ItemCompravel implements Serializable {

	private static final long serialVersionUID = -4404861805894253484L;
	
	protected String nome;
	protected int id;
	protected CategoriaEnum categoria;
	protected Map<String, Double> mapaDePrecos;

	/**
	 * Construtor de ItemCompravel
	 * 
	 * @param nome
	 *            nome do item
	 * @param id
	 *            identificador do item
	 * @param categoria
	 *            categoria do item
	 * @param localDeCompra
	 *            local onde foi comprado o item
	 * @param preco
	 *            preco do item
	 */
	public ItemCompravel(String nome, int id, String categoria, String localDeCompra, double preco) {
		this.id = id;
		this.nome = nome;
		this.mapaDePrecos = new HashMap<>();
		this.adicionaPreco(localDeCompra, preco);
		this.setCategoria(categoria);
	}

	/**
	 * Responsavel por adicionar preco e supermercado no mapa de precos.
	 * 
	 * @param supermercado
	 *            nome do supermercado onde o item foi comprado
	 * @param preco
	 *            preco do item
	 */
	public void adicionaPreco(String supermercado, double preco) {
		this.mapaDePrecos.put(supermercado, preco);
	}
	
	/**
	 * Retorna nome do item.
	 * @return String nome
	 */
	public String getNome(){
		return nome;
	}
	/**
	 * Responsavel por alterar o nome do item.
	 * 
	 * @param nome
	 *            nome do item
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Responsavel por pegar a categoria do item.
	 * @return String - representando a categoria do item
	 */
	public String getCategoria() {
		return this.categoria.toString();
	}
	
	/**
	 * Responsavel por determinar a categoria do item.
	 * 
	 * @param categoria
	 *            categoria do item
	 */
	public void setCategoria(String categoria) {
		for (CategoriaEnum c : CategoriaEnum.values()) {
			if (c.toString().equals(categoria)) {
				this.categoria = c;
				return;
			}
		}
		throw new IllegalArgumentException(ErrosItemCompravel.CATEGORIA_INVALIDA.toString());
	}
	
	/**
	 * Responsavel por pegar o mapa de precos do item.
	 * 
	 * @return Map - representando o mapa de precos
	 */
	public Map<String, Double> getMapaDePrecos() {
		return this.mapaDePrecos;
	}
	
	/**
	 * Responsavel por pegar o id do item.
	 * 
	 * @return int - representando o identificador do item
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Responsável por unir em String os locais de copra do item e seu referente
	 * preco. (usado no toString).
	 * 
	 * @return String - representando locais e precos
	 */
	protected String localPreco() {
		String localPreco = "";
		for (String localDeCompra : this.mapaDePrecos.keySet()) {
			localPreco += localDeCompra + ", " + Utils.realComVirgula((this.mapaDePrecos.get(localDeCompra))) + ";";
		}
		return localPreco;
	}
	
	public abstract void atualiza(String novoValor);

	/**
	 * Responsável por verificar codigo hash do objeto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + nome.hashCode();
		return result;
	}

	/**
	 * Responsável por verificar se dois itens compraveis sáo iguais. Verificando o
	 * nome e a categoria dos itens.
	 * 
	 * @return boolean - determinando true se forem iguais e false caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompravel other = (ItemCompravel) obj;
		if (categoria != other.categoria)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Retorna uma representacao textual basica de um item por quilo contendo sua
	 * descricao e sua categoria e peso base.
	 * 
	 * @return String descricao basica do item
	 */
	public String getDescricaoBasica() {
		return this.nome + ", " + this.categoria;
	}
}
