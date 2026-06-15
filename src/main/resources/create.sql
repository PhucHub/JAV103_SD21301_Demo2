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

-- Movies and MovieSchedules
INSERT INTO movies (title, director, genre, release_year, rating, status) VALUES ('Inception', 'Christopher Nolan', 'Sci-Fi', 2010, 8.8, 'Active');
INSERT INTO movies (title, director, genre, release_year, rating, status) VALUES ('Interstellar', 'Christopher Nolan', 'Sci-Fi', 2014, 8.6, 'Active');
INSERT INTO movies (title, director, genre, release_year, rating, status) VALUES ('The Dark Knight', 'Christopher Nolan', 'Action', 2008, 9.0, 'Inactive');

INSERT INTO movie_schedules (movie_id, schedule_date_time, room, ticket_price) VALUES (1, '2026-06-15 14:00:00', 'Room 1', 12.50);
INSERT INTO movie_schedules (movie_id, schedule_date_time, room, ticket_price) VALUES (2, '2026-06-15 17:30:00', 'Room 2', 15.00);
INSERT INTO movie_schedules (movie_id, schedule_date_time, room, ticket_price) VALUES (3, '2026-06-16 20:00:00', 'Room 1', 10.00);

