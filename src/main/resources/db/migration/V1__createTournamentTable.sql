CREATE TABLE IF NOT EXISTS tournaments (
    id_tournament SERIAL PRIMARY KEY,
    nom varchar(15),
    prix float,
    date_tournament date
    UPDATE=flyway_schema_history SET checksum=1341852848 WHERE version='1' AND checksum=41447489;

    );
