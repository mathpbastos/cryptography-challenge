DROP DATABASE IF EXISTS cryptographydb;
DROP USER IF EXISTS `cryptoadmin`@`%`;
DROP USER IF EXISTS `cryptouser`@`%`;
CREATE DATABASE IF NOT EXISTS cryptographydb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `cryptoadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'letmein';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `cryptographydb`.* TO `cryptoadmin`@`%`;
CREATE USER IF NOT EXISTS `cryptouser`@`%` IDENTIFIED WITH mysql_native_password BY 'letmein';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `cryptographydb`.* TO `cryptouser`@`%`;
FLUSH PRIVILEGES;