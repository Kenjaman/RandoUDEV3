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
  `nb_like` int(11) default '0'
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

CREATE TABLE `Photo` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  id_etape int not null,
  `photo` blob
)ENGINE = INNODB;

CREATE TABLE `Commentaire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  id_etape int not null,
  `com` varchar(255)
)ENGINE = INNODB;;

ALTER TABLE `EtapeItineraire` ADD FOREIGN KEY (`id_itineraire`) REFERENCES `Itineraire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `EtapeItineraire` ADD FOREIGN KEY (`id_etape`) REFERENCES `Etape` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Commentaire` ADD FOREIGN KEY (`id_etape`) REFERENCES `Etape` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Photo` ADD FOREIGN KEY (`id_etape`) REFERENCES `Etape` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `itineraire` (`id`, `nom`, `niveau`) VALUES (NULL, 'Le premier chemin', 'Debutant'),
(NULL, 'Le deuxieme chemin', 'Normal');

INSERT INTO `utilisateur` (`id`, `pseudo`, `mdp`, `role`) VALUES (NULL, 'pattho', 'ZeroM$Pe', 'admin'),
(NULL, 'damien', 'CrEpEsP6','admin');

INSERT INTO `etape` (`id`, `nom`, `description`, `nb_like`) VALUES 
(NULL, 'La deuxieme etape', 'C\'est encore mieux', '0'), 
(NULL, 'La troisieme ', 'C\'est splendide', '0');
