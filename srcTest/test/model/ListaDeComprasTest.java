package test.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import model.ItemCompravel;
import model.ItemPorQtd;
import model.ItemPorUnidade;
import model.ListaDeCompras;

public class ListaDeComprasTest {
	private ListaDeCompras lista;
	
	@Before
	public void setUp(){
		lista = new ListaDeCompras("feira");
	}
	
	@Test
	public void testCriar() {
		new ListaDeCompras("feira");
	}
	
	@Test
	public void testSetQntCompra(){
		ItemCompravel item = new ItemPorQtd("aa", 1, "higiene pessoal", 1, "l", "super", 2.0);
		lista.adicionaItemLista(1, 2, item);
		lista.setQntCompra(1, 2);
		assertEquals("Testa mudar quantidade de compra", "4 aa, higiene pessoal, 1 l", lista.getListaDeCompras().get(1).toString());
		
	}
	
	@Test
	public void testSetQntCompraParaDeletar(){
		ItemCompravel item = new ItemPorQtd("aa", 1, "higiene pessoal", 1, "l", "super", 2.0);
		lista.adicionaItemLista(1, 2, item);
		lista.setQntCompra(1, -1);
	}
	
	@Test
	public void testGetDescritor(){
		assertEquals("Testa descritor de lista","feira", lista.getDescritor());
	}
	
	@Test
	public void testAdicionaItemLista() {
		ItemCompravel item = new ItemPorUnidade("semente", 2, "higiene pessoal", 1, "floricultura", 2.3);
		lista.adicionaItemLista(1, 1, item);
		assertEquals("Verificado adicionar item a lista", "1 " + item.getDescricaoBasica(), lista.getItemPeloId(2));
	}
	
	@Test
	public void testDeletaItemLista() {
		ItemCompravel item = new ItemPorUnidade("semente", 2, "higiene pessoal", 1, "floricultura", 2.3);
		lista.adicionaItemLista(1, 1, item);
		lista.deletaCompra(1);
	}
	
	@Test
	public void testToString() {
		Date dataAtual = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = df.format(dataAtual);
		
		String retornoEsperado = strDate + " - ha";
		ListaDeCompras novaLista = new ListaDeCompras("ha");
		
		assertEquals("Verificado toString da classe ListaDeCompras", retornoEsperado, novaLista.toString());
	}
}
