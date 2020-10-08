<%@page import="it.airlines.manager.service.FlightLocalServiceUtil"%>
<%@ include file="/init.jsp" %>


<liferay-ui:search-container total="<%=FlightLocalServiceUtil.getFlightsCount()%>">
    <liferay-ui:search-container-results results="<%=FlightLocalServiceUtil.
    getFlights(searchContainer.getStart(), searchContainer.getEnd())%>"/>

    <liferay-ui:search-container-row
            className="it.airlines.manager.model.Flight" modelVar="flight">
		
	        <liferay-ui:search-container-column-text 
		        value="<%=flight.getDepartureAirport() + " -> " + flight.getArrivalAirport()%>"
		        name="Volo"/>
	
	        <liferay-ui:search-container-column-text property="departureDate" name ="Data partenza"/>

	        <liferay-ui:search-container-column-text property="availablePlaces" name ="Posti disponibili"/>

	        <liferay-ui:search-container-column-text property="price" name ="Prezzo"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>