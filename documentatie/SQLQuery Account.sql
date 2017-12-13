CREATE TABLE Account (
 AbonneeNR		int,
 Naam			nvarchar(45),  Straat			nvarchar(45),
 Postcode		nvarchar(7),
 Huisnummer		int,
 Woonplaats		nvarchar(30),

 CONSTRAINT AccountPK 
		PRIMARY KEY (AbonneeNR) 	
		);
/*

*/

CREATE TABLE Profiel (
 AbonneeNR		int,
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
 AbonneeNR		int,
 ProfielNaam	nvarchar(8),  Gezien			int,
 Percentage		int,

 CONSTRAINT BekekenPK 
		PRIMARY KEY (AbonneeNR, ProfielNaam, Gezien),
		 	
 CONSTRAINT bekeken_ProfielFK
 	FOREIGN KEY (ProfielAbonneeNR, ProfielProfielNaam)
	REFERENCES Profiel(AbonneeNR, ProfielNaam)
	ON DELETE CASCADE,

CONSTRAINT Bekeken_BekekenFK
	FOREIGN KEY (BekekenAbonneeNR, BekekenProfielNaam, BekekenGezien)
	REFERENCES Bekeken(AbonneeNR, ProfielNaam, Gezien)
	
		);





