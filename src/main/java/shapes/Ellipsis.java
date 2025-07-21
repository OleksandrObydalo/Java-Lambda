package shapes;

public class Ellipsis implements Shape, AnotherShape{

    @Override
    public double calcArea() {
        return 1;
    }

    @Override
    public double calcSomething() {
        return Shape.super.calcSomething();
    }
}
