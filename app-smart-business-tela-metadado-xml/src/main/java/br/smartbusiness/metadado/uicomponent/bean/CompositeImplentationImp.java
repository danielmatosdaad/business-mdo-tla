package br.smartbusiness.metadado.uicomponent.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeImplentationImp implements ICompositeImplentation {

	private static final String CC_IMPLEMETATION = "cc:implementation";

	private static final Componente componetes = null;

	private final Map<String, String> atributos = new HashMap<String, String>();

	public CompositeImplentationImp(Componente componente) {
		super();
		Componente cnp = buscarComponente(componente);
		if (cnp != null) {

			if (cnp.getPropriedades() != null) {
				for (Propriedade propriedade : cnp.getPropriedades()) {

						this.atributos.put(propriedade.getNome(), propriedade.getValor());
				}
			}

		}

	}

	public CompositeImplentationImp(List<Componente> componentes) {
		super();
		Componente componente = buscarComponente(componentes);
		if (componente.getPropriedades() != null) {
			for (Propriedade propriedade : componente.getPropriedades()) {

					this.atributos.put(propriedade.getNome(), propriedade.getValor());
			}
		}
	}

	public static Componente buscarComponente(Componente componente) {

		if (componente == null) {

			return null;
		}

		if (componente.getNomeComponente().trim().equals(CC_IMPLEMETATION)) {

			return componente;
		}

		return buscarComponente(componente.getComponentes());

	}

	public static Componente buscarComponente(List<Componente> componetensParam) {

		if (componetensParam == null) {

			return null;
		}

		for (Componente componente : componetensParam) {

			if (componente.getNomeComponente().trim().equals(CC_IMPLEMETATION)) {

				return componente;
			}

			if (componente.getComponentes() != null && !componente.getComponentes().isEmpty()) {

				Componente subComponente = buscarComponente(componente.getComponentes());
				if (subComponente != null) {

					return subComponente;
				}

			}
		}

		return null;

	}

	@Override
	public Componente getComponentes() {
		return this.componetes;
	}
}
