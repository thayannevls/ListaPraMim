package util;

import java.text.NumberFormat;
import java.util.Locale;

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
}
