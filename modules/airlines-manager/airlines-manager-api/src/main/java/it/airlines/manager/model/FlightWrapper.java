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

package it.airlines.manager.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Flight}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Flight
 * @generated
 */
public class FlightWrapper
	extends BaseModelWrapper<Flight> implements Flight, ModelWrapper<Flight> {

	public FlightWrapper(Flight flight) {
		super(flight);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("flightId", getFlightId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departureDate", getDepartureDate());
		attributes.put("arrivalDate", getArrivalDate());
		attributes.put("departureTime", getDepartureTime());
		attributes.put("arrivalTime", getArrivalTime());
		attributes.put("departureAirport", getDepartureAirport());
		attributes.put("arrivalAirport", getArrivalAirport());
		attributes.put("availablePlaces", getAvailablePlaces());
		attributes.put("totalPlaces", getTotalPlaces());
		attributes.put("duration", getDuration());
		attributes.put("price", getPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long flightId = (Long)attributes.get("flightId");

		if (flightId != null) {
			setFlightId(flightId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String departureDate = (String)attributes.get("departureDate");

		if (departureDate != null) {
			setDepartureDate(departureDate);
		}

		String arrivalDate = (String)attributes.get("arrivalDate");

		if (arrivalDate != null) {
			setArrivalDate(arrivalDate);
		}

		String departureTime = (String)attributes.get("departureTime");

		if (departureTime != null) {
			setDepartureTime(departureTime);
		}

		String arrivalTime = (String)attributes.get("arrivalTime");

		if (arrivalTime != null) {
			setArrivalTime(arrivalTime);
		}

		String departureAirport = (String)attributes.get("departureAirport");

		if (departureAirport != null) {
			setDepartureAirport(departureAirport);
		}

		String arrivalAirport = (String)attributes.get("arrivalAirport");

		if (arrivalAirport != null) {
			setArrivalAirport(arrivalAirport);
		}

		String availablePlaces = (String)attributes.get("availablePlaces");

		if (availablePlaces != null) {
			setAvailablePlaces(availablePlaces);
		}

		String totalPlaces = (String)attributes.get("totalPlaces");

		if (totalPlaces != null) {
			setTotalPlaces(totalPlaces);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}
	}

	/**
	 * Returns the arrival airport of this flight.
	 *
	 * @return the arrival airport of this flight
	 */
	@Override
	public String getArrivalAirport() {
		return model.getArrivalAirport();
	}

	/**
	 * Returns the arrival date of this flight.
	 *
	 * @return the arrival date of this flight
	 */
	@Override
	public String getArrivalDate() {
		return model.getArrivalDate();
	}

	/**
	 * Returns the arrival time of this flight.
	 *
	 * @return the arrival time of this flight
	 */
	@Override
	public String getArrivalTime() {
		return model.getArrivalTime();
	}

	/**
	 * Returns the available places of this flight.
	 *
	 * @return the available places of this flight
	 */
	@Override
	public String getAvailablePlaces() {
		return model.getAvailablePlaces();
	}

	/**
	 * Returns the company ID of this flight.
	 *
	 * @return the company ID of this flight
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this flight.
	 *
	 * @return the create date of this flight
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the departure airport of this flight.
	 *
	 * @return the departure airport of this flight
	 */
	@Override
	public String getDepartureAirport() {
		return model.getDepartureAirport();
	}

	/**
	 * Returns the departure date of this flight.
	 *
	 * @return the departure date of this flight
	 */
	@Override
	public String getDepartureDate() {
		return model.getDepartureDate();
	}

	/**
	 * Returns the departure time of this flight.
	 *
	 * @return the departure time of this flight
	 */
	@Override
	public String getDepartureTime() {
		return model.getDepartureTime();
	}

	/**
	 * Returns the duration of this flight.
	 *
	 * @return the duration of this flight
	 */
	@Override
	public String getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the flight ID of this flight.
	 *
	 * @return the flight ID of this flight
	 */
	@Override
	public long getFlightId() {
		return model.getFlightId();
	}

	/**
	 * Returns the group ID of this flight.
	 *
	 * @return the group ID of this flight
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this flight.
	 *
	 * @return the modified date of this flight
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the price of this flight.
	 *
	 * @return the price of this flight
	 */
	@Override
	public String getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this flight.
	 *
	 * @return the primary key of this flight
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total places of this flight.
	 *
	 * @return the total places of this flight
	 */
	@Override
	public String getTotalPlaces() {
		return model.getTotalPlaces();
	}

	/**
	 * Returns the user ID of this flight.
	 *
	 * @return the user ID of this flight
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this flight.
	 *
	 * @return the user name of this flight
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this flight.
	 *
	 * @return the user uuid of this flight
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this flight.
	 *
	 * @return the uuid of this flight
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the arrival airport of this flight.
	 *
	 * @param arrivalAirport the arrival airport of this flight
	 */
	@Override
	public void setArrivalAirport(String arrivalAirport) {
		model.setArrivalAirport(arrivalAirport);
	}

	/**
	 * Sets the arrival date of this flight.
	 *
	 * @param arrivalDate the arrival date of this flight
	 */
	@Override
	public void setArrivalDate(String arrivalDate) {
		model.setArrivalDate(arrivalDate);
	}

	/**
	 * Sets the arrival time of this flight.
	 *
	 * @param arrivalTime the arrival time of this flight
	 */
	@Override
	public void setArrivalTime(String arrivalTime) {
		model.setArrivalTime(arrivalTime);
	}

	/**
	 * Sets the available places of this flight.
	 *
	 * @param availablePlaces the available places of this flight
	 */
	@Override
	public void setAvailablePlaces(String availablePlaces) {
		model.setAvailablePlaces(availablePlaces);
	}

	/**
	 * Sets the company ID of this flight.
	 *
	 * @param companyId the company ID of this flight
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this flight.
	 *
	 * @param createDate the create date of this flight
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the departure airport of this flight.
	 *
	 * @param departureAirport the departure airport of this flight
	 */
	@Override
	public void setDepartureAirport(String departureAirport) {
		model.setDepartureAirport(departureAirport);
	}

	/**
	 * Sets the departure date of this flight.
	 *
	 * @param departureDate the departure date of this flight
	 */
	@Override
	public void setDepartureDate(String departureDate) {
		model.setDepartureDate(departureDate);
	}

	/**
	 * Sets the departure time of this flight.
	 *
	 * @param departureTime the departure time of this flight
	 */
	@Override
	public void setDepartureTime(String departureTime) {
		model.setDepartureTime(departureTime);
	}

	/**
	 * Sets the duration of this flight.
	 *
	 * @param duration the duration of this flight
	 */
	@Override
	public void setDuration(String duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the flight ID of this flight.
	 *
	 * @param flightId the flight ID of this flight
	 */
	@Override
	public void setFlightId(long flightId) {
		model.setFlightId(flightId);
	}

	/**
	 * Sets the group ID of this flight.
	 *
	 * @param groupId the group ID of this flight
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this flight.
	 *
	 * @param modifiedDate the modified date of this flight
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the price of this flight.
	 *
	 * @param price the price of this flight
	 */
	@Override
	public void setPrice(String price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this flight.
	 *
	 * @param primaryKey the primary key of this flight
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total places of this flight.
	 *
	 * @param totalPlaces the total places of this flight
	 */
	@Override
	public void setTotalPlaces(String totalPlaces) {
		model.setTotalPlaces(totalPlaces);
	}

	/**
	 * Sets the user ID of this flight.
	 *
	 * @param userId the user ID of this flight
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this flight.
	 *
	 * @param userName the user name of this flight
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this flight.
	 *
	 * @param userUuid the user uuid of this flight
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this flight.
	 *
	 * @param uuid the uuid of this flight
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FlightWrapper wrap(Flight flight) {
		return new FlightWrapper(flight);
	}

}