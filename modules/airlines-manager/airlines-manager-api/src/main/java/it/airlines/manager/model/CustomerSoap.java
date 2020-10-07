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
 * This class is used by SOAP remote services, specifically {@link it.airlines.manager.service.http.CustomerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerSoap implements Serializable {

	public static CustomerSoap toSoapModel(Customer model) {
		CustomerSoap soapModel = new CustomerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setFlightId(model.getFlightId());

		return soapModel;
	}

	public static CustomerSoap[] toSoapModels(Customer[] models) {
		CustomerSoap[] soapModels = new CustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[][] toSoapModels(Customer[][] models) {
		CustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[] toSoapModels(List<Customer> models) {
		List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(
			models.size());

		for (Customer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerSoap[soapModels.size()]);
	}

	public CustomerSoap() {
	}

	public long getPrimaryKey() {
		return _customerId;
	}

	public void setPrimaryKey(long pk) {
		setCustomerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFlightId() {
		return _flightId;
	}

	public void setFlightId(String flightId) {
		_flightId = flightId;
	}

	private String _uuid;
	private long _customerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _flightId;

}