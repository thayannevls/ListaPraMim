package ui;

import java.io.IOException;

import persistencia.Persistencia;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Facade f = new Facade();
		Persistencia.carregarItens();
		f.exibeItem(1);
//		Facade f = new Facade();
//		f.adicionaItemPorQtd("aa", "higiene pessoal", 1, "l", "arroz", 2.3);
//		Persistencia.salvarItens(f.exibeItem(1));

	}

}
