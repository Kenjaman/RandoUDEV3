CREATE TABLE `Itineraire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `niveau` ENUM ('Debutants', 'Normal', 'Confirme')
);

CREATE TABLE `Etape` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255),
  `qr_code` varchar(255),
  `nb_like` int
);

CREATE TABLE `EtapeItineraire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `num_etape` int
);

CREATE TABLE `Utilisateur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `pseudo` varchar(255),
  `mdp` varchar(255),
  `role` varchar(255)
);

ALTER TABLE `EtapeItineraire` ADD FOREIGN KEY (`id`) REFERENCES `Itineraire` (`id`);

ALTER TABLE `Etape` ADD FOREIGN KEY (`id`) REFERENCES `EtapeItineraire` (`id`);
