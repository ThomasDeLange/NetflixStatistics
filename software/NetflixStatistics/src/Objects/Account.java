package Objects;

public class Account {
    private int abonneenummer;
    private String naam;
    private String straat;
    private String postcode;
    private String huisnummer;
    private String plaats;

    public Account(int abonneenummer, String naam, String straat, String postcode, String huisnummer, String plaats){
        this.abonneenummer = abonneenummer;
        this.naam = naam;
        this.straat = straat;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
    }

    public int getAbonneenummer() {
        return abonneenummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setAbonneenummer(int abonneenummer) {
        this.abonneenummer = abonneenummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    @Override
    public String toString() {
        return abonneenummer + ", " + naam + ", " + straat + ", " + postcode + ", " + huisnummer + ", " + plaats;
    }



}
