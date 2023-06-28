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

create table region(
    idRegion int primary key not null AUTO_INCREMENT,
    nomRegion varchar(100)
);
insert into region(nomRegion) values ("Atsinanana"),("Sofia");


create table distrique(
    idDistrique int primary key not null AUTO_INCREMENT,
    nomDistrique varchar(100),
    idRegion int,
    foreign key (idRegion) references region(idRegion)
);
insert into distrique(nomDistrique,idRegion) values ("Ampanihy",1),("Beloha",1),("Tsihombe",1),("Toamasina II",2),(" Befandriana Nord",1),("Port Berger",1),("Bealanana",2),("Analalava",2);

create table commune(
    idCommune int primary key not null AUTO_INCREMENT,
    nomCommune varchar(100),
    idDistrique int,
    foreign key (idDistrique) references distrique(idDistrique)
);
insert into commune(nomCommune,idDistrique) 
    values ("Androka",1),("Belafike",1),("Ejeda",1),("Gogogogo",1),
        ("Behabobo",2),("Beloha",2),("Kopoky",2),("Marolinta",2),("Tranoroa",2),("Tranovaho",2),
        ("Anjampaly",3),("Antaritarika",3),("Faux-cap",3),("Imongy",3),("Marovato",3),("Nikoly",3);

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


create table categireProjet(
    idCategireProjet int primary key not null AUTO_INCREMENT,
    nomCategireProjet varchar(500),
    description varchar(1000)
);
insert into categireProjet(nomCategireProjet) values ("Catégorie 1"),("Catégorie 2"),("Catégorie 3"),("Catégorie 4"),("Autre");


-- Mbola tsy vita
create table volet(
    idVolet int primary key not null AUTO_INCREMENT,
    nomVolet varchar(100)
);
insert into volet(nomVolet) values("P1"),("P2"),("Transversale"),("P3");

create table activites(
    idActivites int primary key not null AUTO_INCREMENT,
    nomActivites varchar(100)
);
insert into activites(nomActivites) values("Gouvernance"),("Protection sociale"),("GRC"),("Alphabétisation");

create table projet(
    idProjet int primary key not null AUTO_INCREMENT,
    nomProjet varchar(500),
    idVolet int,
    idActivites int,
    details varchar(1000),
    powerAppId varchar(100),
    idRegion int,
    idDistrique int,
    commune varchar(100),
    fokotany varchar(100),
    foreign key (idVolet) references volet(idVolet),
    foreign key (idActivites) references activites(idActivites),
    foreign key (idRegion) references region(idRegion),
    foreign key (idDistrique) references distrique(idDistrique)
);


create table detailsActivites(
    idDetailsActivites int primary key not null AUTO_INCREMENT,
    nomDetailsActivites varchar(100)
);



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

