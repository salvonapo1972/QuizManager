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
 * Provides the remote service utility for Argomento. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.ArgomentoServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Salvatore
 * @see ArgomentoService
 * @see it.quizscuola.portlet.service.base.ArgomentoServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.ArgomentoServiceImpl
 * @generated
 */
public class ArgomentoServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.ArgomentoServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static it.quizscuola.portlet.model.Argomento addArgomento(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descArgomento, long idMateria) {
		return getService().addArgomento(ctx, descArgomento, idMateria);
	}

	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgumentos(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgumentos(start, end, orderByComparator);
	}

	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentiByMateria(
		long idMateria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getArgomentiByMateria(idMateria, start, end,
			orderByComparator);
	}

	public static int getArgomentiByMateriaCount(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentiByMateriaCount(idMateria);
	}

	public static int getArgomentiCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentiCount();
	}

	public static it.quizscuola.portlet.model.Argomento removeArgomento(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeArgomento(id);
	}

	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentos()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentos();
	}

	public static it.quizscuola.portlet.model.Argomento updateArgomento(
		long idArgomento, java.lang.String descArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getService().updateArgomento(idArgomento, descArgomento);
	}

	public static void deleteDomandasByArgomento(long idUtente, long idArgomento) {
		getService().deleteDomandasByArgomento(idUtente, idArgomento);
	}

	public static void deleteDomandasERisposteByArgomento(long idArgomento) {
		getService().deleteDomandasERisposteByArgomento(idArgomento);
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONListaArgomenti(
		long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJSONListaArgomenti(idMateria);
	}

	public static void clearService() {
		_service = null;
	}

	public static ArgomentoService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ArgomentoService.class.getName());

			if (invokableService instanceof ArgomentoService) {
				_service = (ArgomentoService)invokableService;
			}
			else {
				_service = new ArgomentoServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ArgomentoServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ArgomentoService service) {
	}

	private static ArgomentoService _service;
}