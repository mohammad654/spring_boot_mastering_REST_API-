-- -----------------------------------------------------------------------------
-- Demo Data: Carts & Cart Items (With Hours & Minutes)
-- -----------------------------------------------------------------------------

-- Cart 1: Created right now
SET @cart1 = UNHEX(REPLACE(UUID(), '-', ''));
INSERT INTO carts (id, date_created) 
VALUES (@cart1, NOW());

INSERT INTO cart_items (cart_id, product_id, quantity) VALUES
(@cart1, (SELECT id FROM products LIMIT 1 OFFSET 0), 2),
(@cart1, (SELECT id FROM products LIMIT 1 OFFSET 1), 1);


-- Cart 2: Created 3 hours ago
SET @cart2 = UNHEX(REPLACE(UUID(), '-', ''));
INSERT INTO carts (id, date_created) 
VALUES (@cart2, DATE_SUB(NOW(), INTERVAL 3 HOUR));

INSERT INTO cart_items (cart_id, product_id, quantity) VALUES
(@cart2, (SELECT id FROM products LIMIT 1 OFFSET 2), 5);


-- Cart 3: Created 1 day and 4 hours ago
SET @cart3 = UNHEX(REPLACE(UUID(), '-', ''));
INSERT INTO carts (id, date_created) 
VALUES (@cart3, DATE_SUB(NOW(), INTERVAL '1 4' DAY_HOUR));

INSERT INTO cart_items (cart_id, product_id, quantity) VALUES
(@cart3, (SELECT id FROM products LIMIT 1 OFFSET 0), 1),
(@cart3, (SELECT id FROM products LIMIT 1 OFFSET 3), 2);


-- Cart 4: Specific historic date & time (e.g., 2026-10-08 14:30:00)
SET @cart4 = UNHEX(REPLACE(UUID(), '-', ''));
INSERT INTO carts (id, date_created) 
VALUES (@cart4, '2026-10-08 14:30:00');

INSERT INTO cart_items (cart_id, product_id, quantity) VALUES
(@cart4, (SELECT id FROM products LIMIT 1 OFFSET 1), 4);


-- Cart 5: Created right now with default item quantity
SET @cart5 = UNHEX(REPLACE(UUID(), '-', ''));
INSERT INTO carts (id, date_created) 
VALUES (@cart5, NOW());

INSERT INTO cart_items (cart_id, product_id) VALUES
(@cart5, (SELECT id FROM products LIMIT 1 OFFSET 4));