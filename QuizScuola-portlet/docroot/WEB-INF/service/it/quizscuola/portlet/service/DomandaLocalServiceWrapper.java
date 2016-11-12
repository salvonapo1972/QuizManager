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
 * Provides a wrapper for {@link DomandaLocalService}.
 *
 * @author Salvatore
 * @see DomandaLocalService
 * @generated
 */
public class DomandaLocalServiceWrapper implements DomandaLocalService,
	ServiceWrapper<DomandaLocalService> {
	public DomandaLocalServiceWrapper(DomandaLocalService domandaLocalService) {
		_domandaLocalService = domandaLocalService;
	}

	/**
	* Adds the domanda to the database. Also notifies the appropriate model listeners.
	*
	* @param domanda the domanda
	* @return the domanda that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda addDomanda(
		it.quizscuola.portlet.model.Domanda domanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.addDomanda(domanda);
	}

	/**
	* Creates a new domanda with the primary key. Does not add the domanda to the database.
	*
	* @param idDomanda the primary key for the new domanda
	* @return the new domanda
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda createDomanda(long idDomanda) {
		return _domandaLocalService.createDomanda(idDomanda);
	}

	/**
	* Deletes the domanda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idDomanda the primary key of the domanda
	* @return the domanda that was removed
	* @throws PortalException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda deleteDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.deleteDomanda(idDomanda);
	}

	/**
	* Deletes the domanda from the database. Also notifies the appropriate model listeners.
	*
	* @param domanda the domanda
	* @return the domanda that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda deleteDomanda(
		it.quizscuola.portlet.model.Domanda domanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.deleteDomanda(domanda);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _domandaLocalService.dynamicQuery();
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
		return _domandaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _domandaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _domandaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _domandaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _domandaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.quizscuola.portlet.model.Domanda fetchDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.fetchDomanda(idDomanda);
	}

	/**
	* Returns the domanda with the matching UUID and company.
	*
	* @param uuid the domanda's UUID
	* @param companyId the primary key of the company
	* @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda fetchDomandaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.fetchDomandaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the domanda matching the UUID and group.
	*
	* @param uuid the domanda's UUID
	* @param groupId the primary key of the group
	* @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda fetchDomandaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.fetchDomandaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the domanda with the primary key.
	*
	* @param idDomanda the primary key of the domanda
	* @return the domanda
	* @throws PortalException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda getDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getDomanda(idDomanda);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the domanda with the matching UUID and company.
	*
	* @param uuid the domanda's UUID
	* @param companyId the primary key of the company
	* @return the matching domanda
	* @throws PortalException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda getDomandaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getDomandaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the domanda matching the UUID and group.
	*
	* @param uuid the domanda's UUID
	* @param groupId the primary key of the group
	* @return the matching domanda
	* @throws PortalException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda getDomandaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getDomandaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the domandas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @return the range of domandas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.quizscuola.portlet.model.Domanda> getDomandas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getDomandas(start, end);
	}

	/**
	* Returns the number of domandas.
	*
	* @return the number of domandas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDomandasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.getDomandasCount();
	}

	/**
	* Updates the domanda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param domanda the domanda
	* @return the domanda that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Domanda updateDomanda(
		it.quizscuola.portlet.model.Domanda domanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaLocalService.updateDomanda(domanda);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _domandaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_domandaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _domandaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DomandaLocalService getWrappedDomandaLocalService() {
		return _domandaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDomandaLocalService(
		DomandaLocalService domandaLocalService) {
		_domandaLocalService = domandaLocalService;
	}

	@Override
	public DomandaLocalService getWrappedService() {
		return _domandaLocalService;
	}

	@Override
	public void setWrappedService(DomandaLocalService domandaLocalService) {
		_domandaLocalService = domandaLocalService;
	}

	private DomandaLocalService _domandaLocalService;
}