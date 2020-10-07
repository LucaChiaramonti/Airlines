package it.airlines.manager.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import it.airlines.manager.model.Flight;
import it.airlines.manager.service.FlightLocalService;
import it.airlines.manager.service.impl.FlightServiceImpl;
import it.airlines.manager.web.constants.AirlinesManagerAdminPortletKeys;

/**
 * @author Luca
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AirlinesManagerAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AirlinesManagerAdminPortletKeys.AIRLINESMANAGERADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AirlinesManagerAdminPortlet extends MVCPortlet {
	
	public void addFlight(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Flight.class.getName(), request);

        String arrivalAirport = ParamUtil.getString(request, "arrivalAirport");
        String arrivalDate = ParamUtil.getString(request, "arrivalDate");
        String arrivalTime = ParamUtil.getString(request, "arrivalTime");
        String availablePlaces = ParamUtil.getString(request, "availablePlaces");
        String departureAirport = ParamUtil.getString(request, "departureAirport");
        String departureDate = ParamUtil.getString(request, "departureDate");
        String departureTime = ParamUtil.getString(request, "departureTime");
        String duration = ParamUtil.getString(request, "duration");
        String price = ParamUtil.getString(request, "price");
        String totalPlaces = ParamUtil.getString(request, "totalPlaces");
        
        _flightService.addFlight(serviceContext.getUserId(), arrivalAirport, arrivalDate, arrivalTime, 
        		availablePlaces, departureAirport, departureDate, departureTime, duration, 
        		price, totalPlaces, serviceContext);
	}
	
	@Reference
	private FlightLocalService _flightService;
}