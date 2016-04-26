package servidorNegocio;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Operacoes [operacoes]<br>
 * USAGE:
 * <pre>
 *        ProxyDados client = new ProxyDados();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author 1142412
 */
public class ProxyDados {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Servidor_de_Dados/webresources";

    public ProxyDados() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("operacoes");
    }

    public String setSaldo(String idConta, String valor) throws ClientErrorException {
        System.out.println("Servidor de Negocio - chama setSaldo");
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("setsaldo/{0}/{1}", new Object[]{idConta, valor}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String getSaldo(String idConta) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("saldo/{0}", new Object[]{idConta}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
