package Programa;
/*Libreria a usar*/
import Controlador.JsonManager;
import Controlador.LoginManager;
import Controlador.UserFileManager;
import Estructura.ThreeBB;
import Interfaz.GeoMap;
import Interfaz.VisualGraphics;
import Interfaz.VisualMap;
/**
 *
 * @author live 
 */
public class CityPoli 
{
    //Variables globales
    //Clases a usar logica Tree
    private LoginManager controlador_login;
    private JsonManager controlador_json;
    private UserFileManager controlador_users;
    //Clase a usar logica API
    private VisualMap control_visual_map;
    private VisualGraphics control_visual_graphics;
    private GeoMap control_geo_map;
    //Constructor
    public CityPoli()
    {
        this.controlador_login = new LoginManager();
        this.controlador_json = new JsonManager();
        this.controlador_users = new UserFileManager();
        this.control_visual_map = null;
        this.control_visual_graphics = null;
        this.control_geo_map = new GeoMap();
    }
    //Gets and sets
    public ThreeBB getArbolB() {
        return controlador_login.getArbol_b_asterisco();
    }
    public LoginManager getControlador_login() {
        return controlador_login;
    }

    public void setControlador_login(LoginManager controlador_login) {
        this.controlador_login = controlador_login;
    }

    public JsonManager getControlador_json() {
        return controlador_json;
    }

    public void setControlador_json(JsonManager controlador_json) {
        this.controlador_json = controlador_json;
    }

    public UserFileManager getControlador_users() {
        return controlador_users;
    }

    public void setControlador_users(UserFileManager controlador_users) {
        this.controlador_users = controlador_users;
    }

    public VisualMap getControl_visual_map() {
        return control_visual_map;
    }

    public void setControl_visual_map(VisualMap control_visual_map) {
        this.control_visual_map = control_visual_map;
    }

    public VisualGraphics getControl_visual_graphics() {
        return control_visual_graphics;
    }

    public void setControl_visual_graphics(VisualGraphics control_visual_graphics) {
        this.control_visual_graphics = control_visual_graphics;
    }

    public GeoMap getControl_geo_map() {
        return control_geo_map;
    }

    public void setControl_geo_map(GeoMap control_geo_map) {
        this.control_geo_map = control_geo_map;
    }
    //Funciones 
    
    
    
    //..    

}