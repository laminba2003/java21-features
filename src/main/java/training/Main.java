package training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SequencedCollection;

public class Main {

    void main() {
        Collection<Shape> shapes = getShapes();
        shapes.forEach(shape -> {
            System.out.println(getDimensions(shape));
            System.out.println(getArea(shape));
        });
    }

    public Collection<Shape> getShapes() {
        SequencedCollection<Shape> shapes = new ArrayList<>();
        shapes.addLast(new Rectangle(10, 20));
        shapes.addFirst(new Circle(3.50));
        shapes.add(new Circle(2.50));
        return shapes;
    }

    public double getArea(Shape shape) {
        return switch (shape) {
            case Rectangle rectangle -> rectangle.getArea();
            case Circle circle when circle.radius() < 0 ->
                    throw new RuntimeException("circle radius cannot be negative");
            case Circle circle -> circle.getArea();
            case null -> throw new RuntimeException("shape cannot be null");
            default -> throw new RuntimeException("shape unknown");
        };
    }

    public String getDimensions(Shape shape) {
        if (shape instanceof Rectangle(double width, double height)) {
            return STR."Rectangle width = \{width} ; height = \{height}";
        } else if (shape instanceof Circle(double radius)) {
            return STR."Circle radius = \{radius}";
        }
        throw new RuntimeException("shape unknown");
    }
}
