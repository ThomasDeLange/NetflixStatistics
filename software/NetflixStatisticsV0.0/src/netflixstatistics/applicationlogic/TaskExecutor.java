package netflixstatistics.applicationlogic;

import java.util.ArrayList;

public class TaskExecutor {
    DatabaseController databaseController;

    public TaskExecutor(DatabaseController databaseController){
        this.databaseController = databaseController;
    }

    public ArrayList<String> runTask(String taskID){
        ArrayList<String> stringResults = new ArrayList<>();
        switch (taskID){
            case "getboektitel":
                stringResults =  databaseController.getStrings("SELECT * FROM BOEK", "titel");
                break;
            //other tasks
        }
        return stringResults;
    }
}
