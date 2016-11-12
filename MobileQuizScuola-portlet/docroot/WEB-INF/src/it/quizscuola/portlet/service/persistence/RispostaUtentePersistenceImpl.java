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

import it.quizscuola.portlet.NoSuchRispostaUtenteException;
import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.model.impl.RispostaUtenteImpl;
import it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the risposta utente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Salvatore
 * @see RispostaUtentePersistence
 * @see RispostaUtenteUtil
 * @generated
 */
public class RispostaUtentePersistenceImpl extends BasePersistenceImpl<RispostaUtente>
	implements RispostaUtentePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RispostaUtenteUtil} to access the risposta utente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RispostaUtenteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RispostaUtenteModelImpl.UUID_COLUMN_BITMASK |
			RispostaUtenteModelImpl.IDDOMANDA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the risposta utentes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RispostaUtente> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RispostaUtente> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<RispostaUtente> findByUuid(String uuid, int start, int end,
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

		List<RispostaUtente> list = (List<RispostaUtente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RispostaUtente rispostaUtente : list) {
				if (!Validator.equals(uuid, rispostaUtente.getUuid())) {
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

			query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

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
				query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
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
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RispostaUtente>(list);
				}
				else {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first risposta utente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByUuid_First(uuid,
				orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the first risposta utente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RispostaUtente> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RispostaUtente findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByUuid_Last(uuid, orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the last risposta utente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RispostaUtente> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RispostaUtente[] findByUuid_PrevAndNext(long idRispostaUtente,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = findByPrimaryKey(idRispostaUtente);

		Session session = null;

		try {
			session = openSession();

			RispostaUtente[] array = new RispostaUtenteImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rispostaUtente, uuid,
					orderByComparator, true);

			array[1] = rispostaUtente;

			array[2] = getByUuid_PrevAndNext(session, rispostaUtente, uuid,
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

	protected RispostaUtente getByUuid_PrevAndNext(Session session,
		RispostaUtente rispostaUtente, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

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
			query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rispostaUtente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RispostaUtente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the risposta utentes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RispostaUtente rispostaUtente : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rispostaUtente);
		}
	}

	/**
	 * Returns the number of risposta utentes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching risposta utentes
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

			query.append(_SQL_COUNT_RISPOSTAUTENTE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rispostaUtente.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rispostaUtente.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rispostaUtente.uuid IS NULL OR rispostaUtente.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDUTENTE = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdUtente",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDUTENTE =
		new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdUtente",
			new String[] { Long.class.getName() },
			RispostaUtenteModelImpl.IDUTENTE_COLUMN_BITMASK |
			RispostaUtenteModelImpl.IDDOMANDA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDUTENTE = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdUtente",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the risposta utentes where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @return the matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RispostaUtente> findByIdUtente(long idUtente)
		throws SystemException {
		return findByIdUtente(idUtente, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<RispostaUtente> findByIdUtente(long idUtente, int start, int end)
		throws SystemException {
		return findByIdUtente(idUtente, start, end, null);
	}

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
	@Override
	public List<RispostaUtente> findByIdUtente(long idUtente, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDUTENTE;
			finderArgs = new Object[] { idUtente };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDUTENTE;
			finderArgs = new Object[] { idUtente, start, end, orderByComparator };
		}

		List<RispostaUtente> list = (List<RispostaUtente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RispostaUtente rispostaUtente : list) {
				if ((idUtente != rispostaUtente.getIdUtente())) {
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

			query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDUTENTE_IDUTENTE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idUtente);

				if (!pagination) {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RispostaUtente>(list);
				}
				else {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first risposta utente in the ordered set where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByIdUtente_First(long idUtente,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByIdUtente_First(idUtente,
				orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idUtente=");
		msg.append(idUtente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the first risposta utente in the ordered set where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByIdUtente_First(long idUtente,
		OrderByComparator orderByComparator) throws SystemException {
		List<RispostaUtente> list = findByIdUtente(idUtente, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last risposta utente in the ordered set where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByIdUtente_Last(long idUtente,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByIdUtente_Last(idUtente,
				orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idUtente=");
		msg.append(idUtente);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the last risposta utente in the ordered set where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByIdUtente_Last(long idUtente,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIdUtente(idUtente);

		if (count == 0) {
			return null;
		}

		List<RispostaUtente> list = findByIdUtente(idUtente, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public RispostaUtente[] findByIdUtente_PrevAndNext(long idRispostaUtente,
		long idUtente, OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = findByPrimaryKey(idRispostaUtente);

		Session session = null;

		try {
			session = openSession();

			RispostaUtente[] array = new RispostaUtenteImpl[3];

			array[0] = getByIdUtente_PrevAndNext(session, rispostaUtente,
					idUtente, orderByComparator, true);

			array[1] = rispostaUtente;

			array[2] = getByIdUtente_PrevAndNext(session, rispostaUtente,
					idUtente, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RispostaUtente getByIdUtente_PrevAndNext(Session session,
		RispostaUtente rispostaUtente, long idUtente,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

		query.append(_FINDER_COLUMN_IDUTENTE_IDUTENTE_2);

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
			query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idUtente);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rispostaUtente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RispostaUtente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the risposta utentes where idUtente = &#63; from the database.
	 *
	 * @param idUtente the id utente
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIdUtente(long idUtente) throws SystemException {
		for (RispostaUtente rispostaUtente : findByIdUtente(idUtente,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rispostaUtente);
		}
	}

	/**
	 * Returns the number of risposta utentes where idUtente = &#63;.
	 *
	 * @param idUtente the id utente
	 * @return the number of matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdUtente(long idUtente) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDUTENTE;

		Object[] finderArgs = new Object[] { idUtente };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDUTENTE_IDUTENTE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idUtente);

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

	private static final String _FINDER_COLUMN_IDUTENTE_IDUTENTE_2 = "rispostaUtente.idUtente = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDDOMANDA =
		new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByidDomanda",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDDOMANDA =
		new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByidDomanda",
			new String[] { Long.class.getName() },
			RispostaUtenteModelImpl.IDDOMANDA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDDOMANDA = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByidDomanda",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the risposta utentes where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @return the matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RispostaUtente> findByidDomanda(long idDomanda)
		throws SystemException {
		return findByidDomanda(idDomanda, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<RispostaUtente> findByidDomanda(long idDomanda, int start,
		int end) throws SystemException {
		return findByidDomanda(idDomanda, start, end, null);
	}

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
	@Override
	public List<RispostaUtente> findByidDomanda(long idDomanda, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDDOMANDA;
			finderArgs = new Object[] { idDomanda };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDDOMANDA;
			finderArgs = new Object[] { idDomanda, start, end, orderByComparator };
		}

		List<RispostaUtente> list = (List<RispostaUtente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RispostaUtente rispostaUtente : list) {
				if ((idDomanda != rispostaUtente.getIdDomanda())) {
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

			query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDDOMANDA_IDDOMANDA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idDomanda);

				if (!pagination) {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RispostaUtente>(list);
				}
				else {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first risposta utente in the ordered set where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByidDomanda_First(long idDomanda,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByidDomanda_First(idDomanda,
				orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idDomanda=");
		msg.append(idDomanda);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the first risposta utente in the ordered set where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByidDomanda_First(long idDomanda,
		OrderByComparator orderByComparator) throws SystemException {
		List<RispostaUtente> list = findByidDomanda(idDomanda, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last risposta utente in the ordered set where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByidDomanda_Last(long idDomanda,
		OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByidDomanda_Last(idDomanda,
				orderByComparator);

		if (rispostaUtente != null) {
			return rispostaUtente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idDomanda=");
		msg.append(idDomanda);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRispostaUtenteException(msg.toString());
	}

	/**
	 * Returns the last risposta utente in the ordered set where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByidDomanda_Last(long idDomanda,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByidDomanda(idDomanda);

		if (count == 0) {
			return null;
		}

		List<RispostaUtente> list = findByidDomanda(idDomanda, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public RispostaUtente[] findByidDomanda_PrevAndNext(long idRispostaUtente,
		long idDomanda, OrderByComparator orderByComparator)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = findByPrimaryKey(idRispostaUtente);

		Session session = null;

		try {
			session = openSession();

			RispostaUtente[] array = new RispostaUtenteImpl[3];

			array[0] = getByidDomanda_PrevAndNext(session, rispostaUtente,
					idDomanda, orderByComparator, true);

			array[1] = rispostaUtente;

			array[2] = getByidDomanda_PrevAndNext(session, rispostaUtente,
					idDomanda, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RispostaUtente getByidDomanda_PrevAndNext(Session session,
		RispostaUtente rispostaUtente, long idDomanda,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

		query.append(_FINDER_COLUMN_IDDOMANDA_IDDOMANDA_2);

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
			query.append(RispostaUtenteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idDomanda);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rispostaUtente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RispostaUtente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the risposta utentes where idDomanda = &#63; from the database.
	 *
	 * @param idDomanda the id domanda
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByidDomanda(long idDomanda) throws SystemException {
		for (RispostaUtente rispostaUtente : findByidDomanda(idDomanda,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rispostaUtente);
		}
	}

	/**
	 * Returns the number of risposta utentes where idDomanda = &#63;.
	 *
	 * @param idDomanda the id domanda
	 * @return the number of matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByidDomanda(long idDomanda) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDDOMANDA;

		Object[] finderArgs = new Object[] { idDomanda };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDDOMANDA_IDDOMANDA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idDomanda);

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

	private static final String _FINDER_COLUMN_IDDOMANDA_IDDOMANDA_2 = "rispostaUtente.idDomanda = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED,
			RispostaUtenteImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIdUtente_Domanda",
			new String[] { Long.class.getName(), Long.class.getName() },
			RispostaUtenteModelImpl.IDUTENTE_COLUMN_BITMASK |
			RispostaUtenteModelImpl.IDDOMANDA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA = new FinderPath(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdUtente_Domanda",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or throws a {@link it.quizscuola.portlet.NoSuchRispostaUtenteException} if it could not be found.
	 *
	 * @param idUtente the id utente
	 * @param idDomanda the id domanda
	 * @return the matching risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByIdUtente_Domanda(long idUtente, long idDomanda)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByIdUtente_Domanda(idUtente,
				idDomanda);

		if (rispostaUtente == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idUtente=");
			msg.append(idUtente);

			msg.append(", idDomanda=");
			msg.append(idDomanda);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRispostaUtenteException(msg.toString());
		}

		return rispostaUtente;
	}

	/**
	 * Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idUtente the id utente
	 * @param idDomanda the id domanda
	 * @return the matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByIdUtente_Domanda(long idUtente, long idDomanda)
		throws SystemException {
		return fetchByIdUtente_Domanda(idUtente, idDomanda, true);
	}

	/**
	 * Returns the risposta utente where idUtente = &#63; and idDomanda = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idUtente the id utente
	 * @param idDomanda the id domanda
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching risposta utente, or <code>null</code> if a matching risposta utente could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByIdUtente_Domanda(long idUtente,
		long idDomanda, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { idUtente, idDomanda };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
					finderArgs, this);
		}

		if (result instanceof RispostaUtente) {
			RispostaUtente rispostaUtente = (RispostaUtente)result;

			if ((idUtente != rispostaUtente.getIdUtente()) ||
					(idDomanda != rispostaUtente.getIdDomanda())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDUTENTE_DOMANDA_IDUTENTE_2);

			query.append(_FINDER_COLUMN_IDUTENTE_DOMANDA_IDDOMANDA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idUtente);

				qPos.add(idDomanda);

				List<RispostaUtente> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RispostaUtentePersistenceImpl.fetchByIdUtente_Domanda(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					RispostaUtente rispostaUtente = list.get(0);

					result = rispostaUtente;

					cacheResult(rispostaUtente);

					if ((rispostaUtente.getIdUtente() != idUtente) ||
							(rispostaUtente.getIdDomanda() != idDomanda)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
							finderArgs, rispostaUtente);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
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
			return (RispostaUtente)result;
		}
	}

	/**
	 * Removes the risposta utente where idUtente = &#63; and idDomanda = &#63; from the database.
	 *
	 * @param idUtente the id utente
	 * @param idDomanda the id domanda
	 * @return the risposta utente that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente removeByIdUtente_Domanda(long idUtente, long idDomanda)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = findByIdUtente_Domanda(idUtente,
				idDomanda);

		return remove(rispostaUtente);
	}

	/**
	 * Returns the number of risposta utentes where idUtente = &#63; and idDomanda = &#63;.
	 *
	 * @param idUtente the id utente
	 * @param idDomanda the id domanda
	 * @return the number of matching risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdUtente_Domanda(long idUtente, long idDomanda)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA;

		Object[] finderArgs = new Object[] { idUtente, idDomanda };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RISPOSTAUTENTE_WHERE);

			query.append(_FINDER_COLUMN_IDUTENTE_DOMANDA_IDUTENTE_2);

			query.append(_FINDER_COLUMN_IDUTENTE_DOMANDA_IDDOMANDA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idUtente);

				qPos.add(idDomanda);

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

	private static final String _FINDER_COLUMN_IDUTENTE_DOMANDA_IDUTENTE_2 = "rispostaUtente.idUtente = ? AND ";
	private static final String _FINDER_COLUMN_IDUTENTE_DOMANDA_IDDOMANDA_2 = "rispostaUtente.idDomanda = ?";

	public RispostaUtentePersistenceImpl() {
		setModelClass(RispostaUtente.class);
	}

	/**
	 * Caches the risposta utente in the entity cache if it is enabled.
	 *
	 * @param rispostaUtente the risposta utente
	 */
	@Override
	public void cacheResult(RispostaUtente rispostaUtente) {
		EntityCacheUtil.putResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteImpl.class, rispostaUtente.getPrimaryKey(),
			rispostaUtente);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
			new Object[] {
				rispostaUtente.getIdUtente(), rispostaUtente.getIdDomanda()
			}, rispostaUtente);

		rispostaUtente.resetOriginalValues();
	}

	/**
	 * Caches the risposta utentes in the entity cache if it is enabled.
	 *
	 * @param rispostaUtentes the risposta utentes
	 */
	@Override
	public void cacheResult(List<RispostaUtente> rispostaUtentes) {
		for (RispostaUtente rispostaUtente : rispostaUtentes) {
			if (EntityCacheUtil.getResult(
						RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
						RispostaUtenteImpl.class, rispostaUtente.getPrimaryKey()) == null) {
				cacheResult(rispostaUtente);
			}
			else {
				rispostaUtente.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all risposta utentes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RispostaUtenteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RispostaUtenteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the risposta utente.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RispostaUtente rispostaUtente) {
		EntityCacheUtil.removeResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteImpl.class, rispostaUtente.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rispostaUtente);
	}

	@Override
	public void clearCache(List<RispostaUtente> rispostaUtentes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RispostaUtente rispostaUtente : rispostaUtentes) {
			EntityCacheUtil.removeResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
				RispostaUtenteImpl.class, rispostaUtente.getPrimaryKey());

			clearUniqueFindersCache(rispostaUtente);
		}
	}

	protected void cacheUniqueFindersCache(RispostaUtente rispostaUtente) {
		if (rispostaUtente.isNew()) {
			Object[] args = new Object[] {
					rispostaUtente.getIdUtente(), rispostaUtente.getIdDomanda()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
				args, rispostaUtente);
		}
		else {
			RispostaUtenteModelImpl rispostaUtenteModelImpl = (RispostaUtenteModelImpl)rispostaUtente;

			if ((rispostaUtenteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rispostaUtente.getIdUtente(),
						rispostaUtente.getIdDomanda()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
					args, rispostaUtente);
			}
		}
	}

	protected void clearUniqueFindersCache(RispostaUtente rispostaUtente) {
		RispostaUtenteModelImpl rispostaUtenteModelImpl = (RispostaUtenteModelImpl)rispostaUtente;

		Object[] args = new Object[] {
				rispostaUtente.getIdUtente(), rispostaUtente.getIdDomanda()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA, args);

		if ((rispostaUtenteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA.getColumnBitmask()) != 0) {
			args = new Object[] {
					rispostaUtenteModelImpl.getOriginalIdUtente(),
					rispostaUtenteModelImpl.getOriginalIdDomanda()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDUTENTE_DOMANDA,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDUTENTE_DOMANDA,
				args);
		}
	}

	/**
	 * Creates a new risposta utente with the primary key. Does not add the risposta utente to the database.
	 *
	 * @param idRispostaUtente the primary key for the new risposta utente
	 * @return the new risposta utente
	 */
	@Override
	public RispostaUtente create(long idRispostaUtente) {
		RispostaUtente rispostaUtente = new RispostaUtenteImpl();

		rispostaUtente.setNew(true);
		rispostaUtente.setPrimaryKey(idRispostaUtente);

		String uuid = PortalUUIDUtil.generate();

		rispostaUtente.setUuid(uuid);

		return rispostaUtente;
	}

	/**
	 * Removes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idRispostaUtente the primary key of the risposta utente
	 * @return the risposta utente that was removed
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente remove(long idRispostaUtente)
		throws NoSuchRispostaUtenteException, SystemException {
		return remove((Serializable)idRispostaUtente);
	}

	/**
	 * Removes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the risposta utente
	 * @return the risposta utente that was removed
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente remove(Serializable primaryKey)
		throws NoSuchRispostaUtenteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RispostaUtente rispostaUtente = (RispostaUtente)session.get(RispostaUtenteImpl.class,
					primaryKey);

			if (rispostaUtente == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRispostaUtenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rispostaUtente);
		}
		catch (NoSuchRispostaUtenteException nsee) {
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
	protected RispostaUtente removeImpl(RispostaUtente rispostaUtente)
		throws SystemException {
		rispostaUtente = toUnwrappedModel(rispostaUtente);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rispostaUtente)) {
				rispostaUtente = (RispostaUtente)session.get(RispostaUtenteImpl.class,
						rispostaUtente.getPrimaryKeyObj());
			}

			if (rispostaUtente != null) {
				session.delete(rispostaUtente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rispostaUtente != null) {
			clearCache(rispostaUtente);
		}

		return rispostaUtente;
	}

	@Override
	public RispostaUtente updateImpl(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente)
		throws SystemException {
		rispostaUtente = toUnwrappedModel(rispostaUtente);

		boolean isNew = rispostaUtente.isNew();

		RispostaUtenteModelImpl rispostaUtenteModelImpl = (RispostaUtenteModelImpl)rispostaUtente;

		if (Validator.isNull(rispostaUtente.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rispostaUtente.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rispostaUtente.isNew()) {
				session.save(rispostaUtente);

				rispostaUtente.setNew(false);
			}
			else {
				session.merge(rispostaUtente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RispostaUtenteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rispostaUtenteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rispostaUtenteModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rispostaUtenteModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rispostaUtenteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDUTENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rispostaUtenteModelImpl.getOriginalIdUtente()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDUTENTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDUTENTE,
					args);

				args = new Object[] { rispostaUtenteModelImpl.getIdUtente() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDUTENTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDUTENTE,
					args);
			}

			if ((rispostaUtenteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDDOMANDA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rispostaUtenteModelImpl.getOriginalIdDomanda()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDDOMANDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDDOMANDA,
					args);

				args = new Object[] { rispostaUtenteModelImpl.getIdDomanda() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDDOMANDA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDDOMANDA,
					args);
			}
		}

		EntityCacheUtil.putResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
			RispostaUtenteImpl.class, rispostaUtente.getPrimaryKey(),
			rispostaUtente);

		clearUniqueFindersCache(rispostaUtente);
		cacheUniqueFindersCache(rispostaUtente);

		return rispostaUtente;
	}

	protected RispostaUtente toUnwrappedModel(RispostaUtente rispostaUtente) {
		if (rispostaUtente instanceof RispostaUtenteImpl) {
			return rispostaUtente;
		}

		RispostaUtenteImpl rispostaUtenteImpl = new RispostaUtenteImpl();

		rispostaUtenteImpl.setNew(rispostaUtente.isNew());
		rispostaUtenteImpl.setPrimaryKey(rispostaUtente.getPrimaryKey());

		rispostaUtenteImpl.setUuid(rispostaUtente.getUuid());
		rispostaUtenteImpl.setIdRispostaUtente(rispostaUtente.getIdRispostaUtente());
		rispostaUtenteImpl.setIdRisposta(rispostaUtente.getIdRisposta());
		rispostaUtenteImpl.setIdUtente(rispostaUtente.getIdUtente());
		rispostaUtenteImpl.setDataRisposta(rispostaUtente.getDataRisposta());
		rispostaUtenteImpl.setIdDomanda(rispostaUtente.getIdDomanda());

		return rispostaUtenteImpl;
	}

	/**
	 * Returns the risposta utente with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the risposta utente
	 * @return the risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRispostaUtenteException, SystemException {
		RispostaUtente rispostaUtente = fetchByPrimaryKey(primaryKey);

		if (rispostaUtente == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRispostaUtenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rispostaUtente;
	}

	/**
	 * Returns the risposta utente with the primary key or throws a {@link it.quizscuola.portlet.NoSuchRispostaUtenteException} if it could not be found.
	 *
	 * @param idRispostaUtente the primary key of the risposta utente
	 * @return the risposta utente
	 * @throws it.quizscuola.portlet.NoSuchRispostaUtenteException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente findByPrimaryKey(long idRispostaUtente)
		throws NoSuchRispostaUtenteException, SystemException {
		return findByPrimaryKey((Serializable)idRispostaUtente);
	}

	/**
	 * Returns the risposta utente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the risposta utente
	 * @return the risposta utente, or <code>null</code> if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RispostaUtente rispostaUtente = (RispostaUtente)EntityCacheUtil.getResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
				RispostaUtenteImpl.class, primaryKey);

		if (rispostaUtente == _nullRispostaUtente) {
			return null;
		}

		if (rispostaUtente == null) {
			Session session = null;

			try {
				session = openSession();

				rispostaUtente = (RispostaUtente)session.get(RispostaUtenteImpl.class,
						primaryKey);

				if (rispostaUtente != null) {
					cacheResult(rispostaUtente);
				}
				else {
					EntityCacheUtil.putResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
						RispostaUtenteImpl.class, primaryKey,
						_nullRispostaUtente);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RispostaUtenteModelImpl.ENTITY_CACHE_ENABLED,
					RispostaUtenteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rispostaUtente;
	}

	/**
	 * Returns the risposta utente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idRispostaUtente the primary key of the risposta utente
	 * @return the risposta utente, or <code>null</code> if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente fetchByPrimaryKey(long idRispostaUtente)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)idRispostaUtente);
	}

	/**
	 * Returns all the risposta utentes.
	 *
	 * @return the risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RispostaUtente> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RispostaUtente> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<RispostaUtente> findAll(int start, int end,
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

		List<RispostaUtente> list = (List<RispostaUtente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RISPOSTAUTENTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RISPOSTAUTENTE;

				if (pagination) {
					sql = sql.concat(RispostaUtenteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RispostaUtente>(list);
				}
				else {
					list = (List<RispostaUtente>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the risposta utentes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RispostaUtente rispostaUtente : findAll()) {
			remove(rispostaUtente);
		}
	}

	/**
	 * Returns the number of risposta utentes.
	 *
	 * @return the number of risposta utentes
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

				Query q = session.createQuery(_SQL_COUNT_RISPOSTAUTENTE);

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
	 * Initializes the risposta utente persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.quizscuola.portlet.model.RispostaUtente")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RispostaUtente>> listenersList = new ArrayList<ModelListener<RispostaUtente>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RispostaUtente>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RispostaUtenteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RISPOSTAUTENTE = "SELECT rispostaUtente FROM RispostaUtente rispostaUtente";
	private static final String _SQL_SELECT_RISPOSTAUTENTE_WHERE = "SELECT rispostaUtente FROM RispostaUtente rispostaUtente WHERE ";
	private static final String _SQL_COUNT_RISPOSTAUTENTE = "SELECT COUNT(rispostaUtente) FROM RispostaUtente rispostaUtente";
	private static final String _SQL_COUNT_RISPOSTAUTENTE_WHERE = "SELECT COUNT(rispostaUtente) FROM RispostaUtente rispostaUtente WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rispostaUtente.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RispostaUtente exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RispostaUtente exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RispostaUtentePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RispostaUtente _nullRispostaUtente = new RispostaUtenteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RispostaUtente> toCacheModel() {
				return _nullRispostaUtenteCacheModel;
			}
		};

	private static CacheModel<RispostaUtente> _nullRispostaUtenteCacheModel = new CacheModel<RispostaUtente>() {
			@Override
			public RispostaUtente toEntityModel() {
				return _nullRispostaUtente;
			}
		};
}