-- Insertar datos en ALMACEN
INSERT INTO almacen (nombre, temp) VALUES ('Almacen Central', 'Fresco');

-- Insertar datos en SECCION
INSERT INTO seccion (nombre, limite, accesibilidad, almacen_id) VALUES
                                                                    ('Congelados', 100, 5, 1),
                                                                    ('Refrigerados', 50, 10, 1);

-- Insertar datos en RECIPIENTE
INSERT INTO recipiente (tamanyo, seccion_id) VALUES
                                                 (20, 1),
                                                 (30, 2);

-- Insertar datos en ALIMENTO
INSERT INTO alimento (nombre, perecedero, abierto, tamanyo, fecha_caducidad, seccion_id, recipiente_id, categoria, estado) VALUES
                                                                                                                               ('Manzanas', true, false, 5, '2024-12-31', 2, 2, 'VEGETAL', 'NUEVO'),
                                                                                                                               ('Lata de Sopa', false, false, 10, NULL, 1, 1, 'CONSERVAS', 'NUEVO');
