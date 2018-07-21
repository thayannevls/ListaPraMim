package util;

public enum ErrosItemController {
	
	// CADASTRO
	CADASTRO_NOME_NULO("Erro no cadastro de item: nome nao pode ser vazio ou nulo."),
	CADASTRO_CATEGORIA_NULA("Erro no cadastro de item: categoria nao pode ser vazia ou nula."),
	CADASTRO_CATEGORIA_INEXISTENTE("Erro no cadastro de item: categoria nao existe."),
	CADASTRO_QUILO_NEGATIVO("Erro no cadastro de item: valor de quilos nao pode ser menor que zero."),
	CADASTRO_QUANTIDADE_NEGATIVA("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero."),
	CADASTRO_UNIDADE_NULA("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula."),
	CADASTRO_UNIDADE_NEGATIVA("Erro no cadastro de item: valor de unidade nao pode ser menor que zero."),
	CADASTRO_LOCAL_NULO("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo."),
	CADASTRO_PRECO_INVALIDO("Erro no cadastro de item: preco de item invalido."),
	
	// LISTAGEM
	LISTAGEM_ID_INVALIDO("Erro na listagem de item: id invalido."),
	LISTAGEM_ITEM_INEXISTENTE("Erro na listagem de item: item nao existe."),
	LISTAGEM_CATEGORIA_INEXISTENTE("Erro na listagem de item: categoria nao existe."),
	
	// ATUALIZA
	ATUALIZA_ITEM_INEXISTENTE("Erro na atualizacao de item: item nao existe."),
	ATUALIZA_ATRIBUTO_INEXISTENTE("Erro na atualizacao de item: atributo nao existe."),
	ATUALIZA_ATRIBUTO_NULO("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo."),
	ATUALIZA_VALOR_NULO("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo."),
	ATUALIZA_CATEGORIA_INEXISTENTE("Erro na atualizacao de item: categoria nao existe."),
	ATUALIZA_QUANTIDADE_NEGATIVO("Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero."),
	ATUALIZA_QUILO_NEGATIVO("Erro na atualizacao de item: valor de quilos nao pode ser menor que zero."),
	
	// ADICIONA NOVOS PRECOS
	PRECO_ID_INVALIDO("Erro no cadastro de preco: id de item invalido."),
	PRECO_LOCAL_NULO("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo."),
	PRECO_ITEM_PRECO_INVALIDO("Erro no cadastro de preco: preco de item invalido."),
	PRECO_ITEM_INEXISTENTE("Erro no cadastro de preco: item nao existe."),
	
	// DELETA
	DELETA_ID_INVALIDO("Erro ao deletar item: id de item invalido."),
	
	// PEGAR ITEM
	GET_ID_IVALIDO("Erro ao buscar o item: id de item inexistente");
	
	private String descricao;

	/**
	 * Inicializa a categoria com a sua descricao
	 * 
	 * @param descricao tipo da categoria
	 */
	private ErrosItemController(String descricao) {
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
