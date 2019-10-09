package br.com.fpaixao.openSapGui.testes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

public class TestaEscrita {

	public static void main(String[] args) throws IOException {

		long ini = System.currentTimeMillis();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("textoescrito.txt"));
		
		bw.write("Escrevendo primeira linha");
		bw.newLine();
		bw.newLine();
		bw.write("Pulei a linha \n a agora na terceira");
		
		bw.close();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("A escrita demorou: " + (fim - ini) + " Milisegundos");
		
		
	}
	
}
