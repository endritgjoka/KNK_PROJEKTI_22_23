package models;

public class Perdoruesi {
    private int id;
    private String emri;
    private String mbiemri;
    private String username;
    private String fjalekalimi_salted;
    private String salt;

    private int mosha;
    private char gjinia;

    private boolean admin;

    public Perdoruesi() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perdoruesi(int id, String emri, String mbiemri, String username, String fjalekalimi_salted,
                      String salt, int mosha, char gjinia, boolean admin) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.username = username;
        this.fjalekalimi_salted = fjalekalimi_salted;
        this.salt = salt;
        this.mosha = mosha;
        this.gjinia = gjinia;
        this.admin = admin;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFjalekalimi_salted() {
        return fjalekalimi_salted;
    }

    public void setFjalekalimi_salted(String fjalekalimi_salted) {
        this.fjalekalimi_salted = fjalekalimi_salted;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public char getGjinia() {
        return gjinia;
    }

    public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
