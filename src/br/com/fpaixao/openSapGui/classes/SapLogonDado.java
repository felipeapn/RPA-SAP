package br.com.fpaixao.openSapGui.classes;

import java.io.IOException;

import br.com.fpaixao.openSapGui.exceptions.ExSysnameVazio;

public class SapLogonDado {

	private String sysname;
	private String client;
	private String user;
	private String pw;
	private static String language = "PT";

	public SapLogonDado(String sysname, String client, String user, String pw) throws ExSysnameVazio {
		
		if (sysname.isEmpty()) {
			throw new ExSysnameVazio("Ambiente não foi preenchido");
		}
		
		this.sysname = sysname;
		this.client = client;
		this.user = user;
		this.pw = pw;
	}

	public SapLogonDado() {
		// TODO Auto-generated constructor stub
	}

	public String getComandoAbreSAP() {
		String comando = "C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\sapshcut.exe" + " /sysname="
				+ this.getSysname() + " /client=" + this.getClient() + " /user=" + this.getUser() + " /pw="
				+ this.getPw() + " /language=" + this.getLanguage();

		return comando;

	}

	public void executarComandoLogin() throws IOException {

		System.out.println("Logando no ambiente " + this.getSysname() + " ...");
		Runtime rt = Runtime.getRuntime();
		rt.exec(this.getComandoAbreSAP());

	}

	public String getSysname() {
		return sysname;
	}

	public String getClient() {
		return client;
	}

	public String getUser() {
		return user;
	}

	public String getPw() {
		return pw;
	}

	public String getLanguage() {
		return language;
	}

	public static void setLanguage(String language) {
		SapLogonDado.language = language;
	}

	public String getLinhaFormatada() {

		return String.format("%s	%s	%s	%s", this.sysname, this.client, this.user, this.pw);

	}
}
