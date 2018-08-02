package ui;

public class Main {
	public static void main(String[] args) {
		Facade f = new Facade();
		int id1 = f.adicionaItemPorQtd("aa", "higiene pessoal", 2, "l", "supermercado", 2.1);
		int id2 = f.adicionaItemPorQtd("bb", "higiene pessoal", 2, "l", "supermercado", 2.1);
		int id3 =f.adicionaItemPorQtd("aa", "higiene pessoal", 2, "l", "aa", 1);
		
		f.adicionaListaDeCompras("lista");
		f.adicionaCompraALista("lista", 1, id1);
		f.adicionaCompraALista("lista", 1, id2);
		f.adicionaCompraALista("lista", 1, id3);
		
		System.out.println(f.sugereMelhorEstabelecimento("lista", 0, 1));
	}
}
