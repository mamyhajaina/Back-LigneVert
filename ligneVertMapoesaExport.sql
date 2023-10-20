-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  jeu. 03 août 2023 à 09:59
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ligneVertMapoesa`
--

-- --------------------------------------------------------

--
-- Structure de la table `activites`
--

CREATE TABLE `activites` (
  `idActivites` int(11) NOT NULL,
  `nomActivites` varchar(100) DEFAULT NULL,
  `idVolet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `activites`
--

INSERT INTO `activites` (`idActivites`, `nomActivites`, `idVolet`) VALUES
(1, 'Planning', 1),
(2, 'Liste participants', 1),
(3, 'Carte participants', 1),
(4, 'Site de distribution', 1),
(5, 'Quantité/ Qualité des vivres', 1),
(6, 'Qualité/ Quantité des vivres', 2),
(7, 'Travaux', 2),
(8, 'Liste participants', 2),
(9, 'Site d’activité', 2),
(10, 'Distribution de vivres', 2),
(11, 'Conseils FE/FA', 3),
(12, 'SPC/PECMAM', 3);

-- --------------------------------------------------------

--
-- Structure de la table `appel`
--

CREATE TABLE `appel` (
  `idAppel` int(11) NOT NULL,
  `nomAppelant` varchar(100) DEFAULT NULL,
  `numeroAppelant` varchar(50) DEFAULT NULL,
  `sexe` varchar(7) DEFAULT NULL,
  `resumeAppel` varchar(2000) DEFAULT NULL,
  `idCategireAppel` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  `idVolet` int(11) DEFAULT NULL,
  `idActivites` int(11) DEFAULT NULL,
  `idDetailsActivites` int(11) DEFAULT NULL,
  `idRegion` int(11) DEFAULT NULL,
  `idDistrique` int(11) DEFAULT NULL,
  `categorieSocioProAppelant` varchar(200) DEFAULT NULL,
  `dateAppel` date DEFAULT NULL,
  `dateModification` date DEFAULT NULL,
  `idUtiliateur` int(11) DEFAULT NULL,
  `idPriorite` int(11) DEFAULT NULL,
  `reponseVu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `appel`
--

INSERT INTO `appel` (`idAppel`, `nomAppelant`, `numeroAppelant`, `sexe`, `resumeAppel`, `idCategireAppel`, `idProjet`, `idVolet`, `idActivites`, `idDetailsActivites`, `idRegion`, `idDistrique`, `categorieSocioProAppelant`, `dateAppel`, `dateModification`, `idUtiliateur`, `idPriorite`, `reponseVu`) VALUES
(2, 'test', '2345678', 'HOMME', '2323', 2, 1, 1, 2, NULL, 1, 2, 'tsy aiko', '2023-07-18', NULL, 3, 2, 1),
(3, 'dfgh', 'dfghj', 'Femme', 'xhgjk', 3, 1, 1, 2, NULL, 1, 1, 'ghg', '2023-07-23', NULL, 3, NULL, 1),
(4, 'fvfv', 'everv', 'Femme', 'ervrev', 1, 1, 2, 8, NULL, 1, 1, 'ervr', '2023-07-25', NULL, 3, NULL, 1),
(5, 'tybty', 'tbtb', 'Femme', 'rtvtrv', 2, 1, 1, 1, NULL, 1, NULL, 'rtbtr', '2023-07-25', NULL, 3, NULL, 1),
(6, 'ttavvu', '24545', 'Femme', 'kugfweui wiue iewu euwi ew', 2, 1, 2, 6, NULL, 1, 1, 'sdfghj', '2023-07-25', NULL, 3, NULL, 1),
(7, 'qsdf', 'secsd', 'Femme', 'sdcds', 1, 2, NULL, NULL, NULL, NULL, NULL, 'sdcds', '2023-07-25', NULL, 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categireAppel`
--

CREATE TABLE `categireAppel` (
  `idCategireAppel` int(11) NOT NULL,
  `nomCategireAppel` varchar(500) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categireAppel`
--

INSERT INTO `categireAppel` (`idCategireAppel`, `nomCategireAppel`, `description`) VALUES
(1, 'Catégorie 1', NULL),
(2, 'Catégorie 2', NULL),
(3, 'Catégorie 3', NULL),
(4, 'Catégorie 4', NULL),
(5, 'Autre', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `detailsActivites`
--

CREATE TABLE `detailsActivites` (
  `idDetailsActivites` int(11) NOT NULL,
  `nomDetailsActivites` varchar(100) DEFAULT NULL,
  `idActivites` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailsActivites`
--

INSERT INTO `detailsActivites` (`idDetailsActivites`, `nomDetailsActivites`, `idActivites`) VALUES
(1, 'Planning', 10),
(2, 'Carte participants', 10),
(3, 'Qualité/ Quantité des vivres', 10);

-- --------------------------------------------------------

--
-- Structure de la table `distrique`
--

CREATE TABLE `distrique` (
  `idDistrique` int(11) NOT NULL,
  `nomDistrique` varchar(100) DEFAULT NULL,
  `idRegion` int(11) DEFAULT NULL,
  `commune` varchar(100) DEFAULT NULL,
  `fokotany` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `distrique`
--

INSERT INTO `distrique` (`idDistrique`, `nomDistrique`, `idRegion`, `commune`, `fokotany`) VALUES
(1, 'AMPANIHY OUEST', 1, NULL, NULL),
(2, 'BELOHA', 1, NULL, NULL),
(3, 'TSIHOMBE', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE `priorite` (
  `idPriorite` int(11) NOT NULL,
  `nomPriorite` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `priorite`
--

INSERT INTO `priorite` (`idPriorite`, `nomPriorite`) VALUES
(1, 'élevée'),
(2, 'normale'),
(3, 'basse');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `idProjet` int(11) NOT NULL,
  `nomProjet` varchar(500) DEFAULT NULL,
  `details` varchar(1000) DEFAULT NULL,
  `powerAppId` varchar(100) DEFAULT NULL,
  `couleur` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`idProjet`, `nomProjet`, `details`, `powerAppId`, `couleur`) VALUES
(1, 'RIMA', '', '', NULL),
(2, 'test', NULL, NULL, NULL),
(3, 'test 2', NULL, NULL, NULL),
(4, 'Hajaina', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `idRegion` int(11) NOT NULL,
  `nomRegion` varchar(100) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `region`
--

INSERT INTO `region` (`idRegion`, `nomRegion`, `idProjet`) VALUES
(1, 'Androy', 1),
(2, 'Atsimo Andrefana', 1);

-- --------------------------------------------------------

--
-- Structure de la table `reponseDemande`
--

CREATE TABLE `reponseDemande` (
  `idReponseDemande` int(11) NOT NULL,
  `idAppel` int(11) DEFAULT NULL,
  `reponse` varchar(1000) DEFAULT NULL,
  `idstatut` int(11) DEFAULT NULL,
  `idUtiliateur` int(11) DEFAULT NULL,
  `vu` tinyint(1) DEFAULT NULL,
  `suivi` tinyint(1) DEFAULT NULL,
  `reponseDemande` tinyint(1) DEFAULT NULL,
  `intervention` varchar(50) DEFAULT NULL,
  `constatResolution` varchar(100) DEFAULT NULL,
  `dateInsertion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reponseDemande`
--

INSERT INTO `reponseDemande` (`idReponseDemande`, `idAppel`, `reponse`, `idstatut`, `idUtiliateur`, `vu`, `suivi`, `reponseDemande`, `intervention`, `constatResolution`, `dateInsertion`) VALUES
(1, 2, 'true', 2, 1, 1, NULL, 1, 'dfgh', 'dgfhjkl', NULL),
(5, 4, 'true', 1, 1, 1, NULL, 1, 'jhbjh', 'jhj', NULL),
(6, 5, 'true', 2, 1, 1, NULL, 1, 'eoirneinr', 'kenrej', NULL),
(7, 6, 'true', 1, 1, 1, NULL, 1, 'dfg', 'fgh', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `roleCompte`
--

CREATE TABLE `roleCompte` (
  `idRoleCompte` int(11) NOT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `roleCompte`
--

INSERT INTO `roleCompte` (`idRoleCompte`, `role`) VALUES
(1, 'Manager'),
(2, 'Responsable');

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `idstatut` int(11) NOT NULL,
  `nomStatus` varchar(100) DEFAULT NULL,
  `codeCouleur` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `status`
--

INSERT INTO `status` (`idstatut`, `nomStatus`, `codeCouleur`) VALUES
(1, 'En cours', 'vert'),
(2, 'Terminé', 'Bleu'),
(3, 'En attente', 'Jaune'),
(4, 'Annulé', 'Rouge');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtiliateur` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `idRoleCompte` int(11) DEFAULT NULL,
  `adresseMail` varchar(200) DEFAULT NULL,
  `motsDePasse` varchar(500) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtiliateur`, `nom`, `prenom`, `age`, `sexe`, `adresse`, `idRoleCompte`, `adresseMail`, `motsDePasse`, `idProjet`) VALUES
(1, 'Rakotonirina', 'Mamy', 30, 'HOMME', 'Lot IVD Tanna 101', 1, '61a7390bae174dcdb0cd01e3283420ee4d5ed5da', '61a7390bae174dcdb0cd01e3283420ee4d5ed5da', 1),
(2, 'Andriniaina', 'Toky', 34, 'HOMME', 'Lot IHD Tana 102', 2, 'a22750be2460a932da2f343e8c35dd170c149997', 'a22750be2460a932da2f343e8c35dd170c149997', NULL),
(3, 'Andriatony', 'Tony', 43, 'HOMME', 'Lot IHD Tana 106', 2, '1001e8702733cced254345e193c88aaa47a4f5de', '1001e8702733cced254345e193c88aaa47a4f5de', NULL),
(4, 'manage1', 'fgh', 30, 'Femme', NULL, NULL, 'toky', 'toky', 2),
(5, 'testtest', 'sdfghj', 34, 'Homme', NULL, NULL, 'test', 'test', 3),
(6, 'Andriantsitohaina', 'rtghjk', 32, 'Femme', NULL, NULL, 'toky', 'toky', 4);

-- --------------------------------------------------------

--
-- Structure de la table `volet`
--

CREATE TABLE `volet` (
  `idVolet` int(11) NOT NULL,
  `nomVolet` varchar(100) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `volet`
--

INSERT INTO `volet` (`idVolet`, `nomVolet`, `idProjet`) VALUES
(1, 'Distribution de vivres GFD', 1),
(2, 'FFA', 1),
(3, 'Nutrition', 1),
(4, 'Protection', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activites`
--
ALTER TABLE `activites`
  ADD PRIMARY KEY (`idActivites`),
  ADD KEY `idVolet` (`idVolet`);

--
-- Index pour la table `appel`
--
ALTER TABLE `appel`
  ADD PRIMARY KEY (`idAppel`),
  ADD KEY `idCategireAppel` (`idCategireAppel`),
  ADD KEY `idProjet` (`idProjet`),
  ADD KEY `idVolet` (`idVolet`),
  ADD KEY `idActivites` (`idActivites`),
  ADD KEY `idDetailsActivites` (`idDetailsActivites`),
  ADD KEY `idRegion` (`idRegion`),
  ADD KEY `idDistrique` (`idDistrique`),
  ADD KEY `idUtiliateur` (`idUtiliateur`),
  ADD KEY `idPriorite` (`idPriorite`);

--
-- Index pour la table `categireAppel`
--
ALTER TABLE `categireAppel`
  ADD PRIMARY KEY (`idCategireAppel`);

--
-- Index pour la table `detailsActivites`
--
ALTER TABLE `detailsActivites`
  ADD PRIMARY KEY (`idDetailsActivites`),
  ADD KEY `idActivites` (`idActivites`);

--
-- Index pour la table `distrique`
--
ALTER TABLE `distrique`
  ADD PRIMARY KEY (`idDistrique`),
  ADD KEY `idRegion` (`idRegion`);

--
-- Index pour la table `priorite`
--
ALTER TABLE `priorite`
  ADD PRIMARY KEY (`idPriorite`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`idProjet`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`idRegion`),
  ADD KEY `idProjet` (`idProjet`);

--
-- Index pour la table `reponseDemande`
--
ALTER TABLE `reponseDemande`
  ADD PRIMARY KEY (`idReponseDemande`),
  ADD KEY `idAppel` (`idAppel`),
  ADD KEY `idstatut` (`idstatut`),
  ADD KEY `idUtiliateur` (`idUtiliateur`);

--
-- Index pour la table `roleCompte`
--
ALTER TABLE `roleCompte`
  ADD PRIMARY KEY (`idRoleCompte`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`idstatut`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtiliateur`),
  ADD KEY `idProjet` (`idProjet`),
  ADD KEY `idRoleCompte` (`idRoleCompte`);

--
-- Index pour la table `volet`
--
ALTER TABLE `volet`
  ADD PRIMARY KEY (`idVolet`),
  ADD KEY `idProjet` (`idProjet`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activites`
--
ALTER TABLE `activites`
  MODIFY `idActivites` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `appel`
--
ALTER TABLE `appel`
  MODIFY `idAppel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `categireAppel`
--
ALTER TABLE `categireAppel`
  MODIFY `idCategireAppel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `detailsActivites`
--
ALTER TABLE `detailsActivites`
  MODIFY `idDetailsActivites` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `distrique`
--
ALTER TABLE `distrique`
  MODIFY `idDistrique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `priorite`
--
ALTER TABLE `priorite`
  MODIFY `idPriorite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `idProjet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `region`
--
ALTER TABLE `region`
  MODIFY `idRegion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `reponseDemande`
--
ALTER TABLE `reponseDemande`
  MODIFY `idReponseDemande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `roleCompte`
--
ALTER TABLE `roleCompte`
  MODIFY `idRoleCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `status`
--
ALTER TABLE `status`
  MODIFY `idstatut` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtiliateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `volet`
--
ALTER TABLE `volet`
  MODIFY `idVolet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activites`
--
ALTER TABLE `activites`
  ADD CONSTRAINT `activites_ibfk_1` FOREIGN KEY (`idVolet`) REFERENCES `volet` (`idVolet`);

--
-- Contraintes pour la table `appel`
--
ALTER TABLE `appel`
  ADD CONSTRAINT `appel_ibfk_1` FOREIGN KEY (`idCategireAppel`) REFERENCES `categireAppel` (`idCategireAppel`),
  ADD CONSTRAINT `appel_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`idProjet`),
  ADD CONSTRAINT `appel_ibfk_3` FOREIGN KEY (`idVolet`) REFERENCES `volet` (`idVolet`),
  ADD CONSTRAINT `appel_ibfk_4` FOREIGN KEY (`idActivites`) REFERENCES `activites` (`idActivites`),
  ADD CONSTRAINT `appel_ibfk_5` FOREIGN KEY (`idDetailsActivites`) REFERENCES `detailsActivites` (`idDetailsActivites`),
  ADD CONSTRAINT `appel_ibfk_6` FOREIGN KEY (`idRegion`) REFERENCES `region` (`idRegion`),
  ADD CONSTRAINT `appel_ibfk_7` FOREIGN KEY (`idDistrique`) REFERENCES `distrique` (`idDistrique`),
  ADD CONSTRAINT `appel_ibfk_8` FOREIGN KEY (`idUtiliateur`) REFERENCES `utilisateur` (`idUtiliateur`),
  ADD CONSTRAINT `appel_ibfk_9` FOREIGN KEY (`idPriorite`) REFERENCES `priorite` (`idPriorite`);

--
-- Contraintes pour la table `detailsActivites`
--
ALTER TABLE `detailsActivites`
  ADD CONSTRAINT `detailsactivites_ibfk_1` FOREIGN KEY (`idActivites`) REFERENCES `activites` (`idActivites`);

--
-- Contraintes pour la table `distrique`
--
ALTER TABLE `distrique`
  ADD CONSTRAINT `distrique_ibfk_1` FOREIGN KEY (`idRegion`) REFERENCES `region` (`idRegion`);

--
-- Contraintes pour la table `region`
--
ALTER TABLE `region`
  ADD CONSTRAINT `region_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`idProjet`);

--
-- Contraintes pour la table `reponseDemande`
--
ALTER TABLE `reponseDemande`
  ADD CONSTRAINT `reponsedemande_ibfk_1` FOREIGN KEY (`idAppel`) REFERENCES `appel` (`idAppel`),
  ADD CONSTRAINT `reponsedemande_ibfk_2` FOREIGN KEY (`idstatut`) REFERENCES `status` (`idstatut`),
  ADD CONSTRAINT `reponsedemande_ibfk_3` FOREIGN KEY (`idUtiliateur`) REFERENCES `utilisateur` (`idUtiliateur`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`idProjet`),
  ADD CONSTRAINT `utilisateur_ibfk_2` FOREIGN KEY (`idRoleCompte`) REFERENCES `roleCompte` (`idRoleCompte`);

--
-- Contraintes pour la table `volet`
--
ALTER TABLE `volet`
  ADD CONSTRAINT `volet_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`idProjet`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
