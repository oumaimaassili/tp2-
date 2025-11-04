package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import metier.Compte;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "conversionEuroToDinar")
    public double conversion(@WebParam(name = "montant") double mt) {
        double taux = 3.2;
        return mt * taux;
    }

    @WebMethod(operationName = "getCompte")
    public Compte getCompte(@WebParam(name = "id") int id) {
        return new Compte(id, "Oumaima Assili", 1000.0,new Date());
    }

    @WebMethod(operationName = "getComptes")
    public List<Compte> getComptes() {
        List<Compte> list = new ArrayList<>();
        list.add(new Compte(1, "molka", 1200.0, new Date()));
        list.add(new Compte(2, "ahmed", 800.0, new Date()));
        return list;
    }
}
