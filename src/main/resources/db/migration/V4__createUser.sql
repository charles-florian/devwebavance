CREATE TABLE IF NOT EXISTS users (
    id_user SERIAL PRIMARY KEY,
    email varchar(50),
    pseudo varchar(15),
    mdp varchar(100)
);