package netflixstatistics.applicationlogic;

public class TaskExecutor {
    DatabaseController databaseController;

    public TaskExecutor(){
        databaseController = new DatabaseController();
    }

    public String runTask(String taskID){
        String result = "";
        switch (taskID){
            case "getboektitel":
                databaseController.getStrings("SELECT * FROM TITLE", "titel");
            //other tasks
        }
        return result;
    }





}
