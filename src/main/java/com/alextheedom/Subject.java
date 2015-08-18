package com.alextheedom;

/**
 * Created by atheedom on 18/08/15.
 */
public interface Subject<T> {

    void registerObserver(Observer observer);

    void notifyObserver();

    void unregisterObserver(Observer observer);

    <T> T getUpdate();
}
