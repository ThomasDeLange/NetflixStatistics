package View.Tabs;

import Model.SqlConnection;

import javax.swing.*;
import java.awt.*;

public abstract class Tab {
    private SqlConnection sqlConnection;

    public Tab(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public abstract JPanel createComponents();

    public SqlConnection getSqlConnection() {
        return this.sqlConnection;
    }
}
