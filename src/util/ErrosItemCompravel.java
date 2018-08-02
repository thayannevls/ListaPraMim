package util;

/**
 * Classe responsavel por "enumerar" erros de ItemCompravel.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public enum ErrosItemCompravel {

	CATEGORIA_INVALIDA("A categoria passada como parametro nao e valida");
	
	private String descricao;

	/**
	 * Inicializa a categoria com a sua descricao
	 * 
	 * @param descricao tipo da categoria
	 */
	private ErrosItemCompravel(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna a descricao do item compravel erro.
	 * 
	 * @return String - representando a categoria
	 */
	@Override
	public String toString() {
		return this.descricao;
	}
	
}
