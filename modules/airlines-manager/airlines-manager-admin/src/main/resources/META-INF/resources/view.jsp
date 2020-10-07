<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="airlinesmanageradmin.caption"/></b>
</p>

<portlet:actionURL name="addFlight" var="addFlightURL"/>

<aui:form action="<%=addFlightURL%>" name="fm">

      <aui:input name="departureAirport"  label="departure-airport"/>

      <aui:input name="arrivalAirport" label="arrival-airport"/>

      <aui:input name="departureDate"  label="departure-date"/>
      
      <aui:input name="arrivalDate"  label="arrival-date"/>

      <aui:input name="departureTime"  label="departure-time"/>

      <aui:input name="arrivalTime"  label="arrival-time"/>
      
      <aui:input name="duration"  label="duration"/>
      
      <aui:input name="totalPlaces"  label="total-places"/>
      
      <aui:input name="availablePlaces" label="available-places"/>
 
      <aui:input name="price"  label="price"/>
        
      <aui:button type="submit" value="add"/>
 
</aui:form>
