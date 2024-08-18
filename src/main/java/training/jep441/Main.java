package training.jep441;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Shape> shapes = main.getShapes();
        shapes.forEach(shape -> System.out.println(main.getArea(shape)));
    }

    public List<Shape> getShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(3.50));
        return shapes;
    }

    public double getArea(Shape shape) {
        return switch (shape) {
            case Rectangle rectange -> rectange.getArea();
            case Circle circle when circle.radius() < 0 ->
                    throw new RuntimeException("circle radius cannot be negative");
            case Circle circle -> circle.getArea();
            case null -> throw new RuntimeException("shape cannot be null");
            default -> 0;
        };
    }
}
