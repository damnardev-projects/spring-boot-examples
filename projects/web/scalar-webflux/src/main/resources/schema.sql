CREATE TABLE IF NOT EXISTS "t_employee"
(
    "id"
    BIGINT
    GENERATED
    BY
    DEFAULT AS
    IDENTITY
    PRIMARY
    KEY,
    "first_name"
    VARCHAR
(
    255
),
    "last_name" VARCHAR
(
    255
),
    "birthday" DATE
    );
