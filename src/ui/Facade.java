package ui;

import controller.ItemController;
import easyaccept.EasyAccept;

/**
 * 
 * @author Thayanne Sousa - 117210414
 */
public class Facade {
	ItemController itemController;
	
	public static void main(String[] args){
		args = new String[] {"ui.Facade","acceptance_test/use_case1","acceptance_test/use_case1_exception.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Adiciona um Item com quantidade fixa
	 * @param nome nome do produto
	 * @param categoria categoria a que pertence
	 * @param qnt quantidade
	 * @param unidadeDeMedida unidade de medida adotada
	 * @param localDeCompra local de compra do produto
	 * @param preco preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		return itemController.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}
	
	/**
	 * Adiciona um item por quilo
	 * @param nome nome do produto
	 * @param categoria categoria a que pertence
	 * @param kg peso do item
	 * @param localDeCompra local de compra do produto
	 * @param preco preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return itemController.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	
	/**
	 * Adiciona item por unidade
	 * @param nome nome do produto
	 * @param categoria categoria a que pertence
	 * @param unidade unidades
	 * @param localDeCompra local de compra do produto
	 * @param preco preco em reais
	 * @return int id do novo item
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return itemController.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**
	 * Retorna representacao textual de um item
	 * @param id id do item
	 * @return String item
	 */
	public String exibeItem(int id) {
		return itemController.exibeItem(id);
	}
	
	/**
	 * Atualiza item com id especificado
	 * @param id id do item
	 * @param atributo atributo a ser modificado
	 * @param novoValor novo valor do atributo
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		controller.atualizaItem(id, atributo, novoValor);
	}
	
	/**
	 * Deleta item que contem id especificado
	 * @param id
	 */
	public void deletaItem(int id) {
		controller.deletaItem(id);
	}
}

