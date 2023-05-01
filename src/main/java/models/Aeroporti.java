package models;

public class Aeroporti {
    private  String emri;
    private String qyteti;

    public Aeroporti(){

    }
    public Aeroporti(String emri,String qyteti){
        this.emri=emri;
        this.qyteti=qyteti;
    }
    public String getEmri(){
        return emri;
    }
    public String getQyteti(){
        return qyteti;
    }
    public void setEmri(String emri){
        this.emri=emri;
    }
    public void setQyteti(String qyteti){
        this.qyteti=qyteti;
    }
}
