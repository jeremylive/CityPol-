package GamePlay;
/**
 *
 * @author live yedgerik 
 */
public class Carta 
{
    //Variables globales
    private String nombreLugar;
    private Double latitud;
    private Double longitud;
    /**
     * Constructor de Carta para manejo de GamePlay
     * @param nombreLugar Lugar de la ubicacion
     * @param latitud pos x en mapa real
     * @param longitud pos y en mapa real
     */
    public Carta(String nombreLugar, Double latitud, Double longitud) 
    {
        this.nombreLugar = nombreLugar;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    //Gets and Sets
    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    } 
}
