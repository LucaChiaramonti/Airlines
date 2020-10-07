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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlightLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlightLocalService
 * @generated
 */
public class FlightLocalServiceWrapper
	implements FlightLocalService, ServiceWrapper<FlightLocalService> {

	public FlightLocalServiceWrapper(FlightLocalService flightLocalService) {
		_flightLocalService = flightLocalService;
	}

	/**
	 * Adds the flight to the database. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was added
	 */
	@Override
	public it.airlines.manager.model.Flight addFlight(
		it.airlines.manager.model.Flight flight) {

		return _flightLocalService.addFlight(flight);
	}

	@Override
	public it.airlines.manager.model.Flight addFlight(
			long userId, String arrivalAirport, String arrivalDate,
			String arrivalTime, String availablePlaces, String departureAirport,
			String departureDate, String departureTime, String duration,
			String price, String totalPlaces,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.addFlight(
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
	@Override
	public it.airlines.manager.model.Flight createFlight(long flightId) {
		return _flightLocalService.createFlight(flightId);
	}

	/**
	 * Deletes the flight from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was removed
	 */
	@Override
	public it.airlines.manager.model.Flight deleteFlight(
		it.airlines.manager.model.Flight flight) {

		return _flightLocalService.deleteFlight(flight);
	}

	/**
	 * Deletes the flight with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight that was removed
	 * @throws PortalException if a flight with the primary key could not be found
	 */
	@Override
	public it.airlines.manager.model.Flight deleteFlight(long flightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.deleteFlight(flightId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _flightLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _flightLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _flightLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _flightLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _flightLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _flightLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.airlines.manager.model.Flight fetchFlight(long flightId) {
		return _flightLocalService.fetchFlight(flightId);
	}

	/**
	 * Returns the flight matching the UUID and group.
	 *
	 * @param uuid the flight's UUID
	 * @param groupId the primary key of the group
	 * @return the matching flight, or <code>null</code> if a matching flight could not be found
	 */
	@Override
	public it.airlines.manager.model.Flight fetchFlightByUuidAndGroupId(
		String uuid, long groupId) {

		return _flightLocalService.fetchFlightByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _flightLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _flightLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the flight with the primary key.
	 *
	 * @param flightId the primary key of the flight
	 * @return the flight
	 * @throws PortalException if a flight with the primary key could not be found
	 */
	@Override
	public it.airlines.manager.model.Flight getFlight(long flightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.getFlight(flightId);
	}

	/**
	 * Returns the flight matching the UUID and group.
	 *
	 * @param uuid the flight's UUID
	 * @param groupId the primary key of the group
	 * @return the matching flight
	 * @throws PortalException if a matching flight could not be found
	 */
	@Override
	public it.airlines.manager.model.Flight getFlightByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.getFlightByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<it.airlines.manager.model.Flight> getFlights(
		int start, int end) {

		return _flightLocalService.getFlights(start, end);
	}

	/**
	 * Returns all the flights matching the UUID and company.
	 *
	 * @param uuid the UUID of the flights
	 * @param companyId the primary key of the company
	 * @return the matching flights, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.airlines.manager.model.Flight>
		getFlightsByUuidAndCompanyId(String uuid, long companyId) {

		return _flightLocalService.getFlightsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<it.airlines.manager.model.Flight>
		getFlightsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.airlines.manager.model.Flight> orderByComparator) {

		return _flightLocalService.getFlightsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of flights.
	 *
	 * @return the number of flights
	 */
	@Override
	public int getFlightsCount() {
		return _flightLocalService.getFlightsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _flightLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _flightLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _flightLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the flight in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param flight the flight
	 * @return the flight that was updated
	 */
	@Override
	public it.airlines.manager.model.Flight updateFlight(
		it.airlines.manager.model.Flight flight) {

		return _flightLocalService.updateFlight(flight);
	}

	@Override
	public FlightLocalService getWrappedService() {
		return _flightLocalService;
	}

	@Override
	public void setWrappedService(FlightLocalService flightLocalService) {
		_flightLocalService = flightLocalService;
	}

	private FlightLocalService _flightLocalService;

}