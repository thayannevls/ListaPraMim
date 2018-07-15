package util;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
	public static String realComVirgula(int valorReal) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String currencySymbol = format.format(0.00).replace("0.00", "");
		String valorReais = format.format(valorReal).replace(currencySymbol, currencySymbol + " ");
		return valorReais;
	}
	
	public static String realComVirgula(double valorReal) {
		valorReal *= 1.0;
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String currencySymbol = format.format(0.00).replace("0.00", "");
		String valorReais = format.format(valorReal).replace(currencySymbol, currencySymbol + " ");
		return valorReais;
	}
}
