create table carts
(
    id           binary(16) not null primary key,
    date_created date default (curdate()) not null
);

create table cart_items
(
    id         bigint auto_increment primary key,
    cart_id    binary(16)    not null,
    product_id bigint        not null,
    quantity   int default 1 not null,
    constraint cart_items_cart_product_unique
        unique (cart_id, product_id),
    constraint cart_items_carts_id_fk
        foreign key (cart_id) references carts (id)
            on delete cascade,
    constraint cart_items_products_id_fk
        foreign key (product_id) references products (id)
            on delete cascade
);
ALTER TABLE carts 
    MODIFY COLUMN date_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;


-- order 
create table orders
(
    id          bigint auto_increment
        primary key,
    customer_id bigint                             not null,
    status      varchar(20)                        not null,
    created_at  datetime default current_timestamp not null,
    total_price decimal(10, 2)                     not null,
    constraint orders_users_id_fk
        foreign key (customer_id) references users (id)
);

create table order_items
(
    id          bigint auto_increment
        primary key,
    order_id    bigint         not null,
    product_id  bigint         not null,
    unit_price  decimal(10, 2) not null,
    quantity    int            not null,
    total_price decimal(10, 2) not null,
    constraint order_items_orders_id_fk
        foreign key (order_id) references orders (id),
    constraint order_items_products_id_fk
        foreign key (product_id) references products (id)
);