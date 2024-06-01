package behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int position;

    public ListIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        return list.get(position++);
    }
}

// Aggregate interface
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// Concrete Aggregate
class ListCollection<T> implements IterableCollection<T> {
    private List<T> list;

    public ListCollection() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(list);
    }
}

// Client
public class IteratorDP {
    public static void main(String[] args) {
        ListCollection<String> collection = new ListCollection<>();
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");

        // Iterate over the collection using iterator
        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/*
The Iterator Design Pattern is a behavioral design pattern that provides a way to access elements of an aggregate object sequentially without exposing its underlying representation. It allows you to traverse the elements of a collection without needing to know its internal structure.

Intent:
Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
Decouple the traversal algorithm from the aggregate object, making it possible to iterate over different types of collections using the same interface.
Simplify the client code by providing a uniform interface for iterating over collections.
Structure:
Iterator: Defines the interface for accessing and traversing elements of a collection.
Concrete Iterator: Implements the Iterator interface and keeps track of the current position in the traversal.
Aggregate: Defines the interface for creating an Iterator object.
Concrete Aggregate: Implements the Aggregate interface to create an Iterator object.


        */
