package model;

public class ItemPorQtd extends {

	private int quantidade;
	private String unidade;
	
	public ItemPorQtd(String nome, int id, String categoria, int quantidade, String unidade, String localDeCompra, double preco) {
		super(nome, id, categoria, adicionaPreco);
		this.quantidade = quantidade;
		this.unidade = unidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public String toString() {
		return super(id) + ". " + super(nome) + " " + quantidade + unidade + " ";
	}
}
