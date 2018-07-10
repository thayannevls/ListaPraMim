package model;

import java.util.HashMap;

public abstract class ItemCompravel {

	protected String nome;
	protected int id;
	protected CategoriaEnum categoria;
	protected HashMap<String, Double> mapaDePrecos;
	
	public ItemCompravel(String nome, String categoria, String localDeCompra, double preco, int base) {
		this.nome = nome;
		this.categoria = categoria;
		this.mapaDePrecos = new HashMap<>();
		adicionaPreco(localDeCompra, preco);
		this.id = base++;
	}
	
	public void adicionaPreco(String supermercado, double preco) {
		this.mapaDePrecos.put(supermercado, preco);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
