package Estructura;

import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edgerik
 */
public class NodoGrafo {
    
    final private String id;
    final private String name;
    private Image thumbnail;

    /**
     * Nodo con la imagen del lugar
     * @param id numero de nodo
     * @param tipoLugar Tipo de lugar
     * @param thumbnail 
     */
    public NodoGrafo(String id, String tipoLugar, Image thumbnail) {
        this.id = id;
        this.name = tipoLugar;
        this.thumbnail = thumbnail;
    }


    
    
    public NodoGrafo(String id, String name) {
        this.id = id;
        this.name = name;
        this.thumbnail = null;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NodoGrafo other = (NodoGrafo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: "+name+"\tID: "+id;
    }

}