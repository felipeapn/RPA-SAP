package br.com.fpaixao.openSapGui.testes;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.fpaixao.openSapGui.classes.SapLogonDado;

public class TestaComandos {

	public static void main(String[] args) {

		SapLogonDado logon = null;
		String name;

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (logon == null) {
				System.out.println("Escolha o ambiente (R4D / R4T / R4Q / SRP):");
				name = reader.readLine();
				System.out.println(name);

				switch (name) {
				case "R4T":
					logon = new SapLogonDado(name, "100", "BR0085853537", "e4eREN**2");
					break;
				case "R4Q":
					logon = new SapLogonDado(name, "100", "BR0085853537", "e4eREN**2");
					break;
				case "R4D":
					logon = new SapLogonDado(name, "100", "BR0085853537", "e4eREN**1");
					break;
				case "SRP":
					logon = new SapLogonDado(name, "010", "BR00761", "nSfatima1304?");
					break;
				default:
					System.out.println("Ambiente não configurado!!");

				}
			}

			Runtime rt = Runtime.getRuntime();
			
			//System.out.println("C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\sapshcut.exe" + " /sysname=" + logon.getSysname()
			//+ " /client=" + logon.getClient() + " /user=" + logon.getUser() + " /pw=" + logon.getPw());

			
			rt.exec("C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\sapshcut.exe" + " /sysname=" + logon.getSysname()
					+ " /client=" + logon.getClient() + " /user=" + logon.getUser() + " /pw=" + logon.getPw());

		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
