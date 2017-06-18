package Controlador;
//Bibliotecas a usar
import Estructura.Conexion;
import Estructura.Grafo;
import Estructura.Lugar;
import Estructura.NodoGrafo;
import Interfaz.VisualMap;
import Programa.IConstants;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author live y edgerik
 */
public class JsonManager 
{
    //Variables globales
    private JSONParser lector;
    private JSONObject objeto;
    private JSONArray tipos;
    private Grafo grafo;
    private Iterator<JSONObject> iter;
    private URL link;
    private final HttpClient client = HttpClients.createDefault();
    /**
     * Pido el grafo correspodiente a la ubicacion dada
     * @param control para manejo de la barra de progreso
     * @param tipos Tipos de comercios que se obtendran
     * @param lat Posicion y en mapa real
     * @param lon Posicion x en mapa real
     * @param radio radio de busqueda con api
     * @return Grafo construido con posiciones en pantalla y sus conexiones respectivas
     */
    public Grafo construirGrafo(VisualMap control,String[] tipos, double lat, double lon, String radio)
    {
        grafo = new Grafo();
        int len = tipos.length;
        int aumento = 100/len;
        int cont =0;
        
        for (String tipo : tipos) {
            control.getApiProgress().setValue(cont);
            getJSONFromAPI(tipo, lat, lon, radio);
            cont += aumento;
        }
        control.getApiProgress().setValue(cont);
        
        return grafo;
    }
    
    public void getJSONFromAPI(String type, double lat, double lon, String radius) 
    {

        String response;
        try {
            URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/place/search/json");

            builder.addParameter("location", lat + "," + lon);
            builder.addParameter("radius", radius);
            builder.addParameter("types", type);
            builder.addParameter("sensor", "true");
            builder.addParameter("key", IConstants.APIKEY);

            HttpUriRequest request = new HttpGet(builder.build());

            HttpResponse execute = this.client.execute(request);

            response = EntityUtils.toString(execute.getEntity());
            funcionJson(response);
        } catch (MalformedURLException ex) {
            System.out.println("Se ha dado un URL mal formado");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al leer el JSON del API");
        } catch (URISyntaxException ex) {
            Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void funcionJson(String respuesta)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(respuesta);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray results = (JSONArray) jsonObject.get("results");
            iter = results.iterator();
            JSONObject temp;
            Lugar lugar;
            int cont_nodos = 0;
            
            //Construyo la lista de nodos
            do{
                //Se toman los datos necesarios para la contruccion del Nodo
                temp = iter.next();
                double lat, lng;
                JSONObject location = (JSONObject) ((JSONObject) temp.get("geometry")).get("location");
                lat = (Double) location.get("lat");
                lng = (Double) location.get("lng");
                tipos = (JSONArray) temp.get("types");
                Iterator<String> types = tipos.iterator();
                String[] rets = {"","","",""};
                //Lista de tipos a los cuales pertenece
                for(int i = 0; i<4;i++)
                {
                    if(types.hasNext()){
                        rets[i] = types.next();
                    }
                }
                
                /*
                 * Busca el icono para guardarlo en la clase 
                 */
                URL url =new URL((String) temp.get("icon"));
                Image image = ImageIO.read(url);
                
                //Aveces el dato puede venir como un long, si es asi, no se maneja y se pone valor default
                double rate;
                try{
                    rate = (Double) temp.get("rating");
                }catch(ClassCastException | NullPointerException e)
                {
                    rate = IConstants.defaultRate;
                }    
                 
                //Contruyo un lugar con estos datos
                lugar = new Lugar((String) temp.get("name"), lat, lng, rate,  rets, image);
                //System.out.println(lugar.toString());
                //Se crea el nuevo nodo
                
                grafo.addNodo(new NodoGrafo("ID:"+grafo.getNodos().size(), lugar));
                cont_nodos++;
                
            }while(iter.hasNext() && cont_nodos < IConstants.nodosPorPeticion);
            
        } catch (ParseException | IOException ex) 
        {
            System.out.println("Se ha producido un error en la funcion Json");
        }
    }
}
