package DesignPatterns.ObservableObserver;

import DesignPatterns.ObservableObserver.Observer.Observer;
import DesignPatterns.ObservableObserver.Subject.Subject;

public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new Subject("Sub_1");

        Observer obs1 = new Observer("Observer 1");
        obs1.setSubject(subject);
        subject.addObserver(obs1);

        Observer obs2 = new Observer("Observer 2");
        obs2.setSubject(subject);
        subject.addObserver(obs2);

        subject.setSubjectName("Test_2");
        subject.notifyObservers();
    }
}
