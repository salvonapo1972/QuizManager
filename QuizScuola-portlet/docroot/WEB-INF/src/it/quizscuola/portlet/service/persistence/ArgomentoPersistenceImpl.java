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

import it.quizscuola.portlet.NoSuchArgomentoException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.impl.ArgomentoImpl;
import it.quizscuola.portlet.model.impl.ArgomentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the argomento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see ArgomentoPersistence
 * @see ArgomentoUtil
 * @generated
 */
public class ArgomentoPersistenceImpl extends BasePersistenceImpl<Argomento>
	implements ArgomentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArgomentoUtil} to access the argomento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArgomentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ArgomentoModelImpl.UUID_COLUMN_BITMASK |
			ArgomentoModelImpl.DESCARGOMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the argomentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching argomentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Argomento> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Argomento> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Argomento> findByUuid(String uuid, int start, int end,
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

		List<Argomento> list = (List<Argomento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Argomento argomento : list) {
				if (!Validator.equals(uuid, argomento.getUuid())) {
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

			query.append(_SQL_SELECT_ARGOMENTO_WHERE);

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
				query.append(ArgomentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Argomento>(list);
				}
				else {
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first argomento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching argomento
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByUuid_First(uuid, orderByComparator);

		if (argomento != null) {
			return argomento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArgomentoException(msg.toString());
	}

	/**
	 * Returns the first argomento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching argomento, or <code>null</code> if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Argomento> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Argomento findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByUuid_Last(uuid, orderByComparator);

		if (argomento != null) {
			return argomento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArgomentoException(msg.toString());
	}

	/**
	 * Returns the last argomento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching argomento, or <code>null</code> if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Argomento> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Argomento[] findByUuid_PrevAndNext(long idArgomento, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = findByPrimaryKey(idArgomento);

		Session session = null;

		try {
			session = openSession();

			Argomento[] array = new ArgomentoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, argomento, uuid,
					orderByComparator, true);

			array[1] = argomento;

			array[2] = getByUuid_PrevAndNext(session, argomento, uuid,
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

	protected Argomento getByUuid_PrevAndNext(Session session,
		Argomento argomento, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARGOMENTO_WHERE);

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
			query.append(ArgomentoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(argomento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Argomento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the argomentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Argomento argomento : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(argomento);
		}
	}

	/**
	 * Returns the number of argomentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching argomentos
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

			query.append(_SQL_COUNT_ARGOMENTO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "argomento.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "argomento.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(argomento.uuid IS NULL OR argomento.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ArgomentoModelImpl.UUID_COLUMN_BITMASK |
			ArgomentoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the argomento where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching argomento
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento findByUUID_G(String uuid, long groupId)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByUUID_G(uuid, groupId);

		if (argomento == null) {
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

			throw new NoSuchArgomentoException(msg.toString());
		}

		return argomento;
	}

	/**
	 * Returns the argomento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public Argomento fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Argomento) {
			Argomento argomento = (Argomento)result;

			if (!Validator.equals(uuid, argomento.getUuid()) ||
					(groupId != argomento.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ARGOMENTO_WHERE);

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

				List<Argomento> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Argomento argomento = list.get(0);

					result = argomento;

					cacheResult(argomento);

					if ((argomento.getUuid() == null) ||
							!argomento.getUuid().equals(uuid) ||
							(argomento.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, argomento);
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
			return (Argomento)result;
		}
	}

	/**
	 * Removes the argomento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the argomento that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento removeByUUID_G(String uuid, long groupId)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = findByUUID_G(uuid, groupId);

		return remove(argomento);
	}

	/**
	 * Returns the number of argomentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching argomentos
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

			query.append(_SQL_COUNT_ARGOMENTO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "argomento.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "argomento.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(argomento.uuid IS NULL OR argomento.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "argomento.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, ArgomentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ArgomentoModelImpl.UUID_COLUMN_BITMASK |
			ArgomentoModelImpl.COMPANYID_COLUMN_BITMASK |
			ArgomentoModelImpl.DESCARGOMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the argomentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching argomentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Argomento> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Argomento> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Argomento> findByUuid_C(String uuid, long companyId, int start,
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

		List<Argomento> list = (List<Argomento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Argomento argomento : list) {
				if (!Validator.equals(uuid, argomento.getUuid()) ||
						(companyId != argomento.getCompanyId())) {
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

			query.append(_SQL_SELECT_ARGOMENTO_WHERE);

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
				query.append(ArgomentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Argomento>(list);
				}
				else {
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first argomento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching argomento
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a matching argomento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (argomento != null) {
			return argomento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArgomentoException(msg.toString());
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
	@Override
	public Argomento fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Argomento> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Argomento findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (argomento != null) {
			return argomento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArgomentoException(msg.toString());
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
	@Override
	public Argomento fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Argomento> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Argomento[] findByUuid_C_PrevAndNext(long idArgomento, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = findByPrimaryKey(idArgomento);

		Session session = null;

		try {
			session = openSession();

			Argomento[] array = new ArgomentoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, argomento, uuid,
					companyId, orderByComparator, true);

			array[1] = argomento;

			array[2] = getByUuid_C_PrevAndNext(session, argomento, uuid,
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

	protected Argomento getByUuid_C_PrevAndNext(Session session,
		Argomento argomento, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARGOMENTO_WHERE);

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
			query.append(ArgomentoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(argomento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Argomento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the argomentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Argomento argomento : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(argomento);
		}
	}

	/**
	 * Returns the number of argomentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching argomentos
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

			query.append(_SQL_COUNT_ARGOMENTO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "argomento.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "argomento.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(argomento.uuid IS NULL OR argomento.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "argomento.companyId = ?";

	public ArgomentoPersistenceImpl() {
		setModelClass(Argomento.class);
	}

	/**
	 * Caches the argomento in the entity cache if it is enabled.
	 *
	 * @param argomento the argomento
	 */
	@Override
	public void cacheResult(Argomento argomento) {
		EntityCacheUtil.putResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoImpl.class, argomento.getPrimaryKey(), argomento);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { argomento.getUuid(), argomento.getGroupId() },
			argomento);

		argomento.resetOriginalValues();
	}

	/**
	 * Caches the argomentos in the entity cache if it is enabled.
	 *
	 * @param argomentos the argomentos
	 */
	@Override
	public void cacheResult(List<Argomento> argomentos) {
		for (Argomento argomento : argomentos) {
			if (EntityCacheUtil.getResult(
						ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
						ArgomentoImpl.class, argomento.getPrimaryKey()) == null) {
				cacheResult(argomento);
			}
			else {
				argomento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all argomentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArgomentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArgomentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the argomento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Argomento argomento) {
		EntityCacheUtil.removeResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoImpl.class, argomento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(argomento);
	}

	@Override
	public void clearCache(List<Argomento> argomentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Argomento argomento : argomentos) {
			EntityCacheUtil.removeResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
				ArgomentoImpl.class, argomento.getPrimaryKey());

			clearUniqueFindersCache(argomento);
		}
	}

	protected void cacheUniqueFindersCache(Argomento argomento) {
		if (argomento.isNew()) {
			Object[] args = new Object[] {
					argomento.getUuid(), argomento.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				argomento);
		}
		else {
			ArgomentoModelImpl argomentoModelImpl = (ArgomentoModelImpl)argomento;

			if ((argomentoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						argomento.getUuid(), argomento.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					argomento);
			}
		}
	}

	protected void clearUniqueFindersCache(Argomento argomento) {
		ArgomentoModelImpl argomentoModelImpl = (ArgomentoModelImpl)argomento;

		Object[] args = new Object[] { argomento.getUuid(), argomento.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((argomentoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					argomentoModelImpl.getOriginalUuid(),
					argomentoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new argomento with the primary key. Does not add the argomento to the database.
	 *
	 * @param idArgomento the primary key for the new argomento
	 * @return the new argomento
	 */
	@Override
	public Argomento create(long idArgomento) {
		Argomento argomento = new ArgomentoImpl();

		argomento.setNew(true);
		argomento.setPrimaryKey(idArgomento);

		String uuid = PortalUUIDUtil.generate();

		argomento.setUuid(uuid);

		return argomento;
	}

	/**
	 * Removes the argomento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idArgomento the primary key of the argomento
	 * @return the argomento that was removed
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento remove(long idArgomento)
		throws NoSuchArgomentoException, SystemException {
		return remove((Serializable)idArgomento);
	}

	/**
	 * Removes the argomento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the argomento
	 * @return the argomento that was removed
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento remove(Serializable primaryKey)
		throws NoSuchArgomentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Argomento argomento = (Argomento)session.get(ArgomentoImpl.class,
					primaryKey);

			if (argomento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArgomentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(argomento);
		}
		catch (NoSuchArgomentoException nsee) {
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
	protected Argomento removeImpl(Argomento argomento)
		throws SystemException {
		argomento = toUnwrappedModel(argomento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(argomento)) {
				argomento = (Argomento)session.get(ArgomentoImpl.class,
						argomento.getPrimaryKeyObj());
			}

			if (argomento != null) {
				session.delete(argomento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (argomento != null) {
			clearCache(argomento);
		}

		return argomento;
	}

	@Override
	public Argomento updateImpl(it.quizscuola.portlet.model.Argomento argomento)
		throws SystemException {
		argomento = toUnwrappedModel(argomento);

		boolean isNew = argomento.isNew();

		ArgomentoModelImpl argomentoModelImpl = (ArgomentoModelImpl)argomento;

		if (Validator.isNull(argomento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			argomento.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (argomento.isNew()) {
				session.save(argomento);

				argomento.setNew(false);
			}
			else {
				session.merge(argomento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ArgomentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((argomentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						argomentoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { argomentoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((argomentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						argomentoModelImpl.getOriginalUuid(),
						argomentoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						argomentoModelImpl.getUuid(),
						argomentoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
			ArgomentoImpl.class, argomento.getPrimaryKey(), argomento);

		clearUniqueFindersCache(argomento);
		cacheUniqueFindersCache(argomento);

		return argomento;
	}

	protected Argomento toUnwrappedModel(Argomento argomento) {
		if (argomento instanceof ArgomentoImpl) {
			return argomento;
		}

		ArgomentoImpl argomentoImpl = new ArgomentoImpl();

		argomentoImpl.setNew(argomento.isNew());
		argomentoImpl.setPrimaryKey(argomento.getPrimaryKey());

		argomentoImpl.setUuid(argomento.getUuid());
		argomentoImpl.setIdArgomento(argomento.getIdArgomento());
		argomentoImpl.setDescArgomento(argomento.getDescArgomento());
		argomentoImpl.setIdMateria(argomento.getIdMateria());
		argomentoImpl.setGroupId(argomento.getGroupId());
		argomentoImpl.setCompanyId(argomento.getCompanyId());
		argomentoImpl.setUserId(argomento.getUserId());
		argomentoImpl.setUserName(argomento.getUserName());
		argomentoImpl.setCreateDate(argomento.getCreateDate());
		argomentoImpl.setModifiedDate(argomento.getModifiedDate());

		return argomentoImpl;
	}

	/**
	 * Returns the argomento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the argomento
	 * @return the argomento
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArgomentoException, SystemException {
		Argomento argomento = fetchByPrimaryKey(primaryKey);

		if (argomento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArgomentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return argomento;
	}

	/**
	 * Returns the argomento with the primary key or throws a {@link it.quizscuola.portlet.NoSuchArgomentoException} if it could not be found.
	 *
	 * @param idArgomento the primary key of the argomento
	 * @return the argomento
	 * @throws it.quizscuola.portlet.NoSuchArgomentoException if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento findByPrimaryKey(long idArgomento)
		throws NoSuchArgomentoException, SystemException {
		return findByPrimaryKey((Serializable)idArgomento);
	}

	/**
	 * Returns the argomento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the argomento
	 * @return the argomento, or <code>null</code> if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Argomento argomento = (Argomento)EntityCacheUtil.getResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
				ArgomentoImpl.class, primaryKey);

		if (argomento == _nullArgomento) {
			return null;
		}

		if (argomento == null) {
			Session session = null;

			try {
				session = openSession();

				argomento = (Argomento)session.get(ArgomentoImpl.class,
						primaryKey);

				if (argomento != null) {
					cacheResult(argomento);
				}
				else {
					EntityCacheUtil.putResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
						ArgomentoImpl.class, primaryKey, _nullArgomento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArgomentoModelImpl.ENTITY_CACHE_ENABLED,
					ArgomentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return argomento;
	}

	/**
	 * Returns the argomento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idArgomento the primary key of the argomento
	 * @return the argomento, or <code>null</code> if a argomento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Argomento fetchByPrimaryKey(long idArgomento)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)idArgomento);
	}

	/**
	 * Returns all the argomentos.
	 *
	 * @return the argomentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Argomento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Argomento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Argomento> findAll(int start, int end,
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

		List<Argomento> list = (List<Argomento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARGOMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARGOMENTO;

				if (pagination) {
					sql = sql.concat(ArgomentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Argomento>(list);
				}
				else {
					list = (List<Argomento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the argomentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Argomento argomento : findAll()) {
			remove(argomento);
		}
	}

	/**
	 * Returns the number of argomentos.
	 *
	 * @return the number of argomentos
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

				Query q = session.createQuery(_SQL_COUNT_ARGOMENTO);

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
	 * Initializes the argomento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.quizscuola.portlet.model.Argomento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Argomento>> listenersList = new ArrayList<ModelListener<Argomento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Argomento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ArgomentoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARGOMENTO = "SELECT argomento FROM Argomento argomento";
	private static final String _SQL_SELECT_ARGOMENTO_WHERE = "SELECT argomento FROM Argomento argomento WHERE ";
	private static final String _SQL_COUNT_ARGOMENTO = "SELECT COUNT(argomento) FROM Argomento argomento";
	private static final String _SQL_COUNT_ARGOMENTO_WHERE = "SELECT COUNT(argomento) FROM Argomento argomento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "argomento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Argomento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Argomento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArgomentoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Argomento _nullArgomento = new ArgomentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Argomento> toCacheModel() {
				return _nullArgomentoCacheModel;
			}
		};

	private static CacheModel<Argomento> _nullArgomentoCacheModel = new CacheModel<Argomento>() {
			@Override
			public Argomento toEntityModel() {
				return _nullArgomento;
			}
		};
}