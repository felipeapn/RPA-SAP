package br.com.fpaixao.openSapGui.classes;

import java.io.IOException;

public class SapLogonDado {

	private String sysname;
	private String client;
	private String user;
	private String pw;
	private String language = "PT";
	
	public SapLogonDado(String sysname, String client, String user, String pw) {
		this.sysname = sysname;
		this.client = client;
		this.user = user;
		this.pw = pw;
	}
	
	public String getComandoAbreSAP() {
		String comando = "C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\sapshcut.exe"
						+ " /sysname=" + this.getSysname() + " /client=" + this.getClient() 
						+ " /user=" + this.getUser() + " /pw=" + this.getPw() 
						+ " /language=" + this.getLanguage();

		return comando;
		
	}
	
	public void executarComandoLogin () throws IOException {
		
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
	
	public void setLanguage(String language) {
		this.language = language;
	}
}
