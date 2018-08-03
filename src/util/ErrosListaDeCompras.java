package util;

/**
 * Classe que contem mensagens de erros de ListaDeCompras
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414 UFCG/2018.1 - Laboratório de
 * 
 *         Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public enum ErrosListaDeCompras {
	
	FALTA_DADOS("Faltam dados para informar sobre preços em locais de compras.");
	
	private String descricao;

	/**
	 * Inicializa a categoria com a sua descricao
	 * 
	 * @param descricao tipo da categoria
	 */
	private ErrosListaDeCompras(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Retorna a categoria do item compravel.
	 * 
	 * @return String - representando a categoria
	 */
	@Override
	public String toString() {
		return this.descricao;
	}
}
