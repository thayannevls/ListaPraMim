package model;

/**
 * Classe responsável por registrar e armazenar dados de um item do 
 * tipo: Por quantidade. Herda da classe ItemCompravel.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorQtd extends ItemCompravel{

	private int quantidade;
	private String unidadeDeMedida;
	
	/**
	 * Construtor de ItemPorQuantidade, herdando codigo da classe pai.
	 * @param nome
	 *          nome do item
	 * @param categoria
	 * 			categoria do item
	 * @param quantidade
	 * 			quantidade comprada do item
	 * @param unidadeDeMedida
	 * 			unidade de medida
	 * @param localDeCompra
	 * 			local onde foi comprado o item
	 * @param preco
	 * 			preco do item
	 * @param base
	 * 			base para gerar o id do item
	 */
	public ItemPorQtd(String nome, int id, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;
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
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	
	/**
	 * Responsavel por alterar a quantidade do item.
	 * @param quantidade
	 * 			nova quantidade para ser atualizado
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Responsavel por alterar a unidade de medida do item.
	 * @param unidadeDeMedida
	 * 			novo valor para alterar a unidade de medida
	 */
	public void setUnidade(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * Responsável por unir em String os locais de copra do item e seu referente preco. (usado no toString)
	 * @return String - representando locais e precos
	 */
	private String localPreco() {
		String localPreco = "";
		for (String localDeCompra : mapaDePrecos.keySet()) {
			localPreco += localDeCompra + ", " + String.format("R$ %.2f", (mapaDePrecos.get(localDeCompra))) + ";";
		}
		return localPreco;
	}

	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorQtd.
	 * @return String - representando um ItemPorQtd
	 */
	@Override
	public String toString() {
		return id + ". " + nome + ", " + categoria + ", " + quantidade + " " + unidadeDeMedida + ", " +  "Preco: <" + localPreco() + ">" ;
	}
}
