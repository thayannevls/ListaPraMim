package controller;

import java.util.HashMap;
import java.util.Map;

import model.ItemCompravel;
import model.ItemPorQtd;
import model.ItemPorQuilo;
import model.ItemPorUnidade;
import util.ErrosItemController;
import util.Validator;

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
		Validator.ehPositivo(kg, ErrosItemController.CADASTRO_QUILO_NEGATIVO.toString());
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());
		
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQuilo(nome, id, categoria, kg, localDeCompra, preco);
		itens.put(id, item);
		qtdItens ++;
		return id;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.ehPositivo(unidade, ErrosItemController.CADASTRO_UNIDADE_NEGATIVA.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());
		
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorUnidade(nome, id, categoria, unidade, localDeCompra, preco);
		itens.put(id, item);
		qtdItens ++;
		return id;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		
		Validator.ehPositivo(qnt, ErrosItemController.CADASTRO_QUANTIDADE_NEGATIVA.toString());
		Validator.ehPositivo(preco, ErrosItemController.CADASTRO_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.CADASTRO_LOCAL_NULO.toString());
		Validator.categoriaValida(categoria, ErrosItemController.CADASTRO_CATEGORIA_INEXISTENTE.toString());
		Validator.campoValido(categoria, ErrosItemController.CADASTRO_CATEGORIA_NULA.toString());
		Validator.campoValido(nome, ErrosItemController.CADASTRO_NOME_NULO.toString());
		Validator.campoValido(unidadeDeMedida, ErrosItemController.CADASTRO_UNIDADE_NULA.toString());
		
		int id = qtdItens + 1;
		ItemCompravel item = new ItemPorQtd(nome, id, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
		itens.put(id, item);
		qtdItens ++;
		return id;
	}

	public String exibeItem(int id) {
		idValido(id, ErrosItemController.LISTAGEM_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.LISTAGEM_ITEM_INEXISTENTE.toString());

		return itens.get(id).toString();
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		idValido(id, ErrosItemController.PRECO_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.PRECO_ITEM_INEXISTENTE.toString());

		
		Validator.ehPositivo(preco, ErrosItemController.PRECO_ITEM_PRECO_INVALIDO.toString());
		Validator.campoValido(localDeCompra, ErrosItemController.PRECO_LOCAL_NULO.toString());
		
		itens.get(id).adicionaPreco(localDeCompra, preco);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor) {
		Validator.campoValido(atributo, ErrosItemController.ATUALIZA_ATRIBUTO_NULO.toString());
		Validator.campoValido(novoValor, ErrosItemController.ATUALIZA_VALOR_NULO.toString());
		idValido(id, ErrosItemController.ATUALIZA_ITEM_INEXISTENTE.toString());

		itemExiste(id, ErrosItemController.ATUALIZA_ITEM_INEXISTENTE.toString());
		
		switch(atributo){
			case "nome":
				itens.get(id).setNome(novoValor);
				break;
			case "categoria":
				Validator.categoriaValida(novoValor, ErrosItemController.ATUALIZA_CATEGORIA_INEXISTENTE.toString());
				itens.get(id).setCategoria(novoValor);
				break;
			case "quantidade":
				int quantidade = Integer.parseInt(novoValor);
				Validator.ehPositivo(quantidade, ErrosItemController.ATUALIZA_QUANTIDADE_NEGATIVO.toString());
				((ItemPorQtd) itens.get(id)).setQuantidade(quantidade);
				break;
			case "unidade de medida":
				((ItemPorQtd) itens.get(id)).setUnidade(novoValor);
				break;
			case "unidades":
				int unidade = Integer.parseInt(novoValor);
				Validator.ehPositivo(unidade, ErrosItemController.ATUALIZA_QUANTIDADE_NEGATIVO.toString());
				((ItemPorUnidade) itens.get(id)).setUnidade(unidade);
				break;
			case "kg":
				double kg = Double.parseDouble(novoValor);
				Validator.ehPositivo(kg, ErrosItemController.ATUALIZA_QUILO_NEGATIVO.toString());
				
				((ItemPorQuilo) itens.get(id)).setQuilo(kg);
				break;
			default:
				throw new IllegalArgumentException(ErrosItemController.ATUALIZA_ATRIBUTO_INEXISTENTE.toString());
		}
	}
	
	public void deletaItem(int id) {
		idValido(id, ErrosItemController.DELETA_ID_INVALIDO.toString());
		itemExiste(id, ErrosItemController.DELETA_ID_INVALIDO.toString());
		itens.remove(id);
	}
	
	private boolean idValido(int id, String mensagem){
		if(id < 1)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	private boolean itemExiste(int id, String mensagem){
		if(itens.containsKey(id))
			return true;
		throw new IllegalArgumentException(mensagem);
	}
	
}
