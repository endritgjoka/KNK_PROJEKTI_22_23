package models;

public class Bagazhet {
    private int id;
    private  int pasagjeri_id;
    private int numri_bagazhit;
    private double pesha_bagazhit;

    public Bagazhet(){

    }
    public Bagazhet(int id,int pasagjeri_id,int numri_bagazhit, double pesha_bagazhit){
        this.id=id;
        this.pasagjeri_id=pasagjeri_id;
        this.numri_bagazhit=numri_bagazhit;
        this.pesha_bagazhit=pesha_bagazhit;
    }
}
