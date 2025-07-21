package shapes;

public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Creating rectangle");
    }

    @Override
    public double calcArea() {
        return 3;
    }
}
