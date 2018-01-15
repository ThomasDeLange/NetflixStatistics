CREATE TABLE Content(
ContentID			int,
MinLeeftijd			int,
Taal				nvarchar(30),
Genre				nvarchar(30),
Titel				nvarchar(45),

	CONSTRAINT ContentPK
		PRIMARY KEY (ContentID)
)

CREATE TABLE Film (
 ContentID		int,
 AfleveringID	int,
 Tijdsduur		TIME(0),

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
	ContentID	int,
	Seizoen		int,
	LijktOp		nvarchar(45),
 

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
 AfleveringID		int,
 AfleveringNR		int,
 Titel				nvarchar(45),
 Tijdsduur			TIME(0),
 ContentID			int,

 CONSTRAINT AfleveringPK
		PRIMARY KEY (AfleveringID),
		 	
 CONSTRAINT AfleverinFK
 	FOREIGN KEY (ContentID)
	REFERENCES Content(ContentID)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
		);

/*

*/

