DROP DATABASE IF EXISTS weatherStation;
CREATE DATABASE weatherStation;

USE weatherStation;

CREATE TABLE data (
	id INT NOT NULL AUTO_INCREMENT,
	temperature DOUBLE NULL,
	pressure DOUBLE NULL,
	humidity INT NULL,
	windSpeed INT NULL,
	PRIMARY KEY (id)
);