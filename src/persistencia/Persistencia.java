package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public final class Persistencia {
	
	private static final Persistencia INSTANCE = new Persistencia();
	
	private static final String DIR = "resources" + File.separator + "persistencia";
	private static File rootPath = new File(DIR);
	private static File listasArquivo = new File(rootPath + File.separator + "listasDeCompras.txt");;
	private static File itensArquivo = new File(rootPath + File.separator + "itens.txt");;
	
	private Persistencia(){
		
	}
	
	public static Persistencia getInstance(){
		return INSTANCE;
	}
	
	public static void salvarListas(String texto) throws IOException{
		salvar(listasArquivo, texto);
	}
	
	public static void salvarItens(String texto) throws IOException{
		salvar(itensArquivo, texto);
	}
	
	public static void carregarListas() throws IOException{
		carregar(listasArquivo);
	}
	
	public static void carregarItens() throws IOException{
		carregar(itensArquivo);
	}
	
	
	private static void salvar(File arquivo, String texto) throws IOException{
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(texto);
		
		bw.close();
		fw.close();
	}
	
	private static String carregar(File arquivo) throws IOException{
		
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		StringJoiner joiner = new StringJoiner(System.lineSeparator());
		
		String line = br.readLine();
		while(line != null){
			joiner.add(line);
			line = br.readLine();
		}
		
		br.close();
		fr.close();
		
		return joiner.toString();
	}
}
