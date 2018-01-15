/*
1 Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken
% van de tijdsduur. Bij elke aflevering worden het volgnummer én titel getoond.
*/

SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage
FROM Bekeken
INNER JOIN Aflevering
ON Aflevering.AfleveringID = Bekeken.AfleveringID
INNER JOIN Content
ON Content.ContentID = Aflevering.ContentID
WHERE Content.Titel = 'Sherlock'
GROUP BY Bekeken.AfleveringID, Aflevering.Titel

SELECT *
FROM SERIE 
INNER JOIN Content
ON Content.ContentID = Serie.ContentID
INNER JOIN Aflevering
ON Aflevering.ContentID = serie.ContentID

/*
2 Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemid-
deld bekeken % van de tijdsduur.
*/
SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage
FROM Bekeken
INNER JOIN Aflevering
ON Aflevering.AfleveringID = Bekeken.AfleveringID
INNER JOIN Content
ON Content.ContentID = Aflevering.ContentID
INNER JOIN Account
ON Account.AccountNR = Bekeken.AccountNR	
WHERE	Content.Titel = 'Sherlock'
		AND
		Account.AccountNR = '1215426'
GROUP BY Bekeken.AfleveringID, Aflevering.Titel


/*
3 Welke films zijn er door een door de gebruiker geselecteerd account bekeken?
*/
SELECT DISTINCT Bekeken.AfleveringID, Content.Titel
FROM Bekeken
INNER JOIN Film
ON Film.AfleveringID = Bekeken.AfleveringID
INNER JOIN Content
ON Content.ContentID = Film.ContentID
INNER JOIN Account
ON Film.ContentID = Content.ContentID
INNER JOIN Profiel
ON Profiel.AccountNR = Account.AccountNR
WHERE Account.AccountNR = '1215426'



/*
4 Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.
*/
SELECT Top 1 Film.AfleveringID, Content.Titel, Film.Tijdsduur
FROM Film
INNER JOIN Content
ON Content.ContentID = Film.ContentID
WHERE Content.MinLeeftijd < 16
ORDER BY Film.Tijdsduur DESC

/*
5 Geef de accounts met slechts 1 profiel.
*/
SELECT Profiel.AccountNR, Account.Naam, Profiel.ProfielNaam
FROM Account, Profiel
WHERE Account.AccountNR = ( SELECT Profiel.AccountNR 
							FROM Account
							INNER JOIN Profiel
							ON Profiel.AccountNR = Account.AccountNR
							GROUP BY Profiel.AccountNR
							HAVING COUNT(Profiel.ProfielNaam) = 1)
/*
6 Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel be-
keken?
*/

SELECT Film.AfleveringID, Content.Titel, COUNT(Bekeken.ProcentGezien) AantalGebruikers100ProcentGezien
FROM Film
INNER JOIN Content
ON Content.ContentID = Film.ContentID
INNER JOIN Bekeken
ON Bekeken.AfleveringID = Film.AfleveringID
--WHERE Content.Titel = 'Andy Warhole''s Dracula'
GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel
HAVING Bekeken.ProcentGezien = 100
/*
Voor een door de gebruiker geselecteerde serie, geef het gemiddeld bekeken % van de tijdsduur van die serie als geheel 
(d.w.z. alle afleveringen van die serie).
*/

SELECT Content.Titel, Serie.Seizoen, TotaalBekeken.ProcentGezien
FROM Serie
INNER JOIN Content
ON Content.ContentID = Serie.ContentID
INNER JOIN (SELECT Serie.ContentID as ContentIDTotaal, AVG(Bekeken.ProcentGezien) as ProcentGezien
FROM Bekeken
INNER JOIN Profiel
ON Profiel.AccountNR = Bekeken.AccountNR 
INNER JOIN Content
ON Bekeken.ContentID = Content.ContentID
INNER JOIN Serie
ON Serie.ContentID = Content.ContentID
GROUP BY Serie.ContentID) as TotaalBekeken
ON TotaalBekeken.ContentIDTotaal = Content.ContentID
WHERE Content.Titel = 'The Abominable Bride'


/*  
Voor een door de gebruiker geselecteerde film, hoeveel procent van de kijkers hebben deze in z’n geheel bekeken? 
Geeft hierbij ook het absolute aantal kijkers dat deze film helemaal afkeek en het totaal aantal kijkers.
*/
SELECT Content.Titel, COUNT(Film.AfleveringID) as TotaalGezien, COUNT(TotaalAfgezien.AfleveringID) TotaalAfgezien, COUNT(TotaalAfgezien.AfleveringID) / COUNT(Film.AfleveringID) * 100 as PercentageMensenAfGekeken
FROM Content
INNER JOIN Film
ON Film.ContentID = Content.ContentID
INNER JOIN Bekeken
ON Bekeken.AfleveringID = film.AfleveringID
FULL OUTER JOIN (SELECT Film.AfleveringID, AVG(Bekeken.ProcentGezien) as avgGezien
				FROM Content
				INNER JOIN Film
				ON Film.ContentID = Content.ContentID
				INNER JOIN Bekeken
				ON Bekeken.AfleveringID = film.AfleveringID
				WHERE Bekeken.ProcentGezien = 100
				GROUP BY Film.AfleveringID) as  TotaalAfgezien
ON TotaalAfgezien.AfleveringID = Film.AfleveringID
WHERE Content.titel = 'Pulp Fiction'
GROUP BY Content.Titel, Film.AfleveringID;
