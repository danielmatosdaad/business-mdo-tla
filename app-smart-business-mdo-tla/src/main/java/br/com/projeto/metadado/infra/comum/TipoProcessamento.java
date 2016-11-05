package br.com.projeto.metadado.infra.comum;

public enum TipoProcessamento {

	CRIAR_XML(1), CRIAR_XSD(2), CRIAR_XSL(3), TRASFORMAR_XSLT(4),TRASFORMAR_XML_OBJETO(5);

	private int valor;

	private TipoProcessamento(int valorProcessamento) {
		this.valor = valorProcessamento;
	}

	public int getValor() {
		return valor;
	}

}
