package models;

import java.sql.Timestamp;

public class Fluturimet {
    private int id;
    private int bileta_id;
    private int aeroplani_id;
    private int aeroporti_nisjes_id;

    private Timestamp nisja;
    private int aeroporti_arritjes_id;
    private Timestamp arritja;
    private  String status;
    private Airoplani airoplani;
    private Aeroporti aeroporti1;
    private Aeroporti aeroporti2;
    private Bileta bileta;
    private String qyteti1;
    private String qyteti2;
    private String linja;


    public Bileta getBileta() {
        return bileta;
    }

    public void setBileta(Bileta bileta) {
        this.bileta = bileta;
    }

    public Airoplani getAiroplani() {
        return airoplani;
    }

    public void setAiroplani(Airoplani airoplani) {
        this.airoplani = airoplani;
    }

    public Aeroporti getAeroporti1() {
        return aeroporti1;
    }

    public void setAeroporti1(Aeroporti aeroporti1) {
        this.aeroporti1 = aeroporti1;
    }

    public Aeroporti getAeroporti2() {
        return aeroporti2;
    }

    public void setAeroporti2(Aeroporti aeroporti2) {
        this.aeroporti2 = aeroporti2;
    }

    public  Fluturimet(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBileta_id() {
        return bileta_id;
    }

    public void setBileta_id(int bileta_id) {
        this.bileta_id = bileta_id;
    }

    public int getAeroplani_id() {
        return aeroplani_id;
    }

    public void setAeroplani_id(int aeroplani_id) {
        this.aeroplani_id = aeroplani_id;
    }

    public int getAeroporti_nisjes_id() {
        return aeroporti_nisjes_id;
    }

    public void setAeroporti_nisjes_id(int aeroporti_nisjes_id) {
        this.aeroporti_nisjes_id = aeroporti_nisjes_id;
    }

    public Timestamp getNisja() {
        return nisja;
    }

    public void setNisja(Timestamp nisja) {
        this.nisja = nisja;
    }

    public int getAeroporti_arritjes_id() {
        return aeroporti_arritjes_id;
    }

    public void setAeroporti_arritjes_id(int aeroporti_arritjes_id) {
        this.aeroporti_arritjes_id = aeroporti_arritjes_id;
    }

    public Timestamp getArritja() {
        return arritja;
    }

    public void setArritja(Timestamp arritja) {
        this.arritja = arritja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fluturimet(int id, int bileta_id, int aeroplani_id, int aeroporti_nisjes_id, Timestamp nisja, int aeroporti_arritjes_id, Timestamp arritja, String status) {
        this.id = id;
        this.bileta_id = bileta_id;
        this.aeroplani_id = aeroplani_id;
        this.aeroporti_nisjes_id = aeroporti_nisjes_id;
        this.nisja = nisja;
        this.aeroporti_arritjes_id = aeroporti_arritjes_id;
        this.arritja = arritja;
        this.status = status;
    }

    public String getQyteti1() {
        return qyteti1;
    }

    public void setQyteti1(String qyteti1) {
        this.qyteti1 = qyteti1;
    }

    public String getQyteti2() {
        return qyteti2;
    }

    public void setQyteti2(String qyteti2) {
        this.qyteti2 = qyteti2;
    }

    public String getLinja() {
        return linja;
    }

    public void setLinja(String linja) {
        this.linja = linja;
    }
}


