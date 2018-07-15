package model;

import util.Utils;

/**
 * Classe responsável por registrar e armazenar dados de um item do tipo: Por
 * unidade. Herda da classe ItemCompravel
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorUnidade extends ItemCompravel {

	private int unidade;

	/**
	 * Construtor de ItemPorUnidade, herdando codigo da classe pai.
	 * 
	 * @param nome          nome do item
	 * @param id            identificador de item
	 * @param categoria     categoria do item
	 * @param unidade       quantidade de itens comprados
	 * @param localDeCompra local da compra do produto
	 * @param preco         preco do item
	 */
	public ItemPorUnidade(String nome, int id, String categoria, int unidade, String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.unidade = unidade;
	}

	/**
	 * Responsavel por pegar aqunatidade comprada do item.
	 * 
	 * @return int - representando a quantidade do item
	 */
	public int getUnidade() {
		return this.unidade;
	}

	/**
	 * Responsavel por alterar a quantidade em unidades do item.
	 * 
	 * @param unidade quantidade de itens
	 */
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	/**
	 * Responsável por unir em String os locais de copra do item e seu referente
	 * preco. (usado no toString)
	 * 
	 * @return String - representando locais e precos
	 */
	private String localPreco() {
		String localPreco = "";
		for (String localDeCompra : this.mapaDePrecos.keySet()) {
			localPreco += localDeCompra + ", " + Utils.realComVirgula((this.mapaDePrecos.get(localDeCompra))) + ";";
		}
		return localPreco;
	}

	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorUnidade.
	 * 
	 * @return String - representando um ItemPorUnidade
	 */
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " + this.categoria + ", " + "Preco: <" + this.localPreco() + ">";
	}
}
