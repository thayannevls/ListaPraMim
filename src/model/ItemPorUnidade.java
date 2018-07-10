package model;

public class ItemPorUnidade {

	private int unidade;

	public ItemPorUnidade(String nome, int id, String categoria, int unidade, String localDeCompra, double preco) {
		this.unidade = unidade;
	}
	
	public int getUnidade() {
		return unidade;
	}
}
