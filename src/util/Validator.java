package util;

public class Validator {

	/**
	 * Verifica se número é maior que zero
	 * 
	 * @param num número a ser comparado
	 * @param mensagem mensagem que deve ser incluída na exceção
	 * @return boolean - retorna se for maior que zero
	 * @exception IllegalArgumentException se for menor que zero
	 */
	public static boolean maiorQueZero(int num, String mensagem){
		if(num <= 0)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se número é positivo
	 * 
	 * @param num número a ser comparado
	 * @param mensagem mensagem que deve ser incluída na exceção
	 * @return boolean retorna se for positivo
	 * @exception IllegalArgumentException se for negativo
	 */
	public static boolean ehPositivo(int num, String mensagem){
		if(num <= 0)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se número é positivo
	 * 
	 * @param num número a ser comparado
	 * @param mensagem mensagem que deve ser incluída na exceção
	 * @return boolean retorna se for positivo
	 * @exception IllegalArgumentException se for negativo
	 */
	public static boolean ehPositivo(double num, String mensagem){
		if(num <= 0)
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se um campo de texto não é nulo e nem vazio
	 * 
	 * @param campo texto a ser validado
	 * @return boolean retorna verdadeiro se não for vazio ou nulo
	 * @exception IllegalArgumentException se o campo for nulo ou vazio
	 */
	public static boolean campoValido(String campo, String mensagem){
		if(campo == null || campo.trim().isEmpty())
			throw new IllegalArgumentException(mensagem);
		return true;
	}
	
	/**
	 * Verifica se a categoria é válida pros tipos conhecidos
	 * 
	 * @param mensagem mensagem a ser verificada
	 * @exception IllegalArgumentException caso seja passado uma categoria inválida
	 */
	public static boolean categoriaValida(String categoria, String mensagem){
		for (CategoriaEnum c : CategoriaEnum.values()) {
			if (c.toString().equals(categoria.toLowerCase())) {
				return true;
			}
		}
		throw new IllegalArgumentException(mensagem);
	}
}
