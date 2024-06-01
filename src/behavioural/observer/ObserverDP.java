package behavioural.observer;


import java.util.ArrayList;
import java.util.List;

// Observable interface
interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete Observable
class WeatherStation implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Concrete Observer
class WeatherDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current Temperature: " + temperature);
    }
}

// Client
public class ObserverDP {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        WeatherDisplay display1 = new WeatherDisplay();
        WeatherDisplay display2 = new WeatherDisplay();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Simulate temperature change
        weatherStation.setTemperature(25.5f);
    }
}
/*The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that
 when one object changes state, all its dependents are notified and updated automatically. 
 It is often used in scenarios where a change in one object requires changing other objects, and the exact number 
 and identity of the dependent objects aren't known beforehand.

Components:
Observable: Maintains a list of observers and notifies them of changes in its state.
Observer: Defines an interface for objects that should be notified of changes in the Observable's state.
Concrete Observable: Represents the object being observed. It sends notifications to observers when its state changes.
Concrete Observer: Implements the Observer interface and receives notifications from the Observable.

*/
