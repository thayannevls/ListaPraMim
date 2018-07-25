package test.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import model.ItemCompravel;
import model.ItemPorUnidade;
import model.ListaDeCompras;

public class ListaDeComprasTest {
	private ListaDeCompras lista;
	
	@Before
	public void setUp(){
		lista = new ListaDeCompras(1, "feira");
	}
	
	@Test
	public void testCriar() {
		new ListaDeCompras(1, "feira");
	}

	@Test
	public void testAdicionaItemLista() {
		ItemCompravel item = new ItemPorUnidade("semente", 2, "higiene pessoal", 1, "floricultura", 2.3);
		lista.adicionaItemLista(1, 1, item);
		assertEquals("Verificado adicionar item a lista", item.toString(), lista.getItemPeloId(2));
	}
	
	@Test
	public void testDeletaItemLista() {
		ItemCompravel item = new ItemPorUnidade("semente", 2, "higiene pessoal", 1, "floricultura", 2.3);
		lista.adicionaItemLista(1, 1, item);
		lista.deletaCompra(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeletaItemInexistente() {
		lista.deletaCompra(1);
	}
	
	@Test
	public void testToString() {
		Date dataAtual = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = df.format(dataAtual);
		
		String retornoEsperado = strDate + " ha";
		ListaDeCompras novaLista = new ListaDeCompras(1, "ha");
		
		assertEquals("Verificado toString da classe ListaDeCompras", retornoEsperado, novaLista.toString());
	}
}
