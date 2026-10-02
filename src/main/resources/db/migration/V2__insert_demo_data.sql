-- ============================================================
-- V2__insert_demo_data.sql
-- 10 demo inserts for the Flyway Spring Boot project
-- Run AFTER V1__create_tables.sql
-- ============================================================

-- ------------------------------------------------------------
-- DEMO 1: Insert users
-- ------------------------------------------------------------
INSERT INTO users (name, email, password) VALUES
('Alice Johnson', 'alice@example.com',   '$2a$10$abcdefghijklmnopqrstuv1'),
('Bob Smith',     'bob@example.com',     '$2a$10$abcdefghijklmnopqrstuv2'),
('Charlie Brown', 'charlie@example.com', '$2a$10$abcdefghijklmnopqrstuv3'),
('Diana Prince',  'diana@example.com',   '$2a$10$abcdefghijklmnopqrstuv4'),
('Ethan Hunt',    'ethan@example.com',   '$2a$10$abcdefghijklmnopqrstuv5');

-- ------------------------------------------------------------
-- DEMO 2: Insert profiles (id MUST match users.id)
-- ------------------------------------------------------------
INSERT INTO profiles (id, bio, phone_number, date_of_birth, loyalty_points) VALUES
(1, 'Loves coffee and coding', '+31611111111', '1990-05-14', 120),
(2, 'Avid book reader',        '+31622222222', '1988-09-22', 40),
(3, 'Gamer and streamer',      '+31633333333', '1995-01-30', 300),
(4, 'Yoga instructor',         '+31644444444', '1992-11-11', 75),
(5, 'Traveler and foodie',     '+31655555555', '1997-03-08', 210);

-- ------------------------------------------------------------
-- DEMO 3: Insert addresses
-- ------------------------------------------------------------
INSERT INTO addresses (street, city, state, zip, user_id) VALUES
('Keizersgracht 1', 'Amsterdam', 'NH', '1015 CJ', 1),
('Coolsingel 40',   'Rotterdam', 'ZH', '3011 AD', 2),
('Stratumseind 10', 'Eindhoven', 'NB', '5611 EW', 3),
('Grote Markt 5',   'Groningen', 'GR', '9712 HN', 4),
('Oudegracht 100',  'Utrecht',   'UT', '3511 AW', 5);

-- ------------------------------------------------------------
-- DEMO 4: Insert categories (id is TINYINT, max 127)
-- ------------------------------------------------------------
INSERT INTO categories (name) VALUES
('Electronics'),
('Books'),
('Clothing'),
('Home & Kitchen');

-- ------------------------------------------------------------
-- DEMO 5: Insert products — Electronics (category_id = 1)
-- ------------------------------------------------------------
INSERT INTO products (name, price, description, category_id) VALUES
('Wireless Headphones', 99.99,  'Bluetooth over-ear headphones with ANC', 1),
('Smart Watch',         149.50, 'Fitness tracker with GPS and heart rate', 1),
('USB-C Charger 65W',   24.99,  'Fast charging GaN adapter',               1);

-- ------------------------------------------------------------
-- DEMO 6: Insert products — Books (category_id = 2)
-- ------------------------------------------------------------
INSERT INTO products (name, price, description, category_id) VALUES
('Clean Code',        49.99, 'A Handbook of Agile Software Craftsmanship', 2),
('Effective Java',    54.99, 'Best practices for the Java platform',       2),
('Spring Boot Guide', 44.99, 'Master Spring Boot 3 and Spring 6',          2);

-- ------------------------------------------------------------
-- DEMO 7: Insert products — Clothing & Home (category_id = 3, 4)
-- ------------------------------------------------------------
INSERT INTO products (name, price, description, category_id) VALUES
('Cotton T-Shirt', 19.99, 'Unisex plain t-shirt, 100% cotton', 3),
('Running Shoes',  89.00, 'Lightweight breathable sneakers',   3),
('Table Lamp',     34.99, 'LED desk lamp with dimmer',         4);

-- ------------------------------------------------------------
-- DEMO 8: Insert wishlist (composite PK: product_id + user_id)
-- ------------------------------------------------------------
INSERT INTO wishlist (product_id, user_id) VALUES
(1, 1),
(4, 1),
(2, 2),
(3, 3),
(5, 4),
(7, 5),
(8, 5),
(9, 2);

-- ------------------------------------------------------------
-- DEMO 9: Bulk insert — new users + profiles + addresses
-- ------------------------------------------------------------
INSERT INTO users (name, email, password) VALUES
('Fiona Green', 'fiona@example.com',  '$2a$10$abcdefghijklmnopqrstuv6'),
('George King', 'george@example.com', '$2a$10$abcdefghijklmnopqrstuv7');

INSERT INTO profiles (id, bio, phone_number, date_of_birth, loyalty_points) VALUES
(6, 'Coffee enthusiast', '+31666666666', '1994-07-19', 55),
(7, 'New customer',      '+31677777777', '1999-12-01', 0);

INSERT INTO addresses (street, city, state, zip, user_id) VALUES
('Damrak 1', 'Amsterdam', 'NH', '1012 LG', 6),
('Blaak 20', 'Rotterdam', 'ZH', '3011 TA', 7);

-- ------------------------------------------------------------
-- DEMO 10: Final bulk data + wishlist
-- ------------------------------------------------------------
INSERT INTO products (name, price, description, category_id) VALUES
('Coffee Mug',     9.99,  'Ceramic 350ml mug',           4),
('Winter Jacket', 129.99, 'Waterproof insulated jacket', 3);

INSERT INTO wishlist (product_id, user_id) VALUES
(10, 6),
(11, 7);