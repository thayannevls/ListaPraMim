package model;

/**
 * Classe responsável por registrar e armazenar dados de um item do 
 * tipo: Por quilo. Herda da classe ItemCompravel
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210395
 * @author Siuanny Barbosa - Matriucla: 
 * @author Thayanne Sousa - Matricula:
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorQuilo extends ItemCompravel {

	private double quilo;
	
	/**
	 * Construtor de ItemPorQuilo, herdando codigo da classe pai.
	 * @param nome
	 * 			nome do item
	 * @param categoria
	 * 			categoria do item
	 * @param quilo
	 * 			quantidade em quilo do item
	 * @param localDeCompra
	 * 			local da compra do produto
	 * @param preco
	 * 			preco do item
	 * @param base
	 * 			base para gerar o id do item
	 */
	public ItemPorQuilo(String nome, int id, String categoria, double quilo, String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.quilo = quilo;
	}
	
	/**
	 * Responsavel por pegar a quantidade em quilo do item.
	 * @return int - representando a quantidade comprada do item
	 */
	public double getQuilo() {
		return quilo;
	}
	
	private String localPreco() {
		String localPreco = "";
		for (String localDeCompra : mapaDePrecos.keySet()) {
			localPreco += localDeCompra + ", " + String.format("R$ %.2f", (mapaDePrecos.get(localDeCompra))) + ";";
		}
		return localPreco;
	}
	
	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorQuilo.
	 * @return String - representando um ItemPorQuilo
	 */
	@Override
	public String toString() {
		return id + ". " + nome + ", " + categoria + ", " +  "Preco: <" + localPreco() + ">" ;
	}
}
