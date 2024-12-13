SET REFERENTIAL_INTEGRITY TRUE;

-- Creación de la tabla ALMACEN
CREATE TABLE almacen (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         temp VARCHAR(50)
);

-- Creación de la tabla SECCION
CREATE TABLE seccion (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         limite INTEGER NOT NULL,
                         accesibilidad INTEGER NOT NULL,
                         almacen_id BIGINT,
                         FOREIGN KEY (almacen_id) REFERENCES almacen(id)
);

-- Creación de la tabla RECIPIENTE
CREATE TABLE recipiente (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            tamanyo BIGINT NOT NULL,
                            seccion_id BIGINT,
                            FOREIGN KEY (seccion_id) REFERENCES seccion(id)
);

-- Creación de la tabla ALIMENTO
CREATE TABLE alimento (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          perecedero BOOLEAN NOT NULL,
                          abierto BOOLEAN NOT NULL,
                          tamanyo INTEGER NOT NULL,
                          fecha_caducidad DATE,
                          seccion_id BIGINT,
                          recipiente_id BIGINT,
                          categoria VARCHAR(50),
                          estado VARCHAR(50),
                          FOREIGN KEY (seccion_id) REFERENCES seccion(id),
                          FOREIGN KEY (recipiente_id) REFERENCES recipiente(id)
);
