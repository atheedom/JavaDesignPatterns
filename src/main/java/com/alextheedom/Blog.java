package com.alextheedom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atheedom on 18/08/15.
 */
public class Blog implements Subject<String> {

    List<Observer> observers;
    private boolean stateChange;
    private final Object MUTEX = new Object();


    public Blog() {
        this.observers = new ArrayList<>();
        stateChange = false;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("Null Observer");
        }
        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {

        List<Observer> observersLocal;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!stateChange){
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
        }

        observersLocal.stream().forEach(Observer::update);

        this.stateChange = false;
    }

    @Override
    public String getUpdate() {
        String changedState = null;
        // should have logic to send the
        // state change to querying observer
        if (stateChange) {
            changedState = "Observer Design Pattern";
        }
        return changedState;
    }

    public void postNewArticle() {
        stateChange = true;
        notifyObserver();
    }

}
