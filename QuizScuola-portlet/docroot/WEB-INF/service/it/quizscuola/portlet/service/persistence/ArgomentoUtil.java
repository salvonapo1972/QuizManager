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

import it.quizscuola.portlet.model.Argomento;

import java.util.List;

/**
 * The persistence utility for the argomento service. This utility wraps {@link ArgomentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see ArgomentoPersistence
 * @see ArgomentoPersistenceImpl
 * @generated
 */
public class ArgomentoUtil {
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
	public static void clearCache(Argomento argomento) {
		getPersistence().clearCache(argomento);
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
	public static List<Argomento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Argomento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Argomento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Argomento update(Argomento argomento)
		throws SystemException {
		return getPersistence().update(argomento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Argomento update(Argomento argomento,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(argomento, serviceContext);
	}

	/**
	* Returns all the argomentos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the argomentos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @return the range of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the argomentos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the argomentos before and after the current argomento in the ordered set where uuid = &#63;.
	*
	* @param idArgomento the primary key of the current argomento
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento[] findByUuid_PrevAndNext(
		long idArgomento, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence()
				   .findByUuid_PrevAndNext(idArgomento, uuid, orderByComparator);
	}

	/**
	* Removes all the argomentos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of argomentos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the argomento where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the argomento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of argomentos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the argomentos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the argomentos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @return the range of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the argomentos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the argomentos before and after the current argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param idArgomento the primary key of the current argomento
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento[] findByUuid_C_PrevAndNext(
		long idArgomento, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(idArgomento, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the argomentos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of argomentos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the argomento in the entity cache if it is enabled.
	*
	* @param argomento the argomento
	*/
	public static void cacheResult(
		it.quizscuola.portlet.model.Argomento argomento) {
		getPersistence().cacheResult(argomento);
	}

	/**
	* Caches the argomentos in the entity cache if it is enabled.
	*
	* @param argomentos the argomentos
	*/
	public static void cacheResult(
		java.util.List<it.quizscuola.portlet.model.Argomento> argomentos) {
		getPersistence().cacheResult(argomentos);
	}

	/**
	* Creates a new argomento with the primary key. Does not add the argomento to the database.
	*
	* @param idArgomento the primary key for the new argomento
	* @return the new argomento
	*/
	public static it.quizscuola.portlet.model.Argomento create(long idArgomento) {
		return getPersistence().create(idArgomento);
	}

	/**
	* Removes the argomento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento that was removed
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento remove(long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().remove(idArgomento);
	}

	public static it.quizscuola.portlet.model.Argomento updateImpl(
		it.quizscuola.portlet.model.Argomento argomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(argomento);
	}

	/**
	* Returns the argomento with the primary key or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento findByPrimaryKey(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getPersistence().findByPrimaryKey(idArgomento);
	}

	/**
	* Returns the argomento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento, or <code>null</code> if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchByPrimaryKey(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idArgomento);
	}

	/**
	* Returns all the argomentos.
	*
	* @return the argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the argomentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @return the range of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the argomentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the argomentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of argomentos.
	*
	* @return the number of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArgomentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArgomentoPersistence)PortletBeanLocatorUtil.locate(it.quizscuola.portlet.service.ClpSerializer.getServletContextName(),
					ArgomentoPersistence.class.getName());

			ReferenceRegistry.registerReference(ArgomentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ArgomentoPersistence persistence) {
	}

	private static ArgomentoPersistence _persistence;
}