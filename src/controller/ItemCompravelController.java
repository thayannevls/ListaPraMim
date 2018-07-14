package controller;

import java.util.HashMap;
import java.util.Map;

import model.ItemCompravel;
import model.ItemPorQtd;
import model.ItemPorQuilo;
import model.ItemPorUnidade;

/**
 * Classe responsável por controlar itens comŕavel no sistema
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class ItemCompravelController {
	private Map<Integer, ItemCompravel> itens;
	private int qtdItens;
	
	public ItemCompravelController() {
		this.itens = new HashMap<>();
		this.qtdItens = 0;
	}
	
	/**
	 * 
	 * @param nome
	 * @param categoria
	 * @param kg
	 * @param localDeCompra
	 * @param preco
	 * @return
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQuilo(nome, id, categoria, kg, localDeCompra, preco);
		itens.put(id, item);
		return id;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorUnidade(nome, id, categoria, unidade, localDeCompra, preco);
		itens.put(id, item);
		return id;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQtd(nome, id, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
		itens.put(id, item);
		return id;
	}

	public String exibeItem(int id) {
		idValido(id);
		return itens.get(id).toString();
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		idValido(id);
		itens.get(id).adicionaPreco(localDeCompra, preco);
	}
	
	//to do
	public void atualizaItem(int id, String atributo, String novoValor) {
		idValido(id);
		
		switch(atributo){
			case "nome":
				itens.get(id).setNome(novoValor);
				break;
			case "categoria":
				itens.get(id).setCategoria(novoValor);
				break;
			case "quantidade":
				int valor = Integer.parseInt(novoValor);
				((ItemPorQtd) itens.get(id)).setQuantidade(valor);
				
		}
	}
	
	public void deletaItem(int id) {
		idValido(id);
		itens.remove(id);
	}
	
	private boolean idValido(int id){
		if(id < 1)
			throw new IllegalArgumentException();
		return true;
	}
	
}
