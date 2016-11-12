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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.quizscuola.portlet.NoSuchMateriaException;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.model.impl.MateriaImpl;
import it.quizscuola.portlet.model.impl.MateriaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the materia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see MateriaPersistence
 * @see MateriaUtil
 * @generated
 */
public class MateriaPersistenceImpl extends BasePersistenceImpl<Materia>
	implements MateriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MateriaUtil} to access the materia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MateriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MateriaModelImpl.UUID_COLUMN_BITMASK |
			MateriaModelImpl.DESCMATERIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the materias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Materia> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<Materia> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Materia> list = (List<Materia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Materia materia : list) {
				if (!Validator.equals(uuid, materia.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MateriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Materia>(list);
				}
				else {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first materia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByUuid_First(uuid, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the first materia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Materia> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last materia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByUuid_Last(uuid, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the last materia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Materia> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Materia[] findByUuid_PrevAndNext(long idMateria, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = findByPrimaryKey(idMateria);

		Session session = null;

		try {
			session = openSession();

			Materia[] array = new MateriaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, materia, uuid,
					orderByComparator, true);

			array[1] = materia;

			array[2] = getByUuid_PrevAndNext(session, materia, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Materia getByUuid_PrevAndNext(Session session, Materia materia,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MATERIA_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MateriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(materia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Materia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the materias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Materia materia : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(materia);
		}
	}

	/**
	 * Returns the number of materias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "materia.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "materia.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(materia.uuid IS NULL OR materia.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			MateriaModelImpl.UUID_COLUMN_BITMASK |
			MateriaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the materia where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchMateriaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByUUID_G(String uuid, long groupId)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByUUID_G(uuid, groupId);

		if (materia == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMateriaException(msg.toString());
		}

		return materia;
	}

	/**
	 * Returns the materia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the materia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Materia) {
			Materia materia = (Materia)result;

			if (!Validator.equals(uuid, materia.getUuid()) ||
					(groupId != materia.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Materia> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Materia materia = list.get(0);

					result = materia;

					cacheResult(materia);

					if ((materia.getUuid() == null) ||
							!materia.getUuid().equals(uuid) ||
							(materia.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, materia);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Materia)result;
		}
	}

	/**
	 * Removes the materia where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the materia that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia removeByUUID_G(String uuid, long groupId)
		throws NoSuchMateriaException, SystemException {
		Materia materia = findByUUID_G(uuid, groupId);

		return remove(materia);
	}

	/**
	 * Returns the number of materias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "materia.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "materia.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(materia.uuid IS NULL OR materia.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "materia.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MateriaModelImpl.UUID_COLUMN_BITMASK |
			MateriaModelImpl.COMPANYID_COLUMN_BITMASK |
			MateriaModelImpl.DESCMATERIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the materias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Materia> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<Materia> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Materia> list = (List<Materia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Materia materia : list) {
				if (!Validator.equals(uuid, materia.getUuid()) ||
						(companyId != materia.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MateriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Materia>(list);
				}
				else {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public Materia findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the first materia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Materia> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Materia findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the last materia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Materia> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Materia[] findByUuid_C_PrevAndNext(long idMateria, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = findByPrimaryKey(idMateria);

		Session session = null;

		try {
			session = openSession();

			Materia[] array = new MateriaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, materia, uuid,
					companyId, orderByComparator, true);

			array[1] = materia;

			array[2] = getByUuid_C_PrevAndNext(session, materia, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Materia getByUuid_C_PrevAndNext(Session session, Materia materia,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MATERIA_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MateriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(materia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Materia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the materias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Materia materia : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(materia);
		}
	}

	/**
	 * Returns the number of materias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MATERIA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "materia.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "materia.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(materia.uuid IS NULL OR materia.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "materia.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSE = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClasse",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSE =
		new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, MateriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClasse",
			new String[] { Long.class.getName() },
			MateriaModelImpl.IDCLASSE_COLUMN_BITMASK |
			MateriaModelImpl.DESCMATERIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSE = new FinderPath(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClasse",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the materias where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @return the matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findByClasse(long idClasse) throws SystemException {
		return findByClasse(idClasse, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the materias where idClasse = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idClasse the id classe
	 * @param start the lower bound of the range of materias
	 * @param end the upper bound of the range of materias (not inclusive)
	 * @return the range of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findByClasse(long idClasse, int start, int end)
		throws SystemException {
		return findByClasse(idClasse, start, end, null);
	}

	/**
	 * Returns an ordered range of all the materias where idClasse = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.MateriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idClasse the id classe
	 * @param start the lower bound of the range of materias
	 * @param end the upper bound of the range of materias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findByClasse(long idClasse, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSE;
			finderArgs = new Object[] { idClasse };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSE;
			finderArgs = new Object[] { idClasse, start, end, orderByComparator };
		}

		List<Materia> list = (List<Materia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Materia materia : list) {
				if ((idClasse != materia.getIdClasse())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MATERIA_WHERE);

			query.append(_FINDER_COLUMN_CLASSE_IDCLASSE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MateriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idClasse);

				if (!pagination) {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Materia>(list);
				}
				else {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first materia in the ordered set where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByClasse_First(long idClasse,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByClasse_First(idClasse, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idClasse=");
		msg.append(idClasse);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the first materia in the ordered set where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByClasse_First(long idClasse,
		OrderByComparator orderByComparator) throws SystemException {
		List<Materia> list = findByClasse(idClasse, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last materia in the ordered set where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByClasse_Last(long idClasse,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByClasse_Last(idClasse, orderByComparator);

		if (materia != null) {
			return materia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idClasse=");
		msg.append(idClasse);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMateriaException(msg.toString());
	}

	/**
	 * Returns the last materia in the ordered set where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching materia, or <code>null</code> if a matching materia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByClasse_Last(long idClasse,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClasse(idClasse);

		if (count == 0) {
			return null;
		}

		List<Materia> list = findByClasse(idClasse, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the materias before and after the current materia in the ordered set where idClasse = &#63;.
	 *
	 * @param idMateria the primary key of the current materia
	 * @param idClasse the id classe
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia[] findByClasse_PrevAndNext(long idMateria, long idClasse,
		OrderByComparator orderByComparator)
		throws NoSuchMateriaException, SystemException {
		Materia materia = findByPrimaryKey(idMateria);

		Session session = null;

		try {
			session = openSession();

			Materia[] array = new MateriaImpl[3];

			array[0] = getByClasse_PrevAndNext(session, materia, idClasse,
					orderByComparator, true);

			array[1] = materia;

			array[2] = getByClasse_PrevAndNext(session, materia, idClasse,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Materia getByClasse_PrevAndNext(Session session, Materia materia,
		long idClasse, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MATERIA_WHERE);

		query.append(_FINDER_COLUMN_CLASSE_IDCLASSE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MateriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idClasse);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(materia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Materia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the materias where idClasse = &#63; from the database.
	 *
	 * @param idClasse the id classe
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClasse(long idClasse) throws SystemException {
		for (Materia materia : findByClasse(idClasse, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(materia);
		}
	}

	/**
	 * Returns the number of materias where idClasse = &#63;.
	 *
	 * @param idClasse the id classe
	 * @return the number of matching materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClasse(long idClasse) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSE;

		Object[] finderArgs = new Object[] { idClasse };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MATERIA_WHERE);

			query.append(_FINDER_COLUMN_CLASSE_IDCLASSE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idClasse);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSE_IDCLASSE_2 = "materia.idClasse = ?";

	public MateriaPersistenceImpl() {
		setModelClass(Materia.class);
	}

	/**
	 * Caches the materia in the entity cache if it is enabled.
	 *
	 * @param materia the materia
	 */
	@Override
	public void cacheResult(Materia materia) {
		EntityCacheUtil.putResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaImpl.class, materia.getPrimaryKey(), materia);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { materia.getUuid(), materia.getGroupId() }, materia);

		materia.resetOriginalValues();
	}

	/**
	 * Caches the materias in the entity cache if it is enabled.
	 *
	 * @param materias the materias
	 */
	@Override
	public void cacheResult(List<Materia> materias) {
		for (Materia materia : materias) {
			if (EntityCacheUtil.getResult(
						MateriaModelImpl.ENTITY_CACHE_ENABLED,
						MateriaImpl.class, materia.getPrimaryKey()) == null) {
				cacheResult(materia);
			}
			else {
				materia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all materias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MateriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MateriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the materia.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Materia materia) {
		EntityCacheUtil.removeResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaImpl.class, materia.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(materia);
	}

	@Override
	public void clearCache(List<Materia> materias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Materia materia : materias) {
			EntityCacheUtil.removeResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
				MateriaImpl.class, materia.getPrimaryKey());

			clearUniqueFindersCache(materia);
		}
	}

	protected void cacheUniqueFindersCache(Materia materia) {
		if (materia.isNew()) {
			Object[] args = new Object[] { materia.getUuid(), materia.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, materia);
		}
		else {
			MateriaModelImpl materiaModelImpl = (MateriaModelImpl)materia;

			if ((materiaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						materia.getUuid(), materia.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					materia);
			}
		}
	}

	protected void clearUniqueFindersCache(Materia materia) {
		MateriaModelImpl materiaModelImpl = (MateriaModelImpl)materia;

		Object[] args = new Object[] { materia.getUuid(), materia.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((materiaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					materiaModelImpl.getOriginalUuid(),
					materiaModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new materia with the primary key. Does not add the materia to the database.
	 *
	 * @param idMateria the primary key for the new materia
	 * @return the new materia
	 */
	@Override
	public Materia create(long idMateria) {
		Materia materia = new MateriaImpl();

		materia.setNew(true);
		materia.setPrimaryKey(idMateria);

		String uuid = PortalUUIDUtil.generate();

		materia.setUuid(uuid);

		return materia;
	}

	/**
	 * Removes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idMateria the primary key of the materia
	 * @return the materia that was removed
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia remove(long idMateria)
		throws NoSuchMateriaException, SystemException {
		return remove((Serializable)idMateria);
	}

	/**
	 * Removes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the materia
	 * @return the materia that was removed
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia remove(Serializable primaryKey)
		throws NoSuchMateriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Materia materia = (Materia)session.get(MateriaImpl.class, primaryKey);

			if (materia == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMateriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(materia);
		}
		catch (NoSuchMateriaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Materia removeImpl(Materia materia) throws SystemException {
		materia = toUnwrappedModel(materia);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(materia)) {
				materia = (Materia)session.get(MateriaImpl.class,
						materia.getPrimaryKeyObj());
			}

			if (materia != null) {
				session.delete(materia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (materia != null) {
			clearCache(materia);
		}

		return materia;
	}

	@Override
	public Materia updateImpl(it.quizscuola.portlet.model.Materia materia)
		throws SystemException {
		materia = toUnwrappedModel(materia);

		boolean isNew = materia.isNew();

		MateriaModelImpl materiaModelImpl = (MateriaModelImpl)materia;

		if (Validator.isNull(materia.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			materia.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (materia.isNew()) {
				session.save(materia);

				materia.setNew(false);
			}
			else {
				session.merge(materia);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MateriaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((materiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { materiaModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { materiaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((materiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						materiaModelImpl.getOriginalUuid(),
						materiaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						materiaModelImpl.getUuid(),
						materiaModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((materiaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						materiaModelImpl.getOriginalIdClasse()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSE,
					args);

				args = new Object[] { materiaModelImpl.getIdClasse() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSE,
					args);
			}
		}

		EntityCacheUtil.putResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
			MateriaImpl.class, materia.getPrimaryKey(), materia);

		clearUniqueFindersCache(materia);
		cacheUniqueFindersCache(materia);

		return materia;
	}

	protected Materia toUnwrappedModel(Materia materia) {
		if (materia instanceof MateriaImpl) {
			return materia;
		}

		MateriaImpl materiaImpl = new MateriaImpl();

		materiaImpl.setNew(materia.isNew());
		materiaImpl.setPrimaryKey(materia.getPrimaryKey());

		materiaImpl.setUuid(materia.getUuid());
		materiaImpl.setIdMateria(materia.getIdMateria());
		materiaImpl.setDescMateria(materia.getDescMateria());
		materiaImpl.setIdClasse(materia.getIdClasse());
		materiaImpl.setGroupId(materia.getGroupId());
		materiaImpl.setCompanyId(materia.getCompanyId());
		materiaImpl.setUserId(materia.getUserId());
		materiaImpl.setUserName(materia.getUserName());
		materiaImpl.setCreateDate(materia.getCreateDate());
		materiaImpl.setModifiedDate(materia.getModifiedDate());

		return materiaImpl;
	}

	/**
	 * Returns the materia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the materia
	 * @return the materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMateriaException, SystemException {
		Materia materia = fetchByPrimaryKey(primaryKey);

		if (materia == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMateriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return materia;
	}

	/**
	 * Returns the materia with the primary key or throws a {@link it.quizscuola.portlet.NoSuchMateriaException} if it could not be found.
	 *
	 * @param idMateria the primary key of the materia
	 * @return the materia
	 * @throws it.quizscuola.portlet.NoSuchMateriaException if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia findByPrimaryKey(long idMateria)
		throws NoSuchMateriaException, SystemException {
		return findByPrimaryKey((Serializable)idMateria);
	}

	/**
	 * Returns the materia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the materia
	 * @return the materia, or <code>null</code> if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Materia materia = (Materia)EntityCacheUtil.getResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
				MateriaImpl.class, primaryKey);

		if (materia == _nullMateria) {
			return null;
		}

		if (materia == null) {
			Session session = null;

			try {
				session = openSession();

				materia = (Materia)session.get(MateriaImpl.class, primaryKey);

				if (materia != null) {
					cacheResult(materia);
				}
				else {
					EntityCacheUtil.putResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
						MateriaImpl.class, primaryKey, _nullMateria);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MateriaModelImpl.ENTITY_CACHE_ENABLED,
					MateriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return materia;
	}

	/**
	 * Returns the materia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idMateria the primary key of the materia
	 * @return the materia, or <code>null</code> if a materia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Materia fetchByPrimaryKey(long idMateria) throws SystemException {
		return fetchByPrimaryKey((Serializable)idMateria);
	}

	/**
	 * Returns all the materias.
	 *
	 * @return the materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Materia> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Materia> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Materia> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Materia> list = (List<Materia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MATERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MATERIA;

				if (pagination) {
					sql = sql.concat(MateriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Materia>(list);
				}
				else {
					list = (List<Materia>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the materias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Materia materia : findAll()) {
			remove(materia);
		}
	}

	/**
	 * Returns the number of materias.
	 *
	 * @return the number of materias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MATERIA);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the materia persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.quizscuola.portlet.model.Materia")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Materia>> listenersList = new ArrayList<ModelListener<Materia>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Materia>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MateriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MATERIA = "SELECT materia FROM Materia materia";
	private static final String _SQL_SELECT_MATERIA_WHERE = "SELECT materia FROM Materia materia WHERE ";
	private static final String _SQL_COUNT_MATERIA = "SELECT COUNT(materia) FROM Materia materia";
	private static final String _SQL_COUNT_MATERIA_WHERE = "SELECT COUNT(materia) FROM Materia materia WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "materia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Materia exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Materia exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MateriaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Materia _nullMateria = new MateriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Materia> toCacheModel() {
				return _nullMateriaCacheModel;
			}
		};

	private static CacheModel<Materia> _nullMateriaCacheModel = new CacheModel<Materia>() {
			@Override
			public Materia toEntityModel() {
				return _nullMateria;
			}
		};
}