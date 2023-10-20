create table roleCompte(
    idRoleCompte int PRIMARY KEY not null AUTO_INCREMENT,
    role varchar(20)
);
insert into roleCompte(role) 
     values ("Manager"),("Responsable");

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
    powerAppId varchar(100),
    couleur varchar(50)
);
-- projet RIMA
insert into projet(nomProjet,details,powerAppId)
    values ("RIMA","","");

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
    idProjet int,
    foreign key (idProjet) references projet(idProjet),
    foreign key (idRoleCompte) references roleCompte(idRoleCompte)
);
insert into utilisateur(nom,prenom,age,sexe,adresse,idRoleCompte,adresseMail,motsDePasse,idProjet) 
    values ("Rakotonirina","Mamy",30,"HOMME","Lot IVD Tanna 101",1,sha1("mamy"),sha1("mamy"),1),
        ("Andriniaina", "Toky",34,"HOMME","Lot IHD Tana 102",2,sha1("toky"),sha1("toky"),null),
        ("Andriatony","Tony",43,"HOMME","Lot IHD Tana 106",2,sha1("tony"),sha1("tony"),null);


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

create table appel(
    idAppel int primary key not null AUTO_INCREMENT,
    nomAppelant varchar(100),
    numeroAppelant varchar(50),
    sexe varchar(7),
    resumeAppel varchar(2000),
    idCategireAppel int,
    idProjet int,
    idVolet int,
    idActivites int,
    idDetailsActivites int,
    idRegion int,
    idDistrique int,
    categorieSocioProAppelant varchar(200),
    dateAppel date,
    dateModification date,
    idUtiliateur int,
    idPriorite int,
    foreign key (idCategireAppel) references categireAppel(idCategireAppel),
    foreign key (idProjet) references projet(idProjet),
    foreign key (idVolet) references volet(idVolet),
    foreign key (idActivites) references activites(idActivites),
    foreign key (idDetailsActivites) references detailsActivites(idDetailsActivites),
    foreign key (idRegion) references region(idRegion),
    foreign key (idDistrique) references distrique(idDistrique),
    foreign key (idUtiliateur) references utilisateur(idUtiliateur),
    foreign key (idPriorite) references priorite(idPriorite)
);
alter table appel add reponseVu int;
insert into appel(nomAppelant, numeroAppelant, sexe, resumeAppel, idCategireAppel, idProjet, idVolet, idActivites, idDetailsActivites, idRegion, idDistrique, categorieSocioProAppelant, dateAppel, dateModification, idUtiliateur, idPriorite)
    values ('Randria','0340277383','HOMME',"test test test test",1,1,1,2,null,1,2,"tsy aiko",now(),null,3,2);

select a.nomAppelant, a.numeroAppelant, a.resumeAppel, a.idProjet, p.nomProjet, v.nomVolet, r.nomRegion, d.nomDistrique, d.commune, d.fokotany 
    from reponseDemande rd
        inner join appel a on rd.idAppel = a.idAppel
        left join status s on rd.idstatut = s.idstatut
        left join projet p on a.idProjet = p.idProjet
        left join volet v on a.idVolet = v.idVolet
        left join region r on a.idRegion = r.idRegion 
        left join distrique d on a.idDistrique = d.idDistrique
        where a.idProjet = 1
            and rd.reponseDemande = null



-- Module manager
create table status(
    idstatut int primary key not null AUTO_INCREMENT,
    nomStatus varchar(100),
    codeCouleur varchar(100)
);
insert into status(nomStatus,codeCouleur) values("En cours","vert"),("Terminé","Bleu"),("En attente","Jaune"),("Annulé","Rouge");

create table reponseDemande(
    idReponseDemande int primary key not null AUTO_INCREMENT,
    idAppel int,
    reponse varchar(1000),
    idstatut int,
    idUtiliateur int,
    vu boolean,
    foreign key (idAppel) references appel(idAppel),
    foreign key (idstatut) references status(idstatut),
    foreign key (idUtiliateur) references utilisateur(idUtiliateur)
);
alter table reponseDemande add reponseDemande  boolean;
alter table reponseDemande add intervention  varchar(50);
alter table reponseDemande add constatResolution  varchar(100);
alter table reponseDemande add dateInsertion  date;
