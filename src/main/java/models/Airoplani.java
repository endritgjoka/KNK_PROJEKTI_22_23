package models;

public class Airoplani {
    private String kompania;
    private int kapaciteti;
    private String tipi;

    public Airoplani(){

    }

    public Airoplani(String kompania, int kapaciteti, String tipi) {
        this.kompania = kompania;
        this.kapaciteti = kapaciteti;
        this.tipi = tipi;
    }

    public String getKompania() {
        return kompania;
    }

    public void setKompania(String kompania) {
        this.kompania = kompania;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }

    public void setKapaciteti(int kapaciteti) {
        this.kapaciteti = kapaciteti;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }
}