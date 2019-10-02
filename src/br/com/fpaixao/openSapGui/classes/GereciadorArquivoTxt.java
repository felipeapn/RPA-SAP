package br.com.fpaixao.openSapGui.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class GereciadorArquivoTxt {

	private static int numeroLinhas = 0;

	public static int contaLinhas() {

		try {
			InputStream fls = new FileInputStream("meutexto.txt");
			Reader reader = new InputStreamReader(fls);
			BufferedReader br = new BufferedReader(reader);

			//br.readLine();
			//GereciadorArquivoTxt.numeroLinhas += 1;

			while (br.readLine() != null) {
				GereciadorArquivoTxt.numeroLinhas += 1;
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return GereciadorArquivoTxt.numeroLinhas;

	}
	
	public static String[] retornaParametrosPorSeparador (String linha, char separador, int numeroParamentros) {
		
		int parametro = 0;
		StringBuilder textoDoParametro = new StringBuilder();
		String parametros[] = new String[numeroParamentros];
		
		for (int i=0; i < linha.length(); i++) {
			
			if (linha.charAt(i)!= separador) {
				
				textoDoParametro.append(linha.charAt(i));
				
			} else {
				
				parametros[parametro] = textoDoParametro.toString();
				textoDoParametro.setLength(0);
				parametro += 1;
				
			}
		}
		
		return parametros;
		
	}

}
