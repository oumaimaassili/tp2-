package client;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {

    public static void main(String[] args) {
        try {
            // Créer l'instance du service généré
            BanqueWS service = new BanqueWS();
            BanqueService port = service.getBanqueServicePort(); // Port pour appeler les méthodes SOAP

            // 1. Conversion Euro -> Dinar
            double euros = 100;
            double dinars = port.conversionEuroToDinar(euros);
            System.out.println(euros + " euros = " + dinars + " dinars");

            // 2. Récupération d'un compte
            int compteId = 1;
            Compte compte = port.getCompte(compteId);
            System.out.println("Compte ID " + compte.getId() + ": "
                    + compte.getTitulaire() + ", Solde: " + compte.getSolde());

            // 3. Récupération de la liste des comptes
            List<Compte> comptes = port.getComptes();
            System.out.println("Liste des comptes :");
            for (Compte c : comptes) {
                System.out.println("ID: " + c.getId()
                        + ", Titulaire: " + c.getTitulaire()
                        + ", Solde: " + c.getSolde());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
