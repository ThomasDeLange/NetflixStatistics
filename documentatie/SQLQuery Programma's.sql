CREATE TABLE Content(
ContentID		int,
Leeftijd		int,
Taal			nvarchar(30),
Genre			nvarchar(30),
Titel			nvarchar(45),


	CONSTRAINT ContentPK
		PRIMARY KEY (ContentID)
)

/* 

*/
CREATE TABLE Film (
 Tijdsduur		TIME,
 ContentID		int,

	CONSTRAINT FilmPK 
		PRIMARY KEY (ContentID),

	CONSTRAINT FilmFK
		FOREIGN KEY (ContentID)
		REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
		);
/*

*/

CREATE TABLE Serie (
 Seizoen		nvarchar(8),
 LijktOp		nvarchar(45),
 ContentID		int,

 CONSTRAINT SeriePK 
		PRIMARY KEY (ContentID),
		
	CONSTRAINT SerieFk
		FOREIGN KEY (ContentID)
		REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
);
/*

*/

CREATE TABLE Aflevering (
 ID				int,
 Seizoen		nvarchar(8),
 Titel			nvarchar(45),
 Tijdsduur		TIME,
 ContentID      int,
 CONSTRAINT AfleveringPK
		PRIMARY KEY (ID),
		 	
 CONSTRAINT AfleverinFK
 	FOREIGN KEY (ContentID)
	REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
		);

/*

*/

