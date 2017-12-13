CREATE TABLE Content(
ContentID		int,
Leeftijd		int,
Taal			nvarchar(30),
Genre			nvarchar(30),

	CONSTRAINT ContentPK
		PRIMARY KEY (ContentID)
)

/* 

*/
CREATE TABLE Film (
 ID				nvarchar(6),
 Titel			nvarchar(45), 
 Tijdsduur		TIME,
 ContentID		int,

	CONSTRAINT FilmPK 
		PRIMARY KEY (ID),

	CONSTRAINT FilmFK
		FOREIGN KEY (ContentID)
		REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
		);
/*

*/

CREATE TABLE Serie (
 SerieNaam		nvarchar(45),
 Seizoen		nvarchar(8),
 LijktOp		nvarchar(45),
 ContentID		int,

 CONSTRAINT SeriePK 
		PRIMARY KEY (SerieNaam),
		
	CONSTRAINT SerieFk
		FOREIGN KEY (ContentID)
		REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
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

