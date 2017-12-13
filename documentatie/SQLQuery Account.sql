CREATE TABLE Account (
 AbonneeNR		nvarchar(9),
 Naam			nvarchar(45),  Straat			nvarchar(45),
 Postcode		nvarchar(7),
 Huisnummer		nvarchar(3),
 Woonplaats		nvarchar(30),

 CONSTRAINT AccountPK 
		PRIMARY KEY (AbonneeNR) 	
		);
/*

*/

CREATE TABLE Profiel (
 AbonneeNR		nvarchar(9),
 ProfielNaam	nvarchar(8),  Geboortedatum	DateTime2,


 CONSTRAINT ProfielPK 
		PRIMARY KEY (AbonneeNR, ProfielNaam),

 CONSTRAINT ProfielFK
 	FOREIGN KEY (AbonneeNR)
	REFERENCES Account(AbonneeNR)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
	 	
		);
/*

*/

CREATE TABLE Bekeken (
 AbonneeNR		nvarchar(9),
 ProfielNaam	nvarchar(8),  Gezien			nvarchar(6),
 Percentage		nvarchar(3),

 CONSTRAINT BekekenPK 
		PRIMARY KEY (AbonneeNR, ProfielNaam, Gezien),
		);

CREATE TABLE Profiel_Bekeken (
 ProfielAbonneeNR		nvarchar(9),
 ProfielProfielNaam		nvarchar(8),  BekekenAbonneeNR		nvarchar(9),
 BekekenProfielNaam		nvarchar(8),
 BekekenGezien			nvarchar(6),


 CONSTRAINT Profiel_bekekenPK
		PRIMARY KEY (BekekenAbonneeNR, BekekenProfielNaam, BekekenGezien),
		 	
 CONSTRAINT Profiel_bekeken_ProfielFK
 	FOREIGN KEY (ProfielAbonneeNR, ProfielProfielNaam)
	REFERENCES Profiel(AbonneeNR, ProfielNaam),

CONSTRAINT Profiel_Bekeken_BekekenFK
	FOREIGN KEY (BekekenAbonneeNR, BekekenProfielNaam, BekekenGezien)
	REFERENCES Bekeken(AbonneeNR, ProfielNaam, Gezien)
	
		);

SELECT *
FROM Account
SELECT *
FROM Bekeken
SELECT *
FROM Profiel
SELECT *
FROM Profiel_Bekeken


