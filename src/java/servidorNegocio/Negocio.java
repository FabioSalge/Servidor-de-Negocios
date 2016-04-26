package servidorNegocio;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author 1142412
 */
@Path("negocio")
public class Negocio {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Negocio
     */
    public Negocio() {
    }

    /**
     * Retrieves representation of an instance of servidorNegocio.Negocio
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Path("saldo/{idConta}")
    public String saldo(@PathParam("idConta") String conta) {
        ProxyDados pd = new ProxyDados();
        System.out.println("Servidor de Negocio - operacao saldo - conta " + conta + " - Saldo: " + pd.getSaldo(conta));
        return pd.getSaldo(conta);
    }

    /**
     * PUT method for updating or creating an instance of Negocio
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Produces("text/plain")
    @Path("setsaldo/{idConta}/{valor}")
    public String setSaldo(@PathParam("idConta") String conta, @PathParam("valor") String valor) {
        ProxyDados pd = new ProxyDados();
        int novoSaldo = Integer.parseInt(valor) + Integer.parseInt(pd.getSaldo(conta));
        pd.setSaldo(conta, Integer.toString(novoSaldo));
        System.out.println("Servidor de Negocio - operacao setSaldo - conta " + conta + " - valor: " + valor + " - Saldo: " + pd.getSaldo(conta));
        return pd.getSaldo(conta);
    }
}
