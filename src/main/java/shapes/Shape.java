package shapes;

import java.util.List;

public interface Shape {
    double calcArea();

   static double calcAreas(List<Shape> shapes){
        double areaSum = 0;
        for(Shape shape: shapes){
            areaSum += shape.calcArea();
        }
        return areaSum;
   }
}
