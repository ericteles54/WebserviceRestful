package br.com.qiinfo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe responsável por executar comandos shell e retornar
 * saída do comando
 * 
 * @author Eric Teles Leite
 *
 */
public class ExecutaComandoShell {
	
	private String comando;
	
	public ExecutaComandoShell() {
		
	}
	
	/**
	 * 
	 * Método executa comando no shell e retorna saida do comando
	 * 
	 * @param Comando a ser executado
	 * @return List<String> com saída do comando no shell
	 */	
	public List<String> executar(String comando) {
		
		this.comando = comando;
				
		List<String> retorno = new ArrayList<String>();
		
		try {
			// Tenta executar o comando
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(comando);			
			
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			// lê resposta do comando linha por linha
			String line;
			while ( (line = bufferedReader.readLine()) != null ) {				
				retorno.add(line);
			}			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		this.comando = new String();
		
		return retorno;
	}
}
