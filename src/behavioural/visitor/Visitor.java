package behavioural.visitor;
import java.util.*;


// Visitor interface
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// Concrete Visitor
class DrawingVisitor implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing Rectangle");
    }
}

// Element interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Concrete Elements
class Circle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Object Structure
class Drawing {

    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        ShapeVisitor visitor = new DrawingVisitor();
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

// Client
public class Visitor {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        drawing.addShape(new Circle());
        drawing.addShape(new Rectangle());
        drawing.draw();
    }
}

/*
e Visitor Design Pattern is a behavioral design pattern that allows you to separate algorithms from the objects on which they operate. It is used when you have a set of classes with differing interfaces, and you want to perform a similar operation on each class without modifying their interfaces.

Intent:
Represent an operation to be performed on the elements of an object structure.
Enable the definition of new operations without changing the classes on which they operate.
Separate algorithms from the objects on which they operate.
        Structure:
Visitor: Declares the interface for visiting each element in the object structure. It defines a visit method for each element type.
Concrete Visitor: Implements the Visitor interface and defines the algorithm for each element type.
        Element: Defines the interface for accepting visitors.
Concrete Element: Implements the Element interface and defines the accept method to call the visit method of the visitor.
Object Structure: Represents a collection of elements and provides a way to iterate over them.
ClientTh: Creates visitors and objects and performs operations by invoking the accept method.*/
