package es.upm.miw.apaw_ep_javier_iglesias.patterns.publish;

import java.util.HashSet;
import java.util.Set;

public class Observable {
    private final Set<Observer> observers = new HashSet<>();

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    void notifyObservers() {
        this.observers.forEach(Observer::update);
    }
}