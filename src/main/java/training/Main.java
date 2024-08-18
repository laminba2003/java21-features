package training;

import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        Main main = new Main();
        List<Shape> shapes = main.getShapes();
        shapes.forEach(shape -> {
            System.out.println(main.getDimensions(shape));
            System.out.println(main.getArea(shape));
        });
    }

    public List<Shape> getShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(3.50));
        return shapes;
    }

    public double getArea(Shape shape) {
        return switch (shape) {
            case Rectangle rectangle -> rectangle.getArea();
            case Circle circle when circle.radius() < 0 ->
                    throw new RuntimeException("circle radius cannot be negative");
            case Circle circle -> circle.getArea();
            case null -> throw new RuntimeException("shape cannot be null");
            default -> 0;
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
