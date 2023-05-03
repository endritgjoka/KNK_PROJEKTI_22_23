package models;

public class Pasagjeri extends Perdoruesi {
     private int id;
    private String adresa;
    private String nacionaliteti;
    private String numri_telefonit;

    public Pasagjeri() {

    }

    public Pasagjeri(int id, String emri, String mbiemri, String username, String fjalekalimi_salted, String salt,
                     int mosha, char gjinia, String nacionaliteti,
                     String adresa, String numri_telefonit, boolean admin) {
        super(id, emri, mbiemri, username, fjalekalimi_salted, salt, mosha, gjinia, admin);
        this.adresa = adresa;
        this.nacionaliteti = nacionaliteti;
        this.numri_telefonit = numri_telefonit;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNacionaliteti() {
        return nacionaliteti;
    }

    public void setNacionaliteti(String nacionaliteti) {
        this.nacionaliteti = nacionaliteti;
    }

    public String getNumri_telefonit() {
        return numri_telefonit;
    }

    public void setNumri_telefonit(String numri_telefonit) {
        this.numri_telefonit = numri_telefonit;
    }

    public String getAdresa() {
        return adresa;
    }
}