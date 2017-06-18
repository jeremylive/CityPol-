/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePlay;

/**
 *
 * @author Edgerik Leguizamon
 */
public class Reto {
    public final String verbo;
    public final int cantidad;
    public final String tipoLugar;

    public Reto(String verbo, int cantidad, String tipoLugar) {
        this.verbo = verbo;
        this.cantidad = cantidad;
        this.tipoLugar = tipoLugar;
    }
    
    @Override
    public String toString(){
        return verbo + cantidad + tipoLugar;
    }
}
