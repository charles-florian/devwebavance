CREATE TABLE IF NOT EXISTS tournament  (
    id_tournament SERIAL PRIMARY KEY,
    nom varchar(15),
    prix float,
    date_tournament date
    );