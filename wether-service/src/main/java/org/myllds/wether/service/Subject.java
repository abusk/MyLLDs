package org.myllds.wether.service;

import org.myllds.wether.subject.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
