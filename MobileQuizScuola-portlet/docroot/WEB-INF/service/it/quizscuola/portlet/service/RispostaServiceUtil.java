/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.quizscuola.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Risposta. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.RispostaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Salvatore
 * @see RispostaService
 * @see it.quizscuola.portlet.service.base.RispostaServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.RispostaServiceImpl
 * @generated
 */
public class RispostaServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.RispostaServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static it.quizscuola.portlet.model.Risposta addRisposta(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descRisposta, boolean esatta, long idDomanda) {
		return getService().addRisposta(ctx, descRisposta, esatta, idDomanda);
	}

	public static com.liferay.portal.kernel.json.JSONArray getRisultati(
		long idUtente, long idArgomento) {
		return getService().getRisultati(idUtente, idArgomento);
	}

	public static com.liferay.portal.kernel.json.JSONObject getRisultatiDomande(
		long idUtente, long idArgomento) {
		return getService().getRisultatiDomande(idUtente, idArgomento);
	}

	public static java.util.List<it.quizscuola.portlet.model.Risposta> getRispostas(
		long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRispostas(idDomanda);
	}

	public static it.quizscuola.portlet.model.Risposta updateRisposta(
		com.liferay.portal.service.ServiceContext ctx, long idDomanda,
		long idRisposta, java.lang.String descRisposta, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException {
		return getService()
				   .updateRisposta(ctx, idDomanda, idRisposta, descRisposta,
			esatta);
	}

	public static void clearService() {
		_service = null;
	}

	public static RispostaService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RispostaService.class.getName());

			if (invokableService instanceof RispostaService) {
				_service = (RispostaService)invokableService;
			}
			else {
				_service = new RispostaServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(RispostaServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RispostaService service) {
	}

	private static RispostaService _service;
}