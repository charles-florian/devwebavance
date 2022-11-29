CREATE TABLE IF NOT EXISTS tournaments  (
    id_tournament SERIAL PRIMARY KEY,
    nom varchar(15),
    prix float,
    date_tournament date
    );