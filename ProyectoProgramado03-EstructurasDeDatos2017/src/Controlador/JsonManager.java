package Controlador;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author live
 */
public class JsonManager 
{
    private JSONParser lector;
    private JSONObject objeto;
    private URL link;
    
    public void getJSONFromAPI(String url){
        try {
            link = new URL(url);
            objeto = (JSONObject) lector.parse((String) link.openConnection().getContent());
            System.out.println("Se cargo el JSON exitosamente");
        } catch (MalformedURLException ex) {
            System.out.println("Se ha dado un URL mal formado");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al leer el JSON del API");
        } catch (ParseException ex) {
            System.out.println("No se ha podido crear el JSON (No fue posible hacer parsing)");
        }
        
    }
    
    
}
