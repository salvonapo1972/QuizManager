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

import it.quizscuola.portlet.model.Domanda;

/**
 * The persistence interface for the domanda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see DomandaPersistenceImpl
 * @see DomandaUtil
 * @generated
 */
public interface DomandaPersistence extends BasePersistence<Domanda> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DomandaUtil} to access the domanda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the domandas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the domandas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @return the range of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the domandas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first domanda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the first domanda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last domanda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the last domanda in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the domandas before and after the current domanda in the ordered set where uuid = &#63;.
	*
	* @param idDomanda the primary key of the current domanda
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda[] findByUuid_PrevAndNext(
		long idDomanda, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Removes all the domandas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of domandas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the domanda where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchDomandaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the domanda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the domanda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the domanda where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the domanda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the number of domandas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the domandas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the domandas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @return the range of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the domandas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the first domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the last domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching domanda, or <code>null</code> if a matching domanda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the domandas before and after the current domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param idDomanda the primary key of the current domanda
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda[] findByUuid_C_PrevAndNext(
		long idDomanda, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Removes all the domandas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of domandas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching domandas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the domanda in the entity cache if it is enabled.
	*
	* @param domanda the domanda
	*/
	public void cacheResult(it.quizscuola.portlet.model.Domanda domanda);

	/**
	* Caches the domandas in the entity cache if it is enabled.
	*
	* @param domandas the domandas
	*/
	public void cacheResult(
		java.util.List<it.quizscuola.portlet.model.Domanda> domandas);

	/**
	* Creates a new domanda with the primary key. Does not add the domanda to the database.
	*
	* @param idDomanda the primary key for the new domanda
	* @return the new domanda
	*/
	public it.quizscuola.portlet.model.Domanda create(long idDomanda);

	/**
	* Removes the domanda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idDomanda the primary key of the domanda
	* @return the domanda that was removed
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda remove(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	public it.quizscuola.portlet.model.Domanda updateImpl(
		it.quizscuola.portlet.model.Domanda domanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the domanda with the primary key or throws a {@link it.quizscuola.portlet.NoSuchDomandaException} if it could not be found.
	*
	* @param idDomanda the primary key of the domanda
	* @return the domanda
	* @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda findByPrimaryKey(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException;

	/**
	* Returns the domanda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idDomanda the primary key of the domanda
	* @return the domanda, or <code>null</code> if a domanda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Domanda fetchByPrimaryKey(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the domandas.
	*
	* @return the domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Domanda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the domandas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of domandas
	* @param end the upper bound of the range of domandas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of domandas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Domanda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the domandas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of domandas.
	*
	* @return the number of domandas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}