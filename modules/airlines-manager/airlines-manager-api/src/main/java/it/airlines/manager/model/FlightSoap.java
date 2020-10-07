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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.airlines.manager.service.http.FlightServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlightSoap implements Serializable {

	public static FlightSoap toSoapModel(Flight model) {
		FlightSoap soapModel = new FlightSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFlightId(model.getFlightId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDepartureDate(model.getDepartureDate());
		soapModel.setArrivalDate(model.getArrivalDate());
		soapModel.setDepartureTime(model.getDepartureTime());
		soapModel.setArrivalTime(model.getArrivalTime());
		soapModel.setDepartureAirport(model.getDepartureAirport());
		soapModel.setArrivalAirport(model.getArrivalAirport());
		soapModel.setAvailablePlaces(model.getAvailablePlaces());
		soapModel.setTotalPlaces(model.getTotalPlaces());
		soapModel.setDuration(model.getDuration());
		soapModel.setPrice(model.getPrice());

		return soapModel;
	}

	public static FlightSoap[] toSoapModels(Flight[] models) {
		FlightSoap[] soapModels = new FlightSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlightSoap[][] toSoapModels(Flight[][] models) {
		FlightSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlightSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlightSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlightSoap[] toSoapModels(List<Flight> models) {
		List<FlightSoap> soapModels = new ArrayList<FlightSoap>(models.size());

		for (Flight model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlightSoap[soapModels.size()]);
	}

	public FlightSoap() {
	}

	public long getPrimaryKey() {
		return _flightId;
	}

	public void setPrimaryKey(long pk) {
		setFlightId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFlightId() {
		return _flightId;
	}

	public void setFlightId(long flightId) {
		_flightId = flightId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDepartureDate() {
		return _departureDate;
	}

	public void setDepartureDate(String departureDate) {
		_departureDate = departureDate;
	}

	public String getArrivalDate() {
		return _arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		_arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return _departureTime;
	}

	public void setDepartureTime(String departureTime) {
		_departureTime = departureTime;
	}

	public String getArrivalTime() {
		return _arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		_arrivalTime = arrivalTime;
	}

	public String getDepartureAirport() {
		return _departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		_departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return _arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		_arrivalAirport = arrivalAirport;
	}

	public String getAvailablePlaces() {
		return _availablePlaces;
	}

	public void setAvailablePlaces(String availablePlaces) {
		_availablePlaces = availablePlaces;
	}

	public String getTotalPlaces() {
		return _totalPlaces;
	}

	public void setTotalPlaces(String totalPlaces) {
		_totalPlaces = totalPlaces;
	}

	public String getDuration() {
		return _duration;
	}

	public void setDuration(String duration) {
		_duration = duration;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	private String _uuid;
	private long _flightId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _departureDate;
	private String _arrivalDate;
	private String _departureTime;
	private String _arrivalTime;
	private String _departureAirport;
	private String _arrivalAirport;
	private String _availablePlaces;
	private String _totalPlaces;
	private String _duration;
	private String _price;

}