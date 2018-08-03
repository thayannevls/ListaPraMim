package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe que contem metodos de validacao usados pelo sistema
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programacao 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class Validator {

	/**
	 * Verifica se numero e positivo
	 * 
	 * @param num
	 *            numero a ser comparado
	 * @param mensagem
	 *            mensagem que deve ser incluida na excecao
	 * @exception IllegalArgumentException
	 *                se for negativo
	 */
	public static void ehPositivo(double num, String mensagem) {
		if (num <= 0)
			throw new IllegalArgumentException(mensagem);
	}

	/**
	 * Verifica se um campo de texto nao e nulo e nem vazio
	 * 
	 * @param mensagem mensagem de erro caso nao seja valido
	 * @param campo
	 *            texto a ser validado
	 * @exception IllegalArgumentException
	 *                se o campo for nulo ou vazio
	 */
	public static void campoValido(String campo, String mensagem) {
		if (campo == null || campo.trim().isEmpty())
			throw new IllegalArgumentException(mensagem);
	}

	/**
	 * Verifica se a categoria e valida pros tipos conhecidos
	 * 
	 * @param categoria
	 *            categoria a ser verficida
	 * @param mensagem
	 *            mensagem que vai ser retorna se houver erro
	 * @exception IllegalArgumentException
	 *                caso seja passado uma categoria invalida
	 *                
	 *  @return boolean true caso seja valida
	 */
	public static boolean categoriaValida(String categoria, String mensagem) {
		for (CategoriaEnum c : CategoriaEnum.values()) {
			if (c.toString().equals(categoria.toLowerCase())) {
				return true;
			}
		}
		throw new IllegalArgumentException(mensagem);
	}

	/**
	 * Verifica se campo eh uma data valida
	 * 
	 * @param data
	 *            campo a ser verificado
	 * @param mensagem
	 *            mensagem de erro a ser retornado se nao for valido
	 * @exception IllegalArgumentException
	 *                caso seja passado uma categoria inválida
	 */
	public static void dataValida(String data, String mensagem) {
		String dateFormat = "dd/MM/yyyy";
		try {
			DateFormat df = new SimpleDateFormat(dateFormat);
			df.setLenient(false);
			df.parse(data);
		} catch (ParseException e) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Verifica se a operacao de atualizacao da lista de compras eh valida.
	 * 
	 * @param operacao
	 *            operacao que sera realizada
	 * @param msg
	 *            mensagem que sera lancada
	 */
	public static void operacaoValida(String operacao, String msg) {
		if (!(operacao.equals("adiciona") || operacao.equals("diminui")))
			throw new IllegalArgumentException(msg);
	}

	/**
	 * Verifica se o id de um item eh valido.
	 * 
	 * @param id
	 *            identificacao do item
	 * @param msg mensagem de erro caso seja menor que 1
	 */
	public static void idValido(int id, String msg) {
		if (id < 1)
			throw new IllegalArgumentException(msg);
	}

}
