package View.Tabs;

import Model.ComboBoxEditor;
import Model.SqlConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public abstract class Tab {
    private SqlConnection sqlConnection;
    private ComboBoxEditor comboBoxEditor;


    public Tab(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
        comboBoxEditor = new ComboBoxEditor(sqlConnection);
    }

    public abstract JPanel createComponents() throws SQLException;

    public SqlConnection getSqlConnection() {
        return this.sqlConnection;
    }
}
