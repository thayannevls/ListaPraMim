package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe responsavel por conter metodos para salvar e carregar entidades em arquivos. Usando padrao de projeto Singleton
 * @author José Guilheme - Matricula: 117210370
 * @author Mariana Nascimento - Matricula: 117210416
 * @author Siuanny Barbosa - Matriucla: 117210395
 * @author Thayanne Sousa - Matricula: 117210414
 * 
 *         UFCG/2018.1 - Laboratório de Programação 2 - Projeto de Laboratorio
 *         (Lista pra mim)
 */
public final class Persistencia {
	
	private static final Persistencia INSTANCE = new Persistencia();
	
	private static final String DIR = "resources" + File.separator + "persistencia";
	private static File rootPath = new File(DIR);
	private static File listasArquivo = new File(rootPath + File.separator + "listasDeCompras.txt");;
	private static File itensArquivo = new File(rootPath + File.separator + "itens.txt");;
	
	private Persistencia(){}
	
	public static Persistencia getInstance(){
		return INSTANCE;
	}
	
	/**
	 * Salva todas as listas de compras cadastradas no sistema em um arquivo
	 * @param listas listas a serem cadastradas
	 * @throws IOException caso ocorra algum erro
	 */
	public static void salvarListas(Object listas) throws IOException{
		salvar(listasArquivo, listas);
	}
	
	/**
	 * Salva todas os itens compraveis cadastradas no sistema em um arquivo
	 * @param itens itens a serem cadastradas
	 * @throws IOException caso ocorra algum erro
	 */
	public static void salvarItens(Object itens) throws IOException{
		salvar(itensArquivo, itens);
	}
	
	/**
	 * Recupera todas as listas de compras salvas no arquivo
	 * @return Object listas recuperadas
	 * @throws IOException caso ocorra algum erro
	 */
	public static Object carregarListas() throws IOException, ClassNotFoundException{
		return carregar(listasArquivo);
	}
	
	/**
	 * Recupera todas os itens compraveis salvos no arquivo
	 * @return Object itens recuperado
	 * @throws IOException caso ocorra algum erro
	 */
	public static Object carregarItens() throws IOException, ClassNotFoundException{
		return carregar(itensArquivo);
	}

	/**
	 * Verifica se nenhum arquivo foi criado ainda
	 * @return boolean true caso nao tenha sido criado nenhum arquivo, false o contrario
	 */
	public  static boolean arquivosNaoCriados(){
		if(itensArquivo.exists() && listasArquivo.exists())
			return false;
		return true;
	}
	
	/**
	 * Salva um objeto em um arquivo
	 * @param arquivo arquivo que sera salvo o objeto
	 * @param objeto objeto a ser salvo
	 * @throws IOException caso ocorra algum erro inesperado
	 */
	private static void salvar(File arquivo, Object objeto) throws IOException{
		FileOutputStream fos = new FileOutputStream(arquivo);		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		oos.writeObject(objeto);
		oos.close();
		fos.close();
	}
	
	/**
	 * Recupera objeto salvo em arquivo
	 * @param arquivo arquivo que deve ser lido
	 * @return Object objeto recuperado
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Object carregar(File arquivo) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(arquivo);		
		ObjectInputStream ois = new ObjectInputStream(fis);
		   
		Object objeto =  ois.readObject(); 
		
		ois.close();
		fis.close();
		
		return objeto;
	}
}
