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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClasseService}.
 *
 * @author Salvatore
 * @see ClasseService
 * @generated
 */
public class ClasseServiceWrapper implements ClasseService,
	ServiceWrapper<ClasseService> {
	public ClasseServiceWrapper(ClasseService classeService) {
		_classeService = classeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _classeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_classeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _classeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.quizscuola.portlet.model.Classe addClasse(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descClasse) {
		return _classeService.addClasse(ctx, descClasse);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Classe> getClasses(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classeService.getClasses(start, end, orderByComparator);
	}

	@Override
	public int getClasseCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classeService.getClasseCount();
	}

	@Override
	public it.quizscuola.portlet.model.Classe removeClasse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classeService.removeClasse(id);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Classe> getClasses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classeService.getClasses();
	}

	@Override
	public it.quizscuola.portlet.model.Classe updateClasse(long idClasse,
		java.lang.String descClasse)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchClasseException {
		return _classeService.updateClasse(idClasse, descClasse);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getJSONListaClassi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classeService.getJSONListaClassi();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ClasseService getWrappedClasseService() {
		return _classeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedClasseService(ClasseService classeService) {
		_classeService = classeService;
	}

	@Override
	public ClasseService getWrappedService() {
		return _classeService;
	}

	@Override
	public void setWrappedService(ClasseService classeService) {
		_classeService = classeService;
	}

	private ClasseService _classeService;
}