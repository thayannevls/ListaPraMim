package util;

public enum CategoriaEnum {

	ALIMENTOS_INDUSTRIALIZADOS("alimentos industrializados"), 
	ALIMENTOS_NAO_INDUSTRIALIZADOS("alimentos nao industrializados"), 
	LIMPEZA_HIGIENE_PESSOAL("higiene pessoal");
	
	private String descricao;
	
	private CategoriaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return descricao;
	}
}
