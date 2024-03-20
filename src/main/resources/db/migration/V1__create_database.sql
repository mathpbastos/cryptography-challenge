DROP TABLE IF EXISTS payment;

CREATE TABLE IF NOT EXISTS payment (
	id BIGINT NOT NULL auto_increment PRIMARY KEY,
	user_document VARCHAR(50),
	credit_card_token VARCHAR(50),
	value BIGINT
);