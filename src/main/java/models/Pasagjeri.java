package models;

public class Pasagjeri extends Perdoruesi {

    private String adresa;
    private String nacionaliteti;

    public Pasagjeri() {

    }

    public Pasagjeri(String emri, String mbiemri, String email, String fjalekalimi, int mosha, String gjinia, String adresa, String numri_telefonit, boolean admin) {
        super(emri, mbiemri, email, fjalekalimi, mosha, gjinia, adresa, numri_telefonit, admin);
    }

    @Override
    public String getAdresa() {
        return adresa;
    }
}