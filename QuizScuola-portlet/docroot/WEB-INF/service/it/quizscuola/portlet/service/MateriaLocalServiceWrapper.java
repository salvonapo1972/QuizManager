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
 * Provides a wrapper for {@link MateriaLocalService}.
 *
 * @author Salvatore
 * @see MateriaLocalService
 * @generated
 */
public class MateriaLocalServiceWrapper implements MateriaLocalService,
	ServiceWrapper<MateriaLocalService> {
	public MateriaLocalServiceWrapper(MateriaLocalService materiaLocalService) {
		_materiaLocalService = materiaLocalService;
	}

	/**
	* Adds the materia to the database. Also notifies the appropriate model listeners.
	*
	* @param materia the materia
	* @return the materia that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia addMateria(
		it.quizscuola.portlet.model.Materia materia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.addMateria(materia);
	}

	/**
	* Creates a new materia with the primary key. Does not add the materia to the database.
	*
	* @param idMateria the primary key for the new materia
	* @return the new materia
	*/
	@Override
	public it.quizscuola.portlet.model.Materia createMateria(long idMateria) {
		return _materiaLocalService.createMateria(idMateria);
	}

	/**
	* Deletes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idMateria the primary key of the materia
	* @return the materia that was removed
	* @throws PortalException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia deleteMateria(long idMateria)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.deleteMateria(idMateria);
	}

	/**
	* Deletes the materia from the database. Also notifies the appropriate model listeners.
	*
	* @param materia the materia
	* @return the materia that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia deleteMateria(
		it.quizscuola.portlet.model.Materia materia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.deleteMateria(materia);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _materiaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.quizscuola.portlet.model.Materia fetchMateria(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.fetchMateria(idMateria);
	}

	/**
	* Returns the materia with the matching UUID and company.
	*
	* @param uuid the materia's UUID
	* @param companyId the primary key of the company
	* @return the matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia fetchMateriaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.fetchMateriaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the materia matching the UUID and group.
	*
	* @param uuid the materia's UUID
	* @param groupId the primary key of the group
	* @return the matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia fetchMateriaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.fetchMateriaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the materia with the primary key.
	*
	* @param idMateria the primary key of the materia
	* @return the materia
	* @throws PortalException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia getMateria(long idMateria)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getMateria(idMateria);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the materia with the matching UUID and company.
	*
	* @param uuid the materia's UUID
	* @param companyId the primary key of the company
	* @return the matching materia
	* @throws PortalException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia getMateriaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getMateriaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the materia matching the UUID and group.
	*
	* @param uuid the materia's UUID
	* @param groupId the primary key of the group
	* @return the matching materia
	* @throws PortalException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia getMateriaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getMateriaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the materias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @return the range of materias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.quizscuola.portlet.model.Materia> getMaterias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getMaterias(start, end);
	}

	/**
	* Returns the number of materias.
	*
	* @return the number of materias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMateriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.getMateriasCount();
	}

	/**
	* Updates the materia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param materia the materia
	* @return the materia that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Materia updateMateria(
		it.quizscuola.portlet.model.Materia materia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materiaLocalService.updateMateria(materia);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _materiaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_materiaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _materiaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MateriaLocalService getWrappedMateriaLocalService() {
		return _materiaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMateriaLocalService(
		MateriaLocalService materiaLocalService) {
		_materiaLocalService = materiaLocalService;
	}

	@Override
	public MateriaLocalService getWrappedService() {
		return _materiaLocalService;
	}

	@Override
	public void setWrappedService(MateriaLocalService materiaLocalService) {
		_materiaLocalService = materiaLocalService;
	}

	private MateriaLocalService _materiaLocalService;
}