package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(Observer mentor);
    void notifyObservers();
    void removeObserver(Observer mentor);
}
