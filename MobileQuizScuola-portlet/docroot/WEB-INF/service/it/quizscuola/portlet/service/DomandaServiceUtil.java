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
 * Provides the remote service utility for Domanda. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.DomandaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Salvatore
 * @see DomandaService
 * @see it.quizscuola.portlet.service.base.DomandaServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.DomandaServiceImpl
 * @generated
 */
public class DomandaServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.DomandaServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static it.quizscuola.portlet.model.Domanda addDomanda(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descDomanda, long idArgomento,
		java.util.List<it.quizscuola.portlet.model.Risposta> listaRisposte) {
		return getService()
				   .addDomanda(ctx, descDomanda, idArgomento, listaRisposte);
	}

	public static com.liferay.portal.kernel.json.JSONObject getDomandaRisposte(
		long idArgomento, int posizione) {
		return getService().getDomandaRisposte(idArgomento, posizione);
	}

	public static it.quizscuola.portlet.model.Domanda deleteDomanda(
		long idDomanda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDomanda(idDomanda);
	}

	public static it.quizscuola.portlet.model.Domanda updateDomanda(
		long idDomanda, java.lang.String descDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException {
		return getService().updateDomanda(idDomanda, descDomanda);
	}

	public static java.util.List<it.quizscuola.portlet.model.Domanda> getDomandas(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDomandas(start, end, orderByComparator);
	}

	public static java.util.List<it.quizscuola.portlet.model.Domanda> getDomandasByArgomento(
		long idArgomento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDomandasByArgomento(idArgomento, start, end,
			orderByComparator);
	}

	public static int getDomandasByArgomentoCount(long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDomandasByArgomentoCount(idArgomento);
	}

	public static com.liferay.portal.kernel.json.JSONObject getNumDomandeByArgomento(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNumDomandeByArgomento(idArgomento);
	}

	public static it.quizscuola.portlet.model.Domanda updateDomanda(
		com.liferay.portal.service.ServiceContext ctx, long idDomanda,
		java.lang.String descDomanda, long idArgomento,
		java.util.List<it.quizscuola.portlet.model.Risposta> listaRisposte) {
		return getService()
				   .updateDomanda(ctx, idDomanda, descDomanda, idArgomento,
			listaRisposte);
	}

	public static void clearService() {
		_service = null;
	}

	public static DomandaService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DomandaService.class.getName());

			if (invokableService instanceof DomandaService) {
				_service = (DomandaService)invokableService;
			}
			else {
				_service = new DomandaServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(DomandaServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DomandaService service) {
	}

	private static DomandaService _service;
}