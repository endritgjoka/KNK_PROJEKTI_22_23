package models;

public class Perdoruesi {
    private String emri;
    private String mbiemri;
    private String email;
    private String fjalekalimi;
    private int mosha;
    private String gjinia;
    private String adresa;
    private String numri_telefonit;
    private boolean admin;

    public Perdoruesi(String emri, String mbiemri, String email, String fjalekalimi, int mosha,
                      String gjinia, String adresa, String numri_telefonit, boolean admin) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.fjalekalimi = fjalekalimi;
        this.mosha = mosha;
        this.gjinia = gjinia;
        this.adresa = adresa;
        this.numri_telefonit = numri_telefonit;
        this.admin = admin;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFjalekalimi() {
        return fjalekalimi;
    }

    public void setFjalekalimi(String fjalekalimi) {
        this.fjalekalimi = fjalekalimi;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public String getGjinia() {
        return gjinia;
    }

    public void setGjinia(String gjinia) {
        this.gjinia = gjinia;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumri_telefonit() {
        return numri_telefonit;
    }

    public void setNumri_telefonit(String numri_telefonit) {
        this.numri_telefonit = numri_telefonit;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
