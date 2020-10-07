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

package it.airlines.manager.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Flight. This utility wraps
 * <code>it.airlines.manager.service.impl.FlightLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FlightLocalService
 * @generated
 */
public class FlightLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.airlines.manager.service.impl.FlightLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the flight to the database. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was added
	 */
	public static it.airlines.manager.model.Flight addFlight(
		it.airlines.manager.model.Flight flight) {

		return getService().addFlight(flight);
	}

	public static it.airlines.manager.model.Flight addFlight(
			long userId, String arrivalAirport, String arrivalDate,
			String arrivalTime, String availablePlaces, String departureAirport,
			String departureDate, String departureTime, String duration,
			String price, String totalPlaces,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFlight(
			userId, arrivalAirport, arrivalDate, arrivalTime, availablePlaces,
			departureAirport, departureDate, departureTime, duration, price,
			totalPlaces, serviceContext);
	}

	/**
	 * Creates a new flight with the primary key. Does not add the flight to the database.
	 *
	 * @param flightId the primary key for the new flight
	 * @return the new flight
	 */
	public static it.airlines.manager.model.Flight createFlight(long flightId) {
		return getService().createFlight(flightId);
	}

	/**
	 * Deletes the flight from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was removed
	 */
	public static it.airlines.manager.model.Flight deleteFlight(
		it.airlines.manager.model.Flight flight) {

		return getService().deleteFlight(flight);
	}

	/**
	 * Deletes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight that was removed
	 * @throws PortalException if a flight with the primary key could not be found
	 */
	public static it.airlines.manager.model.Flight deleteFlight(long flightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFlight(flightId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.airlines.manager.model.impl.FlightModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.airlines.manager.model.impl.FlightModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.airlines.manager.model.Flight fetchFlight(long flightId) {
		return getService().fetchFlight(flightId);
	}

	/**
	 * Returns the flight matching the UUID and group.
	 *
	 * @param uuid the flight's UUID
	 * @param groupId the primary key of the group
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	public static it.airlines.manager.model.Flight fetchFlightByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFlightByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the flight with the primary key.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight
	 * @throws PortalException if a flight with the primary key could not be found
	 */
	public static it.airlines.manager.model.Flight getFlight(long flightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFlight(flightId);
	}

	/**
	 * Returns the flight matching the UUID and group.
	 *
	 * @param uuid the flight's UUID
	 * @param groupId the primary key of the group
	 * @return the matching flight
	 * @throws PortalException if a matching flight could not be found
	 */
	public static it.airlines.manager.model.Flight getFlightByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFlightByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the flights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.airlines.manager.model.impl.FlightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @return the range of flights
	 */
	public static java.util.List<it.airlines.manager.model.Flight> getFlights(
		int start, int end) {

		return getService().getFlights(start, end);
	}

	/**
	 * Returns all the flights matching the UUID and company.
	 *
	 * @param uuid the UUID of the flights
	 * @param companyId the primary key of the company
	 * @return the matching flights, or an empty list if no matches were found
	 */
	public static java.util.List<it.airlines.manager.model.Flight>
		getFlightsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFlightsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of flights matching the UUID and company.
	 *
	 * @param uuid the UUID of the flights
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of flights
	 * @param end the upper bound of the range of flights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching flights, or an empty list if no matches were found
	 */
	public static java.util.List<it.airlines.manager.model.Flight>
		getFlightsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.airlines.manager.model.Flight> orderByComparator) {

		return getService().getFlightsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of flights.
	 *
	 * @return the number of flights
	 */
	public static int getFlightsCount() {
		return getService().getFlightsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the flight in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was updated
	 */
	public static it.airlines.manager.model.Flight updateFlight(
		it.airlines.manager.model.Flight flight) {

		return getService().updateFlight(flight);
	}

	public static FlightLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FlightLocalService, FlightLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FlightLocalService.class);

		ServiceTracker<FlightLocalService, FlightLocalService> serviceTracker =
			new ServiceTracker<FlightLocalService, FlightLocalService>(
				bundle.getBundleContext(), FlightLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}