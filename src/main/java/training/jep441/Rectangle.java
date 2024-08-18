package training.jep441;

public record Rectangle(double width, double height) implements Shape {

    @Override
    public double getArea() {
        return width * height;
    }
}
