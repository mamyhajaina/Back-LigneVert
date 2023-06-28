create table roleCompte(
    idRoleCompte int PRIMARY KEY not null AUTO_INCREMENT,
    role varchar(20)
);
insert into roleCompte(role) 
     values ("Manager"),("Responsable");


create table utilisateur(
    idUtiliateur int primary key not null AUTO_INCREMENT,
    nom varchar(100),
    prenom varchar(100),
    age int,
    sexe varchar(10),
    adresse varchar(200),
    idRoleCompte int,
    adresseMail varchar(200),
    motsDePasse varchar(500),
    foreign key (idRoleCompte) references roleCompte(idRoleCompte)
);
insert into utilisateur(nom,prenom,age,sexe,adresse,idRoleCompte,adresseMail,motsDePasse) 
    values ("Rakotonirina","Mamy",30,"HOMME","Lot IVD Tanna 101",1,sha1("mamy"),sha1("mamy")),
        ("Rabesoa","Tafitasoa Aina",34,"FEMME","Lot IHD Tana 102",1,sha1("aina"),sha1("aina")),
        ("Andriniaina", "Toky",34,"HOMME","Lot IHD Tana 102",2,sha1("toky"),sha1("toky")),
        ("Andriatony","Tony",43,"HOMME","Lot IHD Tana 106",2,sha1("tony"),sha1("tony"));

create table status(
    idstatut int primary key not null AUTO_INCREMENT,
    nomStatus varchar(100),
    codeCouleur varchar(100)
);
insert into status(nomStatus,codeCouleur) values("En cours","vert"),("Terminé","Bleu"),("En attente","Jaune"),("Annulé","Rouge");

create table priorite(
    idPriorite int primary key not null AUTO_INCREMENT,
    nomPriorite varchar(100)
);
insert into priorite(nomPriorite) values("élevée"),("normale"),("basse");


-- Classification
create table projet(
    idProjet int primary key not null AUTO_INCREMENT,
    nomProjet varchar(500),
    details varchar(1000),
    powerAppId varchar(100)
);
-- projet RIMA
insert into projet(nomProjet,details,powerAppId)
    values ("RIMA","","");

create table volet(
    idVolet int primary key not null AUTO_INCREMENT,
    nomVolet varchar(100),
    idProjet int,
    foreign key (idProjet) references projet(idProjet)
);
-- projet RIMA
insert into volet(nomVolet,idProjet) values("Distribution de vivres GFD",1),("FFA",1),("Nutrition",1),("Protection",1);

create table activites(
    idActivites int primary key not null AUTO_INCREMENT,
    nomActivites varchar(100),
    idVolet int,
    foreign key(idVolet) references volet(idVolet)
);
-- projet RIMA
insert into activites(nomActivites,idVolet)
    values ("Planning",1),("Liste participants",1),("Carte participants",1),("Site de distribution",1),("Quantité/ Qualité des vivres",1),
        ("Qualité/ Quantité des vivres",2),("Travaux",2),("Liste participants",2),("Site d’activité",2),("Distribution de vivres",2),
        ("Conseils FE/FA",3),("SPC/PECMAM",3);

create table detailsActivites(
    idDetailsActivites int primary key not null AUTO_INCREMENT,
    nomDetailsActivites varchar(100),
    idActivites int,
    foreign key(idActivites) references activites(idActivites)
);
-- projet RIMA
insert into detailsActivites(nomDetailsActivites,idActivites)
    values ("Planning",10),("Carte participants",10),("Qualité/ Quantité des vivres",10);


-- Localisation
create table region(
    idRegion int primary key not null AUTO_INCREMENT,
    nomRegion varchar(100),
    idProjet int,
    foreign key (idProjet) references projet(idProjet)
);
-- projet RIMA
insert into region(nomRegion,idProjet) values ("Androy",1),("Atsimo Andrefana",1);


create table distrique(
    idDistrique int primary key not null AUTO_INCREMENT,
    nomDistrique varchar(100),
    idRegion int,
    commune varchar(100),
    fokotany varchar(100),
    foreign key (idRegion) references region(idRegion)
);
-- projet RIMA
insert into distrique(nomDistrique,idRegion) values ("AMPANIHY OUEST",1),("BELOHA",1),("TSIHOMBE",1);



-- Gestion demande
create table categireAppel(
    idCategireAppel int primary key not null AUTO_INCREMENT,
    nomCategireAppel varchar(500),
    description varchar(1000)
);
insert into categireAppel(nomCategireAppel) values ("Catégorie 1"),("Catégorie 2"),("Catégorie 3"),("Catégorie 4"),("Autre");

create table demande(
    idDemande int primary key not null AUTO_INCREMENT,
    nomAppelant varchar(100),
    numeroAppelant varchar(50)
    resumeAppel varchar(1000),
    idCategireProjet int,
    idProjet int,
    categorieSocioProAppelant varchar(200),
    dateAppel date,
    dateModification date,
    commune varchar(100),
    fokotany varchar(100),
    vu int,
    idUtiliateur int,
    idPriorite int,
    foreign key (idCategireProjet) references categireProjet(idCategireProjet),
    foreign key (idProjet) references projet(idProjet),
    foreign key (idUtiliateur) utilisateur(idUtiliateur)
    foreign key (idPriorite) priorite(idPriorite),
);




-- Mbola anotanina
-- create table action(
--     idAction int primary key not null AUTO_INCREMENT,
--     nomAction varchar(100)
-- );

-- create table reponseDemande(
--     idReponseDemande int primary key not null AUTO_INCREMENT,
--     idDemande int,
--     reponse varchar(1000),
--     idstatut int,
--     idUtiliateur int,
--     foreign key (idDemande) references demande(idDemande),
--     foreign key (idstatut) references status(idstatut),
--     foreign key (idUtiliateur) utilisateur(idUtiliateur)
-- );

-- create table signalerDemande(
--     idSignalerDemande int primary key not null AUTO_INCREMENT,
--     idDemande int,
--     idUtiliateur int,
--     descriptionSignalement varchar(1000),
--     foreign key (idDemande) references demande(idDemande),
--     foreign key (idUtiliateur) utilisateur(idUtiliateur)
-- );

