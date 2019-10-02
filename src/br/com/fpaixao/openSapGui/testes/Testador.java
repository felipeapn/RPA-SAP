package br.com.fpaixao.openSapGui.testes;

import br.com.fpaixao.openSapGui.classes.GereciadorArquivoTxt;

public class Testador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(GereciadorArquivoTxt.contaLinhas());
		
		String teste[] = GereciadorArquivoTxt.
							retornaParametrosPorSeparador("R4T	100	BR0085853537	e4eREN**2	",
				 											'	', 4);
		
		System.out.println(teste[3]);

	}

}
