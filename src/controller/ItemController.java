package controller;

import java.util.HashMap;
import java.util.Map;

import model.ItemCompravel;

public class ItemController {
	
	private Map<Integer, ItemCompravel> itensCompraveisCadastrados;

	public ItemController() {
		itensCompraveisCadastrados = new HashMap<>();
	}

	/**
	 * Adicina ao sistema de itens os itens que são do tipo por quantidade.
	 * 
	 * @param nome
	 *            nome do item a ser cadastrado
	 * @param categoria
	 *            categoria do item a ser cadastrado
	 * @param qnt
	 *            quantidade de itens
	 * @param unidadeDeMedida
	 *            unidade de medida do item
	 * @param localDeCompra
	 *            onde o item foi adquirido
	 * @param preco
	 *            valor do item a ser cadastrado
	 * @return id do item cadastrado
	 */
	public int adicionaItemPorQnt(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		ItemPorQnt newItem = new ItemPorQnt(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco, itensCompraveisCadastrados.size());
		itensCompraveisCadastrados.put(newItem.getId(), newItem);
		return newItem.getId();
	}
	
	/**
	 * Adicina ao sistema de itens os itens que são do tipo por quilo.
	 * 
	 * @param nome
	 *            nome do item a ser cadastrado
	 * @param categoria
	 *            categoria do item a ser cadastrado
	 * @param quilo
	 *            peso do item a ser cadastrado
	 * @param localDeCompra
	 *            local onde o item foi adquirido
	 * @param preco
	 *            valor do item a ser cadastrado
	 * @return id do item cadastrado
	 */
	public int adcionaItemPorQuilo(String nome, String categoria, double quilo, String localDeCompra, double preco) {
		ItemPorQuilo newItem = new ItemPorQuilo(nome, categoria, quilo, localDeCompra, preco, itensCompraveisCadastrados.size());
		itensCompraveisCadastrados.put(newItem.getId(), newItem);
		return newItem.getId();	
	}
	
	public int adcionaItemPorUnidade(String nome, )
	
}
