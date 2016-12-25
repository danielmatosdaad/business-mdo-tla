package br.smartbusiness.metadado.conversor;

import java.util.ArrayList;
import java.util.List;

import br.smartbusiness.metadado.uicomponent.bean.Componente;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;
import br.smartbusiness.metadado.uicomponent.bean.Propriedade;

public class ConversorBean {

	private static final String NS_PROJETO_COMPONENTES = "http://url.projeto/componentes";

	public static List<MetaDado> converterParaMetadado(List<ICompositeInterfaces> compositeInterfaces) {

		if (compositeInterfaces == null) {
			return null;
		}

		List<MetaDado> metadados = new ArrayList<MetaDado>();

		for (ICompositeInterfaces composite : compositeInterfaces) {

			MetaDado mdo = converterParaMetadado(composite);
			metadados.add(mdo);
		}

		return metadados;

	}

	public static MetaDado converterParaMetadado(ICompositeInterfaces compositeInterfaces) {

		if (compositeInterfaces == null) {
			return null;
		}
		MetaDado metadado = new MetaDado(new ArrayList<Componente>());
		List<Componente> cpns = compositeInterfaces.getComponete().getComponentes();
		List<Propriedade> propriedadesMetadado = new ArrayList<Propriedade>();

		for (Componente componente : cpns) {

			if (componente.getPropriedades() != null) {

				for (Propriedade p : componente.getPropriedades()) {

					Propriedade prop = new Propriedade(p.getValor(), "");
					propriedadesMetadado.add(prop);

				}

			}

		}
		Componente componentemdo = new Componente(compositeInterfaces.getNome(), NS_PROJETO_COMPONENTES,
				propriedadesMetadado);
		metadado.getComponentes().add(componentemdo);

		return metadado;

	}

}
