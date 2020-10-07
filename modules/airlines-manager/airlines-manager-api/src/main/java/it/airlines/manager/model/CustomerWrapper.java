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
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
public class CustomerWrapper
	extends BaseModelWrapper<Customer>
	implements Customer, ModelWrapper<Customer> {

	public CustomerWrapper(Customer customer) {
		super(customer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("customerId", getCustomerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("flightId", getFlightId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String flightId = (String)attributes.get("flightId");

		if (flightId != null) {
			setFlightId(flightId);
		}
	}

	/**
	 * Returns the company ID of this customer.
	 *
	 * @return the company ID of this customer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this customer.
	 *
	 * @return the create date of this customer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the first name of this customer.
	 *
	 * @return the first name of this customer
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the flight ID of this customer.
	 *
	 * @return the flight ID of this customer
	 */
	@Override
	public String getFlightId() {
		return model.getFlightId();
	}

	/**
	 * Returns the group ID of this customer.
	 *
	 * @return the group ID of this customer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this customer.
	 *
	 * @return the last name of this customer
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this customer.
	 *
	 * @return the modified date of this customer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this customer.
	 *
	 * @return the user ID of this customer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this customer.
	 *
	 * @return the user name of this customer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this customer.
	 *
	 * @return the user uuid of this customer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this customer.
	 *
	 * @return the uuid of this customer
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
	 * Sets the company ID of this customer.
	 *
	 * @param companyId the company ID of this customer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this customer.
	 *
	 * @param createDate the create date of this customer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the first name of this customer.
	 *
	 * @param firstName the first name of this customer
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the flight ID of this customer.
	 *
	 * @param flightId the flight ID of this customer
	 */
	@Override
	public void setFlightId(String flightId) {
		model.setFlightId(flightId);
	}

	/**
	 * Sets the group ID of this customer.
	 *
	 * @param groupId the group ID of this customer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this customer.
	 *
	 * @param lastName the last name of this customer
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this customer.
	 *
	 * @param modifiedDate the modified date of this customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this customer.
	 *
	 * @param userId the user ID of this customer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this customer.
	 *
	 * @param userName the user name of this customer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this customer.
	 *
	 * @param userUuid the user uuid of this customer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this customer.
	 *
	 * @param uuid the uuid of this customer
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
	protected CustomerWrapper wrap(Customer customer) {
		return new CustomerWrapper(customer);
	}

}