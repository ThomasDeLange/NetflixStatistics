CREATE TABLE Account (
 AccountNR		int,
 Naam			nvarchar(45),
 Straat			nvarchar(45),
 Postcode		nvarchar(7),
 Huisnummer		int,
 Woonplaats		nvarchar(30),

 CONSTRAINT AccountPK 
		PRIMARY KEY (AccountNR) 	
		);
/*

*/

CREATE TABLE Profiel (
 AccountNR		int,
 ProfielNaam	nvarchar(30),
 Geboortedatum	DateTime2

 CONSTRAINT ProfielPK 
		PRIMARY KEY (AccountNR, ProfielNaam),

 CONSTRAINT ProfielFK
 	FOREIGN KEY (AccountNR)
	REFERENCES Account(AccountNR)
		ON UPDATE CASCADE
		ON DELETE NO ACTION
	 	
		);
/*

*/
CREATE TABLE Bekeken (
 AccountNR		int,
 ProfielNaam	nvarchar(30),
 AfleveringID	int,
 ProcentGezien	int,
 ContentID		int,
 CONSTRAINT BekekenPK 
		PRIMARY KEY (AccountNR, ProfielNaam, AfleveringID),
		 	
 CONSTRAINT bekeken_ProfielFK
 	FOREIGN KEY (AccountNR, ProfielNaam)
	REFERENCES Profiel(AccountNR, ProfielNaam)
	ON DELETE CASCADE,

CONSTRAINT Bekeken_ContentFK
	FOREIGN KEY (ContentID)
	REFERENCES Content(ContentID)
	
);





