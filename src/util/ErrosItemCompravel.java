package util;

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
