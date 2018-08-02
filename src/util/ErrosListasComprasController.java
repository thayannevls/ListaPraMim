package util;

public enum ErrosListasComprasController {
	
	//CADASTRO
	C_DESCRITOR_INVALIDO("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo."),
	
	//PESQUISA
	P_COMPRA_INEXISTENTE("Erro na pesquisa de compra: compra nao encontrada na lista."),
	P_ID_INVALIDO("Erro na pesquisa de compra: item id invalido."),
	P_DESCRITOR_INVALIDO("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo."),
	PL_DESCRITOR_INVALIDO("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo."),
	P_LISTA_INEXISTENTE("Erro na pesquisa de compra: lista de compras nao existe."),
	P_DATA_FORMATO_IVALIDO("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy"),
	P_DATA_VAZIA_OU_NULA("Erro na pesquisa de compra: data nao pode ser vazia ou nula."),
	
	//ATUALIZACAO
	A_COMPRA_INEXISTENTE("Erro na atualizacao de compra: compra nao encontrada na lista."),
	A_OPERACAO_INVALIDA("Erro na atualizacao de compra: operacao invalida para atualizacao."),
	A_DESCRITOR_INVALIDO("Erro na atualizacao da compra: descritor nao pode ser vazio ou null."),
	A_NOVA_QTD_INVALIDA("Erro na atualizacao da compra: quantidade invalida."),
	
	//ADICIONAR
	ADD_ITEM_INEXISTENTE("Erro na compra de item: item nao existe no sistema."),
	ADD_DESCRITOR_INVALIDO("Erro na compra de item: descritor nao pode ser vazio ou nulo."),
	ADD_QTD_INVALIDA("Erro na compra de item: quantidade nao pode ser menor ou igual a zero."),
	
	//EXCLUIR
	E_DESCRITOR_INVALIDO("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo."),
	E_COMPRA_INEXISTENTE("Erro na exclusao de compra: compra nao encontrada na lista."),
	E_ITEM_INEXISTENTE("Erro na exclusao de compra: item nao existe no sistema."),
	
	//FINALIZAR
	F_DESCRITOR_INVALIDO("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo."),
	F_LOCAL_INVALIDO("Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo."),
	F_VALOR_FINAL_INVALIDO("Erro na finalizacao de lista de compras: valor final da lista invalido."),
	
	LISTA_FINALIZADA("Erro: Lista ja finalizada."),
	
	//LISTA NAO EXISTE
	LISTA_INEXISTENTE("Erro: lista nao cadastrada."),
	
	//GERAR lISTA
	G_COMPRA_NAO_CADASTRADA("Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
	
	private String descricao;

	/**
	 * Inicializa a categoria com a sua descricao
	 * 
	 * @param descricao tipo da categoria
	 */
	private ErrosListasComprasController(String descricao) {
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
