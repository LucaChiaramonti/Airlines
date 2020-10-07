/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package it.airlines.manager.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.airlines.manager.exception.NoSuchFlightException;
import it.airlines.manager.model.Flight;
import it.airlines.manager.model.impl.FlightImpl;
import it.airlines.manager.model.impl.FlightModelImpl;
import it.airlines.manager.service.persistence.FlightPersistence;
import it.airlines.manager.service.persistence.impl.constants.AMPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the flight service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FlightPersistence.class)
public class FlightPersistenceImpl
	extends BasePersistenceImpl<Flight> implements FlightPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FlightUtil</code> to access the flight persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FlightImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching flights
	 */
	@Override
	public List<Flight> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of matching flights
	 */
	@Override
	public List<Flight> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Flight> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Flight> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Flight> list = null;

		if (useFinderCache) {
			list = (List<Flight>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Flight flight : list) {
					if (!uuid.equals(flight.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Flight>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByUuid_First(
			String uuid, OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByUuid_First(uuid, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUuid_First(
		String uuid, OrderByComparator<Flight> orderByComparator) {

		List<Flight> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByUuid_Last(
			String uuid, OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByUuid_Last(uuid, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUuid_Last(
		String uuid, OrderByComparator<Flight> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Flight> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flights before and after the current flight in the ordered set where uuid = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight[] findByUuid_PrevAndNext(
			long flightId, String uuid,
			OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		uuid = Objects.toString(uuid, "");

		Flight flight = findByPrimaryKey(flightId);

		Session session = null;

		try {
			session = openSession();

			Flight[] array = new FlightImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, flight, uuid, orderByComparator, true);

			array[1] = flight;

			array[2] = getByUuid_PrevAndNext(
				session, flight, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Flight getByUuid_PrevAndNext(
		Session session, Flight flight, String uuid,
		OrderByComparator<Flight> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FLIGHT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(flight)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Flight> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flights where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Flight flight :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(flight);
		}
	}

	/**
	 * Returns the number of flights where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching flights
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "flight.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(flight.uuid IS NULL OR flight.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByUUID_G(String uuid, long groupId)
		throws NoSuchFlightException {

		Flight flight = fetchByUUID_G(uuid, groupId);

		if (flight == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFlightException(sb.toString());
		}

		return flight;
	}

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the flight where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Flight) {
			Flight flight = (Flight)result;

			if (!Objects.equals(uuid, flight.getUuid()) ||
				(groupId != flight.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Flight> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Flight flight = list.get(0);

					result = flight;

					cacheResult(flight);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Flight)result;
		}
	}

	/**
	 * Removes the flight where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the flight that was removed
	 */
	@Override
	public Flight removeByUUID_G(String uuid, long groupId)
		throws NoSuchFlightException {

		Flight flight = findByUUID_G(uuid, groupId);

		return remove(flight);
	}

	/**
	 * Returns the number of flights where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching flights
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"flight.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(flight.uuid IS NULL OR flight.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"flight.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching flights
	 */
	@Override
	public List<Flight> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of matching flights
	 */
	@Override
	public List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Flight> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flights where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Flight> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Flight> list = null;

		if (useFinderCache) {
			list = (List<Flight>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Flight flight : list) {
					if (!uuid.equals(flight.getUuid()) ||
						(companyId != flight.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Flight>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the first flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Flight> orderByComparator) {

		List<Flight> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the last flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Flight> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Flight> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flights before and after the current flight in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight[] findByUuid_C_PrevAndNext(
			long flightId, String uuid, long companyId,
			OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		uuid = Objects.toString(uuid, "");

		Flight flight = findByPrimaryKey(flightId);

		Session session = null;

		try {
			session = openSession();

			Flight[] array = new FlightImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, flight, uuid, companyId, orderByComparator, true);

			array[1] = flight;

			array[2] = getByUuid_C_PrevAndNext(
				session, flight, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Flight getByUuid_C_PrevAndNext(
		Session session, Flight flight, String uuid, long companyId,
		OrderByComparator<Flight> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FLIGHT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(flight)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Flight> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flights where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Flight flight :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(flight);
		}
	}

	/**
	 * Returns the number of flights where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching flights
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FLIGHT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"flight.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(flight.uuid IS NULL OR flight.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"flight.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDA_AA_DD;
	private FinderPath _finderPathWithoutPaginationFindByDA_AA_DD;
	private FinderPath _finderPathCountByDA_AA_DD;

	/**
	 * Returns all the flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @return the matching flights
	 */
	@Override
	public List<Flight> findByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate) {

		return findByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of matching flights
	 */
	@Override
	public List<Flight> findByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate,
		int start, int end) {

		return findByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate,
		int start, int end, OrderByComparator<Flight> orderByComparator) {

		return findByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching flights
	 */
	@Override
	public List<Flight> findByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate,
		int start, int end, OrderByComparator<Flight> orderByComparator,
		boolean useFinderCache) {

		departureAirport = Objects.toString(departureAirport, "");
		arrivalAirport = Objects.toString(arrivalAirport, "");
		departureDate = Objects.toString(departureDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDA_AA_DD;
				finderArgs = new Object[] {
					departureAirport, arrivalAirport, departureDate
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDA_AA_DD;
			finderArgs = new Object[] {
				departureAirport, arrivalAirport, departureDate, start, end,
				orderByComparator
			};
		}

		List<Flight> list = null;

		if (useFinderCache) {
			list = (List<Flight>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Flight flight : list) {
					if (!departureAirport.equals(
							flight.getDepartureAirport()) ||
						!arrivalAirport.equals(flight.getArrivalAirport()) ||
						!departureDate.equals(flight.getDepartureDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_FLIGHT_WHERE);

			boolean bindDepartureAirport = false;

			if (departureAirport.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_3);
			}
			else {
				bindDepartureAirport = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_2);
			}

			boolean bindArrivalAirport = false;

			if (arrivalAirport.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_3);
			}
			else {
				bindArrivalAirport = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_2);
			}

			boolean bindDepartureDate = false;

			if (departureDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_3);
			}
			else {
				bindDepartureDate = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FlightModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartureAirport) {
					queryPos.add(departureAirport);
				}

				if (bindArrivalAirport) {
					queryPos.add(arrivalAirport);
				}

				if (bindDepartureDate) {
					queryPos.add(departureDate);
				}

				list = (List<Flight>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first flight in the ordered set where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByDA_AA_DD_First(
			String departureAirport, String arrivalAirport,
			String departureDate, OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByDA_AA_DD_First(
			departureAirport, arrivalAirport, departureDate, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departureAirport=");
		sb.append(departureAirport);

		sb.append(", arrivalAirport=");
		sb.append(arrivalAirport);

		sb.append(", departureDate=");
		sb.append(departureDate);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the first flight in the ordered set where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByDA_AA_DD_First(
		String departureAirport, String arrivalAirport, String departureDate,
		OrderByComparator<Flight> orderByComparator) {

		List<Flight> list = findByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flight in the ordered set where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight
	 * @throws NoSuchFlightException if a matching flight could not be found
	 */
	@Override
	public Flight findByDA_AA_DD_Last(
			String departureAirport, String arrivalAirport,
			String departureDate, OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		Flight flight = fetchByDA_AA_DD_Last(
			departureAirport, arrivalAirport, departureDate, orderByComparator);

		if (flight != null) {
			return flight;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departureAirport=");
		sb.append(departureAirport);

		sb.append(", arrivalAirport=");
		sb.append(arrivalAirport);

		sb.append(", departureDate=");
		sb.append(departureDate);

		sb.append("}");

		throw new NoSuchFlightException(sb.toString());
	}

	/**
	 * Returns the last flight in the ordered set where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public Flight fetchByDA_AA_DD_Last(
		String departureAirport, String arrivalAirport, String departureDate,
		OrderByComparator<Flight> orderByComparator) {

		int count = countByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate);

		if (count == 0) {
			return null;
		}

		List<Flight> list = findByDA_AA_DD(
			departureAirport, arrivalAirport, departureDate, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flights before and after the current flight in the ordered set where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param flightId the primary key of the current flight
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight[] findByDA_AA_DD_PrevAndNext(
			long flightId, String departureAirport, String arrivalAirport,
			String departureDate, OrderByComparator<Flight> orderByComparator)
		throws NoSuchFlightException {

		departureAirport = Objects.toString(departureAirport, "");
		arrivalAirport = Objects.toString(arrivalAirport, "");
		departureDate = Objects.toString(departureDate, "");

		Flight flight = findByPrimaryKey(flightId);

		Session session = null;

		try {
			session = openSession();

			Flight[] array = new FlightImpl[3];

			array[0] = getByDA_AA_DD_PrevAndNext(
				session, flight, departureAirport, arrivalAirport,
				departureDate, orderByComparator, true);

			array[1] = flight;

			array[2] = getByDA_AA_DD_PrevAndNext(
				session, flight, departureAirport, arrivalAirport,
				departureDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Flight getByDA_AA_DD_PrevAndNext(
		Session session, Flight flight, String departureAirport,
		String arrivalAirport, String departureDate,
		OrderByComparator<Flight> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_FLIGHT_WHERE);

		boolean bindDepartureAirport = false;

		if (departureAirport.isEmpty()) {
			sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_3);
		}
		else {
			bindDepartureAirport = true;

			sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_2);
		}

		boolean bindArrivalAirport = false;

		if (arrivalAirport.isEmpty()) {
			sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_3);
		}
		else {
			bindArrivalAirport = true;

			sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_2);
		}

		boolean bindDepartureDate = false;

		if (departureDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_3);
		}
		else {
			bindDepartureDate = true;

			sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FlightModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDepartureAirport) {
			queryPos.add(departureAirport);
		}

		if (bindArrivalAirport) {
			queryPos.add(arrivalAirport);
		}

		if (bindDepartureDate) {
			queryPos.add(departureDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(flight)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Flight> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63; from the database.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 */
	@Override
	public void removeByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate) {

		for (Flight flight :
				findByDA_AA_DD(
					departureAirport, arrivalAirport, departureDate,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(flight);
		}
	}

	/**
	 * Returns the number of flights where departureAirport = &#63; and arrivalAirport = &#63; and departureDate = &#63;.
	 *
	 * @param departureAirport the departure airport
	 * @param arrivalAirport the arrival airport
	 * @param departureDate the departure date
	 * @return the number of matching flights
	 */
	@Override
	public int countByDA_AA_DD(
		String departureAirport, String arrivalAirport, String departureDate) {

		departureAirport = Objects.toString(departureAirport, "");
		arrivalAirport = Objects.toString(arrivalAirport, "");
		departureDate = Objects.toString(departureDate, "");

		FinderPath finderPath = _finderPathCountByDA_AA_DD;

		Object[] finderArgs = new Object[] {
			departureAirport, arrivalAirport, departureDate
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_FLIGHT_WHERE);

			boolean bindDepartureAirport = false;

			if (departureAirport.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_3);
			}
			else {
				bindDepartureAirport = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_2);
			}

			boolean bindArrivalAirport = false;

			if (arrivalAirport.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_3);
			}
			else {
				bindArrivalAirport = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_2);
			}

			boolean bindDepartureDate = false;

			if (departureDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_3);
			}
			else {
				bindDepartureDate = true;

				sb.append(_FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartureAirport) {
					queryPos.add(departureAirport);
				}

				if (bindArrivalAirport) {
					queryPos.add(arrivalAirport);
				}

				if (bindDepartureDate) {
					queryPos.add(departureDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_2 =
		"flight.departureAirport = ? AND ";

	private static final String _FINDER_COLUMN_DA_AA_DD_DEPARTUREAIRPORT_3 =
		"(flight.departureAirport IS NULL OR flight.departureAirport = '') AND ";

	private static final String _FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_2 =
		"flight.arrivalAirport = ? AND ";

	private static final String _FINDER_COLUMN_DA_AA_DD_ARRIVALAIRPORT_3 =
		"(flight.arrivalAirport IS NULL OR flight.arrivalAirport = '') AND ";

	private static final String _FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_2 =
		"flight.departureDate = ?";

	private static final String _FINDER_COLUMN_DA_AA_DD_DEPARTUREDATE_3 =
		"(flight.departureDate IS NULL OR flight.departureDate = '')";

	public FlightPersistenceImpl() {
		setModelClass(Flight.class);

		setModelImplClass(FlightImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the flight in the entity cache if it is enabled.
	 *
	 * @param flight the flight
	 */
	@Override
	public void cacheResult(Flight flight) {
		entityCache.putResult(
			entityCacheEnabled, FlightImpl.class, flight.getPrimaryKey(),
			flight);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {flight.getUuid(), flight.getGroupId()}, flight);

		flight.resetOriginalValues();
	}

	/**
	 * Caches the flights in the entity cache if it is enabled.
	 *
	 * @param flights the flights
	 */
	@Override
	public void cacheResult(List<Flight> flights) {
		for (Flight flight : flights) {
			if (entityCache.getResult(
					entityCacheEnabled, FlightImpl.class,
					flight.getPrimaryKey()) == null) {

				cacheResult(flight);
			}
			else {
				flight.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flights.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FlightImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flight.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Flight flight) {
		entityCache.removeResult(
			entityCacheEnabled, FlightImpl.class, flight.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FlightModelImpl)flight, true);
	}

	@Override
	public void clearCache(List<Flight> flights) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Flight flight : flights) {
			entityCache.removeResult(
				entityCacheEnabled, FlightImpl.class, flight.getPrimaryKey());

			clearUniqueFindersCache((FlightModelImpl)flight, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, FlightImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(FlightModelImpl flightModelImpl) {
		Object[] args = new Object[] {
			flightModelImpl.getUuid(), flightModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, flightModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FlightModelImpl flightModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				flightModelImpl.getUuid(), flightModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((flightModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				flightModelImpl.getOriginalUuid(),
				flightModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new flight with the primary key. Does not add the flight to the database.
	 *
	 * @param flightId the primary key for the new flight
	 * @return the new flight
	 */
	@Override
	public Flight create(long flightId) {
		Flight flight = new FlightImpl();

		flight.setNew(true);
		flight.setPrimaryKey(flightId);

		String uuid = PortalUUIDUtil.generate();

		flight.setUuid(uuid);

		flight.setCompanyId(CompanyThreadLocal.getCompanyId());

		return flight;
	}

	/**
	 * Removes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight that was removed
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight remove(long flightId) throws NoSuchFlightException {
		return remove((Serializable)flightId);
	}

	/**
	 * Removes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flight
	 * @return the flight that was removed
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight remove(Serializable primaryKey) throws NoSuchFlightException {
		Session session = null;

		try {
			session = openSession();

			Flight flight = (Flight)session.get(FlightImpl.class, primaryKey);

			if (flight == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlightException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(flight);
		}
		catch (NoSuchFlightException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Flight removeImpl(Flight flight) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flight)) {
				flight = (Flight)session.get(
					FlightImpl.class, flight.getPrimaryKeyObj());
			}

			if (flight != null) {
				session.delete(flight);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (flight != null) {
			clearCache(flight);
		}

		return flight;
	}

	@Override
	public Flight updateImpl(Flight flight) {
		boolean isNew = flight.isNew();

		if (!(flight instanceof FlightModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(flight.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(flight);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in flight proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Flight implementation " +
					flight.getClass());
		}

		FlightModelImpl flightModelImpl = (FlightModelImpl)flight;

		if (Validator.isNull(flight.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			flight.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (flight.getCreateDate() == null)) {
			if (serviceContext == null) {
				flight.setCreateDate(now);
			}
			else {
				flight.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!flightModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				flight.setModifiedDate(now);
			}
			else {
				flight.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (flight.isNew()) {
				session.save(flight);

				flight.setNew(false);
			}
			else {
				flight = (Flight)session.merge(flight);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {flightModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				flightModelImpl.getUuid(), flightModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				flightModelImpl.getDepartureAirport(),
				flightModelImpl.getArrivalAirport(),
				flightModelImpl.getDepartureDate()
			};

			finderCache.removeResult(_finderPathCountByDA_AA_DD, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDA_AA_DD, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((flightModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					flightModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {flightModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((flightModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					flightModelImpl.getOriginalUuid(),
					flightModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					flightModelImpl.getUuid(), flightModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((flightModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDA_AA_DD.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					flightModelImpl.getOriginalDepartureAirport(),
					flightModelImpl.getOriginalArrivalAirport(),
					flightModelImpl.getOriginalDepartureDate()
				};

				finderCache.removeResult(_finderPathCountByDA_AA_DD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDA_AA_DD, args);

				args = new Object[] {
					flightModelImpl.getDepartureAirport(),
					flightModelImpl.getArrivalAirport(),
					flightModelImpl.getDepartureDate()
				};

				finderCache.removeResult(_finderPathCountByDA_AA_DD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDA_AA_DD, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, FlightImpl.class, flight.getPrimaryKey(),
			flight, false);

		clearUniqueFindersCache(flightModelImpl, false);
		cacheUniqueFindersCache(flightModelImpl);

		flight.resetOriginalValues();

		return flight;
	}

	/**
	 * Returns the flight with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flight
	 * @return the flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlightException {

		Flight flight = fetchByPrimaryKey(primaryKey);

		if (flight == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlightException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return flight;
	}

	/**
	 * Returns the flight with the primary key or throws a <code>NoSuchFlightException</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight
	 * @throws NoSuchFlightException if a flight with the primary key could not be found
	 */
	@Override
	public Flight findByPrimaryKey(long flightId) throws NoSuchFlightException {
		return findByPrimaryKey((Serializable)flightId);
	}

	/**
	 * Returns the flight with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight, or <code>null</code> if a flight with the primary key could not be found
	 */
	@Override
	public Flight fetchByPrimaryKey(long flightId) {
		return fetchByPrimaryKey((Serializable)flightId);
	}

	/**
	 * Returns all the flights.
	 *
	 * @return the flights
	 */
	@Override
	public List<Flight> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of flights
	 */
	@Override
	public List<Flight> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flights
	 */
	@Override
	public List<Flight> findAll(
		int start, int end, OrderByComparator<Flight> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of flights
	 */
	@Override
	public List<Flight> findAll(
		int start, int end, OrderByComparator<Flight> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Flight> list = null;

		if (useFinderCache) {
			list = (List<Flight>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FLIGHT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FLIGHT;

				sql = sql.concat(FlightModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Flight>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the flights from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Flight flight : findAll()) {
			remove(flight);
		}
	}

	/**
	 * Returns the number of flights.
	 *
	 * @return the number of flights
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FLIGHT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "flightId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FLIGHT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FlightModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the flight persistence.
	 */
	@Activate
	public void activate() {
		FlightModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FlightModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			FlightModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			FlightModelImpl.UUID_COLUMN_BITMASK |
			FlightModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			FlightModelImpl.UUID_COLUMN_BITMASK |
			FlightModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByDA_AA_DD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDA_AA_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDA_AA_DD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FlightImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDA_AA_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			FlightModelImpl.DEPARTUREAIRPORT_COLUMN_BITMASK |
			FlightModelImpl.ARRIVALAIRPORT_COLUMN_BITMASK |
			FlightModelImpl.DEPARTUREDATE_COLUMN_BITMASK);

		_finderPathCountByDA_AA_DD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDA_AA_DD",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FlightImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = AMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.it.airlines.manager.model.Flight"),
			true);
	}

	@Override
	@Reference(
		target = AMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FLIGHT =
		"SELECT flight FROM Flight flight";

	private static final String _SQL_SELECT_FLIGHT_WHERE =
		"SELECT flight FROM Flight flight WHERE ";

	private static final String _SQL_COUNT_FLIGHT =
		"SELECT COUNT(flight) FROM Flight flight";

	private static final String _SQL_COUNT_FLIGHT_WHERE =
		"SELECT COUNT(flight) FROM Flight flight WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "flight.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Flight exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Flight exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FlightPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(AMPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}