--users
INSERT INTO usr(id,created_date, updated_date, username,password)
values(1,'2020-01-01','2020-01-01','User1','$2a$10$F54u0Dsy7nP0fGNXXb7yw.bscVuKs9kJxeddA1wkNGBRZKGrK3tEq');

INSERT INTO usr(id,created_date, updated_date, username,password)
values(2,'2020-01-01','2020-01-01','User2','$2a$10$F54u0Dsy7nP0fGNXXb7yw.bscVuKs9kJxeddA1wkNGBRZKGrK3tEq');

-- roles
INSERT INTO role (id,name)
VALUES (1,'USER');

INSERT INTO role (id,name)
VALUES (2,'USER');

-- user roles
INSERT INTO usr_role (user_id, role_id)
VALUES (2, 2);

INSERT INTO usr_role (user_id, role_id)
VALUES (1, 1);

--exchange_rate
--insert into exchange_rate(id, created_date, updated_date, currency, ecb_date, rate)
--values (1, '2020-01-01','2020-01-01', 'USD', '2022-12-20', 1.0622);
--
--insert into exchange_rate (id, created_date, updated_date, currency, ecb_date, rate)
--values (2, '2020-01-01','2020-01-01', 'PLN', '2022-12-20', 4.6423);
--
--insert into conversion(id, created_date, updated_date, ecb_date, from_value, to_value, conversion_from_id, conversion_to_id, author_id)
--values (1, '2020-01-01','2020-01-01', '2022-12-20', 1, 0.229, 2, 1, 1);
--
--insert into conversion(id, created_date, updated_date, ecb_date, from_value, to_value, conversion_from_id, conversion_to_id, author_id)
--values (2, '2020-01-01','2020-01-01', '2022-12-20', 1, 0.229, 2, 1, 2);