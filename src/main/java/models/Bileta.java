package models;

public class Bileta {
    private int id;

    private int çmimi;
    private boolean dy_drejtimeshe;

    public  Bileta(){

    }

    public Bileta(int id, int çmimi, boolean dy_drejtimeshe) {
        this.id = id;
        this.çmimi = çmimi;
        this.dy_drejtimeshe = dy_drejtimeshe;
    }

    public int getÇmimi() {
        return çmimi;
    }

    public void setÇmimi(int çmimi) {
        this.çmimi = çmimi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDy_drejtimeshe() {
        return dy_drejtimeshe;
    }

    public void setDy_drejtimeshe(boolean dy_drejtimeshe) {
        this.dy_drejtimeshe = dy_drejtimeshe;
    }
}