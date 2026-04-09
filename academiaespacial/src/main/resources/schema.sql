CREATE TABLE pilotos
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    rango  VARCHAR(50)  NOT NULL
);

CREATE TABLE naves
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    nombre    VARCHAR(100) NOT NULL,
    modelo    VARCHAR(100) NOT NULL,
    piloto_id INT,
    FOREIGN KEY (piloto_id) REFERENCES pilotos (id)
);

CREATE TABLE misiones
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    codigo  VARCHAR(50)  NOT NULL,
    destino VARCHAR(100) NOT NULL,
    estado  VARCHAR(50)  NOT NULL,
    nave_id INT,
    FOREIGN KEY (nave_id) REFERENCES naves (id)
);