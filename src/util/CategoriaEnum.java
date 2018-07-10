package util;

/** 
 * Classe responsável por "enumerar" a categoria, retornando o tipo
 * da categoria do Item compravel.
 * 
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210395
 * @author Siuanny Barbosa - Matriucla: 
 * @author Thayanne Sousa - Matricula:
 * UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio (Lista pra mim)
 */
public enum CategoriaEnum {

	ALIMENTOS_INDUSTRIALIZADOS("alimentos industrializados"), 
	ALIMENTOS_NAO_INDUSTRIALIZADOS("alimentos nao industrializados"), 
	HIGIENE_PESSOAL("higiene pessoal"),
	LIMPEZA("limpeza");
	
	private String descricao;
	
	
	/**
	 * Inicializa a categoria com a sua descricao
	 * @param descricao
	 * 			tipo da categoria
	 */
	private CategoriaEnum(String descricao) {
		this.descricao = descricao;
	}

	
	/**
	 * Retorna a categoria do item compravel.
	 * @return String - representando a categoria
	 */
	@Override
	public String toString() {
		return descricao;
	}

	
	
}
