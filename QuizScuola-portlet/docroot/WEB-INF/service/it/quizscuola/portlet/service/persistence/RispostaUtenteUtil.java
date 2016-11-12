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

package it.quizscuola.portlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.model.RispostaUtente;

import java.util.List;

/**
 * The persistence utility for the risposta utente service. This utility wraps {@link RispostaUtentePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see RispostaUtentePersistence
 * @see RispostaUtentePersistenceImpl
 * @generated
 */
public class RispostaUtenteUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(RispostaUtente rispostaUtente) {
		getPersistence().clearCache(rispostaUtente);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RispostaUtente> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RispostaUtente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RispostaUtente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RispostaUtente update(RispostaUtente rispostaUtente)
		throws SystemException {
		return getPersistence().update(rispostaUtente);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RispostaUtente update(RispostaUtente rispostaUtente,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rispostaUtente, serviceContext);
	}

	/**
	* Returns all the risposta utentes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the risposta utentes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @return the range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the risposta utentes where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the risposta utentes before and after the current risposta utente in the ordered set where uuid = &#63;.
	*
	* @param idRispostaUtente the primary key of the current risposta utente
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente[] findByUuid_PrevAndNext(
		long idRispostaUtente, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException {
		return getPersistence()
				   .findByUuid_PrevAndNext(idRispostaUtente, uuid,
			orderByComparator);
	}

	/**
	* Removes all the risposta utentes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of risposta utentes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the risposta utente in the entity cache if it is enabled.
	*
	* @param rispostaUtente the risposta utente
	*/
	public static void cacheResult(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente) {
		getPersistence().cacheResult(rispostaUtente);
	}

	/**
	* Caches the risposta utentes in the entity cache if it is enabled.
	*
	* @param rispostaUtentes the risposta utentes
	*/
	public static void cacheResult(
		java.util.List<it.quizscuola.portlet.model.RispostaUtente> rispostaUtentes) {
		getPersistence().cacheResult(rispostaUtentes);
	}

	/**
	* Creates a new risposta utente with the primary key. Does not add the risposta utente to the database.
	*
	* @param idRispostaUtente the primary key for the new risposta utente
	* @return the new risposta utente
	*/
	public static it.quizscuola.portlet.model.RispostaUtente create(
		long idRispostaUtente) {
		return getPersistence().create(idRispostaUtente);
	}

	/**
	* Removes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente that was removed
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente remove(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException {
		return getPersistence().remove(idRispostaUtente);
	}

	public static it.quizscuola.portlet.model.RispostaUtente updateImpl(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rispostaUtente);
	}

	/**
	* Returns the risposta utente with the primary key or throws a {@link it.quizscuola.portlet.NoSuchRispostaUtenteException} if it could not be found.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente findByPrimaryKey(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException {
		return getPersistence().findByPrimaryKey(idRispostaUtente);
	}

	/**
	* Returns the risposta utente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente, or <code>null</code> if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.RispostaUtente fetchByPrimaryKey(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idRispostaUtente);
	}

	/**
	* Returns all the risposta utentes.
	*
	* @return the risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the risposta utentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the risposta utentes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of risposta utentes.
	*
	* @return the number of risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RispostaUtentePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RispostaUtentePersistence)PortletBeanLocatorUtil.locate(it.quizscuola.portlet.service.ClpSerializer.getServletContextName(),
					RispostaUtentePersistence.class.getName());

			ReferenceRegistry.registerReference(RispostaUtenteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RispostaUtentePersistence persistence) {
	}

	private static RispostaUtentePersistence _persistence;
}