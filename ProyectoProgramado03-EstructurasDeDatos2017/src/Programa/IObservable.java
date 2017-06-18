/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author Edgerik Leguizamon
 */
public interface IObservable {
    
    public void notifyObservers();

    /**
     * Agrega a la lista de observadores
     * @param nuevoObservador nueva interfaz
     */
    public void addObserver(IObserver nuevoObservador);
    
}
