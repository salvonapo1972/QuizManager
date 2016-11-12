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
 * Provides a wrapper for {@link ArgomentoService}.
 *
 * @author Salvatore
 * @see ArgomentoService
 * @generated
 */
public class ArgomentoServiceWrapper implements ArgomentoService,
	ServiceWrapper<ArgomentoService> {
	public ArgomentoServiceWrapper(ArgomentoService argomentoService) {
		_argomentoService = argomentoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _argomentoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_argomentoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _argomentoService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.quizscuola.portlet.model.Argomento addArgomento(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descArgomento, long idMateria) {
		return _argomentoService.addArgomento(ctx, descArgomento, idMateria);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Argomento> getArgumentos(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getArgumentos(start, end, orderByComparator);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentiByMateria(
		long idMateria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getArgomentiByMateria(idMateria, start, end,
			orderByComparator);
	}

	@Override
	public int getArgomentiByMateriaCount(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getArgomentiByMateriaCount(idMateria);
	}

	@Override
	public int getArgomentiCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getArgomentiCount();
	}

	@Override
	public it.quizscuola.portlet.model.Argomento removeArgomento(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.removeArgomento(id);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentos()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getArgomentos();
	}

	@Override
	public it.quizscuola.portlet.model.Argomento updateArgomento(
		long idArgomento, java.lang.String descArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return _argomentoService.updateArgomento(idArgomento, descArgomento);
	}

	@Override
	public void deleteDomandasByArgomento(long idUtente, long idArgomento) {
		_argomentoService.deleteDomandasByArgomento(idUtente, idArgomento);
	}

	@Override
	public void deleteDomandasERisposteByArgomento(long idArgomento) {
		_argomentoService.deleteDomandasERisposteByArgomento(idArgomento);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getJSONListaArgomenti(
		long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomentoService.getJSONListaArgomenti(idMateria);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ArgomentoService getWrappedArgomentoService() {
		return _argomentoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedArgomentoService(ArgomentoService argomentoService) {
		_argomentoService = argomentoService;
	}

	@Override
	public ArgomentoService getWrappedService() {
		return _argomentoService;
	}

	@Override
	public void setWrappedService(ArgomentoService argomentoService) {
		_argomentoService = argomentoService;
	}

	private ArgomentoService _argomentoService;
}