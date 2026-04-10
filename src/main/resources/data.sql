INSERT INTO pilotos (nombre, rango)
VALUES ('Nova Vega', 'Comandante'),
       ('Kai Orion', 'Teniente'),
       ('Luna Solaris', 'Capitana');

INSERT INTO naves (nombre, modelo, piloto_id)
VALUES ('Nebula-1', 'Explorer X', 1),
       ('Titan-7', 'Cargo Z', 2),
       ('Falcon-X', 'Interceptor V', 3);

INSERT INTO misiones (codigo, destino, estado, nave_id)
VALUES ('MS-001', 'Marte', 'PLANIFICADA', 1),
       ('MS-002', 'Europa', 'EN_CURSO', 2),
       ('MS-003', 'Titan', 'COMPLETADA', 3);