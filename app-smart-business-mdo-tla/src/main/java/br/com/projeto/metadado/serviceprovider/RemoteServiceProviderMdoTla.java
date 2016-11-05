package br.com.projeto.metadado.serviceprovider;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.GrupoFuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.app.smart.business.funcionalidade.dto.PerfilDTO;

@ApplicationScoped
@Named
public class RemoteServiceProviderMdoTla implements Serializable{

	@EJB(lookup = "java:global/app-smart-business/app-smart-business-fnc-mdo/FuncionalidadeServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "MetaDadoServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<FuncionalidadeDTO> funcionalidadeService;

	@EJB(lookup = "java:global/app-smart-business/app-smart-business-fnc-mdo/MetaDadoServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "MetaDadoServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<MetaDadoDTO> metaDadoService;
	
	@EJB(lookup = "java:global/app-smart-business/app-smart-business-fnc-mdo/PerfilServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "MetaDadoServiceImp", beanInterface = IServicoRemoteDAO.class)
	IServicoRemoteDAO<PerfilDTO> perfilService;
	
	
	@EJB(lookup = "java:global/app-smart-business/app-smart-business-fnc-mdo/GrupoFuncionalidadeServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "GrupoFuncionalidadeServiceImp", beanInterface = IServicoRemoteDAO.class)
	IServicoRemoteDAO<GrupoFuncionalidadeDTO> grupoFuncionalidadeService;

	@Default
	@Produces
	public IServicoRemoteDAO<FuncionalidadeDTO> getFuncionalidadeService() {
		System.out.println("Injetando Servico funcionalidadeService");
		return funcionalidadeService;
	}
	
	
	@Default
	@Produces
	public IServicoRemoteDAO<GrupoFuncionalidadeDTO> getGrupoFuncionalidadeService() {
		System.out.println("Injetando Servico grupoFuncionalidadeService");
		return grupoFuncionalidadeService;
	}
	
	
	@Default
	@Produces
	public IServicoRemoteDAO<MetaDadoDTO> getMetaDadoService() {
		System.out.println("Injetando Servico metaDadoService");
		return metaDadoService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<PerfilDTO> getPerfilService() {
		return perfilService;
	}

	/**
	 * Carrega instância da service passada como parâmetro do contexto
	 * 
	 * @param clazz
	 * @return
	 */
	private static Object carregaService(Class clazz) {
		Object service = null;
		BeanManager beanManager = getBeanManager();
		try {
			for (Bean<?> bean : beanManager.getBeans(clazz)) {
				try {
					CreationalContext contexto = beanManager.createCreationalContext(bean);
					service = bean.create(contexto);
					break;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
		}

		return service;
	}

	/**
	 * @return
	 */
	public static final BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			return null;
		}
	}
}
