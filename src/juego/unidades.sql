
CREATE TABLE `unidades` (
  `Nombre` varchar(50) NOT NULL,
  `Tipo` varchar(10) NOT NULL,
  `Combate` int(3) NOT NULL,
  `Fuerza` int(3) NOT NULL,
  `Defensa` int(3) NOT NULL,
  `Num_Ataques` int(3) NOT NULL,
  `Heridas` int(3) NOT NULL,
  `Tipo_Unidad` varchar(20) NOT NULL
);

INSERT INTO `unidades` (`Nombre`, `Tipo`, `Combate`, `Fuerza`, `Defensa`, `Num_Ataques`, `Heridas`, `Tipo_Unidad`) VALUES
('Guerrero de minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Infantería'),
('Caballero de Minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Caballería'),
('Guardia del Patio del Manantial', 'Bien', 4, 3, 6, 1, 1, 'Infantería'),
('Guardia de la ciudadela', 'Bien', 4, 3, 5, 1, 1, 'Infantería'),
('Caballero de Dol Amroth', 'Bien', 4, 3, 6, 1, 1, 'Infantería'),
('Capitán de Minas Thirith', 'Bien', 4, 4, 6, 2, 2, 'Infantería'),
('Faramir', 'Bien', 5, 4, 5, 2, 2, 'Infantería'),
('Berengond', 'Bien', 4, 4, 6, 1, 1, 'Infantería'),
('Imrahil', 'Bien', 6, 4, 7, 3, 3, 'Infantería'),
('Damrod', 'Bien', 4, 4, 5, 1, 1, 'Infantería'),
('Rey de los hombres', 'Bien', 5, 4, 4, 2, 2, 'Infantería'),
('Capitán de Dol Amroth', 'Bien', 4, 4, 7, 2, 2, 'Infantería');

