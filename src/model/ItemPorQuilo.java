package model;

import util.ErrosItemController;
import util.Validator;

/**
 * Classe responsável por registrar e armazenar dados de um item do tipo: Por
 * quilo. Herda da classe ItemCompravel
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratório de
 *         Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorQuilo extends ItemCompravel {

	private double quilograma;

	/**
	 * Construtor de ItemPorQuilo, herdando codigo da classe pai.
	 * 
	 * @param nome
	 *            nome do item
	 * @param id
	 *            identificador do item
	 * @param categoria
	 *            categoria do item
	 * @param quilograma
	 *            quantidade em quilo do item
	 * @param localDeCompra
	 *            local da compra do produto
	 * @param preco
	 *            preco do item
	 */
	public ItemPorQuilo(String nome, int id, String categoria, double quilograma, String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.quilograma = quilograma;
	}

	/**
	 * Responsavel por pegar a quantidade em quilo do item.
	 * 
	 * @return double - representando a quantidade de kg de um item
	 */
	public double getQuilo() {
		return this.quilograma;
	}

	/**
	 * Responsavel por alterar o valor da quantidade em quilo do item.
	 * 
	 * @param quilograma
	 *            novo valor para a quantidade em quilo do item
	 */
	public void setQuilo(double quilograma) {
		this.quilograma = quilograma;
	}
	
	@Override
	public void atualiza(String novoValor) {
		this.quilograma = Double.parseDouble(novoValor);
	}

	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorQuilo.
	 * 
	 * @return String - representando um ItemPorQuilo
	 */
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " + this.categoria + ", " + "Preco por quilo: <" + super.localPreco() + ">";
	}
}
