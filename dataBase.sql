create table roleCompte(
    idRoleCompte int PRIMARY KEY not null AUTO_INCREMENT,
    role varchar(20)
);

create table utilisateur(
    idUtiliateur int primary key not null AUTO_INCREMENT,
    nom varchar(100),
    prenom varchar(100),
    age int,
    sexe varchar(10),
    adresse varchar(200),
    idRoleCompte int,
    foreign key (idRoleCompte) references roleCompte(idRoleCompte)
);

create table region(
    idRegion int primary key not null AUTO_INCREMENT,
    nomRegion varchar(100)
);


create table distrique(
    idDistrique int primary key not null AUTO_INCREMENT,
    nomDistrique varchar(100)
);

create table status(
    idstatut int primary key not null AUTO_INCREMENT,
    nomStatus varchar(100)
);

create table priorite(
    idPriorite int primary key not null AUTO_INCREMENT,
    nomPriorite varchar(100)
);

create table demande(
    idDemande int primary key not null AUTO_INCREMENT,
    idRegion int,
    idDistrique int,
    idPriorite int,
    vu int,
    description varchar(1000),
    dateInsertion date,
    dateModification date,
    foreign key (idRegion) references region(idRegion),
    foreign key (idDistrique) references distrique(idDistrique),
    foreign key (idPriorite) priorite(idPriorite)
);

create table reponseDemande(
    idReponseDemande int primary key not null AUTO_INCREMENT,
    idDemande int,
    reponse varchar(1000),
    idstatut int,
    foreign key (idDemande) references demande(idDemande),
    foreign key (idstatut) references status(idstatut)
);

create table signalerDemande(
    idSignalerDemande int primary key not null AUTO_INCREMENT,
    idDemande int,
    descriptionSignalement varchar(1000),
    foreign key (idDemande) references demande(idDemande)
);

insert into roleCompte(role) 
     values ("Manager"),("Responsable");

insert into utilisateur(nom,prenom,age,sexe,adresse,idRoleCompte) 
    values ("Rakotonirina","Mamy","30","HOMME","Lot IVD Tanna 101",1),
        ("Rabesoa","Tafitasoa Aina","34","FEMME","Lot IHD Tana 102",1),
        ("Andriniaina", "Toky","34","HOMME","Lot IHD Tana 102",2),
        ("Andriatony","Tony","43","HOMME","Lot IHD Tana 106",2);

insert into region(nomRegion) 
    values ("MAJUNGA"),("TAMATAVY"),("DIEGO");