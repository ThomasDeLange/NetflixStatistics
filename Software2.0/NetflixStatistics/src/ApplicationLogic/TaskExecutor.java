package ApplicationLogic;

import java.util.ArrayList;

public class TaskExecutor {
    ApplicationLogic.DatabaseController databaseController;

    public TaskExecutor(){
        databaseController = new ApplicationLogic.DatabaseController();
    }

    public ArrayList<String> runTask(String taskID){
        ArrayList<String> stringResults = new ArrayList<>();

        switch (taskID){
            case "getboektitel":
                stringResults =  databaseController.getStrings("SELECT * FROM BOEK", "titel");
                //other tasks
        }

        return stringResults;
    }
}
