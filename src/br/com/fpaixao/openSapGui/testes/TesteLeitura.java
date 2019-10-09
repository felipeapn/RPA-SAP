package br.com.fpaixao.openSapGui.testes;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv"));

		while (scanner.hasNextLine()) {

			Scanner linha = new Scanner(scanner.nextLine());
			
			linha.useDelimiter(",");
			linha.useLocale(Locale.US);
			
//			String tipoConta = linha.next();
//			int  agencia = linha.nextInt();
//			int    conta = linha.nextInt();
//			String nome = linha.next();
//			double saldo = linha.nextDouble();
			
			String tipoConta = linha.next();
            int agencia = linha.nextInt();
            int numero = linha.nextInt();
            String titular = linha.next();
            //String saldo = linha.next();
            double saldo = linha.nextDouble();
			
			
			String formatada = String.format(Locale.GERMANY, "%s - %04d- %08d, %12s: %08.2f",
							 	tipoConta, agencia, numero, titular, saldo);
			
			System.out.println(formatada);
			
			linha.close();

		}

		scanner.close();
	}

}
