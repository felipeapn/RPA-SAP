package br.com.fpaixao.openSapGui.principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import br.com.fpaixao.openSapGui.classes.GereciadorArquivoTxt;
import br.com.fpaixao.openSapGui.classes.SapLogonDado;

public class AbrirAmbienteSAP {

	int contaEspaço;
	// String param2;
	// String param1;

	public static void main(String[] args) {

		int contador = 0;
		boolean ambienteEcontrado = false;
		String ambienteSelecionado = "";
		SapLogonDado ambientes[] = new SapLogonDado[GereciadorArquivoTxt.contaLinhas()];
		StringBuilder perguntaQualAmbiente = new StringBuilder("Selecione o abiente (");
		BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			InputStream fls = new FileInputStream("meutexto.txt");
			Reader reader = new InputStreamReader(fls);
			BufferedReader br = new BufferedReader(reader);

			String linha = br.readLine();

			while (linha != null) {

				String parametros[] = GereciadorArquivoTxt.retornaParametrosPorSeparador(linha, '	', 4);

				ambientes[contador] = new SapLogonDado(parametros[0], parametros[1], parametros[2], parametros[3]);

				contador++;
				linha = br.readLine();
			}

			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < ambientes.length; i++) {
			perguntaQualAmbiente.append(ambientes[i].getSysname());
			if (i == ambientes.length - 1) {
				perguntaQualAmbiente.append("):");
			} else {
				perguntaQualAmbiente.append(" | ");
			}
		}

		try {
			while (!ambienteEcontrado) {

				System.out.println(perguntaQualAmbiente);
				ambienteSelecionado = bufferEntrada.readLine();
				System.out.println(ambienteSelecionado.toUpperCase());

				for (int i = 0; i < ambientes.length; i++) {

					if (ambientes[i].getSysname().equalsIgnoreCase(ambienteSelecionado)) {
												
						ambientes[i].executarComandoLogin();
						ambienteEcontrado = true;
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}