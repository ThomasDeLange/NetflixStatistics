package applicationlogic;

import Objects.Account;
import Repositories.AccountRepository;
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
        AccountRepository accountRepository = new AccountRepository(sqlConnection);

        switch (taskID){
            case "Account info":
                ArrayList<Account> accounts = accountRepository.readAll();
                for(Account a: accounts) {
                    resultString +=a + "\n ";
                }
                break;

            case "Account info per id":
                resultString = accountRepository.read(1215426) + " ";
                break;

            case "Button 3":

                break;

            case "AddUser":

                break;
            //other tasks
        }
        return resultString;
    }

}
