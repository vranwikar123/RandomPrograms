package DesignPatterns.ObservableObserver.Observer;

import DesignPatterns.ObservableObserver.Subject.ISubject;
import DesignPatterns.ObservableObserver.Subject.Subject;

public class Observer implements IObserver{
    private String test;
    private Subject subject;

    public Observer(String test)
    {
        this.test = test;
    }

    @Override
    public void update() {
        System.out.println("Observer updated..." +subject.getSubjectName());
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public ISubject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
