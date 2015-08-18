package com.alextheedom;

/**
 * Created by atheedom on 18/08/15.
 */
public interface Observer {

    void update();

    void setSubject(Subject subject);

}
