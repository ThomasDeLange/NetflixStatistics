package Model;

import View.Tabs.Opdracht1Tab;
import View.UserInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TaskExecutorTest {
    private static SqlConnection sqlConnection;
    private static UserInterface ui;
    private static ComboBoxEditor comboBoxEditor;

    @BeforeAll
    public static void setUp(){
        sqlConnection = new SqlConnection();
        sqlConnection.connectDatabase("jdbc:sqlserver://thomasserver.database.windows.net:1433;database=NetflixStatistics;user=Thomas@thomasserver;password={admin123!};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        ui = new UserInterface(sqlConnection);
        SwingUtilities.invokeLater(ui);
        comboBoxEditor = new ComboBoxEditor(sqlConnection);
    }

    @Test
    void testTask1ResultSetNotNull() throws SQLException {
        JComboBox serieDropdown = null;
        serieDropdown = comboBoxEditor.fillCombobox(serieDropdown, "SerieTitels");

        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection, serieDropdown);
        ResultSet rs =  taskExecutor.runTask("Opdracht1");
        Assertions.assertNotNull(rs);
    }

    @Test
    void testTask2ResultSetNotNull() throws SQLException{
        JComboBox serieDropdown = null;
        serieDropdown = comboBoxEditor.fillCombobox(serieDropdown, "SerieTitels");

        JComboBox<String> accountDropdown = null;
        accountDropdown = comboBoxEditor.fillCombobox(accountDropdown, "AccountNRs");

        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection, accountDropdown, serieDropdown);
        ResultSet rs =  taskExecutor.runTask("Opdracht2");
        Assertions.assertNotNull(rs);
    }

    @Test
    void testTask3ResultSetNotNull() throws SQLException{
        JComboBox accountDropdown = null;
        accountDropdown = comboBoxEditor.fillCombobox(accountDropdown, "AccountNRs");

        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection, accountDropdown);
        ResultSet rs =  taskExecutor.runTask("Opdracht3");
        Assertions.assertNotNull(rs);
    }

    @Test
    void testTask4ResultSetNotNull(){
        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection);
        ResultSet rs =  taskExecutor.runTask("Opdracht4");
        Assertions.assertNotNull(rs);
    }

    @Test
    void testTask5ResultSetNotNull(){
        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection);
        ResultSet rs =  taskExecutor.runTask("Opdracht5");
        Assertions.assertNotNull(rs);
    }

    @Test
    void testTask6ResultSetNotNull() throws SQLException{
        JComboBox filmDropdown = null;
        filmDropdown = comboBoxEditor.fillCombobox(filmDropdown, "FilmTitels");

        TaskExecutor taskExecutor = new TaskExecutor(sqlConnection, filmDropdown);
        ResultSet rs =  taskExecutor.runTask("Opdracht6");
        Assertions.assertNotNull(rs);
    }
}