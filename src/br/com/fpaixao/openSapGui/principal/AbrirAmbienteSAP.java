package br.com.fpaixao.openSapGui.principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import br.com.fpaixao.openSapGui.classes.CryptoUtils;
import br.com.fpaixao.openSapGui.classes.GereciadorArquivoTxt;
import br.com.fpaixao.openSapGui.classes.SapLogonDado;

public class AbrirAmbienteSAP {

	public static void main(String[] args) {

		boolean ambienteEcontrado = false;
		String ambienteSelecionado = "";
		ArrayList<SapLogonDado> ambientes = new ArrayList<SapLogonDado>();
		String perguntaQualAmbiente;
		BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(System.in));

		GereciadorArquivoTxt gerente = new GereciadorArquivoTxt();
		File file = new File("meutexto.txt");

		String key = "Mary has one cat";

		try {

			CryptoUtils.decrypt(key, file, file);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {

				Scanner linha = new Scanner(scanner.nextLine());
				linha.useDelimiter("	");
				linha.useLocale(Locale.US);

				ambientes.add(new SapLogonDado(linha.next(), linha.next(), linha.next(), linha.next()));

				linha.close();
			}

			scanner.close();
			CryptoUtils.encrypt(key, file, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		perguntaQualAmbiente = gerente.getMensagemSaida(ambientes);

		try {
			while (!ambienteEcontrado) {

				System.out.println(perguntaQualAmbiente);
				ambienteSelecionado = bufferEntrada.readLine().toUpperCase();

				if (ambienteSelecionado.equalsIgnoreCase("EDIT")) {

					System.out.println("ADD -> Novo ambiente | DEL -> Apagar Ambiente");
					String comando = bufferEntrada.readLine().toUpperCase();

					switch (comando) {

					case "ADD":

						System.out.print("Informar ambiente: ");
						String sysname = bufferEntrada.readLine().toUpperCase();
						System.out.print("Informar client: ");
						String client = bufferEntrada.readLine().toUpperCase();
						System.out.print("Informar user: ");
						String user = bufferEntrada.readLine().toUpperCase();
						System.out.print("Informar senha: ");
						String pw = bufferEntrada.readLine().toUpperCase();

						ambientes.add(new SapLogonDado(sysname, client, user, pw));

						CryptoUtils.decrypt(key, file, file);

						if (gerente.gravarArquivo(file, ambientes)) {
							System.out.println("Novo ambiente gravado");
						} else {
							System.out.println("Não foi possível gravar");
						}

						CryptoUtils.encrypt(key, file, file);

						perguntaQualAmbiente = gerente.getMensagemSaida(ambientes);

						break;

					case "DEL":

						SapLogonDado objDeletar = null;

						System.out.println("Digite o ambiente para deleção: ");
						comando = bufferEntrada.readLine().toUpperCase();

						for (SapLogonDado sapLogonDado : ambientes) {
							if (sapLogonDado.getSysname().equalsIgnoreCase(comando)) {
								objDeletar = sapLogonDado;
								break;
							}
						}

						if (objDeletar != null) {

							ambientes.remove(objDeletar);

							CryptoUtils.decrypt(key, file, file);

							if (gerente.gravarArquivo(file, ambientes)) {
								System.out.println("Ambiante " + comando + " removido");
							} else {
								System.out.println("Não foi possível gravar");
							}

							CryptoUtils.encrypt(key, file, file);

							perguntaQualAmbiente = gerente.getMensagemSaida(ambientes);
						}

						break;

					default:
						System.out.println("Comando não existe");
					}

				} else {
					if (ambienteSelecionado.length() > 4) {

						SapLogonDado.setLanguage((String) ambienteSelecionado.subSequence(3, 5));

					}

					if (ambienteSelecionado.length() > 2) {

						for (int i = 0; i < ambientes.size(); i++) {

							if (ambientes.get(i).getSysname()
									.equalsIgnoreCase((String) ambienteSelecionado.subSequence(0, 3))) {

								ambientes.get(i).executarComandoLogin();
								ambienteEcontrado = true;
								break;
							}
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}