package shapes;

public interface AnotherShape {
    default double calcSomething(){
        return 2;
    }
}
