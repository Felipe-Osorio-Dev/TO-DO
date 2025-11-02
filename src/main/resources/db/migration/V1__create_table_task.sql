CREATE TABLE IF NOT EXISTS tb_task(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    endTime DATE,
    status VARCHAR(20)
);