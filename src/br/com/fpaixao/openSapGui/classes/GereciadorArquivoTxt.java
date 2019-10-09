package br.com.fpaixao.openSapGui.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.fpaixao.openSapGui.exceptions.ExSysnameVazio;

// alterar aqui
public class GereciadorArquivoTxt {
	
	public String getMensagemSaida (ArrayList<SapLogonDado> list) {
		
		StringBuilder stringBuilder = new StringBuilder("Selecione o ambiente (");
		
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(list.get(i).getSysname());
			if (i == list.size() - 1) {
				stringBuilder.append("):");
			} else {
				stringBuilder.append(" | ");
			}
		}
		
		return stringBuilder.toString();	
		
	}

	public boolean gravarArquivo(File file, ArrayList<SapLogonDado> ambientes) throws Exception {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		for (SapLogonDado sapLogonDado : ambientes) {
			
			bw.write(sapLogonDado.getLinhaFormatada());
			bw.newLine();	
		}
		
		bw.close();
		
		return true;
	}

	public SapLogonDado criaAmbientes(BufferedReader bufferEntrada) throws IOException, ExSysnameVazio {
				
		System.out.print("Informar ambiente: ");
		String sysname = bufferEntrada.readLine().toUpperCase();
		System.out.print("Informar client: ");
		String client = bufferEntrada.readLine().toUpperCase();
		System.out.print("Informar user: ");
		String user = bufferEntrada.readLine().toUpperCase();
		System.out.print("Informar senha: ");
		String pw = bufferEntrada.readLine().toUpperCase();
		
		return new SapLogonDado(sysname, client, user, pw);
		
	}

	

}
