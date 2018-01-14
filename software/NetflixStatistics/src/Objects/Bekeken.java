package Objects;

public class Bekeken {
    private int abonneeNR;
    private String profielNaam;
    private int gezien;
    private int percentage;
    private int contentID;

    public Bekeken(int abonneeNR, String profielNaam, int gezien, int percentage, int contentID){
        this.abonneeNR = abonneeNR;
        this.profielNaam = profielNaam;
        this.gezien = gezien;
        this.percentage = percentage;
        this.contentID = contentID;
    }

    public int getAbonneeNR() {
        return abonneeNR;
    }

    public int getContentID() {
        return contentID;
    }

    public int getGezien() {
        return gezien;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getProfielNaam() {
        return profielNaam;
    }

    public void setAbonneeNR(int abonneeNR) {
        this.abonneeNR = abonneeNR;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public void setGezien(int gezien) {
        this.gezien = gezien;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setProfielNaam(String profielNaam) {
        this.profielNaam = profielNaam;
    }
}
