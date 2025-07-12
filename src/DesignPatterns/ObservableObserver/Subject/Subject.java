package DesignPatterns.ObservableObserver.Subject;

import DesignPatterns.ObservableObserver.Observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

    private String subjectName;
    private List<IObserver> observers;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.observers = new ArrayList<IObserver>();
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
