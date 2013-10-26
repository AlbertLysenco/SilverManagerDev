﻿ DROP DATABASE IF EXISTS ST_OWNER_DEV;
 COMMIT;
 
 CREATE DATABASE IF NOT EXISTS ST_OWNER_DEV;
 
 USE ST_OWNER_DEV;
 
 CREATE TABLE IF NOT EXISTS ST_CONTRACTS(
 CONTRACT_ID INT NOT NULL AUTO_INCREMENT ,
 CONTRACT_NUMBER VARCHAR (100),
 CONTRACT_DATE DATE,
  PRIMARY KEY (CONTRACT_ID) 
  
  );
  
    INSERT INTO ST_CONTRACTS (CONTRACT_NUMBER,CONTRACT_DATE) VALUES ('00000001','2013-01-01');
    INSERT INTO ST_CONTRACTS (CONTRACT_NUMBER,CONTRACT_DATE) VALUES ('00000002','2013-01-02');
    INSERT INTO ST_CONTRACTS (CONTRACT_NUMBER,CONTRACT_DATE) VALUES ('00000003','2013-02-02');
	INSERT INTO ST_CONTRACTS (CONTRACT_NUMBER,CONTRACT_DATE) VALUES ('00000004','2013-03-02');
	INSERT INTO ST_CONTRACTS (CONTRACT_NUMBER,CONTRACT_DATE) VALUES ('00000005','2013-03-05');
	
  CREATE TABLE IF NOT EXISTS ST_MANAGERS(
 MANAGER_ID INT NOT NULL AUTO_INCREMENT ,
 MANAGER_FIRST_NAME VARCHAR (70),
 MANAGER_LAST_NAME VARCHAR (70),
 MANAGER_FATHERS_NAME VARCHAR (70),
 MANAGER_SPACE VARCHAR (70),
 MANAGER_PHONE INT (70),
 MANAGER_PHONE_S1 INT (70),
 MANAGER_PHONE_S2 INT (70),
 MANAGER_STATUS VARCHAR (70),
  PRIMARY KEY (MANAGER_ID) 
  
  );
    
	INSERT INTO ST_MANAGERS (MANAGER_FIRST_NAME,MANAGER_LAST_NAME,MANAGER_FATHERS_NAME,MANAGER_SPACE,MANAGER_PHONE,MANAGER_PHONE_S1,MANAGER_PHONE_S2,MANAGER_STATUS) VALUES ('Владимир','Ленин','Ильич','Святошинский',0631234567,0672349876,0443056787,'Работает');
	INSERT INTO ST_MANAGERS (MANAGER_FIRST_NAME,MANAGER_LAST_NAME,MANAGER_FATHERS_NAME,MANAGER_SPACE,MANAGER_PHONE,MANAGER_PHONE_S1,MANAGER_PHONE_S2,MANAGER_STATUS) VALUES ('Николай','Валуев','Васильевич','Деснянский',53573365,35652567,33632632,'Уволен');
	INSERT INTO ST_MANAGERS (MANAGER_FIRST_NAME,MANAGER_LAST_NAME,MANAGER_FATHERS_NAME,MANAGER_SPACE,MANAGER_PHONE,MANAGER_PHONE_S1,MANAGER_PHONE_S2,MANAGER_STATUS) VALUES ('Никита','Джигурда','Федорович','Подольский',325235325,75474574,457457475,'Работает');
	INSERT INTO ST_MANAGERS (MANAGER_FIRST_NAME,MANAGER_LAST_NAME,MANAGER_FATHERS_NAME,MANAGER_SPACE,MANAGER_PHONE,MANAGER_PHONE_S1,MANAGER_PHONE_S2,MANAGER_STATUS) VALUES ('Джастин','Бибер','Джонович','Днепровкий',45745747,457457457,4634634,'Уволен');
	INSERT INTO ST_MANAGERS (MANAGER_FIRST_NAME,MANAGER_LAST_NAME,MANAGER_FATHERS_NAME,MANAGER_SPACE,MANAGER_PHONE,MANAGER_PHONE_S1,MANAGER_PHONE_S2,MANAGER_STATUS) VALUES ('Леонид','Черновецкий','Валериевич','Шевченковкий',3463463,765756756,657567567,'Работает');
	
	
	  CREATE TABLE IF NOT EXISTS ST_EQUIPMENT_VENDORS(
 EQ_VENDOR_ID INT NOT NULL AUTO_INCREMENT ,
 EQ_VENDOR_NAME VARCHAR (70),
 EQ_VENDOR_MODEL VARCHAR (70),
 EQ_VENDOR_SERIAL_NUM INT (100),
 EQ_VENDOR_SOFTWARE VARCHAR (100),
 EQ_VENDOR_PORTS_COUNT INT (30),
 EQ_VENDOR_OPTICAL_COUNT INT (30),
 EQ_VENDOR_YEAR INT (30),
  PRIMARY KEY (EQ_VENDOR_ID) 
  
  );
  
  INSERT INTO ST_EQUIPMENT_VENDORS (EQ_VENDOR_NAME,EQ_VENDOR_MODEL,EQ_VENDOR_SERIAL_NUM,EQ_VENDOR_SOFTWARE,EQ_VENDOR_PORTS_COUNT,EQ_VENDOR_OPTICAL_COUNT,EQ_VENDOR_YEAR) VALUES ('Cisco','Catalyst',93423435,'1.0.1', 24, 2, 2007);
  INSERT INTO ST_EQUIPMENT_VENDORS (EQ_VENDOR_NAME,EQ_VENDOR_MODEL,EQ_VENDOR_SERIAL_NUM,EQ_VENDOR_SOFTWARE,EQ_VENDOR_PORTS_COUNT,EQ_VENDOR_OPTICAL_COUNT,EQ_VENDOR_YEAR) VALUES ('Edge-Core','E359',53423423,'1.0.3', 12, 2, 2008);
  INSERT INTO ST_EQUIPMENT_VENDORS (EQ_VENDOR_NAME,EQ_VENDOR_MODEL,EQ_VENDOR_SERIAL_NUM,EQ_VENDOR_SOFTWARE,EQ_VENDOR_PORTS_COUNT,EQ_VENDOR_OPTICAL_COUNT,EQ_VENDOR_YEAR) VALUES ('Linksys','M354',52353252,'4.0.1', 24, 4, 2012);
  INSERT INTO ST_EQUIPMENT_VENDORS (EQ_VENDOR_NAME,EQ_VENDOR_MODEL,EQ_VENDOR_SERIAL_NUM,EQ_VENDOR_SOFTWARE,EQ_VENDOR_PORTS_COUNT,EQ_VENDOR_OPTICAL_COUNT,EQ_VENDOR_YEAR) VALUES ('Mikrotik','S3453345',4532532,'OS 7.0', 4, 0, 2010);
  INSERT INTO ST_EQUIPMENT_VENDORS (EQ_VENDOR_NAME,EQ_VENDOR_MODEL,EQ_VENDOR_SERIAL_NUM,EQ_VENDOR_SOFTWARE,EQ_VENDOR_PORTS_COUNT,EQ_VENDOR_OPTICAL_COUNT,EQ_VENDOR_YEAR) VALUES ('D-Link','F777',324235,'5.0.1', 10, 0, 2004);
  
  CREATE TABLE IF NOT EXISTS ST_STAGE_CONTACTS(
 STAGE_CONTACT_ID INT NOT NULL AUTO_INCREMENT ,
 STAGE_CONTACT_ADRESS VARCHAR (100),
 STAGE_CONTACT_PERSON VARCHAR (100),
 STAGE_CONTACT_PERSON_PHONE INT (255),
 STAGE_CONTACT_PHONE_TECH INT (255),
 STAGE_CONTACT_SECURITY_PHONE INT (255),
  PRIMARY KEY (STAGE_CONTACT_ID) 
  
  );
  
  INSERT INTO ST_STAGE_CONTACTS (STAGE_CONTACT_ADRESS,STAGE_CONTACT_PERSON,STAGE_CONTACT_PERSON_PHONE,STAGE_CONTACT_PHONE_TECH,STAGE_CONTACT_SECURITY_PHONE) VALUES ('Машиностроительная 59Б офис 144','Жлобенко Виталий', 06713214, 09323213,044242421);
  INSERT INTO ST_STAGE_CONTACTS (STAGE_CONTACT_ADRESS,STAGE_CONTACT_PERSON,STAGE_CONTACT_PERSON_PHONE,STAGE_CONTACT_PHONE_TECH,STAGE_CONTACT_SECURITY_PHONE) VALUES ('Межигорская 33В офис 1','Гнус О.В', 523235325, 23523525,23523525);
  INSERT INTO ST_STAGE_CONTACTS (STAGE_CONTACT_ADRESS,STAGE_CONTACT_PERSON,STAGE_CONTACT_PERSON_PHONE,STAGE_CONTACT_PHONE_TECH,STAGE_CONTACT_SECURITY_PHONE) VALUES ('Борщаговсквя 3 здание 1','Семкин Валера', 325325235, 5235235,456456456);
  INSERT INTO ST_STAGE_CONTACTS (STAGE_CONTACT_ADRESS,STAGE_CONTACT_PERSON,STAGE_CONTACT_PERSON_PHONE,STAGE_CONTACT_PHONE_TECH,STAGE_CONTACT_SECURITY_PHONE) VALUES ('Крещатик 14 пентхаус 777','тетя Клава', 235235532, 13123123,213123123);
  INSERT INTO ST_STAGE_CONTACTS (STAGE_CONTACT_ADRESS,STAGE_CONTACT_PERSON,STAGE_CONTACT_PERSON_PHONE,STAGE_CONTACT_PHONE_TECH,STAGE_CONTACT_SECURITY_PHONE) VALUES ('Минская 43 офис 444','дядя Коля', 5325235, 32523523,325235);
  
  
   CREATE TABLE IF NOT EXISTS ST_EQUIPMENT(
 EQUIPMENT_ID INT NOT NULL AUTO_INCREMENT ,
 EQ_VENDOR_ID INT (22),
 EQ_TYPE VARCHAR (22),
 EQ_VLAN_AVAILABLE INT (100),
 EQ_DATE_BOUTH DATE ,
 EQ_STATUS VARCHAR (70),
 FOREIGN KEY (EQ_VENDOR_ID) REFERENCES ST_EQUIPMENT_VENDORS(EQ_VENDOR_ID),
  PRIMARY KEY (EQUIPMENT_ID) 
  
  );
  
  
  INSERT INTO ST_EQUIPMENT (EQ_VENDOR_ID,EQ_TYPE,EQ_VLAN_AVAILABLE,EQ_DATE_BOUTH,EQ_STATUS) VALUES (1,'Hub', 144, '2013-01-01','OFF');
  INSERT INTO ST_EQUIPMENT (EQ_VENDOR_ID,EQ_TYPE,EQ_VLAN_AVAILABLE,EQ_DATE_BOUTH,EQ_STATUS) VALUES (2,'Switch', 102, '2013-01-02','ON');
  INSERT INTO ST_EQUIPMENT (EQ_VENDOR_ID,EQ_TYPE,EQ_VLAN_AVAILABLE,EQ_DATE_BOUTH,EQ_STATUS) VALUES (3,'Router', 144, '2013-01-03','OFF');
  INSERT INTO ST_EQUIPMENT(EQ_VENDOR_ID,EQ_TYPE,EQ_VLAN_AVAILABLE,EQ_DATE_BOUTH,EQ_STATUS) VALUES (4,'Switch', 102, '2013-01-04','ON');
	INSERT INTO ST_EQUIPMENT(EQ_VENDOR_ID,EQ_TYPE,EQ_VLAN_AVAILABLE,EQ_DATE_BOUTH,EQ_STATUS) VALUES (5,'Switch', 144, '2013-01-05','ON');
  
  CREATE TABLE IF NOT EXISTS ST_STAGES (
     STAGE_ID INT NOT NULL AUTO_INCREMENT ,
	 STAGE_NAME VARCHAR(100),
	 STAGE_CONTACT_ID INT(22) NOT NULL ,
	 EQUIPMENT_ID INT(22),
	 STAGE_STATUS VARCHAR (50),
	 STAGE_AVAILABLE_TIME VARCHAR (30),
	 STAGE_DESCRIPTION TEXT (2000),
	 FOREIGN KEY (STAGE_CONTACT_ID) REFERENCES ST_STAGE_CONTACTS(STAGE_CONTACT_ID),
	 FOREIGN KEY (EQUIPMENT_ID) REFERENCES ST_EQUIPMENT(EQUIPMENT_ID),	 
     PRIMARY KEY (STAGE_ID)
) ;


INSERT INTO ST_STAGES (STAGE_NAME,STAGE_CONTACT_ID,EQUIPMENT_ID,STAGE_STATUS,STAGE_AVAILABLE_TIME,STAGE_DESCRIPTION) VALUES ('ATC07',1, 1, 'В работе','с 10 утра', null);
INSERT INTO ST_STAGES (STAGE_NAME,STAGE_CONTACT_ID,EQUIPMENT_ID,STAGE_STATUS,STAGE_AVAILABLE_TIME,STAGE_DESCRIPTION) VALUES ('ATC08',2, 2, 'В работе','с 10 утра', null);
INSERT INTO ST_STAGES (STAGE_NAME,STAGE_CONTACT_ID,EQUIPMENT_ID,STAGE_STATUS,STAGE_AVAILABLE_TIME,STAGE_DESCRIPTION) VALUES ('ATC09',3, 3, 'В работе','с 10 утра', null);
INSERT INTO ST_STAGES (STAGE_NAME,STAGE_CONTACT_ID,EQUIPMENT_ID,STAGE_STATUS,STAGE_AVAILABLE_TIME,STAGE_DESCRIPTION) VALUES ('РОСТОК',4, 4, 'В работе','с 10 утра', null);
INSERT INTO ST_STAGES (STAGE_NAME,STAGE_CONTACT_ID,EQUIPMENT_ID,STAGE_STATUS,STAGE_AVAILABLE_TIME,STAGE_DESCRIPTION) VALUES ('РОСТОК',5, 5, 'В работе','с 10 утра', null);



 CREATE TABLE IF NOT EXISTS ST_ADRESSES(
 ADRESS_ID INT NOT NULL AUTO_INCREMENT ,
 ADRESS_CITY VARCHAR (100),
 ADRESS_STREET VARCHAR (100),
 ADRESS_HOUSE_NUMBER INT (100),
  PRIMARY KEY (ADRESS_ID) 
  
  );
  
   INSERT INTO ST_ADRESSES (ADRESS_CITY,ADRESS_STREET,ADRESS_HOUSE_NUMBER) VALUES ('Kиев','Лермонтова', 10);
  INSERT INTO ST_ADRESSES (ADRESS_CITY,ADRESS_STREET,ADRESS_HOUSE_NUMBER) VALUES ('Kиев','Хмельницкого',33);
  INSERT INTO ST_ADRESSES (ADRESS_CITY,ADRESS_STREET,ADRESS_HOUSE_NUMBER) VALUES ('Kиев','Радищева', 14);
  INSERT INTO ST_ADRESSES (ADRESS_CITY,ADRESS_STREET,ADRESS_HOUSE_NUMBER) VALUES ('Kиев','Пушкина', 3);
  INSERT INTO ST_ADRESSES (ADRESS_CITY,ADRESS_STREET,ADRESS_HOUSE_NUMBER) VALUES ('Kиев','Маркса', 33);
  
  
  CREATE TABLE IF NOT EXISTS ST_SERVICES(
 SERVICE_ID INT NOT NULL AUTO_INCREMENT,
 SERVICE_ADRESS VARCHAR(255),
 CONTRACT_ID INT (22),	
	FOREIGN KEY (CONTRACT_ID) REFERENCES ST_CONTRACTS(CONTRACT_ID),
  PRIMARY KEY (SERVICE_ID)
  
  
  );
 
  INSERT INTO ST_SERVICES (SERVICE_ADRESS,CONTRACT_ID) VALUES (null,1);
  INSERT INTO ST_SERVICES (SERVICE_ADRESS,CONTRACT_ID) VALUES (null,2);
  INSERT INTO ST_SERVICES (SERVICE_ADRESS,CONTRACT_ID) VALUES (null,3);
  INSERT INTO ST_SERVICES (SERVICE_ADRESS,CONTRACT_ID) VALUES (null,4);
  INSERT INTO ST_SERVICES (SERVICE_ADRESS,CONTRACT_ID) VALUES (null,5); 
  
  CREATE TABLE IF NOT EXISTS ST_CLIENTS (
     CLIENT_ID INT NOT NULL AUTO_INCREMENT ,
     CLIENT_FULL_NAME VARCHAR(100) ,
	 CLIENT_DIR_NAME VARCHAR(100) ,
	 ADRESS_ID INT(22) ,
	 STAGE_ID INT(22),
	 MANAGER_ID INT(22),
	 CLIENT_STATUS VARCHAR(22),
     CLIENT_DATE_ON DATE,
     CLIENT_DATE_OFF DATE,
     SERVICE_ID INT(22),
	 CLIENT_PHONE_S INT(255),
     CLIENT_PHONE_BUH INT(255),
     CLIENT_PHONE_DIR INT(255),
     CLIENT_PHONE_IT INT(255),
     CLIENT_FAX INT(100),
     CLIENT_EMAIL VARCHAR(100),
     CLIENT_DESCRIPTION TEXT (2000),
	 FOREIGN KEY (MANAGER_ID) REFERENCES ST_MANAGERS(MANAGER_ID),
	 FOREIGN KEY (SERVICE_ID) REFERENCES ST_SERVICES(SERVICE_ID),
	 FOREIGN KEY (ADRESS_ID) REFERENCES ST_ADRESSES(ADRESS_ID),
	 FOREIGN KEY (STAGE_ID) REFERENCES ST_STAGES(STAGE_ID), 
     PRIMARY KEY (CLIENT_ID)
) ;


 INSERT INTO ST_CLIENTS (CLIENT_FULL_NAME,CLIENT_DIR_NAME,ADRESS_ID,STAGE_ID,MANAGER_ID,CLIENT_STATUS,CLIENT_DATE_ON,CLIENT_DATE_OFF,SERVICE_ID,CLIENT_PHONE_S,CLIENT_PHONE_BUH,CLIENT_PHONE_DIR,CLIENT_PHONE_IT,CLIENT_FAX,CLIENT_EMAIL,CLIENT_DESCRIPTION) VALUES ('Завод Оболонь','Радченко А.В',1,1,1,'ON','2013-01-01','2013-01-02',1,null,null,null,null,null,null,null);
 INSERT INTO ST_CLIENTS (CLIENT_FULL_NAME,CLIENT_DIR_NAME,ADRESS_ID,STAGE_ID,MANAGER_ID,CLIENT_STATUS,CLIENT_DATE_ON,CLIENT_DATE_OFF,SERVICE_ID,CLIENT_PHONE_S,CLIENT_PHONE_BUH,CLIENT_PHONE_DIR,CLIENT_PHONE_IT,CLIENT_FAX,CLIENT_EMAIL,CLIENT_DESCRIPTION) VALUES ('Рикер','Войтенко А.В',2,2,2,'ON','2013-01-01','2013-01-02',2,null,null,null,null,null,null,null);
 INSERT INTO ST_CLIENTS (CLIENT_FULL_NAME,CLIENT_DIR_NAME,ADRESS_ID,STAGE_ID,MANAGER_ID,CLIENT_STATUS,CLIENT_DATE_ON,CLIENT_DATE_OFF,SERVICE_ID,CLIENT_PHONE_S,CLIENT_PHONE_BUH,CLIENT_PHONE_DIR,CLIENT_PHONE_IT,CLIENT_FAX,CLIENT_EMAIL,CLIENT_DESCRIPTION) VALUES ('МюзикБокс','Иванов А.В',3,3,3,'ON','2013-01-01','2013-01-02',3,null,null,null,null,null,null,null);
 INSERT INTO ST_CLIENTS (CLIENT_FULL_NAME,CLIENT_DIR_NAME,ADRESS_ID,STAGE_ID,MANAGER_ID,CLIENT_STATUS,CLIENT_DATE_ON,CLIENT_DATE_OFF,SERVICE_ID,CLIENT_PHONE_S,CLIENT_PHONE_BUH,CLIENT_PHONE_DIR,CLIENT_PHONE_IT,CLIENT_FAX,CLIENT_EMAIL,CLIENT_DESCRIPTION) VALUES ('Тикон','Васильев А.В',4,4,4,'ON','2013-01-01','2013-01-02',4,null,null,null,null,null,null,null);
 INSERT INTO ST_CLIENTS (CLIENT_FULL_NAME,CLIENT_DIR_NAME,ADRESS_ID,STAGE_ID,MANAGER_ID,CLIENT_STATUS,CLIENT_DATE_ON,CLIENT_DATE_OFF,SERVICE_ID,CLIENT_PHONE_S,CLIENT_PHONE_BUH,CLIENT_PHONE_DIR,CLIENT_PHONE_IT,CLIENT_FAX,CLIENT_EMAIL,CLIENT_DESCRIPTION) VALUES ('АЙТИЕНТИ','Митин А.В',5,5,5,'ON','2013-01-01','2013-01-02',5,null,null,null,null,null,null,null);
 


/* 
 INSERT INTO ST_SERVICES_INFO (ADRESS_ID,CONTRACT_ID) VALUES (1,1);
  INSERT INTO ST_SERVICES_INFO (ADRESS_ID,CONTRACT_ID) VALUES (2,2);
  INSERT INTO ST_SERVICES_INFO (ADRESS_ID,CONTRACT_ID) VALUES (3,3);
  INSERT INTO ST_SERVICES_INFO (ADRESS_ID,CONTRACT_ID) VALUES (4,4);
  INSERT INTO ST_SERVICES_INFO (ADRESS_ID,CONTRACT_ID) VALUES (5,5);
  
  CREATE TABLE IF NOT EXISTS ST_CLIENTS_INFO  (
     CLIENT_ID INT NOT NULL AUTO_INCREMENT,
     CLIENT_NAME VARCHAR(100) NOT NULL,
	 MANAGER_ID INT(22),
	 CLIENT_STATUS VARCHAR(22),
     CONTACT_ID INT(22),
     CLIENT_DATE_ON DATE,
     CLIENT_DATE_OFF DATE,
     SERVICE_ID INT(22),
	 CLIENT_DESCRIPTION TEXT (2000),
	 FOREIGN KEY (CONTACT_ID) REFERENCES ST_CLIENTS_CONTACTS(CONTACT_ID),
	 FOREIGN KEY (MANAGER_ID) REFERENCES ST_MANAGERS_INFO(MANAGER_ID),
	 FOREIGN KEY (SERVICE_ID) REFERENCES ST_SERVICES_INFO(SERVICE_ID),
     PRIMARY KEY (CLIENT_ID)
	 
) ;


*/








