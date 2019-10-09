package br.com.fpaixao.openSapGui.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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

	

}
