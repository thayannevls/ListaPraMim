package model;

/**
 * Classe responsável por registrar e armazenar dados de um item do 
 * tipo: Por quantidade. Herda da classe ItemCompravel.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210395
 * @author Siuanny Barbosa - Matriucla: 
 * @author Thayanne Sousa - Matricula:
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorQtd extends ItemCompravel{

	private int quantidade;
	private String unidade;
	
	
	/**
	 * Construtor de ItemPorQuantidade, herdando codigo da classe pai.
	 * 
	 * @param nome
	 *          nome do item
	 * @param categoria
	 * 			categoria do item
	 * @param quantidade
	 * 			quantidade comprada do item
	 * @param unidade
	 * 			unidade de medida
	 * @param localDeCompra
	 * 			local onde foi comprado o item
	 * @param preco
	 * 			preco do item
	 * @param base
	 * 			base para gerar o id do item
	 */
	public ItemPorQtd(String nome, String categoria, int quantidade, String unidade, String localDeCompra, double preco, int base) {
		super(nome, categoria, localDeCompra, preco, base);
		this.quantidade = quantidade;
		this.unidade = unidade;
	}
	
	
	/**
	 * Responsavel por pegar a quantidade comprada do produto.
	 * @return int - representando a quantidade do produto
	 */
	public int getQuantidade() {
		return quantidade;
	}
	
	
	/**
	 * Responsavel por pegar a unidade de medida do item.
	 * @return String - representando a unidade de medida
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorQtd.
	 * @return String - representando um ItemPorQtd
	 */
	@Override
	public String toString() {
//		". Batata Tentacoes, alimento industrializado, Preco: <Supermercado Excepcional, R$ 3,79;>" exibeItem id=${id10}
		return id + ". " + nome + ", " + categoria + ", " +  "Preco: <" ;
	}
}
