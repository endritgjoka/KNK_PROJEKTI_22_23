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

}
