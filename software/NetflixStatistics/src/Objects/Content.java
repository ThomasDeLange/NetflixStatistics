package Objects;

public class Content {
    private int contentID;
    private int leeftijd;
    private String taal;
    private String genre;
    private String titel;

    public Content(int contentID, int leeftijd, String taal, String genre, String titel){
        this.contentID = contentID;
        this.leeftijd = leeftijd;
        this.taal = taal;
        this.genre = genre;
        this.titel = titel;
    }

    public int getContentID() {
        return contentID;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getGenre() {
        return genre;
    }

    public String getTaal() {
        return taal;
    }

    public String getTitel() {
        return titel;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
