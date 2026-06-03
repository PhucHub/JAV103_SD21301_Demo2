INSERT INTO students (id, name, email, phone) VALUES (1001, 'Student 1', 'Email 1', 'Phone 1');
INSERT INTO students (id, name, email, phone) VALUES (1002, 'Student 2', 'Email 2', 'Phone 2');
INSERT INTO students (id, name, email, phone) VALUES (1003, 'Student 3', 'Email 3', 'Phone 3');


--@OneToMany and @ManyToOne
INSERT INTO categories (name) VALUES ('category 1');
INSERT INTO categories (name) VALUES ('category 2');
INSERT INTO categories (name) VALUES ('category 3');

INSERT INTO products (id, name, price, category_id) VALUES (101, 'product 1', 9.1, 1);
INSERT INTO products (id, name, price, category_id) VALUES (102, 'product 2', 9.2, 3);
INSERT INTO products (id, name, price, category_id) VALUES (103, 'product 3', 9.3, 2);
INSERT INTO products (id, name, price, category_id) VALUES (104, 'product 4', 9.4, 1);
