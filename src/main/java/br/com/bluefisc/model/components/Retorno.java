package br.com.bluefisc.model.components;

public class Retorno {

	private String seSucesso;
	private String erroGeral;
	
	public Retorno(){
		this.setSucesso(); //Padrão inicia como sucesso
	}	
	
	public void setErro(){
		this.setSeSucesso("0");
	}
	public void setSucesso(){
		this.setSeSucesso("1");
	}
	
	public String getSeSucesso() {
		return seSucesso;
	}
	public void setSeSucesso(String seSucesso) {
		this.seSucesso = seSucesso;
	}
	
	public String getErroGeral() {
		return erroGeral;
	}
	public void setErroGeral(String erroGeral) {
		this.setErro();
		this.erroGeral = erroGeral;
	}
		
}
