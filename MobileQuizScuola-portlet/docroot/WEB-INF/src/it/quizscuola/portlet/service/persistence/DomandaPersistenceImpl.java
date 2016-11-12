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

import it.quizscuola.portlet.NoSuchDomandaException;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.impl.DomandaImpl;
import it.quizscuola.portlet.model.impl.DomandaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the domanda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see DomandaPersistence
 * @see DomandaUtil
 * @generated
 */
public class DomandaPersistenceImpl extends BasePersistenceImpl<Domanda>
	implements DomandaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DomandaUtil} to access the domanda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DomandaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DomandaModelImpl.UUID_COLUMN_BITMASK |
			DomandaModelImpl.POSIZIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the domandas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Domanda> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<Domanda> findByUuid(String uuid, int start, int end,
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

		List<Domanda> list = (List<Domanda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Domanda domanda : list) {
				if (!Validator.equals(uuid, domanda.getUuid())) {
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

			query.append(_SQL_SELECT_DOMANDA_WHERE);

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
				query.append(DomandaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Domanda>(list);
				}
				else {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first domanda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByUuid_First(uuid, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the first domanda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Domanda> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last domanda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByUuid_Last(uuid, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the last domanda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Domanda> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Domanda[] findByUuid_PrevAndNext(long idDomanda, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = findByPrimaryKey(idDomanda);

		Session session = null;

		try {
			session = openSession();

			Domanda[] array = new DomandaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, domanda, uuid,
					orderByComparator, true);

			array[1] = domanda;

			array[2] = getByUuid_PrevAndNext(session, domanda, uuid,
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

	protected Domanda getByUuid_PrevAndNext(Session session, Domanda domanda,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOMANDA_WHERE);

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
			query.append(DomandaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(domanda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Domanda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the domandas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Domanda domanda : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(domanda);
		}
	}

	/**
	 * Returns the number of domandas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching domandas
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

			query.append(_SQL_COUNT_DOMANDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "domanda.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "domanda.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(domanda.uuid IS NULL OR domanda.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DomandaModelImpl.UUID_COLUMN_BITMASK |
			DomandaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the domanda where uuid = &#63; and groupId = &#63; or throws a {@link it.quizscuola.portlet.NoSuchDomandaException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByUUID_G(String uuid, long groupId)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByUUID_G(uuid, groupId);

		if (domanda == null) {
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

			throw new NoSuchDomandaException(msg.toString());
		}

		return domanda;
	}

	/**
	 * Returns the domanda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the domanda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Domanda) {
			Domanda domanda = (Domanda)result;

			if (!Validator.equals(uuid, domanda.getUuid()) ||
					(groupId != domanda.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOMANDA_WHERE);

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

				List<Domanda> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Domanda domanda = list.get(0);

					result = domanda;

					cacheResult(domanda);

					if ((domanda.getUuid() == null) ||
							!domanda.getUuid().equals(uuid) ||
							(domanda.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, domanda);
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
			return (Domanda)result;
		}
	}

	/**
	 * Removes the domanda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the domanda that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda removeByUUID_G(String uuid, long groupId)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = findByUUID_G(uuid, groupId);

		return remove(domanda);
	}

	/**
	 * Returns the number of domandas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching domandas
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

			query.append(_SQL_COUNT_DOMANDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "domanda.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "domanda.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(domanda.uuid IS NULL OR domanda.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "domanda.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DomandaModelImpl.UUID_COLUMN_BITMASK |
			DomandaModelImpl.COMPANYID_COLUMN_BITMASK |
			DomandaModelImpl.POSIZIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the domandas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Domanda> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<Domanda> findByUuid_C(String uuid, long companyId, int start,
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

		List<Domanda> list = (List<Domanda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Domanda domanda : list) {
				if (!Validator.equals(uuid, domanda.getUuid()) ||
						(companyId != domanda.getCompanyId())) {
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

			query.append(_SQL_SELECT_DOMANDA_WHERE);

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
				query.append(DomandaModelImpl.ORDER_BY_JPQL);
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
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Domanda>(list);
				}
				else {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the first domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Domanda> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Domanda findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the last domanda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Domanda> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Domanda[] findByUuid_C_PrevAndNext(long idDomanda, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = findByPrimaryKey(idDomanda);

		Session session = null;

		try {
			session = openSession();

			Domanda[] array = new DomandaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, domanda, uuid,
					companyId, orderByComparator, true);

			array[1] = domanda;

			array[2] = getByUuid_C_PrevAndNext(session, domanda, uuid,
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

	protected Domanda getByUuid_C_PrevAndNext(Session session, Domanda domanda,
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

		query.append(_SQL_SELECT_DOMANDA_WHERE);

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
			query.append(DomandaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(domanda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Domanda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the domandas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Domanda domanda : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(domanda);
		}
	}

	/**
	 * Returns the number of domandas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching domandas
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

			query.append(_SQL_COUNT_DOMANDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "domanda.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "domanda.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(domanda.uuid IS NULL OR domanda.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "domanda.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARGOMENTO =
		new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArgomento",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARGOMENTO =
		new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArgomento",
			new String[] { Long.class.getName() },
			DomandaModelImpl.IDARGOMENTO_COLUMN_BITMASK |
			DomandaModelImpl.POSIZIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARGOMENTO = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArgomento",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the domandas where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @return the matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findByArgomento(long idArgomento)
		throws SystemException {
		return findByArgomento(idArgomento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the domandas where idArgomento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idArgomento the id argomento
	 * @param start the lower bound of the range of domandas
	 * @param end the upper bound of the range of domandas (not inclusive)
	 * @return the range of matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findByArgomento(long idArgomento, int start, int end)
		throws SystemException {
		return findByArgomento(idArgomento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the domandas where idArgomento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.DomandaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idArgomento the id argomento
	 * @param start the lower bound of the range of domandas
	 * @param end the upper bound of the range of domandas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findByArgomento(long idArgomento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARGOMENTO;
			finderArgs = new Object[] { idArgomento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARGOMENTO;
			finderArgs = new Object[] { idArgomento, start, end, orderByComparator };
		}

		List<Domanda> list = (List<Domanda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Domanda domanda : list) {
				if ((idArgomento != domanda.getIdArgomento())) {
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

			query.append(_SQL_SELECT_DOMANDA_WHERE);

			query.append(_FINDER_COLUMN_ARGOMENTO_IDARGOMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DomandaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idArgomento);

				if (!pagination) {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Domanda>(list);
				}
				else {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first domanda in the ordered set where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByArgomento_First(long idArgomento,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByArgomento_First(idArgomento, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idArgomento=");
		msg.append(idArgomento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the first domanda in the ordered set where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByArgomento_First(long idArgomento,
		OrderByComparator orderByComparator) throws SystemException {
		List<Domanda> list = findByArgomento(idArgomento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last domanda in the ordered set where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByArgomento_Last(long idArgomento,
		OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByArgomento_Last(idArgomento, orderByComparator);

		if (domanda != null) {
			return domanda;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idArgomento=");
		msg.append(idArgomento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDomandaException(msg.toString());
	}

	/**
	 * Returns the last domanda in the ordered set where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByArgomento_Last(long idArgomento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArgomento(idArgomento);

		if (count == 0) {
			return null;
		}

		List<Domanda> list = findByArgomento(idArgomento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the domandas before and after the current domanda in the ordered set where idArgomento = &#63;.
	 *
	 * @param idDomanda the primary key of the current domanda
	 * @param idArgomento the id argomento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda[] findByArgomento_PrevAndNext(long idDomanda,
		long idArgomento, OrderByComparator orderByComparator)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = findByPrimaryKey(idDomanda);

		Session session = null;

		try {
			session = openSession();

			Domanda[] array = new DomandaImpl[3];

			array[0] = getByArgomento_PrevAndNext(session, domanda,
					idArgomento, orderByComparator, true);

			array[1] = domanda;

			array[2] = getByArgomento_PrevAndNext(session, domanda,
					idArgomento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Domanda getByArgomento_PrevAndNext(Session session,
		Domanda domanda, long idArgomento, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOMANDA_WHERE);

		query.append(_FINDER_COLUMN_ARGOMENTO_IDARGOMENTO_2);

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
			query.append(DomandaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idArgomento);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(domanda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Domanda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the domandas where idArgomento = &#63; from the database.
	 *
	 * @param idArgomento the id argomento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArgomento(long idArgomento) throws SystemException {
		for (Domanda domanda : findByArgomento(idArgomento, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(domanda);
		}
	}

	/**
	 * Returns the number of domandas where idArgomento = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @return the number of matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArgomento(long idArgomento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARGOMENTO;

		Object[] finderArgs = new Object[] { idArgomento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOMANDA_WHERE);

			query.append(_FINDER_COLUMN_ARGOMENTO_IDARGOMENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idArgomento);

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

	private static final String _FINDER_COLUMN_ARGOMENTO_IDARGOMENTO_2 = "domanda.idArgomento = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ARGOMENTO_POS = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, DomandaImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByArgomento_Pos",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DomandaModelImpl.IDARGOMENTO_COLUMN_BITMASK |
			DomandaModelImpl.POSIZIONE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARGOMENTO_POS = new FinderPath(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArgomento_Pos",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the domanda where idArgomento = &#63; and posizione = &#63; or throws a {@link it.quizscuola.portlet.NoSuchDomandaException} if it could not be found.
	 *
	 * @param idArgomento the id argomento
	 * @param posizione the posizione
	 * @return the matching domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByArgomento_Pos(long idArgomento, int posizione)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByArgomento_Pos(idArgomento, posizione);

		if (domanda == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idArgomento=");
			msg.append(idArgomento);

			msg.append(", posizione=");
			msg.append(posizione);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDomandaException(msg.toString());
		}

		return domanda;
	}

	/**
	 * Returns the domanda where idArgomento = &#63; and posizione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idArgomento the id argomento
	 * @param posizione the posizione
	 * @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByArgomento_Pos(long idArgomento, int posizione)
		throws SystemException {
		return fetchByArgomento_Pos(idArgomento, posizione, true);
	}

	/**
	 * Returns the domanda where idArgomento = &#63; and posizione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idArgomento the id argomento
	 * @param posizione the posizione
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching domanda, or <code>null</code> if a matching domanda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByArgomento_Pos(long idArgomento, int posizione,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { idArgomento, posizione };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
					finderArgs, this);
		}

		if (result instanceof Domanda) {
			Domanda domanda = (Domanda)result;

			if ((idArgomento != domanda.getIdArgomento()) ||
					(posizione != domanda.getPosizione())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOMANDA_WHERE);

			query.append(_FINDER_COLUMN_ARGOMENTO_POS_IDARGOMENTO_2);

			query.append(_FINDER_COLUMN_ARGOMENTO_POS_POSIZIONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idArgomento);

				qPos.add(posizione);

				List<Domanda> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DomandaPersistenceImpl.fetchByArgomento_Pos(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Domanda domanda = list.get(0);

					result = domanda;

					cacheResult(domanda);

					if ((domanda.getIdArgomento() != idArgomento) ||
							(domanda.getPosizione() != posizione)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
							finderArgs, domanda);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
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
			return (Domanda)result;
		}
	}

	/**
	 * Removes the domanda where idArgomento = &#63; and posizione = &#63; from the database.
	 *
	 * @param idArgomento the id argomento
	 * @param posizione the posizione
	 * @return the domanda that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda removeByArgomento_Pos(long idArgomento, int posizione)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = findByArgomento_Pos(idArgomento, posizione);

		return remove(domanda);
	}

	/**
	 * Returns the number of domandas where idArgomento = &#63; and posizione = &#63;.
	 *
	 * @param idArgomento the id argomento
	 * @param posizione the posizione
	 * @return the number of matching domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArgomento_Pos(long idArgomento, int posizione)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARGOMENTO_POS;

		Object[] finderArgs = new Object[] { idArgomento, posizione };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOMANDA_WHERE);

			query.append(_FINDER_COLUMN_ARGOMENTO_POS_IDARGOMENTO_2);

			query.append(_FINDER_COLUMN_ARGOMENTO_POS_POSIZIONE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idArgomento);

				qPos.add(posizione);

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

	private static final String _FINDER_COLUMN_ARGOMENTO_POS_IDARGOMENTO_2 = "domanda.idArgomento = ? AND ";
	private static final String _FINDER_COLUMN_ARGOMENTO_POS_POSIZIONE_2 = "domanda.posizione = ?";

	public DomandaPersistenceImpl() {
		setModelClass(Domanda.class);
	}

	/**
	 * Caches the domanda in the entity cache if it is enabled.
	 *
	 * @param domanda the domanda
	 */
	@Override
	public void cacheResult(Domanda domanda) {
		EntityCacheUtil.putResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaImpl.class, domanda.getPrimaryKey(), domanda);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { domanda.getUuid(), domanda.getGroupId() }, domanda);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
			new Object[] { domanda.getIdArgomento(), domanda.getPosizione() },
			domanda);

		domanda.resetOriginalValues();
	}

	/**
	 * Caches the domandas in the entity cache if it is enabled.
	 *
	 * @param domandas the domandas
	 */
	@Override
	public void cacheResult(List<Domanda> domandas) {
		for (Domanda domanda : domandas) {
			if (EntityCacheUtil.getResult(
						DomandaModelImpl.ENTITY_CACHE_ENABLED,
						DomandaImpl.class, domanda.getPrimaryKey()) == null) {
				cacheResult(domanda);
			}
			else {
				domanda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all domandas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DomandaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DomandaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the domanda.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Domanda domanda) {
		EntityCacheUtil.removeResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaImpl.class, domanda.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(domanda);
	}

	@Override
	public void clearCache(List<Domanda> domandas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Domanda domanda : domandas) {
			EntityCacheUtil.removeResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
				DomandaImpl.class, domanda.getPrimaryKey());

			clearUniqueFindersCache(domanda);
		}
	}

	protected void cacheUniqueFindersCache(Domanda domanda) {
		if (domanda.isNew()) {
			Object[] args = new Object[] { domanda.getUuid(), domanda.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, domanda);

			args = new Object[] { domanda.getIdArgomento(), domanda.getPosizione() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARGOMENTO_POS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS, args,
				domanda);
		}
		else {
			DomandaModelImpl domandaModelImpl = (DomandaModelImpl)domanda;

			if ((domandaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						domanda.getUuid(), domanda.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					domanda);
			}

			if ((domandaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ARGOMENTO_POS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						domanda.getIdArgomento(), domanda.getPosizione()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARGOMENTO_POS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
					args, domanda);
			}
		}
	}

	protected void clearUniqueFindersCache(Domanda domanda) {
		DomandaModelImpl domandaModelImpl = (DomandaModelImpl)domanda;

		Object[] args = new Object[] { domanda.getUuid(), domanda.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((domandaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					domandaModelImpl.getOriginalUuid(),
					domandaModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { domanda.getIdArgomento(), domanda.getPosizione() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARGOMENTO_POS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS, args);

		if ((domandaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ARGOMENTO_POS.getColumnBitmask()) != 0) {
			args = new Object[] {
					domandaModelImpl.getOriginalIdArgomento(),
					domandaModelImpl.getOriginalPosizione()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARGOMENTO_POS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARGOMENTO_POS,
				args);
		}
	}

	/**
	 * Creates a new domanda with the primary key. Does not add the domanda to the database.
	 *
	 * @param idDomanda the primary key for the new domanda
	 * @return the new domanda
	 */
	@Override
	public Domanda create(long idDomanda) {
		Domanda domanda = new DomandaImpl();

		domanda.setNew(true);
		domanda.setPrimaryKey(idDomanda);

		String uuid = PortalUUIDUtil.generate();

		domanda.setUuid(uuid);

		return domanda;
	}

	/**
	 * Removes the domanda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDomanda the primary key of the domanda
	 * @return the domanda that was removed
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda remove(long idDomanda)
		throws NoSuchDomandaException, SystemException {
		return remove((Serializable)idDomanda);
	}

	/**
	 * Removes the domanda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the domanda
	 * @return the domanda that was removed
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda remove(Serializable primaryKey)
		throws NoSuchDomandaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Domanda domanda = (Domanda)session.get(DomandaImpl.class, primaryKey);

			if (domanda == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDomandaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(domanda);
		}
		catch (NoSuchDomandaException nsee) {
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
	protected Domanda removeImpl(Domanda domanda) throws SystemException {
		domanda = toUnwrappedModel(domanda);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(domanda)) {
				domanda = (Domanda)session.get(DomandaImpl.class,
						domanda.getPrimaryKeyObj());
			}

			if (domanda != null) {
				session.delete(domanda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (domanda != null) {
			clearCache(domanda);
		}

		return domanda;
	}

	@Override
	public Domanda updateImpl(it.quizscuola.portlet.model.Domanda domanda)
		throws SystemException {
		domanda = toUnwrappedModel(domanda);

		boolean isNew = domanda.isNew();

		DomandaModelImpl domandaModelImpl = (DomandaModelImpl)domanda;

		if (Validator.isNull(domanda.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			domanda.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (domanda.isNew()) {
				session.save(domanda);

				domanda.setNew(false);
			}
			else {
				session.merge(domanda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DomandaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((domandaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { domandaModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { domandaModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((domandaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						domandaModelImpl.getOriginalUuid(),
						domandaModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						domandaModelImpl.getUuid(),
						domandaModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((domandaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARGOMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						domandaModelImpl.getOriginalIdArgomento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARGOMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARGOMENTO,
					args);

				args = new Object[] { domandaModelImpl.getIdArgomento() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARGOMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARGOMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
			DomandaImpl.class, domanda.getPrimaryKey(), domanda);

		clearUniqueFindersCache(domanda);
		cacheUniqueFindersCache(domanda);

		return domanda;
	}

	protected Domanda toUnwrappedModel(Domanda domanda) {
		if (domanda instanceof DomandaImpl) {
			return domanda;
		}

		DomandaImpl domandaImpl = new DomandaImpl();

		domandaImpl.setNew(domanda.isNew());
		domandaImpl.setPrimaryKey(domanda.getPrimaryKey());

		domandaImpl.setUuid(domanda.getUuid());
		domandaImpl.setIdDomanda(domanda.getIdDomanda());
		domandaImpl.setDescDomanda(domanda.getDescDomanda());
		domandaImpl.setIdArgomento(domanda.getIdArgomento());
		domandaImpl.setGroupId(domanda.getGroupId());
		domandaImpl.setCompanyId(domanda.getCompanyId());
		domandaImpl.setUserId(domanda.getUserId());
		domandaImpl.setUserName(domanda.getUserName());
		domandaImpl.setCreateDate(domanda.getCreateDate());
		domandaImpl.setModifiedDate(domanda.getModifiedDate());
		domandaImpl.setPosizione(domanda.getPosizione());

		return domandaImpl;
	}

	/**
	 * Returns the domanda with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the domanda
	 * @return the domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDomandaException, SystemException {
		Domanda domanda = fetchByPrimaryKey(primaryKey);

		if (domanda == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDomandaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return domanda;
	}

	/**
	 * Returns the domanda with the primary key or throws a {@link it.quizscuola.portlet.NoSuchDomandaException} if it could not be found.
	 *
	 * @param idDomanda the primary key of the domanda
	 * @return the domanda
	 * @throws it.quizscuola.portlet.NoSuchDomandaException if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda findByPrimaryKey(long idDomanda)
		throws NoSuchDomandaException, SystemException {
		return findByPrimaryKey((Serializable)idDomanda);
	}

	/**
	 * Returns the domanda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the domanda
	 * @return the domanda, or <code>null</code> if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Domanda domanda = (Domanda)EntityCacheUtil.getResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
				DomandaImpl.class, primaryKey);

		if (domanda == _nullDomanda) {
			return null;
		}

		if (domanda == null) {
			Session session = null;

			try {
				session = openSession();

				domanda = (Domanda)session.get(DomandaImpl.class, primaryKey);

				if (domanda != null) {
					cacheResult(domanda);
				}
				else {
					EntityCacheUtil.putResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
						DomandaImpl.class, primaryKey, _nullDomanda);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DomandaModelImpl.ENTITY_CACHE_ENABLED,
					DomandaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return domanda;
	}

	/**
	 * Returns the domanda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDomanda the primary key of the domanda
	 * @return the domanda, or <code>null</code> if a domanda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Domanda fetchByPrimaryKey(long idDomanda) throws SystemException {
		return fetchByPrimaryKey((Serializable)idDomanda);
	}

	/**
	 * Returns all the domandas.
	 *
	 * @return the domandas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Domanda> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Domanda> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Domanda> findAll(int start, int end,
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

		List<Domanda> list = (List<Domanda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOMANDA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOMANDA;

				if (pagination) {
					sql = sql.concat(DomandaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Domanda>(list);
				}
				else {
					list = (List<Domanda>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the domandas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Domanda domanda : findAll()) {
			remove(domanda);
		}
	}

	/**
	 * Returns the number of domandas.
	 *
	 * @return the number of domandas
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

				Query q = session.createQuery(_SQL_COUNT_DOMANDA);

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
	 * Initializes the domanda persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.quizscuola.portlet.model.Domanda")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Domanda>> listenersList = new ArrayList<ModelListener<Domanda>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Domanda>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DomandaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOMANDA = "SELECT domanda FROM Domanda domanda";
	private static final String _SQL_SELECT_DOMANDA_WHERE = "SELECT domanda FROM Domanda domanda WHERE ";
	private static final String _SQL_COUNT_DOMANDA = "SELECT COUNT(domanda) FROM Domanda domanda";
	private static final String _SQL_COUNT_DOMANDA_WHERE = "SELECT COUNT(domanda) FROM Domanda domanda WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "domanda.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Domanda exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Domanda exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DomandaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Domanda _nullDomanda = new DomandaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Domanda> toCacheModel() {
				return _nullDomandaCacheModel;
			}
		};

	private static CacheModel<Domanda> _nullDomandaCacheModel = new CacheModel<Domanda>() {
			@Override
			public Domanda toEntityModel() {
				return _nullDomanda;
			}
		};
}