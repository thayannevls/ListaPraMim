package controller;

import java.util.HashMap;
import java.util.Map;

import model.ItemCompravel;
import model.ItemPorQtd;
import model.ItemPorQuilo;
import model.ItemPorUnidade;
import util.ErrosItemController;

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
		qtdItens ++;
		return id;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorUnidade(nome, id, categoria, unidade, localDeCompra, preco);
		itens.put(id, item);
		qtdItens ++;
		return id;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQtd(nome, id, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
		itens.put(id, item);
		qtdItens ++;
		return id;
	}

	public String exibeItem(int id) {
		idValido(id, ErrosItemController.LISTAGEM_ITEM_INEXISTENTE.toString());
		return itens.get(id).toString();
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		idValido(id, ErrosItemController.PRECO_ID_INVALIDO.toString());
		itens.get(id).adicionaPreco(localDeCompra, preco);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor) {
		idValido(id, ErrosItemController.ATUALIZA_ITEM_INEXISTENTE.toString());
		
		switch(atributo){
			case "nome":
				itens.get(id).setNome(novoValor);
				break;
			case "categoria":
				itens.get(id).setCategoria(novoValor);
				break;
			case "quantidade":
				((ItemPorQtd) itens.get(id)).setQuantidade(Integer.parseInt(novoValor));
				break;
			case "unidade de medida":
				((ItemPorQtd) itens.get(id)).setUnidade(novoValor);
				break;
			case "kg":
				((ItemPorQuilo) itens.get(id)).setQuilo(Double.parseDouble(novoValor));
				break;
			default:
				throw new IllegalArgumentException(ErrosItemController.ATUALIZA_ATRIBUTO_INEXISTENTE.toString());
		}
	}
	
	public void deletaItem(int id) {
		idValido(id, ErrosItemController.DELETA_ID_INVALIDO.toString());
		itens.remove(id);
	}
	
	private boolean idValido(int id, String mensagem){
		if(id < 1)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
}
