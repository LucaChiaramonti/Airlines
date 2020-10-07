create table AM_Customer (
	uuid_ VARCHAR(75) null,
	customerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	flightId VARCHAR(75) null
);

create table AM_Flight (
	uuid_ VARCHAR(75) null,
	flightId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	departureDate VARCHAR(75) null,
	arrivalDate VARCHAR(75) null,
	departureTime VARCHAR(75) null,
	arrivalTime VARCHAR(75) null,
	departureAirport VARCHAR(75) null,
	arrivalAirport VARCHAR(75) null,
	availablePlaces VARCHAR(75) null,
	totalPlaces VARCHAR(75) null,
	duration VARCHAR(75) null,
	price VARCHAR(75) null
);