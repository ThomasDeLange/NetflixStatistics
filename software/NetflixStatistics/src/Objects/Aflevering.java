package Objects;

public class Aflevering {

    private int id;
    private String seizoen;
    private String time;
    private String titel;
    private int contentID;

    public Aflevering(String titel, int id, String seizoen, String time, int contentID){
        this.id = id;
        this.seizoen = seizoen;
        this.time = time;
        this.titel = titel;
        this.contentID = contentID;
    }

    public String getTime() {
        return time;
    }

    public String getSeizoen() {
        return seizoen;
    }

    public int getId() {
        return id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeizoen(String seizoen) {
        this.seizoen = seizoen;
    }

    public void setId(int id) {
        this.id = id;
    }
}
