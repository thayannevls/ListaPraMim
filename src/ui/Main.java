package ui;

public class Main {
	public static void main(String[] args) {
		Facade f = new Facade();
		f.adicionaListaDeCompras("lista");
		int id3 =f.adicionaItemPorQtd("cc", "higiene pessoal", 2, "l", "loja", 2);
		int id4 =f.adicionaItemPorQtd("dd", "higiene pessoal", 2, "l", "loja", 2.1);

		f.adicionaCompraALista("lista", 2, id3);
		f.adicionaCompraALista("lista", 2, id4);
		
		System.out.println(f.sugereMelhorEstabelecimento("lista", 0, 0)); //printando 12.40
		
//		int id3 =f.adicionaItemPorQtd("cc", "higiene pessoal", 2, "l", "loja", 1.6);
//		int id4 =f.adicionaItemPorQtd("dd", "higiene pessoal", 2, "l", "loja", 2);
//		
//		int id1 = f.adicionaItemPorQtd("aa", "higiene pessoal", 2, "l", "supermercado", 2.1);
//		int id2 = f.adicionaItemPorQtd("bb", "higiene pessoal", 2, "l", "supermercado", 2.1);
//		int id3 =f.adicionaItemPorQtd("cc", "higiene pessoal", 2, "l", "loja", 1.6);
//		int id4 =f.adicionaItemPorQtd("dd", "higiene pessoal", 2, "l", "loja", 2);
//		
//		f.adicionaListaDeCompras("lista");
//		f.adicionaCompraALista("lista", 1, id1);
//		f.adicionaCompraALista("lista", 1, id2);
//		f.adicionaCompraALista("lista", 2, id3);
//		f.adicionaCompraALista("lista", 5, id4);
//		System.out.println(f.sugereMelhorEstabelecimento("lista", 1, 0));
//		System.out.println(f.sugereMelhorEstabelecimento("lista", 0, 0));
	}
}
