package applicationlogic;
import Repositories.AccountRepository;
import Objects.Account;
import ui.UserInterface;

import java.sql.PreparedStatement;
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

    UserInterface userInterface;
    AccountRepository account = new AccountRepository(new SqlConnection());
    public TaskExecutor(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    public void runTask(String taskID){
        ArrayList<String> stringResults = new ArrayList<>();
        switch (taskID){
            case "GetAccountNummers":
                ArrayList<Account> accounts =  account.readAll();
                for(Account a: accounts) {
                    System.out.println(a.getAbonneenummer());
                }
                break;

            case "GetAccountName":
                break;

            case "GetAccountWoonplaats":
                break;

            case "AddUser":
                break;
            //other tasks
        }
    }
}
