
CREATE TABLE customers(
	customer_ID SERIAL PRIMARY KEY, 
	user_name VARCHAR(20),
	pass_word VARCHAR(20),
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	str_num VARCHAR(10),
	str_name VARCHAR(25),
	city VARCHAR(25),
	state VARCHAR(20),
	zip VARCHAR(5),
	application_status VARCHAR(10) DEFAULT(NULL)
);

CREATE TABLE employees(
	employee_ID SERIAL PRIMARY KEY, 
	user_name VARCHAR(20),
	pass_word VARCHAR(20)
);

CREATE TABLE admins(
	admin_ID SERIAL PRIMARY KEY, 
	user_name VARCHAR(20),
	pass_word VARCHAR(20)
);

CREATE SEQUENCE number_seq START 101;

CREATE TABLE finances(
	Customer_ID INT, 
	account_num INT DEFAULT NEXTVAL('number_seq') PRIMARY KEY,
	account_balance NUMERIC(8,2)
);


DROP TABLE IF EXISTS accounts;

SELECT *  FROM customers WHERE user_name = 'user' AND pass_word = 'pass';

ALTER TABLE customers DROP COLUMN zip;
ALTER TABLE customers DROP COLUMN application_status;

ALTER TABLE customers ADD COLUMN zip VARCHAR(5);
ALTER TABLE customers ADD COLUMN application_status VARCHAR(10) DEFAULT('none');



INSERT INTO employees (user_name, pass_word) 
VALUES ('employee', 'employee');

INSERT INTO admins (user_name, pass_word) 
VALUES ('admin', 'admin');



--SELECT customers.customer_id, customers.first_name, 
--FROM customers
--WHERE customers.customer_id = 2
--INNER JOIN finances ON customer.customer_id=finances.customer_id;

ALTER TABLE finances DROP COLUMN customer_id;
ALTER TABLE finances ADD COLUMN customer_id;


DROP TABLE IF EXISTS finances;

CREATE SEQUENCE num_seq START 101;

CREATE TABLE finances(
	Customer_ID INT, 
	account_num INT DEFAULT NEXTVAL('num_seq') PRIMARY KEY,
	account_balance NUMERIC(8,2)
);


--UPDATE finances SET account_balance = account_balance + '40.88' WHERE account_num = 101;


--SELECT * FROM customers JOIN finances USING (customer_id);    
--   
--SELECT * FROM customers FULL OUTER JOIN finances USING (customer_id);    
--   
--SELECT * FROM customers WHERE application_status = 'applied';   
--     
--SELECT * FROM customers WHERE application_status = 'applied';   
--   
--TRUNCATE TABLE finances;
--
--UPDATE employees SET user_name = 'employee1', pass_word = 'employee1' WHERE employee_id = '1';

