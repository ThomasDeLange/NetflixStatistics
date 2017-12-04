package netflixstatistics.applicationlogic;

import java.util.ArrayList;

public class TaskExecutor {
    DatabaseController databaseController;

    public TaskExecutor(){
        databaseController = new DatabaseController();
    }

    public ArrayList<String> runTask(String taskID){
        ArrayList<String> stringResults = new ArrayList<>();

        switch (taskID){
            case "getboektitel":
                stringResults =  databaseController.getStrings("SELECT * FROM TITLE", "titel");
            //other tasks
        }

        return stringResults;
    }





}
