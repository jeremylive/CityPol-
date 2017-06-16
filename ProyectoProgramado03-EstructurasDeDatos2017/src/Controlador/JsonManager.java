package Controlador;

import Estructura.Borde;
import Estructura.Grafo;
import Estructura.Lugar;
import Estructura.NodoGrafo;
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
 * @author live
 */
public class JsonManager {

    private JSONParser lector;
    private JSONObject objeto;
    private JSONArray tipos;
    private Iterator<JSONObject> iter;
    private URL link;
    private final HttpClient client = HttpClients.createDefault();

    public void getJSONFromAPI(String type, double lat, double lon) {

        String response = "";
        try {
            URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/place/search/json");

            builder.addParameter("location", lat + "," + lon);
            builder.addParameter("radius", "500");
            builder.addParameter("types", type);
            builder.addParameter("sensor", "true");
            builder.addParameter("key", IConstants.APIKEY);

            HttpUriRequest request = new HttpGet(builder.build());

            HttpResponse execute = this.client.execute(request);

            response = EntityUtils.toString(execute.getEntity());
            
            
            System.out.println("Se cargo el JSON exitosamente");
            
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
                URL url =new URL((String) temp.get("icon"));
                Image image = ImageIO.read(url);
                double rate;
                try{
                    rate = (Double) temp.get("rating");
                }catch(ClassCastException | NullPointerException e)
                {
                    rate = 4.0;
                }    
                 
                //Contruyo un lugar con estos datos
                lugar = new Lugar((String) temp.get("name"), lat, lng, rate,  rets, image);
                //System.out.println(lugar.toString());
                //Se crea el nuevo nodo
                
                Grafo.getInstance().addNodo(new NodoGrafo("ID:"+Grafo.getInstance().getNodos().size(), lugar));
                cont_nodos++;
                
            }while(iter.hasNext() && cont_nodos < IConstants.nodosPorPeticion);
            
        } catch (ParseException | IOException ex) {
            System.out.println("Se ha producido un error en la funcion Json");
        }
    }

}
