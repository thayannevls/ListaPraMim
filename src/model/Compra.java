package model;

/**
 * Entidade que representa uma determinada compra em um sistema. Em uma compra
 * ha uma quantidade que representa a quantos itens se deseja comprar e um item
 * a ser comprado. Sao realizadas algumas acoes basicas em uma compra, como
 * alterar a quantidade de itens que se deseja comprar.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class Compra {

	private int qtd;
	private ItemCompravel item;

	/**
	 * Construtor da classe compra inicializa os atributos da classe compra.
	 * 
	 * @param qtd
	 *            quantidade que se deseja comprar de um determinado item
	 * @param item
	 *            item o qual se deseja comprar
	 */
	public Compra(int qtd, ItemCompravel item) {
		this.qtd = qtd;
		this.item = item;
	}
	
	/**
	 * Retorna a quantidade de itens que se deseja comprar de um determinado item.
	 * 
	 * @return int com a quantidade que se deseja comprar do item
	 */
	public int getQtd() {
		return this.qtd;
	}

	/**
	 * Alterar a quantidade que se deseja comprar do item.
	 * 
	 * @param nQtd
	 *            nova quantidade que se deseja comprar
	 */
	public void setQtd(int nQtd) {
		this.qtd = nQtd;
	}
	
	/**
	 * Disponibiliza para outras entidades do sistema a categoria do item a ser comprado.
	 * 
	 * @return string contendo a categoria do item a ser comprado.
	 */
	public String getCategoria() {
		return this.item.getCategoria();
	}
	
	/**
	 * Disponibiliza para outras entidades do sistema a descricao do item a ser comprado.
	 * 
	 * @return string contendo a descricao do item a ser comprado.
	 */
	public String getNome() {
		return this.item.getNome();
	}

	/**
	 * Representacao textual da classe compra contendo a quantidade de itens a serem
	 * comprados e uma descricao basica do item.
	 */
	public String toString() {
		return this.qtd + " " + item.getDescricaoBasica();
	}

}
