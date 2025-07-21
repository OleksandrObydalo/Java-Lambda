package shapes;

public class Circle extends Ellipsis{
    public Circle() {
        System.out.println("Creating circle");
    }

    @Override
    public double calcArea() {
        return 1;
    }

}
