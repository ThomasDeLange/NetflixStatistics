CREATE TABLE Content(
ContentID		int,
Leeftijd		int,
Taal			nvarchar(30),
Genre			nvarchar(30),
)

/* 

*/
CREATE TABLE Film (
 ID				nvarchar(6),
 Titel			nvarchar(45), 
 Tijdsduur		TIME,
 
 CONSTRAINT FilmPK 
		PRIMARY KEY (ID) 	
		);
/*

*/

CREATE TABLE Serie (
 SerieNaam		nvarchar(45),
 Seizoen		nvarchar(8),
 LijktOp		nvarchar(45),

 CONSTRAINT SeriePK 
		PRIMARY KEY (SerieNaam) 	
		);
/*

*/
CREATE TABLE Aflevering (
 ID				nvarchar(6),
 Seizoen		nvarchar(8),
 Titel			nvarchar(45),
 Tijdsduur		TIME,
 SerieNaam		nvarchar(45)

 CONSTRAINT AfleveringPK
		PRIMARY KEY (ID),
		 	
 CONSTRAINT AfleverinFK
 	FOREIGN KEY (SerieNaam)
	REFERENCES Serie(Serienaam)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
		);

/*

*/

