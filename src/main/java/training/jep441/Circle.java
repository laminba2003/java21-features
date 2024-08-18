package training.jep441;

public record Circle(double radius) implements Shape {

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
