package service;

import models.Pasagjeri;
import models.Perdoruesi;
import repository.PasagjeriRepository;
import repository.UserRepository;

import java.sql.Date;
import java.sql.SQLException;

public class PasagjeriService {
    public static Pasagjeri regjistroPasagjerin(int perdoruesi_id, String adresa, String nacionaliteti, String numriTelefonit, String numriPasaportes) throws SQLException {

        Pasagjeri pasagjeri = new Pasagjeri(0,perdoruesi_id, adresa, nacionaliteti, numriTelefonit, numriPasaportes);
        PasagjeriRepository.insert(pasagjeri);

        return PasagjeriRepository.getByPId(perdoruesi_id);

    }

}