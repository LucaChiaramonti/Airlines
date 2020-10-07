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
 * Provides a wrapper for {@link FlightService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlightService
 * @generated
 */
public class FlightServiceWrapper
	implements FlightService, ServiceWrapper<FlightService> {

	public FlightServiceWrapper(FlightService flightService) {
		_flightService = flightService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _flightService.getOSGiServiceIdentifier();
	}

	@Override
	public FlightService getWrappedService() {
		return _flightService;
	}

	@Override
	public void setWrappedService(FlightService flightService) {
		_flightService = flightService;
	}

	private FlightService _flightService;

}