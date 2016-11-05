package br.com.projeto.metadado.regras;


import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.MetadadoUI;

public interface IRegrasMetaDado {

	
	public MetadadoUI funcionalidadeMetadado(int numeroTela,
			int funcionalidade,MetaDado metadado);
	
	public MetaDado buscarMetadado(int numeroTela, int funcionalidade) throws InfraEstruturaException, NegocioException;

	public MetadadoUI atualizarTela(long idMetaDado) throws InfraEstruturaException, NegocioException;
}
