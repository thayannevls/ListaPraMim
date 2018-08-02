package model;

/**
 * Classe responsável por registrar e armazenar dados de um item do tipo: Por
 * quantidade. Herda da classe ItemCompravel.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matricula: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratório de
 *         Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemPorQtd extends ItemCompravel {

	private int quantidade;
	private String unidadeDeMedida;

	/**
	 * Construtor de ItemPorQuantidade, herdando codigo da classe pai.
	 * 
	 * @param nome
	 *            nome do item
	 * @param id
	 *            identificador do item
	 * @param categoria
	 *            categoria do item
	 * @param quantidade
	 *            quantidade comprada do item
	 * @param unidadeDeMedida
	 *            unidade de medida do item
	 * @param localDeCompra
	 *            local onde foi comprado o item
	 * @param preco
	 *            preco do item
	 */
	public ItemPorQtd(String nome, int id, String categoria, int quantidade, String unidadeDeMedida,
			String localDeCompra, double preco) {
		super(nome, id, categoria, localDeCompra, preco);
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * Responsavel por pegar a quantidade comprada do produto.
	 * 
	 * @return int - representando a quantidade do produto
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Responsavel por pegar a unidade de medida do item.
	 * 
	 * @return String - representando a unidade de medida
	 */
	public String getUnidadeDeMedida() {
		return this.unidadeDeMedida;
	}

	/**
	 * Responsavel por alterar a quantidade do item.
	 * 
	 * @param quantidade
	 *            nova quantidade para ser atualizado
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Responsavel por alterar a unidade de medida do item.
	 * 
	 * @param unidadeDeMedida
	 *            novo valor para alterar a unidade de medida
	 */
	public void setUnidade(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * Retorna uma representacao textual basica de um item por quilo contendo sua
	 * descricao e sua categoria e peso base.
	 */
	@Override
	public String getDescricaoBasica() {
		return this.nome + ", " + this.categoria + ", " + this.quantidade + " " + this.unidadeDeMedida;
	}
	

	@Override
	public void atualiza(String novoValor) {
		this.unidadeDeMedida = novoValor;
	}
	
	/**
	 * Responsavel por retornar a represnetação em String de um ItemPorQtd.
	 * 
	 * @return String - representando um ItemPorQtd
	 */
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " + this.categoria + ", " + this.quantidade + " " + this.unidadeDeMedida
				+ ", " + "Preco: <" + super.localPreco() + ">";
	}

}
