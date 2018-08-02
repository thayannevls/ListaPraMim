package util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe que contem metodos auxiliares.
 * 
 * @author Jose Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratorio de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public class Utils {

	/**
	 * Retorna representacao do valor inteiro como a moeda Real
	 * 
	 * @param valorReal
	 *            valor inteiro do dinheiro
	 * @return String representacao em real
	 */
	public static String realComVirgula(int valorReal) {
		Locale ptBr = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(ptBr).format(valorReal);
	}

	/**
	 * Retorna representacao do valor double como a moeda Real
	 * 
	 * @param valorReal
	 *            valor double do dinheiro
	 * @return String representacao em real
	 */
	public static String realComVirgula(double valorReal) {
		Locale ptBr = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(ptBr).format(valorReal * 1.0);
	}

	/**
	 * Retorna data atual em string
	 * 
	 * @return String representacao da data
	 */
	public static String dataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date(System.currentTimeMillis()));
	}
	
}
