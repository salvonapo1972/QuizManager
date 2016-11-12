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

import it.quizscuola.portlet.model.Risposta;

/**
 * The persistence interface for the risposta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see RispostaPersistenceImpl
 * @see RispostaUtil
 * @generated
 */
public interface RispostaPersistence extends BasePersistence<Risposta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RispostaUtil} to access the risposta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rispostas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rispostas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @return the range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rispostas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the first risposta in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the last risposta in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rispostas before and after the current risposta in the ordered set where uuid = &#63;.
	*
	* @param idRisposta the primary key of the current risposta
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta[] findByUuid_PrevAndNext(
		long idRisposta, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Removes all the rispostas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rispostas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchRispostaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the risposta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the risposta where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the risposta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the number of rispostas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rispostas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rispostas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @return the range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rispostas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the first risposta in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the last risposta in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rispostas before and after the current risposta in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param idRisposta the primary key of the current risposta
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta[] findByUuid_C_PrevAndNext(
		long idRisposta, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Removes all the rispostas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rispostas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rispostas where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @return the matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByDomanda(
		long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rispostas where idDomanda = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idDomanda the id domanda
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @return the range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByDomanda(
		long idDomanda, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rispostas where idDomanda = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idDomanda the id domanda
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findByDomanda(
		long idDomanda, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByDomanda_First(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the first risposta in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByDomanda_First(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByDomanda_Last(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the last risposta in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByDomanda_Last(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rispostas before and after the current risposta in the ordered set where idDomanda = &#63;.
	*
	* @param idRisposta the primary key of the current risposta
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta[] findByDomanda_PrevAndNext(
		long idRisposta, long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Removes all the rispostas where idDomanda = &#63; from the database.
	*
	* @param idDomanda the id domanda
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rispostas where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @return the number of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta where idDomanda = &#63; and esatta = &#63; or throws a {@link it.quizscuola.portlet.NoSuchRispostaException} if it could not be found.
	*
	* @param idDomanda the id domanda
	* @param esatta the esatta
	* @return the matching risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByDomanda_RispEsatta(
		long idDomanda, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the risposta where idDomanda = &#63; and esatta = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idDomanda the id domanda
	* @param esatta the esatta
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByDomanda_RispEsatta(
		long idDomanda, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta where idDomanda = &#63; and esatta = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idDomanda the id domanda
	* @param esatta the esatta
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching risposta, or <code>null</code> if a matching risposta could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByDomanda_RispEsatta(
		long idDomanda, boolean esatta, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the risposta where idDomanda = &#63; and esatta = &#63; from the database.
	*
	* @param idDomanda the id domanda
	* @param esatta the esatta
	* @return the risposta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta removeByDomanda_RispEsatta(
		long idDomanda, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the number of rispostas where idDomanda = &#63; and esatta = &#63;.
	*
	* @param idDomanda the id domanda
	* @param esatta the esatta
	* @return the number of matching rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countByDomanda_RispEsatta(long idDomanda, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the risposta in the entity cache if it is enabled.
	*
	* @param risposta the risposta
	*/
	public void cacheResult(it.quizscuola.portlet.model.Risposta risposta);

	/**
	* Caches the rispostas in the entity cache if it is enabled.
	*
	* @param rispostas the rispostas
	*/
	public void cacheResult(
		java.util.List<it.quizscuola.portlet.model.Risposta> rispostas);

	/**
	* Creates a new risposta with the primary key. Does not add the risposta to the database.
	*
	* @param idRisposta the primary key for the new risposta
	* @return the new risposta
	*/
	public it.quizscuola.portlet.model.Risposta create(long idRisposta);

	/**
	* Removes the risposta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRisposta the primary key of the risposta
	* @return the risposta that was removed
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta remove(long idRisposta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	public it.quizscuola.portlet.model.Risposta updateImpl(
		it.quizscuola.portlet.model.Risposta risposta)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta with the primary key or throws a {@link it.quizscuola.portlet.NoSuchRispostaException} if it could not be found.
	*
	* @param idRisposta the primary key of the risposta
	* @return the risposta
	* @throws it.quizscuola.portlet.NoSuchRispostaException if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta findByPrimaryKey(
		long idRisposta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException;

	/**
	* Returns the risposta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idRisposta the primary key of the risposta
	* @return the risposta, or <code>null</code> if a risposta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Risposta fetchByPrimaryKey(
		long idRisposta)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rispostas.
	*
	* @return the rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Risposta> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rispostas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rispostas
	* @param end the upper bound of the range of rispostas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rispostas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Risposta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rispostas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rispostas.
	*
	* @return the number of rispostas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}