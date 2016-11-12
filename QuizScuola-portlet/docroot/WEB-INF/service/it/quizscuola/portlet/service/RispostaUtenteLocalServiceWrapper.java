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
 * Provides a wrapper for {@link RispostaUtenteLocalService}.
 *
 * @author Salvatore
 * @see RispostaUtenteLocalService
 * @generated
 */
public class RispostaUtenteLocalServiceWrapper
	implements RispostaUtenteLocalService,
		ServiceWrapper<RispostaUtenteLocalService> {
	public RispostaUtenteLocalServiceWrapper(
		RispostaUtenteLocalService rispostaUtenteLocalService) {
		_rispostaUtenteLocalService = rispostaUtenteLocalService;
	}

	/**
	* Adds the risposta utente to the database. Also notifies the appropriate model listeners.
	*
	* @param rispostaUtente the risposta utente
	* @return the risposta utente that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente addRispostaUtente(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.addRispostaUtente(rispostaUtente);
	}

	/**
	* Creates a new risposta utente with the primary key. Does not add the risposta utente to the database.
	*
	* @param idRispostaUtente the primary key for the new risposta utente
	* @return the new risposta utente
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente createRispostaUtente(
		long idRispostaUtente) {
		return _rispostaUtenteLocalService.createRispostaUtente(idRispostaUtente);
	}

	/**
	* Deletes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente that was removed
	* @throws PortalException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente deleteRispostaUtente(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.deleteRispostaUtente(idRispostaUtente);
	}

	/**
	* Deletes the risposta utente from the database. Also notifies the appropriate model listeners.
	*
	* @param rispostaUtente the risposta utente
	* @return the risposta utente that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente deleteRispostaUtente(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.deleteRispostaUtente(rispostaUtente);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rispostaUtenteLocalService.dynamicQuery();
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
		return _rispostaUtenteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rispostaUtenteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rispostaUtenteLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _rispostaUtenteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rispostaUtenteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.quizscuola.portlet.model.RispostaUtente fetchRispostaUtente(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.fetchRispostaUtente(idRispostaUtente);
	}

	/**
	* Returns the risposta utente with the primary key.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente
	* @throws PortalException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente getRispostaUtente(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.getRispostaUtente(idRispostaUtente);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the risposta utentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @return the range of risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> getRispostaUtentes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.getRispostaUtentes(start, end);
	}

	/**
	* Returns the number of risposta utentes.
	*
	* @return the number of risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRispostaUtentesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.getRispostaUtentesCount();
	}

	/**
	* Updates the risposta utente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rispostaUtente the risposta utente
	* @return the risposta utente that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.quizscuola.portlet.model.RispostaUtente updateRispostaUtente(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaUtenteLocalService.updateRispostaUtente(rispostaUtente);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rispostaUtenteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rispostaUtenteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rispostaUtenteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RispostaUtenteLocalService getWrappedRispostaUtenteLocalService() {
		return _rispostaUtenteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRispostaUtenteLocalService(
		RispostaUtenteLocalService rispostaUtenteLocalService) {
		_rispostaUtenteLocalService = rispostaUtenteLocalService;
	}

	@Override
	public RispostaUtenteLocalService getWrappedService() {
		return _rispostaUtenteLocalService;
	}

	@Override
	public void setWrappedService(
		RispostaUtenteLocalService rispostaUtenteLocalService) {
		_rispostaUtenteLocalService = rispostaUtenteLocalService;
	}

	private RispostaUtenteLocalService _rispostaUtenteLocalService;
}