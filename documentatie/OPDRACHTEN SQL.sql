/*
o Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken
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


/*
o Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemid-
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
o Welke films zijn er door een door de gebruiker geselecteerd account bekeken?
*/
SELECT Bekeken.AfleveringID, Aflevering.Titel
FROM Bekeken
INNER JOIN Aflevering
ON Aflevering.AfleveringID = Bekeken.AfleveringID
INNER JOIN Content
ON Content.ContentID = Aflevering.ContentID
INNER JOIN Account
ON Account.AccountNR = Bekeken.AccountNR	
INNER JOIN Film
ON Film.ContentID = Content.ContentID
WHERE Account.AccountNR = '1215426'



/*
o Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.
*/
SELECT TOP 1 Film.AfleveringID, Content.Titel, Film.Tijdsduur
FROM Film
INNER JOIN Content
ON Content.ContentID = Film.ContentID
WHERE Content.MinLeeftijd < 16
ORDER BY Film.Tijdsduur DESC

/*
o Geef de accounts met slechts 1 profiel.
*/
SELECT Account.AccountNR, Account.Naam, Profiel.ProfielNaam
FROM Account
INNER JOIN Profiel
ON Profiel.AccountNR = Account.AccountNR
GROUP BY Profiel.AccountNR, Account.AccountNR, Account.Naam
HAVING COUNT(Profiel.AccountNR) = 1

/*
o Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel be-
keken?
*/

SELECT Film.AfleveringID, Content.Titel, COUNT(Bekeken.ProcentGezien) AantalGebruikers100ProcentGezien, Bekeken.ProcentGezien
FROM Film
INNER JOIN Content
ON Content.ContentID = Film.ContentID
INNER JOIN Bekeken
ON Bekeken.AfleveringID = Film.AfleveringID
WHERE Content.Titel = 'The Life of Brian'
GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel
HAVING Bekeken.ProcentGezien = 100

--GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel
--HAVING Bekeken.ProcentGezien > 100
