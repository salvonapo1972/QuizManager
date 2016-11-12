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
 * Provides a wrapper for {@link RispostaLocalService}.
 *
 * @author Salvatore
 * @see RispostaLocalService
 * @generated
 */
public class RispostaLocalServiceWrapper implements RispostaLocalService,
	ServiceWrapper<RispostaLocalService> {
	public RispostaLocalServiceWrapper(
		RispostaLocalService rispostaLocalService) {
		_rispostaLocalService = rispostaLocalService;
	}

	/**
	* Adds the risposta to the database. Also notifies the appropriate model listeners.
	*
	* @param risposta the risposta
	* @return the risposta that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta addRisposta(
		it.quizscuola.portlet.model.Risposta risposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.addRisposta(risposta);
	}

	/**
	* Creates a new risposta with the primary key. Does not add the risposta to the database.
	*
	* @param idRisposta the primary key for the new risposta
	* @return the new risposta
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta createRisposta(long idRisposta) {
		return _rispostaLocalService.createRisposta(idRisposta);
	}

	/**
	* Deletes the risposta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRisposta the primary key of the risposta
	* @return the risposta that was removed
	* @throws PortalException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta deleteRisposta(long idRisposta)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.deleteRisposta(idRisposta);
	}

	/**
	* Deletes the risposta from the database. Also notifies the appropriate model listeners.
	*
	* @param risposta the risposta
	* @return the risposta that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta deleteRisposta(
		it.quizscuola.portlet.model.Risposta risposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.deleteRisposta(risposta);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rispostaLocalService.dynamicQuery();
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
		return _rispostaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rispostaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rispostaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _rispostaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rispostaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.quizscuola.portlet.model.Risposta fetchRisposta(long idRisposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.fetchRisposta(idRisposta);
	}

	/**
	* Returns the risposta with the matching UUID and company.
	*
	* @param uuid the risposta's UUID
	* @param companyId the primary key of the company
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta fetchRispostaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.fetchRispostaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the risposta matching the UUID and group.
	*
	* @param uuid the risposta's UUID
	* @param groupId the primary key of the group
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta fetchRispostaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.fetchRispostaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the risposta with the primary key.
	*
	* @param idRisposta the primary key of the risposta
	* @return the risposta
	* @throws PortalException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta getRisposta(long idRisposta)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getRisposta(idRisposta);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the risposta with the matching UUID and company.
	*
	* @param uuid the risposta's UUID
	* @param companyId the primary key of the company
	* @return the matching risposta
	* @throws PortalException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta getRispostaByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getRispostaByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the risposta matching the UUID and group.
	*
	* @param uuid the risposta's UUID
	* @param groupId the primary key of the group
	* @return the matching risposta
	* @throws PortalException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta getRispostaByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getRispostaByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rispostas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @return the range of rispostas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.quizscuola.portlet.model.Risposta> getRispostas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getRispostas(start, end);
	}

	/**
	* Returns the number of rispostas.
	*
	* @return the number of rispostas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRispostasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.getRispostasCount();
	}

	/**
	* Updates the risposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param risposta the risposta
	* @return the risposta that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.Risposta updateRisposta(
		it.quizscuola.portlet.model.Risposta risposta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaLocalService.updateRisposta(risposta);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rispostaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rispostaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rispostaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RispostaLocalService getWrappedRispostaLocalService() {
		return _rispostaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRispostaLocalService(
		RispostaLocalService rispostaLocalService) {
		_rispostaLocalService = rispostaLocalService;
	}

	@Override
	public RispostaLocalService getWrappedService() {
		return _rispostaLocalService;
	}

	@Override
	public void setWrappedService(RispostaLocalService rispostaLocalService) {
		_rispostaLocalService = rispostaLocalService;
	}

	private RispostaLocalService _rispostaLocalService;
}