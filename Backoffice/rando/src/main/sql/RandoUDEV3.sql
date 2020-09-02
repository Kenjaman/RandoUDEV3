drop database if exists `RandoUDEV3`;

create database if not exists `RandoUDEV3` character set 'UTF8';

use RandoUDEV3;

CREATE table if not exists `Itineraire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `niveau` ENUM ('Debutant', 'Normal', 'Confirme')
)ENGINE = INNODB;

CREATE TABLE if not exists `Etape` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `description` varchar(255),
  `nb_like` int,
  `latitude` float(8),
  `longitude` float(8)
)ENGINE = INNODB;

CREATE TABLE if not exists `EtapeItineraire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_etape` int not null,
  `id_itineraire` int not null,
  `num_etape` int not null
)ENGINE = INNODB;

CREATE table if not exists `Utilisateur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `pseudo` varchar(255),
  `mdp` varchar(255),
  `role` varchar(255)
)ENGINE = INNODB;

ALTER TABLE `EtapeItineraire` ADD FOREIGN KEY (`id_itineraire`) REFERENCES `Itineraire` (`id`);

ALTER TABLE `EtapeItineraire` ADD FOREIGN KEY (`id_etape`) REFERENCES `Etape` (`id`);

INSERT INTO `itineraire` (`id`, `nom`, `niveau`) VALUES (NULL, 'Le premier chemin', 'Debutant'),
(NULL, 'Le deuxieme chemin', 'Normal');

INSERT INTO `etape` (`id`, `nom`, `description`, `nb_like`, `latitude`, `longitude`) VALUES 
(NULL, 'La deuxieme etape', 'C\'est encore mieux', '0', '22,5844', '44,683'), 
(NULL, 'La troisieme ', 'C\'est splendide', '0', '11,255', '78,8494');
