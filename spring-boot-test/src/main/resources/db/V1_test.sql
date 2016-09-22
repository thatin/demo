DROP TABLE IF EXISTS test_user;
CREATE TABLE IF NOT EXISTS test_user (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	password VARCHAR(255),
  	last_updated_time TIMESTAMP(6) NOT NULL,
  	PRIMARY KEY (id),
  	INDEX (name)
);