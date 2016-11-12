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
 * Provides the remote service utility for Materia. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.MateriaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Salvatore
 * @see MateriaService
 * @see it.quizscuola.portlet.service.base.MateriaServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.MateriaServiceImpl
 * @generated
 */
public class MateriaServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.MateriaServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static it.quizscuola.portlet.model.Materia addMateria(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descMateria, long idClasse) {
		return getService().addMateria(ctx, descMateria, idClasse);
	}

	public static java.util.List<it.quizscuola.portlet.model.Materia> getMaterias(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaterias(start, end, orderByComparator);
	}

	public static java.util.List<it.quizscuola.portlet.model.Materia> getMateriasByClasse(
		long idClasse, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMateriasByClasse(idClasse, start, end, orderByComparator);
	}

	public static int getMateriasByClasseCount(long idClasse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMateriasByClasseCount(idClasse);
	}

	public static int getMateriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMateriasCount();
	}

	public static it.quizscuola.portlet.model.Materia removeMateria(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeMateria(id);
	}

	public static void deleteMateriaByIdMateria(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException {
		getService().deleteMateriaByIdMateria(idMateria);
	}

	public static java.util.List<it.quizscuola.portlet.model.Materia> getClasses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasses();
	}

	public static it.quizscuola.portlet.model.Materia updateMateria(
		long idMateria, java.lang.String descMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException {
		return getService().updateMateria(idMateria, descMateria);
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONListaMateria(
		long idClasse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJSONListaMateria(idClasse);
	}

	public static void clearService() {
		_service = null;
	}

	public static MateriaService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MateriaService.class.getName());

			if (invokableService instanceof MateriaService) {
				_service = (MateriaService)invokableService;
			}
			else {
				_service = new MateriaServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(MateriaServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MateriaService service) {
	}

	private static MateriaService _service;
}