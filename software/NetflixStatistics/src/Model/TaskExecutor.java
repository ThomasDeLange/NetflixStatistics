package Model;

import javax.swing.*;
import java.sql.ResultSet;

/*
TaskExecutor
1. Ontvangt van ClickListener een taskId
2. Zoekt de bijbehorende sql querry bij de taskId
3. Stuurt de sql querry naar DatabaseController
4. Krijgt het resultaat van de sql querry terug van de DatabaseController in een ResultSet
5. Geeft de ResultSet terug aan de ClickListener

 */
public class TaskExecutor {

    private SqlConnection sqlConnection;
    private Object input1;
    private Object input2;

    //0 input
    public TaskExecutor(SqlConnection sqlConnection) {
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;

    }

    //1 input
    public TaskExecutor(SqlConnection sqlConnection, Object input) {
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;
        this.input1 = input;

    }

    //2 input
    public TaskExecutor(SqlConnection sqlConnection, Object input1, Object input2) {
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;
        this.input1 = input1;
        this.input2 = input2;
    }

    public String makeStringSqlReady(String string) {
        if (string.contains("'")) {
            string = string.replace("'", "''");
        }
        return string;
    }

    public ResultSet runTask(String taskID) {

        ResultSet resultSet = null;

        switch (taskID) {
            case "Opdracht1":
                //Er komt 1 combobox binnen - Titel
                JComboBox cbTitel1 = ((JComboBox) input1);
                String inputSerieTitel1 = (String) cbTitel1.getSelectedItem();

                inputSerieTitel1 = makeStringSqlReady(inputSerieTitel1);

                /*
                1 Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken
                % van de tijdsduur. Bij elke aflevering worden het volgnummer Èn titel getoond.
                */

                resultSet = sqlConnection.executeSql("" +
                        "SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                        "FROM Bekeken\n" +
                        "INNER JOIN Aflevering\n" +
                        "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Aflevering.ContentID\n" +
                        "WHERE Content.Titel =" + "'" + inputSerieTitel1 + "'" + "\n" +
                        "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");
                break;

            case "Opdracht2":
                //Er komen twee comboboxen binnen - Account, Serie

                JComboBox cbAccount1 = ((JComboBox) input1);
                String inputAccount1 = (String) cbAccount1.getSelectedItem();

                JComboBox cbSerie2 = ((JComboBox) input2);
                String inputSerieTitel2 = (String) cbSerie2.getSelectedItem();

                inputAccount1 = makeStringSqlReady(inputAccount1);
                inputSerieTitel2 = makeStringSqlReady(inputSerieTitel2);

                /*
                2 Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemid-
                deld bekeken % van de tijdsduur.
                */

                resultSet = sqlConnection.executeSql("" +
                        "SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                        "FROM Bekeken\n" +
                        "INNER JOIN Aflevering\n" +
                        "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Aflevering.ContentID\n" +
                        "INNER JOIN Account\n" +
                        "ON Account.AccountNR = Bekeken.AccountNR\t\n" +
                        "WHERE Content.Titel =" + "'" + inputSerieTitel2 + "'" + "\n" +
                        "AND\n" +
                        "Account.AccountNR =" + "'" + inputAccount1 + "'" + "\n" +
                        "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");
                break;

            case "Opdracht3":
                //Er komt 1 dropdown binnen - Account
                JComboBox cbAccount2 = ((JComboBox) input1);
                String inputAccount2 = (String) cbAccount2.getSelectedItem();
                System.out.println(inputAccount2);

                inputAccount2 = makeStringSqlReady(inputAccount2);
                /*
                3 Welke films zijn er door een door de gebruiker geselecteerd account bekeken?
                */
                resultSet = sqlConnection.executeSql("" +
                        "SELECT DISTINCT Bekeken.AfleveringID, Content.Titel\n" +
                        "FROM Bekeken\n" +
                        "INNER JOIN Film\n" +
                        "ON Film.AfleveringID = Bekeken.AfleveringID\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Film.ContentID\n" +
                        "INNER JOIN Account\n" +
                        "ON Film.ContentID = Content.ContentID\n" +
                        "INNER JOIN Profiel\n" +
                        "ON Profiel.AccountNR = Account.AccountNR\n" +
                        "WHERE Account.AccountNR =" + "'" + inputAccount2 + "'");
                break;

            case "Opdracht4":
                //Er komt geen input binnen

                /*
                4 Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.
                */

                resultSet = sqlConnection.executeSql("" +
                        "SELECT TOP 1 Film.AfleveringID, Content.Titel, Film.Tijdsduur\n" +
                        "FROM Film\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Film.ContentID\n" +
                        "WHERE Content.MinLeeftijd < 16\n" +
                        "ORDER BY Film.Tijdsduur DESC");
                break;

            case "Opdracht5":
                //Er komt geen input binnen

                /*
                5 Geef de accounts met slechts 1 profiel.
                */

                resultSet = sqlConnection.executeSql("" +
                        "SELECT Profiel.AccountNR, Account.Naam, Profiel.ProfielNaam\n" +
                        "FROM Account, Profiel\n" +
                        "WHERE Account.AccountNR = ( SELECT Profiel.AccountNR \n" +
                        "FROM Account\n" +
                        "INNER JOIN Profiel\n" +
                        "ON Profiel.AccountNR = Account.AccountNR\n" +
                        "GROUP BY Profiel.AccountNR\n" +
                        "HAVING COUNT(Profiel.ProfielNaam) = 1)");
                break;

            case "Opdracht6":
                //Er komt een dropdown binnen - Film
                JComboBox cbFilmTitel = ((JComboBox) input1);
                String inputFilmTitel = (String) cbFilmTitel.getSelectedItem();

                inputFilmTitel = makeStringSqlReady(inputFilmTitel);

                /*
                6 Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in zín geheel be-
                keken?
                */

                resultSet = sqlConnection.executeSql("" +
                        "SELECT Film.AfleveringID, Content.Titel, COUNT(Bekeken.ProcentGezien) AantalGebruikers100ProcentGezien\n" +
                        "FROM Film\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Film.ContentID\n" +
                        "INNER JOIN Bekeken\n" +
                        "ON Bekeken.AfleveringID = Film.AfleveringID\n" +
                        "WHERE Content.Titel =" + "'" + inputFilmTitel + "'" + "\n" +
                        "GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel\n" +
                        "HAVING Bekeken.ProcentGezien = 100");


                break;

            case "Opdracht7":
                //Er komt een dropdown binnen - serie
                JComboBox cbSerie3 = ((JComboBox) input1);
                String inputSerieTitel3 = (String) cbSerie3.getSelectedItem();

                 inputSerieTitel3 = makeStringSqlReady(inputSerieTitel3);

                resultSet = sqlConnection.executeSql("" +
                        "SELECT Content.Titel, Serie.Seizoen, TotaalBekeken.ProcentGezien\n" +
                        "FROM Serie\n" +
                        "INNER JOIN Content\n" +
                        "ON Content.ContentID = Serie.ContentID\n" +
                        "INNER JOIN (SELECT Serie.ContentID as ContentIDTotaal, AVG(Bekeken.ProcentGezien) as ProcentGezien\n" +
                        "FROM Bekeken\n" +
                        "INNER JOIN Profiel\n" +
                        "ON Profiel.AccountNR = Bekeken.AccountNR \n" +
                        "INNER JOIN Content\n" +
                        "ON Bekeken.ContentID = Content.ContentID\n" +
                        "INNER JOIN Serie\n" +
                        "ON Serie.ContentID = Content.ContentID\n" +
                        "GROUP BY Serie.ContentID) as TotaalBekeken\n" +
                        "ON TotaalBekeken.ContentIDTotaal = Content.ContentID\n" +
                        "WHERE Content.Titel =" + "'" + inputSerieTitel3 + "'");


                break;

        }
        return resultSet;
    }

}
