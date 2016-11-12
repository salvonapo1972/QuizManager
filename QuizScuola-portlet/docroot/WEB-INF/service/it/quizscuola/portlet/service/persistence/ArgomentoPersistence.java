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

import com.liferay.portal.service.persistence.BasePersistence;

import it.quizscuola.portlet.model.Argomento;

/**
 * The persistence interface for the argomento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see ArgomentoPersistenceImpl
 * @see ArgomentoUtil
 * @generated
 */
public interface ArgomentoPersistence extends BasePersistence<Argomento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArgomentoUtil} to access the argomento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the argomentos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the first argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the last argomento in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.quizscuola.portlet.model.Argomento[] findByUuid_PrevAndNext(
		long idArgomento, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Removes all the argomentos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of argomentos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the argomento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the argomento where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the argomento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the number of argomentos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the argomentos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.quizscuola.portlet.model.Argomento findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the first argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.quizscuola.portlet.model.Argomento findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the last argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.quizscuola.portlet.model.Argomento[] findByUuid_C_PrevAndNext(
		long idArgomento, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Removes all the argomentos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of argomentos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching argomentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the argomento in the entity cache if it is enabled.
	*
	* @param argomento the argomento
	*/
	public void cacheResult(it.quizscuola.portlet.model.Argomento argomento);

	/**
	* Caches the argomentos in the entity cache if it is enabled.
	*
	* @param argomentos the argomentos
	*/
	public void cacheResult(
		java.util.List<it.quizscuola.portlet.model.Argomento> argomentos);

	/**
	* Creates a new argomento with the primary key. Does not add the argomento to the database.
	*
	* @param idArgomento the primary key for the new argomento
	* @return the new argomento
	*/
	public it.quizscuola.portlet.model.Argomento create(long idArgomento);

	/**
	* Removes the argomento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento that was removed
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento remove(long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	public it.quizscuola.portlet.model.Argomento updateImpl(
		it.quizscuola.portlet.model.Argomento argomento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the argomento with the primary key or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento
	* @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento findByPrimaryKey(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException;

	/**
	* Returns the argomento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento, or <code>null</code> if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Argomento fetchByPrimaryKey(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the argomentos.
	*
	* @return the argomentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Argomento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Argomento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the argomentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of argomentos.
	*
	* @return the number of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}