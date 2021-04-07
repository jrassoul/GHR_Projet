-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 05 avr. 2021 à 12:32
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `id_absence` varchar(20) NOT NULL,
  `date_absence` date DEFAULT NULL,
  `motif_absence` varchar(30) DEFAULT NULL,
  `date_reprise` date DEFAULT NULL,
  `id_employe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_absence`),
  KEY `id_employe` (`id_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `absence`
--

INSERT INTO `absence` (`id_absence`, `date_absence`, `motif_absence`, `date_reprise`, `id_employe`) VALUES
('01', '2020-02-12', 'sans_motif', '2020-03-15', 'FR1203'),
('02', '2020-06-01', 'maladie', '2020-06-10', 'FR1201'),
('03', '2020-06-01', 'maladie', '2020-06-10', 'FR1202'),
('04', '2029-05-01', 'sans_motif', '2029-05-15', 'FR1205');

-- --------------------------------------------------------

--
-- Structure de la table `avantage`
--

DROP TABLE IF EXISTS `avantage`;
CREATE TABLE IF NOT EXISTS `avantage` (
  `id_avantage` varchar(20) NOT NULL,
  `type_avantage` varchar(30) DEFAULT NULL,
  `annee_validite` int(11) DEFAULT NULL,
  `id_employe` varchar(20) DEFAULT NULL,
  `montant_avantage` float DEFAULT NULL,
  PRIMARY KEY (`id_avantage`),
  KEY `id_employe` (`id_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `avantage`
--

INSERT INTO `avantage` (`id_avantage`, `type_avantage`, `annee_validite`, `id_employe`, `montant_avantage`) VALUES
('01', 'ticket_restaurant', 2022, 'FR1201', 50),
('02', 'Voiture_Service', 2022, 'FR1203', 80000),
('03', 'bon_achat', 2022, 'FR1203', 200),
('04', 'Voiture_Service', 2025, 'FR1209', 10000);

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
CREATE TABLE IF NOT EXISTS `contrat` (
  `id_contrat` varchar(10) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `id_employe` varchar(20) DEFAULT NULL,
  `nbr_heure_travail` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contrat`),
  KEY `id_employe` (`id_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id_contrat`, `date_debut`, `id_employe`, `nbr_heure_travail`) VALUES
('01', '2019-02-01', 'FR1201', 35),
('02', '2015-01-01', 'FR1203', 36),
('05', '2020-05-01', 'FR1200', 27),
('06', '2019-08-05', 'FR1209', 35);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id_employe` varchar(20) NOT NULL,
  `nom_employe` varchar(20) DEFAULT NULL,
  `prenom_employe` varchar(20) DEFAULT NULL,
  `statut_employe` varchar(30) DEFAULT NULL,
  `nationalite_employe` varchar(30) DEFAULT NULL,
  `age_employe` int(11) DEFAULT NULL,
  `salaire` float DEFAULT NULL,
  PRIMARY KEY (`id_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id_employe`, `nom_employe`, `prenom_employe`, `statut_employe`, `nationalite_employe`, `age_employe`, `salaire`) VALUES
('FR1200', 'Ait-Abdelkader', 'Lydia', 'cadre', 'Algerienne', 23, 3500),
('FR1201', 'Rebib', 'Sabrina', 'Cadre', 'Algerienne', 25, 3500),
('FR1202', 'Curie', 'Nicolas', 'Ingenieur', 'Française', 33, 3500),
('FR1203', 'Dupont', 'François', 'Technicien', 'Française', 38, 1200),
('FR1204', 'Leclaire', 'Marie', 'Directrice', 'Française', 45, 4000),
('FR1205', 'Rassoul', 'Juba', 'Chef de service', 'Turque', 25, 3000),
('FR1206', 'Rouas', 'Amal', 'Chef de service', 'Algerienne', 30, 3000),
('FR1207', 'Zhang', 'Wei', 'Cadre', 'Chinoise', 25, 3500),
('FR1208', 'Li', 'Jing', 'Cadre', 'Chinoise', 63, 3500),
('FR1209', 'Arkab', 'Selma', 'Cadre', 'Italienne', 29, 3500);


-- --------------------------------------------------------

--
-- Structure de la table `pret`
--

DROP TABLE IF EXISTS `pret`;
CREATE TABLE IF NOT EXISTS `pret` (
  `id_pret` varchar(20) NOT NULL,
  `type_pret` varchar(30) DEFAULT NULL,
  `date_pret` date DEFAULT NULL,
  `montant_pret` float DEFAULT NULL,
  `duree_pret` int(11) DEFAULT NULL,
  `id_employe` varchar(20) DEFAULT NULL,
  `poucentage_prlv_sem` double DEFAULT NULL,
  PRIMARY KEY (`id_pret`),
  KEY `id_employe` (`id_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pret`
--

INSERT INTO `pret` (`id_pret`, `type_pret`, `date_pret`, `montant_pret`, `duree_pret`, `id_employe`, `poucentage_prlv_sem`) VALUES
('4567', 'voiture', '2020-02-23', 10000, 2, 'FR1203', 0.3),
('4568', 'voiture', '2020-05-20', 20000, 1, 'FR1202', 0.3),
('4569', 'immobilier', '2021-02-23', 80000, 3, 'FR1203', 0.4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
