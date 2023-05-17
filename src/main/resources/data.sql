
-- Inserta datos en la tabla role
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_OWNER', 'ROLE_OWNER');

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