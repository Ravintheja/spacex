CREATE TABLE satellite_tab(
    noradId varchar(100) NOT NULL PRIMARY KEY,
    satName varchar(100) NOT NULL,
    satAltitude INT NOT NULL,
    satLong INT NOT NULL,
    satLat INT NOT NULL,
    satOrbit varchar(100) NOT NULL,
    satHealth varchar(100) NOT NULL
);