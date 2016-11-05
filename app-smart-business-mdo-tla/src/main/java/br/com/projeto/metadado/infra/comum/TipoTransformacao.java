package br.com.projeto.metadado.infra.comum;

public enum TipoTransformacao {

	TRASFORMAR_XSLT(1),TRASFORMAR_XML_OBJETO(2);

	private int valor;

	private TipoTransformacao(int valorProcessamento) {
		this.valor = valorProcessamento;
	}

	public int getValor() {
		return valor;
	}

}
