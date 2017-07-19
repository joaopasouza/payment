/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection.observer;

import java.util.ArrayList;

/**
 *
 * @author joaopaulo
 */
public abstract class Sujeito {

    private final ArrayList<IObservador> observadores;

    public Sujeito() {
        observadores = new ArrayList<>();
    }

    public void addObserver(IObservador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void removeObserver(IObservador observador) {
        if (observadores.contains(observador)) {
            observadores.remove(observador);
        }
    }

    public void notifyObservers() {
        observadores.stream().forEach((observador) -> {
            observador.update();
        });
    }

}
