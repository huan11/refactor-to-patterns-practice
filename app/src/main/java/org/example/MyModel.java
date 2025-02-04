package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyModel {
    private String name;
    private int age;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MyModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        String oldValue = this.name;
        this.name = name;
        support.firePropertyChange("name", oldValue, name);
    }

    public int GetAge() {
        return age;
    }

    public void SetAge(int age) {
        int oldValue = this.age;
        this.age = age;
        support.firePropertyChange("age", oldValue, age);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
