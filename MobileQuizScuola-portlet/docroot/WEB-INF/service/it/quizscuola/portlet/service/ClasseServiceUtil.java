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
 * Provides the remote service utility for Classe. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.ClasseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Salvatore
 * @see ClasseService
 * @see it.quizscuola.portlet.service.base.ClasseServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.ClasseServiceImpl
 * @generated
 */
public class ClasseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.ClasseServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static it.quizscuola.portlet.model.Classe addClasse(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descClasse) {
		return getService().addClasse(ctx, descClasse);
	}

	public static java.util.List<it.quizscuola.portlet.model.Classe> getClasses(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasses(start, end, orderByComparator);
	}

	public static int getClasseCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasseCount();
	}

	public static it.quizscuola.portlet.model.Classe removeClasse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeClasse(id);
	}

	public static java.util.List<it.quizscuola.portlet.model.Classe> getClasses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasses();
	}

	public static it.quizscuola.portlet.model.Classe updateClasse(
		long idClasse, java.lang.String descClasse)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchClasseException {
		return getService().updateClasse(idClasse, descClasse);
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONListaClassi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJSONListaClassi();
	}

	public static void clearService() {
		_service = null;
	}

	public static ClasseService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClasseService.class.getName());

			if (invokableService instanceof ClasseService) {
				_service = (ClasseService)invokableService;
			}
			else {
				_service = new ClasseServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ClasseServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ClasseService service) {
	}

	private static ClasseService _service;
}