create index IX_67079C6B on AM_Customer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5C1241AD on AM_Customer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9FBF30F8 on AM_Flight (departureAirport[$COLUMN_LENGTH:75$], arrivalAirport[$COLUMN_LENGTH:75$], departureDate[$COLUMN_LENGTH:75$]);
create index IX_1AAD5CBD on AM_Flight (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B06FEE7F on AM_Flight (uuid_[$COLUMN_LENGTH:75$], groupId);