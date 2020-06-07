create table if not exists User
(
    Id   bigint NOT NULL,
    Name text,
    Age  bigint,
    City text
);

-- INSERT INTO User (id, name, age, city)
-- values (1, 'Tirion', 25, 'RoyalHarbor'),
--        (2, 'Jayme', 30, 'RoyalHarbor'),
--        (3, 'Sersea', 27, 'RoyalHarbor');
