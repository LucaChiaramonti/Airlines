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

package it.airlines.manager.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.airlines.manager.model.Flight;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Flight in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlightCacheModel implements CacheModel<Flight>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlightCacheModel)) {
			return false;
		}

		FlightCacheModel flightCacheModel = (FlightCacheModel)obj;

		if (flightId == flightCacheModel.flightId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, flightId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", flightId=");
		sb.append(flightId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", departureDate=");
		sb.append(departureDate);
		sb.append(", arrivalDate=");
		sb.append(arrivalDate);
		sb.append(", departureTime=");
		sb.append(departureTime);
		sb.append(", arrivalTime=");
		sb.append(arrivalTime);
		sb.append(", departureAirport=");
		sb.append(departureAirport);
		sb.append(", arrivalAirport=");
		sb.append(arrivalAirport);
		sb.append(", availablePlaces=");
		sb.append(availablePlaces);
		sb.append(", totalPlaces=");
		sb.append(totalPlaces);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Flight toEntityModel() {
		FlightImpl flightImpl = new FlightImpl();

		if (uuid == null) {
			flightImpl.setUuid("");
		}
		else {
			flightImpl.setUuid(uuid);
		}

		flightImpl.setFlightId(flightId);
		flightImpl.setGroupId(groupId);
		flightImpl.setCompanyId(companyId);
		flightImpl.setUserId(userId);

		if (userName == null) {
			flightImpl.setUserName("");
		}
		else {
			flightImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			flightImpl.setCreateDate(null);
		}
		else {
			flightImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			flightImpl.setModifiedDate(null);
		}
		else {
			flightImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (departureDate == null) {
			flightImpl.setDepartureDate("");
		}
		else {
			flightImpl.setDepartureDate(departureDate);
		}

		if (arrivalDate == null) {
			flightImpl.setArrivalDate("");
		}
		else {
			flightImpl.setArrivalDate(arrivalDate);
		}

		if (departureTime == null) {
			flightImpl.setDepartureTime("");
		}
		else {
			flightImpl.setDepartureTime(departureTime);
		}

		if (arrivalTime == null) {
			flightImpl.setArrivalTime("");
		}
		else {
			flightImpl.setArrivalTime(arrivalTime);
		}

		if (departureAirport == null) {
			flightImpl.setDepartureAirport("");
		}
		else {
			flightImpl.setDepartureAirport(departureAirport);
		}

		if (arrivalAirport == null) {
			flightImpl.setArrivalAirport("");
		}
		else {
			flightImpl.setArrivalAirport(arrivalAirport);
		}

		if (availablePlaces == null) {
			flightImpl.setAvailablePlaces("");
		}
		else {
			flightImpl.setAvailablePlaces(availablePlaces);
		}

		if (totalPlaces == null) {
			flightImpl.setTotalPlaces("");
		}
		else {
			flightImpl.setTotalPlaces(totalPlaces);
		}

		if (duration == null) {
			flightImpl.setDuration("");
		}
		else {
			flightImpl.setDuration(duration);
		}

		if (price == null) {
			flightImpl.setPrice("");
		}
		else {
			flightImpl.setPrice(price);
		}

		flightImpl.resetOriginalValues();

		return flightImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		flightId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		departureDate = objectInput.readUTF();
		arrivalDate = objectInput.readUTF();
		departureTime = objectInput.readUTF();
		arrivalTime = objectInput.readUTF();
		departureAirport = objectInput.readUTF();
		arrivalAirport = objectInput.readUTF();
		availablePlaces = objectInput.readUTF();
		totalPlaces = objectInput.readUTF();
		duration = objectInput.readUTF();
		price = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(flightId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (departureDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departureDate);
		}

		if (arrivalDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arrivalDate);
		}

		if (departureTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departureTime);
		}

		if (arrivalTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arrivalTime);
		}

		if (departureAirport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departureAirport);
		}

		if (arrivalAirport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arrivalAirport);
		}

		if (availablePlaces == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(availablePlaces);
		}

		if (totalPlaces == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(totalPlaces);
		}

		if (duration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duration);
		}

		if (price == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(price);
		}
	}

	public String uuid;
	public long flightId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String departureDate;
	public String arrivalDate;
	public String departureTime;
	public String arrivalTime;
	public String departureAirport;
	public String arrivalAirport;
	public String availablePlaces;
	public String totalPlaces;
	public String duration;
	public String price;

}