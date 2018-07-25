package util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Metodos auxiliares 
 * @author Thayanne
 */
public class Utils {
	public static String realComVirgula(int valorReal) {
		Locale ptBr = new Locale("pt", "BR");
		String valorReais = NumberFormat.getCurrencyInstance(ptBr).format(valorReal);
		return valorReais;
	}
	
	public static String realComVirgula(double valorReal) {
		valorReal *= 1.0;
		Locale ptBr = new Locale("pt", "BR");
		String valorReais = NumberFormat.getCurrencyInstance(ptBr).format(valorReal);
		return valorReais;
	}
	
	/**
	 * Retorna data atual em string
	 * @return
	 */
	public static String dataAtual(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date(System.currentTimeMillis()));
	}
}
