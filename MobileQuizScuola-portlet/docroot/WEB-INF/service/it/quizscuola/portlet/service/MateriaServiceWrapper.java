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
 * Provides a wrapper for {@link MateriaService}.
 *
 * @author Salvatore
 * @see MateriaService
 * @generated
 */
public class MateriaServiceWrapper implements MateriaService,
	ServiceWrapper<MateriaService> {
	public MateriaServiceWrapper(MateriaService materiaService) {
		_materiaService = materiaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _materiaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_materiaService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _materiaService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.quizscuola.portlet.model.Materia addMateria(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descMateria, long idClasse) {
		return _materiaService.addMateria(ctx, descMateria, idClasse);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Materia> getMaterias(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getMaterias(start, end, orderByComparator);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Materia> getMateriasByClasse(
		long idClasse, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getMateriasByClasse(idClasse, start, end,
			orderByComparator);
	}

	@Override
	public int getMateriasByClasseCount(long idClasse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getMateriasByClasseCount(idClasse);
	}

	@Override
	public int getMateriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getMateriasCount();
	}

	@Override
	public it.quizscuola.portlet.model.Materia removeMateria(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.removeMateria(id);
	}

	@Override
	public void deleteMateriaByIdMateria(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException {
		_materiaService.deleteMateriaByIdMateria(idMateria);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Materia> getClasses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getClasses();
	}

	@Override
	public it.quizscuola.portlet.model.Materia updateMateria(long idMateria,
		java.lang.String descMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException {
		return _materiaService.updateMateria(idMateria, descMateria);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getJSONListaMateria(
		long idClasse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaService.getJSONListaMateria(idClasse);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MateriaService getWrappedMateriaService() {
		return _materiaService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMateriaService(MateriaService materiaService) {
		_materiaService = materiaService;
	}

	@Override
	public MateriaService getWrappedService() {
		return _materiaService;
	}

	@Override
	public void setWrappedService(MateriaService materiaService) {
		_materiaService = materiaService;
	}

	private MateriaService _materiaService;
}