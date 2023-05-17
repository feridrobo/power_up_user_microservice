-- Borra la tabla user si ya existe
DROP TABLE IF EXISTS `user`;

-- Borra la tabla role si ya existe
DROP TABLE IF EXISTS `role`;

-- Crea la tabla role
CREATE TABLE `role` (
                        `id` INT PRIMARY KEY,
                        `description` VARCHAR(255),
                        `name` VARCHAR(255)
);

-- Inserta datos en la tabla role
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_OWNER', 'ROLE_OWNER');

-- Crea la tabla user
CREATE TABLE `user` (
                        `id` INT PRIMARY KEY,
                        `name` VARCHAR(255),
                        `surname` VARCHAR(255),
                        `birthdate` DATE,
                        `phone` VARCHAR(20),
                        `dniNumber` VARCHAR(20),
                        `mail` VARCHAR(255),
                        `password` VARCHAR(255),
                        `id_rol` INT,
                        FOREIGN KEY (`id_rol`) REFERENCES `role`(`id`)
);

-- Inserta datos en la tabla user
INSERT INTO `user` (
    `id`,
    `name`,
    `surname`,
    `birthdate`,
    `phone`,
    `dni_number`,
    `mail`,
    `password`,
    `id_role`
)
VALUES
    (
        '1',
        'Manuel',
        'Idrobo',
        '2001-10-30',
        '+573208853789',
        '1234567890',
        'feridrobo3@gmail.com',
        '$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S',
        '1'
    );