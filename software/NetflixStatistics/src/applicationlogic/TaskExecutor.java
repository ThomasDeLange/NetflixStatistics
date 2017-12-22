package applicationlogic;

import Objects.Account;
import Repositories.AccountRepository;
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

    //UserInterface userInterface;
    private SqlConnection sqlConnection;

    public TaskExecutor(SqlConnection sqlConnection){
        //this.userInterface = userInterface;
        this.sqlConnection = sqlConnection;
    }

    public String runTask(String taskID){

        String resultString = new String();
        switch (taskID){
            case "GetAccountNummers":

                AccountRepository accountRepository = new AccountRepository(sqlConnection);
                ArrayList<Account> accounts = accountRepository.readAll();
                for(Account a: accounts) {
                    resultString +=a + "\n ";
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
        return resultString;
    }

}
