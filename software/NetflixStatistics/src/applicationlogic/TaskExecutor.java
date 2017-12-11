package applicationlogic;

import java.util.ArrayList;
/*
TaskExecutor
1. Ontvangt van ClickListener een taskId
2. Zoekt de bijbehorende sql querry bij de taskId
3. Stuurt de sql querry naar DatabaseController
4. Krijgt het resultaat van de sql querry terug van de DatabaseController
5. Geeft het resultaat terug aan de ClickListener

 */
public class TaskExecutor {
    DatabaseController databaseController;

    public TaskExecutor(DatabaseController databaseController){
        this.databaseController = databaseController;
    }

    public ArrayList<String> runTask(String taskID){
        ArrayList<String> stringResults = new ArrayList<>();
        switch (taskID){
            case "GetAccountNR":
                stringResults =  databaseController.getStrings("SELECT * FROM Account", "AbonneeNR");
                break;

            case "GetAccountName":
                stringResults =  databaseController.getStrings("SELECT * FROM Account", "Naam");
                break;
            //other tasks
        }
        return stringResults;
    }
}
