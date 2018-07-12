package ui;

import controller.ItemCompravelController;
import easyaccept.EasyAccept;

/**
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public class Facade {
	ItemCompravelController itemController;
	
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
	 * Adiciona um preco ao mapa de compras do item
	 * @param id id do item a ser adicionado
	 * @param localDeCompra local de compra do produto
	 * @param preco preco nesse local de compra
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco){
		itemController.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/**
	 * Atualiza item com id especificado
	 * @param id id do item
	 * @param atributo atributo a ser modificado
	 * @param novoValor novo valor do atributo
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		itemController.atualizaItem(id, atributo, novoValor);
	}
	
	/**
	 * Deleta item que contem id especificado
	 * @param id
	 */
	public void deletaItem(int id) {
		itemController.deletaItem(id);
	}
}

