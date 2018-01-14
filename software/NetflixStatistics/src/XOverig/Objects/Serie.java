package XOverig.Objects;

public class Serie extends  Content {

    private String lijktOp;

    public Serie(int contentID, int leeftijf, String taal, String  genre, String titel, String lijktOp){
        super(contentID, leeftijf, taal, genre, titel);
        this.lijktOp = lijktOp;
    }

    public String getLijktOp() {
        return lijktOp;
    }

    public void setLijktOp(String lijktOp) {
        this.lijktOp = lijktOp;
    }
}
