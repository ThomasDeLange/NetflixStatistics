package Objects;

public class Profiel {
    private int abonneenummer;
    private String profielnaam;
    private String geboortedatum;

    public Profiel(int abonneenummer, String profielnaam, String geboortedatum){
        this.abonneenummer = abonneenummer;
        this.profielnaam = profielnaam;
        this.geboortedatum = geboortedatum;
    }

    public int getAbonneenummer() {
        return abonneenummer;
    }

    public String getProfielnaam() {
        return profielnaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setAbonneenummer(int abonneenummer) {
        this.abonneenummer = abonneenummer;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setProfielnaam(String profielnaam) {
        this.profielnaam = profielnaam;
    }
}
