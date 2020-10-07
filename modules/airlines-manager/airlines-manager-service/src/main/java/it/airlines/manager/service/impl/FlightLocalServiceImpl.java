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

package it.airlines.manager.service.impl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import it.airlines.manager.model.Flight;
import it.airlines.manager.service.base.FlightLocalServiceBaseImpl;

/**
 * The implementation of the flight local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.airlines.manager.service.FlightLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlightLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.airlines.manager.model.Flight",
	service = AopService.class
)
public class FlightLocalServiceImpl extends FlightLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.airlines.manager.service.FlightLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.airlines.manager.service.FlightLocalServiceUtil</code>.
	 */
	@Override
	  public Flight addFlight(long userId, String arrivalAirport, String arrivalDate,
			  String arrivalTime, String availablePlaces, String departureAirport,
			  String departureDate, String departureTime, String duration, String price,
			  String totalPlaces, ServiceContext serviceContext) throws PortalException {
		  
	        long groupId = serviceContext.getScopeGroupId();
	        
	        User user = userLocalService.getUserById(userId);
	        
	        Date now = new Date();
	        
	        long flightId = counterLocalService.increment();
	        
	        Flight flight = flightPersistence.create(flightId);
	        
	        flight.setUuid(serviceContext.getUuid());
	        flight.setUserId(userId);
	        flight.setGroupId(groupId);
	        flight.setCompanyId(user.getCompanyId());
	        flight.setUserName(user.getFullName());
	        flight.setCreateDate(serviceContext.getCreateDate(now));
	        flight.setModifiedDate(serviceContext.getModifiedDate(now));
	        flight.setExpandoBridgeAttributes(serviceContext);
	        
	        flight.setArrivalAirport(arrivalAirport);
	        flight.setArrivalDate(arrivalDate);
	        flight.setArrivalTime(arrivalTime);;
	        flight.setAvailablePlaces(availablePlaces);
	        flight.setDepartureAirport(departureAirport);
	        flight.setDepartureDate(departureDate);
	        flight.setDepartureTime(departureTime);
	        flight.setDuration(duration);
	        flight.setPrice(price);
	        flight.setTotalPlaces(totalPlaces);
	        
	        flightPersistence.update(flight);
	        
	        return flight;
	    }	
	
}