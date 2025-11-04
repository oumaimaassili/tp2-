package server;
import service.BanqueService;
import jakarta.xml.ws.Endpoint;
public class serverws {



        public static void main(String[] args) {
            String url = "http://localhost:8084/banque"; // URL de publication
            Endpoint.publish(url, new BanqueService());
            System.out.println("Service publié à : " + url + "?wsdl");
        }
    }
