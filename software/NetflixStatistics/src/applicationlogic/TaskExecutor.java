package applicationlogic;

import Clicklistener.TableEditor;
import Objects.Account;
import Repositories.AccountRepository;
import com.sun.tools.javac.util.Name;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    private TableEditor tableEditor;
    private Object input0;
    private Object input1;
    private Object input2;

    public TaskExecutor(SqlConnection sqlConnection, DefaultTableModel defaultTableModel, JTable resultTable, Object input0){
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;
        this.input0 = input0;
        tableEditor = new TableEditor(defaultTableModel, resultTable);

    }

    public TaskExecutor(SqlConnection sqlConnection, DefaultTableModel defaultTableModel,JTable resultTable, Object input1, Object input2){
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;
        this.input1 = input1;
        this.input2 = input2;
        tableEditor = new TableEditor(defaultTableModel, resultTable);
    }


    public ResultSet runTask(String taskID){

        ResultSet resultSet = null;

        switch (taskID){
            case "Opdracht1":


                JComboBox cb = ((JComboBox) input0);
                String inputTitel = (String)cb.getSelectedItem();

                /*
                1 Voor een door de gebruiker geselecteerde serie, geef per aflevering het gemiddeld bekeken
                % van de tijdsduur. Bij elke aflevering worden het volgnummer Èn titel getoond.
                */

                resultSet = sqlConnection.executeSql(  "SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                                                                "FROM Bekeken\n" +
                                                                "INNER JOIN Aflevering\n" +
                                                                "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Aflevering.ContentID\n" +
                                                                "WHERE Content.Titel =" + "'" + inputTitel + "'" + "\n" +
                                                                "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");
                break;

            case "Opdracht2":

                /*
                2 Voor een door de gebruiker geselecteerde account en serie, geef per aflevering het gemid-
                deld bekeken % van de tijdsduur.
                */

                resultSet = sqlConnection.executeSql(  "SELECT Bekeken.AfleveringID, Aflevering.Titel, AVG(Bekeken.ProcentGezien) as gemiddeldBekekenPercentage\n" +
                                                                "FROM Bekeken\n" +
                                                                "INNER JOIN Aflevering\n" +
                                                                "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Aflevering.ContentID\n" +
                                                                "INNER JOIN Account\n" +
                                                                "ON Account.AccountNR = Bekeken.AccountNR\t\n" +
                                                                "WHERE\tContent.Titel =" + "'" + input1+ "'" + "\n" +
                                                                "\t\tAND\n" +
                                                                "\t\tAccount.AccountNR =" + "'" + input2+ "'" + "\n" +
                                                                "GROUP BY Bekeken.AfleveringID, Aflevering.Titel");
                break;

            case "Opdracht3":
                /*
                3 Welke films zijn er door een door de gebruiker geselecteerd account bekeken?
                */
                resultSet = sqlConnection.executeSql(  "SELECT Bekeken.AfleveringID, Aflevering.Titel\n" +
                                                                "FROM Bekeken\n" +
                                                                "INNER JOIN Aflevering\n" +
                                                                "ON Aflevering.AfleveringID = Bekeken.AfleveringID\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Aflevering.ContentID\n" +
                                                                "INNER JOIN Account\n" +
                                                                "ON Account.AccountNR = Bekeken.AccountNR\t\n" +
                                                                "INNER JOIN Film\n" +
                                                                "ON Film.ContentID = Content.ContentID\n" +
                                                                "WHERE Account.AccountNR =" + "'" + input2+ "'");
                break;

            case "Opdracht4":

                /*
                4 Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.
                */

                resultSet = sqlConnection.executeSql(  "SELECT TOP 1 Film.AfleveringID, Content.Titel, Film.Tijdsduur\n" +
                                                                "FROM Film\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Film.ContentID\n" +
                                                                "WHERE Content.MinLeeftijd < 16\n" +
                                                                "ORDER BY Film.Tijdsduur DESC");
                break;

            case "Opdracht5":

                /*
                5 Geef de accounts met slechts 1 profiel.
                */

                resultSet = sqlConnection.executeSql(  "SELECT Account.AccountNR, Account.Naam, Profiel.ProfielNaam\n" +
                                                                "FROM Account\n" +
                                                                "INNER JOIN Profiel\n" +
                                                                "ON Profiel.AccountNR = Account.AccountNR\n" +
                                                                "GROUP BY Profiel.AccountNR, Account.AccountNR, Account.Naam\n" +
                                                                "HAVING COUNT(Profiel.AccountNR) = 1");
                break;

            case "opdracht6":

                /*
                6 Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in zín geheel be-
                keken?
                */

                resultSet = sqlConnection.executeSql(  "SELECT Film.AfleveringID, Content.Titel, COUNT(Bekeken.ProcentGezien) AantalGebruikers100ProcentGezien, Bekeken.ProcentGezien\n" +
                                                                "FROM Film\n" +
                                                                "INNER JOIN Content\n" +
                                                                "ON Content.ContentID = Film.ContentID\n" +
                                                                "INNER JOIN Bekeken\n" +
                                                                "ON Bekeken.AfleveringID = Film.AfleveringID\n" +
                                                                "WHERE Content.Titel =" + "'" + input2+ "'" + "\n" +
                                                                "GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel\n" +
                                                                "HAVING Bekeken.ProcentGezien = 100\n" +
                                                                "\n" +
                                                                "GROUP BY Film.AfleveringID, Bekeken.ProcentGezien, Content.Titel\n" +
                                                                "HAVING Bekeken.ProcentGezien = 100");
                break;

        }
        return resultSet;
    }

}
