package model;

public class ItemPorQuilo {

	private double quilo;
	
	public ItemPorQuilo(String nome, int id, String categoria, double quilo, String localDeCompra, double preco) {
		this.quilo = quilo;
	}
	
	public double getQuilo() {
		return quilo;
	}
	
	public String toString() {
		
	}
}
