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

import it.quizscuola.portlet.model.Materia;

/**
 * The persistence interface for the materia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see MateriaPersistenceImpl
 * @see MateriaUtil
 * @generated
 */
public interface MateriaPersistence extends BasePersistence<Materia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MateriaUtil} to access the materia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the materias where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the materias where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @return the range of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the materias where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first materia in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the first materia in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last materia in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the last materia in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materias before and after the current materia in the ordered set where uuid = &#63;.
	*
	* @param idMateria the primary key of the current materia
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia[] findByUuid_PrevAndNext(
		long idMateria, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Removes all the materias where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of materias where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materia where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchMateriaException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the materia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the materia where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the materia that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the number of materias where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the materias where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the materias where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @return the range of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the materias where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first materia in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the first materia in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last materia in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the last materia in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching materia, or <code>null</code> if a matching materia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materias before and after the current materia in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param idMateria the primary key of the current materia
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia[] findByUuid_C_PrevAndNext(
		long idMateria, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Removes all the materias where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of materias where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching materias
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the materia in the entity cache if it is enabled.
	*
	* @param materia the materia
	*/
	public void cacheResult(it.quizscuola.portlet.model.Materia materia);

	/**
	* Caches the materias in the entity cache if it is enabled.
	*
	* @param materias the materias
	*/
	public void cacheResult(
		java.util.List<it.quizscuola.portlet.model.Materia> materias);

	/**
	* Creates a new materia with the primary key. Does not add the materia to the database.
	*
	* @param idMateria the primary key for the new materia
	* @return the new materia
	*/
	public it.quizscuola.portlet.model.Materia create(long idMateria);

	/**
	* Removes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idMateria the primary key of the materia
	* @return the materia that was removed
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia remove(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	public it.quizscuola.portlet.model.Materia updateImpl(
		it.quizscuola.portlet.model.Materia materia)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materia with the primary key or throws a {@link it.quizscuola.portlet.NoSuchMateriaException} if it could not be found.
	*
	* @param idMateria the primary key of the materia
	* @return the materia
	* @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia findByPrimaryKey(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchMateriaException;

	/**
	* Returns the materia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idMateria the primary key of the materia
	* @return the materia, or <code>null</code> if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.quizscuola.portlet.model.Materia fetchByPrimaryKey(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the materias.
	*
	* @return the materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.quizscuola.portlet.model.Materia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the materias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.quizscuola.portlet.model.Materia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the materias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of materias.
	*
	* @return the number of materias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}