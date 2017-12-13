package Objects;

public class Film extends Content{

    private String tijd;

    public Film(int contentID, int leeftijf, String taal, String  genre, String titel, String tijd){
        super(contentID, leeftijf, taal, genre, titel);
        this.tijd = tijd;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }
}
