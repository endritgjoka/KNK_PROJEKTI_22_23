package models;

public class Rezervimi {
   int id;
   int perdoruesi_id;
   String adresa;
   String nacionaliteti;
   String numri_telefonit;

   public Rezervimi(){

   }

   public Rezervimi(int id,int perdoruesi_id, String adresa,String nacionaliteti, String numri_telefonit ){
       this.id=id;
       this.perdoruesi_id=perdoruesi_id;
       this.adresa=adresa;
       this.nacionaliteti=nacionaliteti;
       this.numri_telefonit=numri_telefonit;
   }
   public int getId(){
       return id;
   }
   public int getPerdoruesi_id(){
       return perdoruesi_id;
   }
   public String getAdresa(){
       return adresa;

   }
   public String getNacionaliteti(){
       return nacionaliteti;
   }
   public String getNumri_telefonit(){
       return nacionaliteti;
   }
   public void setId(int id){
       this.id=id;
   }
  public void setPerdoruesi_id(int perdoruesi_id){
       this.perdoruesi_id=perdoruesi_id;
  }
  public void setAdresa(String adresa){
       this.adresa=adresa;
  }
  public void setNacionaliteti(String nacionaliteti){
       this.nacionaliteti=nacionaliteti;
  }
  public void setNumri_telefonit(String numri_telefonit){
       this.numri_telefonit=numri_telefonit;
  }
}
