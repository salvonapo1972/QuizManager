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

import it.quizscuola.portlet.model.RispostaUtente;

/**
 * The persistence interface for the risposta utente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see RispostaUtentePersistenceImpl
 * @see RispostaUtenteUtil
 * @generated
 */
public interface RispostaUtentePersistence extends BasePersistence<RispostaUtente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RispostaUtenteUtil} to access the risposta utente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the risposta utentes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the first risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the last risposta utente in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.quizscuola.portlet.model.RispostaUtente[] findByUuid_PrevAndNext(
		long idRispostaUtente, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Removes all the risposta utentes where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of risposta utentes where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the risposta utentes where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @return the matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByIdUtente(
		long idUtente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the risposta utentes where idUtente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idUtente the id utente
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @return the range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByIdUtente(
		long idUtente, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the risposta utentes where idUtente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idUtente the id utente
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByIdUtente(
		long idUtente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta utente in the ordered set where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByIdUtente_First(
		long idUtente,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the first risposta utente in the ordered set where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByIdUtente_First(
		long idUtente,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta utente in the ordered set where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByIdUtente_Last(
		long idUtente,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the last risposta utente in the ordered set where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByIdUtente_Last(
		long idUtente,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta utentes before and after the current risposta utente in the ordered set where idUtente = &#63;.
	*
	* @param idRispostaUtente the primary key of the current risposta utente
	* @param idUtente the id utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente[] findByIdUtente_PrevAndNext(
		long idRispostaUtente, long idUtente,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Removes all the risposta utentes where idUtente = &#63; from the database.
	*
	* @param idUtente the id utente
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdUtente(long idUtente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of risposta utentes where idUtente = &#63;.
	*
	* @param idUtente the id utente
	* @return the number of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdUtente(long idUtente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the risposta utentes where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @return the matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByidDomanda(
		long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the risposta utentes where idDomanda = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idDomanda the id domanda
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @return the range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByidDomanda(
		long idDomanda, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the risposta utentes where idDomanda = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idDomanda the id domanda
	* @param start the lower bound of the range of risposta utentes
	* @param end the upper bound of the range of risposta utentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findByidDomanda(
		long idDomanda, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first risposta utente in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByidDomanda_First(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the first risposta utente in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByidDomanda_First(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last risposta utente in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByidDomanda_Last(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the last risposta utente in the ordered set where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByidDomanda_Last(
		long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta utentes before and after the current risposta utente in the ordered set where idDomanda = &#63;.
	*
	* @param idRispostaUtente the primary key of the current risposta utente
	* @param idDomanda the id domanda
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente[] findByidDomanda_PrevAndNext(
		long idRispostaUtente, long idDomanda,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Removes all the risposta utentes where idDomanda = &#63; from the database.
	*
	* @param idDomanda the id domanda
	* @throws SystemException if a system exception occurred
	*/
	public void removeByidDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of risposta utentes where idDomanda = &#63;.
	*
	* @param idDomanda the id domanda
	* @return the number of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public int countByidDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or throws a {@link it.quizscuola.portlet.NoSuchRispostaUtenteException} if it could not be found.
	*
	* @param idUtente the id utente
	* @param idDomanda the id domanda
	* @return the matching risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByIdUtente_Domanda(
		long idUtente, long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idUtente the id utente
	* @param idDomanda the id domanda
	* @return the matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByIdUtente_Domanda(
		long idUtente, long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idUtente the id utente
	* @param idDomanda the id domanda
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByIdUtente_Domanda(
		long idUtente, long idDomanda, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the risposta utente where idUtente = &#63; and idDomanda = &#63; from the database.
	*
	* @param idUtente the id utente
	* @param idDomanda the id domanda
	* @return the risposta utente that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente removeByIdUtente_Domanda(
		long idUtente, long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the number of risposta utentes where idUtente = &#63; and idDomanda = &#63;.
	*
	* @param idUtente the id utente
	* @param idDomanda the id domanda
	* @return the number of matching risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdUtente_Domanda(long idUtente, long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the risposta utente in the entity cache if it is enabled.
	*
	* @param rispostaUtente the risposta utente
	*/
	public void cacheResult(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente);

	/**
	* Caches the risposta utentes in the entity cache if it is enabled.
	*
	* @param rispostaUtentes the risposta utentes
	*/
	public void cacheResult(
		java.util.List<it.quizscuola.portlet.model.RispostaUtente> rispostaUtentes);

	/**
	* Creates a new risposta utente with the primary key. Does not add the risposta utente to the database.
	*
	* @param idRispostaUtente the primary key for the new risposta utente
	* @return the new risposta utente
	*/
	public it.quizscuola.portlet.model.RispostaUtente create(
		long idRispostaUtente);

	/**
	* Removes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente that was removed
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente remove(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	public it.quizscuola.portlet.model.RispostaUtente updateImpl(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the risposta utente with the primary key or throws a {@link it.quizscuola.portlet.NoSuchRispostaUtenteException} if it could not be found.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente
	* @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente findByPrimaryKey(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaUtenteException;

	/**
	* Returns the risposta utente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idRispostaUtente the primary key of the risposta utente
	* @return the risposta utente, or <code>null</code> if a risposta utente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.RispostaUtente fetchByPrimaryKey(
		long idRispostaUtente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the risposta utentes.
	*
	* @return the risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.RispostaUtente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the risposta utentes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of risposta utentes.
	*
	* @return the number of risposta utentes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}