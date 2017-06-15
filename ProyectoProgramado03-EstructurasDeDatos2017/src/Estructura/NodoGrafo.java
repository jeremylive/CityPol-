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
    private int posX;
    private int posY;

    /**
     * Nodo con la imagen del lugar
     * @param id numero de nodo
     * @param tipoLugar Tipo de lugar
     * @param thumbnail Imagen del lugar visitado
     */
    public NodoGrafo(String id, String tipoLugar, Image thumbnail) {
        this.id = id;
        this.name = tipoLugar;
        this.thumbnail = thumbnail;
        this.posX = 0;
        this.posY = 0;
    }

    
    public NodoGrafo(String id, String name) {
        this.id = id;
        this.name = name;
        this.thumbnail = null;
        this.posX = 0;
        this.posY = 0;
    }
    public String getId() {
        return id;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    /**
     * Crea codigo hash para manejo de nodos
     * @return La posicion a insertar en la tabla
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Para comparar con otros nodos
     * @param obj con el cual comparar
     * @return true si es igual, false si no
     */
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