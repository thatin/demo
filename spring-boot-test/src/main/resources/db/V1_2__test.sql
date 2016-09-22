DROP TABLE IF EXISTS test_user;
CREATE TABLE IF NOT EXISTS test_user (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	password VARCHAR(255),
  	PRIMARY KEY (id),
  	INDEX (name)
);

INSERT INTO test_user values (1,'test','test');
INSERT INTO test_user values (2,'test2','test2');
INSERT INTO test_user values (3,'test1','test1');