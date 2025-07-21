package shapes;

public class Circle implements Shape{
    public Circle() {
        System.out.println("Creating circle");
    }

    @Override
    public double calcArea() {
        return 1;
    }
}
